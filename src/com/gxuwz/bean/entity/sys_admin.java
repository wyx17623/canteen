package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * 时间：2019年6月14日上午10:52:17
 * Description:系统管理员实体类
 */
public class sys_admin {
private String adminID;
private String adminName;
private String adminTel;

public sys_admin() {
	super();
}
public sys_admin(String adminID, String adminName, String adminTel) {
	super();
	this.adminID = adminID;
	this.adminName = adminName;
	this.adminTel = adminTel;
}
public String getAdminID() {
	return adminID;
}
public void setAdminID(String adminID) {
	this.adminID = adminID;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminTel() {
	return adminTel;
}
public void setAdminTel(String adminTel) {
	this.adminTel = adminTel;
}

}
