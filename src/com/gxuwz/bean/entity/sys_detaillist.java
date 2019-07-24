package com.gxuwz.bean.entity;
//采购明细表实体类
public class sys_detaillist {
	private String detailListID;
	private String shoppingID;
	private String materialsName;
	private String price;
	private String materialsNum;
	private String supplier;

	public sys_detaillist() {
		super();
	}

	public sys_detaillist(String detailListID, String shoppingID,
			String materialsName, String price, String materialsNum,
			String supplier) {
		super();
		this.detailListID = detailListID;
		this.shoppingID = shoppingID;
		this.materialsName = materialsName;
		this.price = price;
		this.materialsNum = materialsNum;
		this.supplier = supplier;
	}

	public String getDetailListID() {
		return detailListID;
	}

	public void setDetailListID(String detailListID) {
		this.detailListID = detailListID;
	}

	public String getShoppingID() {
		return shoppingID;
	}

	public void setShoppingID(String shoppingID) {
		this.shoppingID = shoppingID;
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

}
