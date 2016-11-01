package base.util;

/**
 * 计算止盈止损
 * 
 * @author Administrator
 * 
 */
public class CalculateMoney {

	/**
	 * 获取止损
	 * 
	 * @param orderType
	 *            --订单类型
	 * @param orderMoney
	 *            --保证金
	 * @param quantity
	 *            --数量
	 * @param lossPrice
	 *            --止损比例
	 * @param profitPrice
	 *            --止盈比例
	 * @param rtimePrices
	 *            --行情价格
	 * @param valuedot
	 *            --点值
	 * @param adjustbase
	 *            --基值
	 * @return
	 */
	public static double returnMoney1(String orderType, Double ordemoney,
			Double quantity, Double lossPrice, Double profitPrice,
			Double rtimePrices, Double valuedot, Double adjustbase) {
		
		// 买涨
		if (orderType.equals("0")) {
			// 1.止损价
			//公式：lossPrice = 减仓价 - ((保障金/手数*止损比例)/点值)*点差基值;
			if (lossPrice.doubleValue() == 0) {
				return 0d;
			} else {
				double money1 = Arith.div(ordemoney.doubleValue(), quantity.doubleValue());
				money1 = Arith.mul(money1, lossPrice.doubleValue());
				money1 = Arith.div(money1, valuedot.doubleValue());
				money1 = Arith.mul(money1, adjustbase.doubleValue());
				return Arith.sub(rtimePrices.doubleValue(), money1);
			}
		} else {
			// 1.止损价
			// 公式 lossPrice = orderPrice + ((保障金/手数*止损比例)/点值)*点差基值;
			
			if (lossPrice.doubleValue() == 0) {
				return 0d;
			} else {
				double money1 = Arith.div(ordemoney.doubleValue(), quantity.doubleValue());
				money1 = Arith.mul(money1, lossPrice.doubleValue());
				money1 = Arith.div(money1, valuedot.doubleValue());
				money1 = Arith.mul(money1, adjustbase.doubleValue());
				return Arith.add(rtimePrices.doubleValue(), money1);
			}
		}
	}

	/**
	 * 获取止盈
	 * 
	 * @param orderType
	 *            --订单类型
	 * @param orderMoney
	 *            --保证金
	 * @param quantity
	 *            --数量
	 * @param lossPrice
	 *            --止损比例
	 * @param profitPrice
	 *            --止盈比例
	 * @param rtimePrices
	 *            --行情价格
	 * @param valuedot
	 *            --点值
	 * @param adjustbase
	 *            --基值
	 * @return
	 */
	public static double returnMoney2(String orderType, Double ordemoney,
			Double quantity, Double lossPrice, Double profitPrice,
			Double rtimePrices, Double valuedot, Double adjustbase) {
		
		// 买涨
		if (orderType.equals("0")) {
			//profitPrice = orderPrice + ((保障金/手数*止损比例)/点值)*点差基值;
			
			// 2.止盈价
			if (profitPrice.doubleValue() == 0) {
				return 0d;
			} else {
				double money1 = Arith.div(ordemoney.doubleValue(), quantity.doubleValue());
				money1 = Arith.mul(money1, profitPrice.doubleValue());
				money1 = Arith.div(money1, valuedot.doubleValue());
				money1 = Arith.mul(money1, adjustbase.doubleValue());
				return Arith.add(rtimePrices.doubleValue(), money1);
			}
		} else {
			//profitPrice = orderPrice - ((保障金/手数*止损比例)/点值)*点差基值;
			
			// 2.止盈价
			if (profitPrice.doubleValue() == 0) {
				return 0d;
			} else {
				double money1 = Arith.div(ordemoney.doubleValue(), quantity.doubleValue());
				money1 = Arith.mul(money1, profitPrice.doubleValue());
				money1 = Arith.div(money1, valuedot.doubleValue());
				money1 = Arith.mul(money1, adjustbase.doubleValue());
				return Arith.sub(rtimePrices.doubleValue(), money1);
			}
		}
	}
	
	/**
	 * 计算盈亏
	 * @param overPrice
	 * @param orderPrice
	 * @param adjustbase
	 * @param valuedot
	 * @param quantity
	 * @return
	 */
	public static double returnMoney3(double overPrice,double orderPrice,double adjustbase,double valuedot,double quantity){
		//计算盈亏公式
		//@OverPrice-@OrderPrice)/adjustbase*valuedot*@Quantity
		double money=Arith.sub(overPrice, orderPrice);
		money=Arith.div(money, adjustbase,2);
		money=Arith.mul(money, valuedot);
		money=Arith.mul(money, quantity);
		return money;
	}
	
	public static double returnMoney4(Double money,Double occMoney,Double yinkuaiMoney){
		//（账户余额-冻结资金+用户所有持仓单盈亏）/(用户账户占用定金即保证金+挂单预付款)<0.5
		
		return 0;
	}
	
	
	public static void main(String[] args){
		System.out.println(returnMoney1("0", 10.00, 1.00, 0.10, 0.10, 23735.0, 0.05, 1.0));
	}
}
