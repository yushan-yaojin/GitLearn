package base.data;


public class TradeAutoEntity {

	private String Orderid;

	private String orderType;

	private Double Orderprice;

	private String goodscode;

	private Double quantity;

	private Double valuedot;

	private Double adjustbase;

	private Double lossPrice;

	private Double profitPrice;

	private String close;
	
	private Double overPrice;
	
	private String overType;
	
	private String userId;

	public String getOrderid() {
		return Orderid;
	}

	public void setOrderid(String orderid) {
		Orderid = orderid;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getGoodscode() {
		return goodscode;
	}

	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}

	public Double getOrderprice() {
		return Orderprice;
	}

	public void setOrderprice(Double orderprice) {
		Orderprice = orderprice;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public Double getValuedot() {
		return valuedot;
	}

	public void setValuedot(Double valuedot) {
		this.valuedot = valuedot;
	}

	public Double getAdjustbase() {
		return adjustbase;
	}

	public void setAdjustbase(Double adjustbase) {
		this.adjustbase = adjustbase;
	}

	public Double getLossPrice() {
		return lossPrice;
	}

	public void setLossPrice(Double lossPrice) {
		this.lossPrice = lossPrice;
	}

	public Double getProfitPrice() {
		return profitPrice;
	}

	public void setProfitPrice(Double profitPrice) {
		this.profitPrice = profitPrice;
	}

	public Double getOverPrice() {
		return overPrice;
	}

	public void setOverPrice(Double overPrice) {
		this.overPrice = overPrice;
	}

	public String getOverType() {
		return overType;
	}

	public void setOverType(String overType) {
		this.overType = overType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
