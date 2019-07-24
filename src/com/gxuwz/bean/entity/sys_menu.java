package com.gxuwz.bean.entity;

public class sys_menu {
	private String menuID;
	private String menuName;
	private String menuDescription;
	private String price;

	public sys_menu() {
		super();
	}

	public sys_menu(String menuID, String menuName, String menuDescription,
			String price) {
		super();
		this.menuID = menuID;
		this.menuName = menuName;
		this.menuDescription = menuDescription;
		this.price = price;
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

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
