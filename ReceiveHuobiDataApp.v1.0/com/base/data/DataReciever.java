package base.data;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.core.IOAcknowledge;
import base.core.IOCallback;
import base.core.SocketIO;
import base.core.SocketIOException;
import base.redis.RedisHandleUtil;
import base.util.Arith;

import com.google.gson.Gson;

public class DataReciever {

	private String url = "http://hq.huobi.com:80/";// hqUrl

	private static volatile SocketIO socket;

	private static Logger logger = LoggerFactory.getLogger(DataReciever.class);

	public DataReciever() {
	}

	public DataReciever connectToSocketIO(final Object livetime) {
		try {
			socket = new SocketIO(url, new IOCallback() {
				public void onMessage(JSONObject json, IOAcknowledge ack) {

				}

				public void onMessage(String data, IOAcknowledge ack) {
				}

				public void onError(SocketIOException socketIOException) {
					logger.warn("", socketIOException);
					socket.disconnect();
				}

				public void onDisconnect() {
					logger.warn("socket.io disconnect");
				}

				public void onConnect() {
					logger.info("socket.io connected-------------");

				}

				public void on(final String event, IOAcknowledge ack,
						final Object... args) {
					try {
						DataReciever.dispatcher((JSONObject) args[0],livetime);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			});
			register();
		} catch (Exception e) {
			logger.error("", e);
		}
		return this;
	}

	public static void dispatcher(JSONObject recieveJO,Object obj) throws Exception {
		String msgType = recieveJO.getString("msgType");
		String code="btccny";
		if(msgType.equals("lastTimeLine")){
			//获取最新的价格
			double rtimeprice=Double.valueOf(recieveJO.getJSONObject("payload").get("priceLast").toString()).doubleValue();
			rtimeprice=Arith.sub(rtimeprice, 0.01);
			rtimeprice=Arith.add(rtimeprice, 0.01);
			List<Object> list = (List<Object>)RedisHandleUtil.getAllList("order_list");
			long l=0;
			if(obj!=null){
				l=Long.valueOf(obj.toString());
			}
			RedisHandleUtil.addRedis(code, rtimeprice+"",l);//实时最新价
			RedisHandleUtil.addRedisString("lastPrice"+code, rtimeprice+"", 0);//上一次接收到的最新价
			String nowtime=base.util.DateUtil.getTime("yyyyMMddHHmmss");
			for(Object objMoney:list){
				if(objMoney==null){
					continue;
				}
				Gson gson=new Gson();
				TempOrderEntity auto = gson.fromJson(objMoney.toString(), TempOrderEntity.class);
				if(auto==null||!auto.getGoodCode().equals(code)){
					continue;
				}

				//判断该订单是否已经被平仓
				Object emptyFlag = RedisHandleUtil.getValueAsStr(auto.getOrderid());
				if(emptyFlag==null){//说明此订单已经被平仓
					RedisHandleUtil.removeElement("order_list", 0, objMoney);//从订单队列中移除
					RedisHandleUtil.removeStr(auto.getOrderid());//移除该订单标识,因为自动平仓程序运行有延迟，因此，防止该订单已经止损或者止盈了，但用户在界面手动平仓
					continue;
				}
				
				//如果是分秒必争订单
				if(auto.getPlayway().equals("1")&&nowtime.compareTo(auto.getExpireTime())>=0){
					Double overPrice=rtimeprice;//当前行情价
					TempOrderEntity newAutoEntity = new TempOrderEntity();
					BeanUtils.copyProperties(newAutoEntity, auto);
					newAutoEntity.setDescValueDot(overPrice);
					Gson gson1=new Gson();
					RedisHandleUtil.addList("order_list_out", gson1.toJson(newAutoEntity), 0);//添加到待平仓队列
					RedisHandleUtil.removeElement("order_list", 0, objMoney);//从订单队列中移除
					RedisHandleUtil.removeStr(auto.getOrderid());//移除该订单标识,因为自动平仓程序运行有延迟，因此，防止该订单已经止损或者止盈了，但用户在界面手动平仓
					continue;
				}else if(auto.getPlayway().equals("2")){//一触即付()
					Double overPrice=rtimeprice;//当前行情价
					if(nowtime.compareTo(auto.getExpireTime())>=0){//说明过期
						TempOrderEntity newAutoEntity = new TempOrderEntity();
						BeanUtils.copyProperties(newAutoEntity, auto);
						newAutoEntity.setOverPrice(overPrice);
						Gson gson1=new Gson();
						RedisHandleUtil.addList("order_list_out", gson1.toJson(newAutoEntity), 0);//添加到待平仓队列
						RedisHandleUtil.removeElement("order_list", 0, objMoney);//从订单队列中移除
						RedisHandleUtil.removeStr(auto.getOrderid());//移除该订单标识,因为自动平仓程序运行有延迟，因此，防止该订单已经止损或者止盈了，但用户在界面手动平仓
						continue;
					}else{
						if((auto.getOrderType().equals("0")&&overPrice.doubleValue()>=auto.getDescValueDot1().doubleValue())||(auto.getOrderType().equals("1")&&overPrice.doubleValue()<=auto.getDescValueDot1().doubleValue())){//涨
							TempOrderEntity newAutoEntity = new TempOrderEntity();
							BeanUtils.copyProperties(newAutoEntity, auto);
							newAutoEntity.setOverPrice(overPrice);
							Gson gson1=new Gson();
							RedisHandleUtil.addList("order_list_out", gson1.toJson(newAutoEntity), 0);//添加到待平仓队列
							RedisHandleUtil.removeElement("order_list", 0, objMoney);//从订单队列中移除
							RedisHandleUtil.removeStr(auto.getOrderid());//移除该订单标识,因为自动平仓程序运行有延迟，因此，防止该订单已经止损或者止盈了，但用户在界面手动平仓
							continue;
						}
					}
				}
			}
		}
	}

	public void register() {
		// 实时数据推�?
		String strMsg = "{\"symbolList\":{\"lastTimeLine\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
				+ "\"marketOverview\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}]"
				+ "},\"version\":1,\"msgType\":\"reqMsgSubscribe\",\"requestIndex\":1404103038520}";
		JSONObject sendJO = new JSONObject(new JSONTokener(strMsg));
		socket.emit("request", sendJO);
	}

	public boolean isConnected() {
		return socket != null && socket.isConnected();
	}

	public long getLastTimeReceivedMessage() {
		return socket == null ? -1 : socket.getLastTimeReceivedMessage();
	}

	public void disconnect() {
		if (socket == null) {
			return;
		}
		socket.disconnect();
		socket = null;
	}
}
