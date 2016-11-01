package base.data;

import java.io.Serializable;

/**
 * 临时订单
 * @author Administrator
 *
 */
public class TempOrderEntity implements Serializable{

	/**
	 * 用户主键
	 */
	private String userId;
	
	/**
	 * 用户的openid
	 */
	private String wUserId;
	
	/**
	 * 会员机构id
	 */
	private String orgId;
	
	/**
	 * 订单号
	 */
	private String orderid;
	
	/**
	 * 交易产品编号
	 */
	private String goodCode;
	
	/**
	 * 订单类型(0-买涨 1-买跌)
	 */
	private String orderType;
	
	/**
	 * 订单类型（1-分秒必争；2-点到即止；3-价差风云；4-涨跌争霸；5-区间高手；6：预见未来）
	 */
	private String playway;
	
	/**
	 * 盈亏率
	 */
	private Double percentMoney;
	
	/**
	 * 下单时候的行情值
	 */
	private Double srcValueDot;
	
	/**
	 * 目标行情值
	 */
	private Double descValueDot;
	
	/**
	 * 高手用户目标值
	 */
	private Double descValueDot1;
	
	/**
	 * 平仓实时价
	 */
	private Double overPrice;
	
	/**
	 * 过期时间节点
	 */
	private String expireTime;
	
	/**
	 * 活动点值
	 */
	private Double dot;
	
	/**
	 * 下单金额
	 */
	private Double orderMoney;

	/**
	 * 手续费
	 */
	private Double tradeFee;
	
	/**
	 * 资金账户变动前余额
	 */
	private Double oldMoney;
	
	/**
	 * 资金账户变动后余额
	 */
	private Double newMoney;
	
	/**
	 * 操作用户
	 */
	private String userName;
	
	/**
	 * 数量
	 */
	private Double quantity;
	
	/**
	 * 时间间隔(分秒必争)
	 */
	private Integer timeMul;
	
	private String cashUser;
	
	/**
	 * 下单时间
	 */
	private String orderTime;
	
	/**
	 * 
	 */
	private String iftouch;
	
	/**
	 * 玩法对应的配置id
	 */
	private String playwaysetid;
	
	public Double getTradeFee() {
		return tradeFee;
	}

	public void setTradeFee(Double tradeFee) {
		this.tradeFee = tradeFee;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getGoodCode() {
		return goodCode;
	}

	public void setGoodCode(String goodCode) {
		this.goodCode = goodCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPlayway() {
		return playway;
	}

	public void setPlayway(String playway) {
		this.playway = playway;
	}

	public Double getPercentMoney() {
		return percentMoney;
	}

	public void setPercentMoney(Double percentMoney) {
		this.percentMoney = percentMoney;
	}

	public Double getSrcValueDot() {
		return srcValueDot;
	}

	public void setSrcValueDot(Double srcValueDot) {
		this.srcValueDot = srcValueDot;
	}

	public Double getDescValueDot() {
		return descValueDot;
	}

	public void setDescValueDot(Double descValueDot) {
		this.descValueDot = descValueDot;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}


	public Double getDot() {
		return dot;
	}

	public void setDot(Double dot) {
		this.dot = dot;
	}

	public Double getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getwUserId() {
		return wUserId;
	}

	public void setwUserId(String wUserId) {
		this.wUserId = wUserId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Double getOldMoney() {
		return oldMoney;
	}

	public void setOldMoney(Double oldMoney) {
		this.oldMoney = oldMoney;
	}

	public Double getNewMoney() {
		return newMoney;
	}

	public void setNewMoney(Double newMoney) {
		this.newMoney = newMoney;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCashUser() {
		return cashUser;
	}

	public void setCashUser(String cashUser) {
		this.cashUser = cashUser;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Integer getTimeMul() {
		return timeMul;
	}

	public void setTimeMul(Integer timeMul) {
		this.timeMul = timeMul;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Double getOverPrice() {
		return overPrice;
	}

	public void setOverPrice(Double overPrice) {
		this.overPrice = overPrice;
	}

	public Double getDescValueDot1() {
		return descValueDot1;
	}

	public void setDescValueDot1(Double descValueDot1) {
		this.descValueDot1 = descValueDot1;
	}

	public String getIftouch() {
		return iftouch;
	}

	public void setIftouch(String iftouch) {
		this.iftouch = iftouch;
	}

	public String getPlaywaysetid() {
		return playwaysetid;
	}

	public void setPlaywaysetid(String playwaysetid) {
		this.playwaysetid = playwaysetid;
	}
	
	
}
