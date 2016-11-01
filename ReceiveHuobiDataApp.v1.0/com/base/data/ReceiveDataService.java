package base.data;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import base.redis.RedisHandleUtil;

/**
 * 处理比特币订单
 * @author Administrator
 *
 */
public class ReceiveDataService  extends GenericServlet{
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
	}

	@Override
	public void init() throws ServletException {
		try {
			receiveData1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 接受 139.196.54.180 服务器上的行情源
	 * 
	 * @throws IOException
	 */
	public void receiveData1() throws IOException {
		String code="btccny";
		Object obj = RedisHandleUtil.findRedis("livetime_"+code);
		DataReciever dataReciever = new DataReciever().connectToSocketIO(obj);
        //心跳检测链接是否断开
        new CheckConnection(dataReciever).check(obj);
	}
	
}
