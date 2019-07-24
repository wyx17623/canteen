package com.gxuwz.bean.vo;

public class listorderingcount {
private String menuID;
private String menuName;
private String orderingNum;

public listorderingcount() {
	super();
}
public listorderingcount(String menuID, String menuName, String orderingNum) {
	super();
	this.menuID = menuID;
	this.menuName = menuName;
	this.orderingNum = orderingNum;
}
public String getMenuID() {
	return menuID;
}
public void setMenuID(String menuID) {
	this.menuID = menuID;
}
public String getMenuName() {
	return menuName;
}
public void setMenuName(String menuName) {
	this.menuName = menuName;
}
public String getOrderingNum() {
	return orderingNum;
}
public void setOrderingNum(String orderingNum) {
	this.orderingNum = orderingNum;
}

}
