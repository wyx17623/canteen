package com.gxuwz.bean.vo;

public class listexpenditure {
	//员工ID，员工姓名、月份、用餐次数、总费用
	private String staffID;
	private String staffName;
	private String months;
	private String mealNum;
	private String totalCost;
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
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	public String getMealNum() {
		return mealNum;
	}
	public void setMealNum(String mealNum) {
		this.mealNum = mealNum;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public listexpenditure(String staffID, String staffName, String months,
			String mealNum, String totalCost) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.months = months;
		this.mealNum = mealNum;
		this.totalCost = totalCost;
	}
	public listexpenditure() {
		super();
	}
	
	
}
