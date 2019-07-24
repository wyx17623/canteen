package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * 时间：2019年6月14日上午10:57:41
 * Description:食堂采购人员实体类
 */
public class sys_buyer {
	private String buyerID;
	private String buyerName;
	private String buyerTel;

	public sys_buyer() {
		super();
	}

	public sys_buyer(String buyerID, String buyerName, String buyerTel) {
		super();
		this.buyerID = buyerID;
		this.buyerName = buyerName;
		this.buyerTel = buyerTel;
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

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

}
