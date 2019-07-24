package com.gxuwz.bean.vo;

public class listordering {
private String orderingID;
private String menuName;
private String staffName;
private int    orderingNum;
private int    surplusNum;
private String orderingtime;
public String getOrderingID() {
	return orderingID;
}
public void setOrderingID(String orderingID) {
	this.orderingID = orderingID;
}
public String getMenuName() {
	return menuName;
}
public void setMenuName(String menuName) {
	this.menuName = menuName;
}
public String getStaffName() {
	return staffName;
}
public void setStaffName(String staffName) {
	this.staffName = staffName;
}
public int getOrderingNum() {
	return orderingNum;
}
public void setOrderingNum(int orderingNum) {
	this.orderingNum = orderingNum;
}
public int getSurplusNum() {
	return surplusNum;
}
public void setSurplusNum(int surplusNum) {
	this.surplusNum = surplusNum;
}
public String getOrderingtime() {
	return orderingtime;
}
public void setOrderingtime(String orderingtime) {
	this.orderingtime = orderingtime;
}
public listordering(String orderingID, String menuName, String staffName,
		int orderingNum, int surplusNum, String orderingtime) {
	super();
	this.orderingID = orderingID;
	this.menuName = menuName;
	this.staffName = staffName;
	this.orderingNum = orderingNum;
	this.surplusNum = surplusNum;
	this.orderingtime = orderingtime;
}
public listordering() {
	super();
}

}
