package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��14������11:07:19
 * Description:ʳ�ù���Աʵ����
 */
public class sys_canteenadmin {
	private String canteenAdminID;
	private String canteenAdminName;
	private String canteenAdminTel;

	public sys_canteenadmin() {
		super();
	}

	public sys_canteenadmin(String canteenAdminID, String canteenAdminName,
			String canteenAdminTel) {
		super();
		this.canteenAdminID = canteenAdminID;
		this.canteenAdminName = canteenAdminName;
		this.canteenAdminTel = canteenAdminTel;
	}

	public String getCanteenAdminID() {
		return canteenAdminID;
	}

	public void setCanteenAdminID(String canteenAdminID) {
		this.canteenAdminID = canteenAdminID;
	}

	public String getCanteenAdminName() {
		return canteenAdminName;
	}

	public void setCanteenAdminName(String canteenAdminName) {
		this.canteenAdminName = canteenAdminName;
	}

	public String getCanteenAdminTel() {
		return canteenAdminTel;
	}

	public void setCanteenAdminTel(String canteenAdminTel) {
		this.canteenAdminTel = canteenAdminTel;
	}

}
