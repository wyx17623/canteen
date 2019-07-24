package com.gxuwz.bean.entity;

public class sys_shoppinglist {
	private String shoppingID;
	private String buyerID;
	private String materialsName;
	private String price;
	private String materialsNum;
	private String supplier;
	private String shoppingTime;
	private String status;
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
	public String getMaterialsName() {
		return materialsName;
	}
	public void setMaterialsName(String materialsName) {
		this.materialsName = materialsName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMaterialsNum() {
		return materialsNum;
	}
	public void setMaterialsNum(String materialsNum) {
		this.materialsNum = materialsNum;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getShoppingTime() {
		return shoppingTime;
	}
	public void setShoppingTime(String shoppingTime) {
		this.shoppingTime = shoppingTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public sys_shoppinglist(String shoppingID, String buyerID,
			String materialsName, String price, String materialsNum,
			String supplier, String shoppingTime, String status) {
		super();
		this.shoppingID = shoppingID;
		this.buyerID = buyerID;
		this.materialsName = materialsName;
		this.price = price;
		this.materialsNum = materialsNum;
		this.supplier = supplier;
		this.shoppingTime = shoppingTime;
		this.status = status;
	}
	public sys_shoppinglist() {
		super();
	}

}
