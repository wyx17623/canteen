package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��14������10:57:41
 * Description:ʳ�òɹ���Աʵ����
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
