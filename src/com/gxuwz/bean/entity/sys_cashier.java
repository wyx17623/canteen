package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * 时间：2019年6月14日上午11:00:46
 * Description:食堂出纳人员实体类
 */
public class sys_cashier {
	private String cashierID;
	private String cashierName;
	private String cashierTel;

	public sys_cashier() {
		super();
	}

	public sys_cashier(String cashierID, String cashierName, String cashierTel) {
		super();
		this.cashierID = cashierID;
		this.cashierName = cashierName;
		this.cashierTel = cashierTel;
	}

	public String getCashierID() {
		return cashierID;
	}

	public void setCashierID(String cashierID) {
		this.cashierID = cashierID;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	public String getCashierTel() {
		return cashierTel;
	}

	public void setCashierTel(String cashierTel) {
		this.cashierTel = cashierTel;
	}

}
