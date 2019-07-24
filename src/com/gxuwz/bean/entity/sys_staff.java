package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * 时间：2019年6月14日上午11:03:23
 * Description:公司工作人员实体类
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
