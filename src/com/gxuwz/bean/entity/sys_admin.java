package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��14������10:52:17
 * Description:ϵͳ����Աʵ����
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
