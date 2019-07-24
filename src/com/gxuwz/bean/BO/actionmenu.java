package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_menu;

public class actionmenu {
private String menuID;
private String menuName;
private String menuDescription;
private String price;
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
public actionmenu(String menuID, String menuName, String menuDescription,
		String price) {
	super();
	this.menuID = menuID;
	this.menuName = menuName;
	this.menuDescription = menuDescription;
	this.price = price;
}
public actionmenu() {
	super();
}
public List<sys_menu> listmenu() throws Exception {

	String sql = "select * from sys_menu";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);

	ResultSet rs = pstmt.executeQuery();

	List<sys_menu> ls = new ArrayList<sys_menu>();
	while (rs.next()) {
		menuID = rs.getString("menuID");
		menuName = rs.getString("menuName");
		menuDescription = rs.getString("menuDescription");
		price =rs.getString("price");
		sys_menu sl = new sys_menu(menuID,
				menuName, menuDescription,price);
		ls.add(sl);

	}
	database.close(rs,pstmt, conn);
	return ls;
}
/*
 * 
 * 食堂管理员增加菜单的方法
 */
public void addmenu() throws Exception {

	String sql = "insert into sys_menu(menuID,menuName,menuDescription,price) values(?,?,?,?)";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, menuID);
	pstmt.setString(Index++, menuName);
	pstmt.setString(Index++, menuDescription);
	pstmt.setString(Index++, price);
	pstmt.executeUpdate();
	database.close(pstmt, conn);
}
/*
 * 
 * 
 * 食堂管理员修改菜单的方法
 */
public void updatemenu() throws Exception {

	String sql = "update sys_menu set menuName=?,menuDescription=?,price=? where menuID=?";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, menuName);
	pstmt.setString(Index++, menuDescription);
	pstmt.setString(Index++, price);
	pstmt.setString(Index++, menuID);
	pstmt.executeUpdate();
	database.close(pstmt, conn);
}
/*
 * 
 * 食堂管理员删除菜单的方法
 */
public void removemenu(String menuID) throws Exception {
	Connection conn = database.getConn();
	String sql = "delete from sys_menu where menuID=?";

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int parameterIndex = 1;
	pstmt.setString(parameterIndex, menuID);

	int count = pstmt.executeUpdate();
	database.close(pstmt, conn);
}
}
