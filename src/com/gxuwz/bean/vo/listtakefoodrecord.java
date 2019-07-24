package com.gxuwz.bean.vo;

public class listtakefoodrecord {
private String orderingID;
private String menuName;
private String takefoodtime;
private String surplusNum;
public String getOrderingID() {
	return orderingID;
}
public void setOrdingID(String ordingID) {
	this.orderingID = ordingID;
}
public String getMenuName() {
	return menuName;
}
public void setMenuName(String menuName) {
	this.menuName = menuName;
}
public String getTakefoodtime() {
	return takefoodtime;
}
public void setTakefoodtime(String takefoodtime) {
	this.takefoodtime = takefoodtime;
}
public String getSurplusNum() {
	return surplusNum;
}
public void setSurplusNum(String surplusNum) {
	this.surplusNum = surplusNum;
}
public listtakefoodrecord(String ordingID, String menuName,
		String takefoodtime, String surplusNum) {
	super();
	this.orderingID = ordingID;
	this.menuName = menuName;
	this.takefoodtime = takefoodtime;
	this.surplusNum = surplusNum;
}
public listtakefoodrecord() {
	super();
}

}
