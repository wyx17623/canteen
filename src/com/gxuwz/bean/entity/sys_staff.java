package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��14������11:03:23
 * Description:��˾������Աʵ����
 */
public class sys_staff {
	private String staffID;
	private String staffName;
	private String staffTel;

	public sys_staff() {
		super();
	}

	public sys_staff(String staffID, String staffName, String staffTel) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.staffTel = staffTel;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffTel() {
		return staffTel;
	}

	public void setStaffTel(String staffTel) {
		this.staffTel = staffTel;
	}

}
