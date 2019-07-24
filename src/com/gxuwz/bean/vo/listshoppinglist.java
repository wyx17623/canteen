package com.gxuwz.bean.vo;
/**
 * 
 * @author 
 * 时间：2019年6月18日下午5:33:08
 * Description:采购清单显示类
 */
public class listshoppinglist {
	private String shoppingID;
	private String buyerID;
	private String buyerName;
	private String shoppingTime;
	private String totalMoney;
	private String status;

	public listshoppinglist() {
		super();
	}

	public listshoppinglist(String shoppingID, 
			String buyerName, String totalMoney,String shoppingTime, 
			String status) {
		super();
		this.shoppingID = shoppingID;
		this.buyerName = buyerName;
		this.shoppingTime = shoppingTime;
		this.totalMoney = totalMoney;
		this.status = status;
	}

	public String getShoppingID() {
		return shoppingID;
	}

	public void setShoppingID(String shoppingID) {
		this.shoppingID = shoppingID;
	}

	public String getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(String buyerID) {
		this.buyerID = buyerID;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getShoppingTime() {
		return shoppingTime;
	}

	public void setShoppingTime(String shoppingTime) {
		this.shoppingTime = shoppingTime;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
