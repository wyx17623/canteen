package com.gxuwz.bean.BO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listordering;
import com.gxuwz.bean.vo.listorderingcount;
import com.gxuwz.bean.vo.listexpenditure;
/**
 * 
 * @author 
 * 时间：2019年6月17日上午1:14:13
 * Description:订单业务处理类
 */
public class actionordering {
private String orderingID;
private String menuID;
private String staffID;
private String orderingNum;
private String surplusNum;
private String ordertime;

public actionordering(String orderingID, String menuID, String staffID,
		String orderingNum, String surplusNum, String ordertime) {
	super();
	this.orderingID = orderingID;
	this.orderingID = orderingID;
	this.staffID = staffID;
	this.orderingNum = orderingNum;
	this.surplusNum = surplusNum;
	this.ordertime = ordertime;
}
public actionordering(String orderingID, String menuID, String staffID,
		String orderingNum) {
	super();
	this.orderingID = orderingID;
	this.menuID = menuID;
	this.staffID = staffID;
	this.orderingNum = orderingNum;
	this.surplusNum = orderingNum;
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    this.ordertime = sf.format(date);
}

public String getOrderingID() {
	return orderingID;
}


public void setOrderingID(String orderingID) {
	this.orderingID = orderingID;
}


public String getMenuID() {
	return menuID;
}


public void setMenuID(String menuID) {
	this.menuID = menuID;
}


public String getOrdertime() {
	return ordertime;
}

public void setOrdertime(String ordertime) {
	this.ordertime = ordertime;
}

public String getStaffID() {
	return staffID;
}
public void setStaffID(String staffID) {
	this.staffID = staffID;
}
public String getOrderingNum() {
	return orderingNum;
}
public void setOrderingNum(String orderingNum) {
	this.orderingNum = orderingNum;
}
public String getSurplusNum() {
	return surplusNum;
}
public void setSurplusNum(String surplusNum) {
	this.surplusNum = surplusNum;
}
public String getordertime() {
	return ordertime;
}
public void setordertime(String ordertime) {
	this.ordertime = ordertime;
}
public actionordering() {
	super();
} 

/*
 * 
 * 
 * 取餐时调用该方法，改便剩余餐品数量，（实际没有取餐功能）
 */
public void updateordering(int surplusNum,String orderingID) throws Exception {

	String sql = "update sys_ordering set surplusNum=? where orderingID=?";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, menuID);
	pstmt.setString(Index++, staffID);
	pstmt.setString(Index++, orderingNum);
	pstmt.setInt(Index++, surplusNum);
	pstmt.setString(Index++, ordertime);
	pstmt.setString(Index++, orderingID);
	pstmt.executeUpdate();
	database.close(pstmt, conn);
}
/*
 * 
 * 机关工作人员订餐
 */
public void addordering() throws Exception {
    
	String sql = "insert into sys_ordering(orderingID,menuID,staffID,orderingNum,surplusNum,ordertime) values(?,?,?,?,?,?)";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, orderingID);
	pstmt.setString(Index++, menuID);
	pstmt.setString(Index++, staffID);
	pstmt.setString(Index++, orderingNum);
	pstmt.setString(Index++, surplusNum);
	pstmt.setString(Index++, ordertime);
	pstmt.executeUpdate();
	database.close(pstmt, conn);
}
//机关工作人员修改订单，但是目前订餐平台没有修改这个功能，所以取消这个功能
/*public void updateordering() throws Exception {

	String sql = "update sys_ordering set menuID=?,staffID=?,orderingNum=?,surplusNum=?,ordertime=? where orderingID=?";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, menuID);
	pstmt.setString(Index++, staffID);
	pstmt.setString(Index++, orderingNum);
	pstmt.setString(Index++, surplusNum);
	pstmt.setString(Index++, ordertime);
	pstmt.setString(Index++, orderingID);
	pstmt.executeUpdate();

}*/
/*
 * 
 * 
 * 机关工作人员退单
 */
public void removeordering(String orderingID) throws Exception {
	Connection conn = database.getConn();
	String sql = "delete from sys_ordering where orderingID=?";

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int parameterIndex = 1;
	pstmt.setString(parameterIndex, orderingID);

	int count = pstmt.executeUpdate();
	database.close(pstmt, conn);
}
/*
 * 
 * 
 * 点完餐之后返回的页面，显示当前的订餐信息,同时也是查询单一订单的方法
 */
public List<listordering> listordering(String staffID,String orderingID) throws Exception {

	String sql = "select orderingID,menuName,staffName,orderingNum,surplusNum,ordertime "
			+ "from sys_ordering a,sys_staff b,sys_menu c "
			+ "where a.menuID=c.menuID and a.staffID=b.staffID and a.staffID=? and orderingID=?";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int parameterIndex = 1;
	pstmt.setString(parameterIndex++, staffID);
	pstmt.setString(parameterIndex, orderingID);
	ResultSet rs = pstmt.executeQuery();

	List<listordering> ls = new ArrayList<listordering>();
	while (rs.next()) {
		orderingID = rs.getString("orderingID");
String 	menuName = rs.getString("menuName");
String 	staffName = rs.getString("staffName");
		orderingNum =rs.getString("orderingNum");
		surplusNum =rs.getString("surplusNum");
		ordertime =rs.getString("ordertime");
		listordering sl = new listordering(orderingID,menuName,staffName, Integer.parseInt(orderingNum),Integer.parseInt(surplusNum),ordertime);
		ls.add(sl);

	}
	database.close(rs,pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 机关工作人员查询所有订单
 */
public List<listordering> listordering(String staffID) throws Exception {

	String sql = "select orderingID,menuName,staffName,orderingNum,surplusNum,ordertime "
			+ "from sys_ordering a,sys_staff b,sys_menu c "
			+ "where a.menuID=c.menuID and a.staffID=b.staffID and a.staffID=? Order By ordertime Desc";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int parameterIndex = 1;
	pstmt.setString(parameterIndex++, staffID);
	ResultSet rs = pstmt.executeQuery();

	List<listordering> ls = new ArrayList<listordering>();
	while (rs.next()) {
		orderingID = rs.getString("orderingID");
String 	menuName = rs.getString("menuName");
String 	staffName = rs.getString("staffName");
		orderingNum =rs.getString("orderingNum");
		surplusNum =rs.getString("surplusNum");
		ordertime =rs.getString("ordertime");
		listordering sl = new listordering(orderingID,menuName,staffName, Integer.parseInt(orderingNum),Integer.parseInt(surplusNum),ordertime);
		ls.add(sl);

	}
	database.close(rs,pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 
 * 采购员：统计订单情况，菜品的数量情况
 */

public List<listorderingcount> listorderingcount() throws Exception {

	String sql = "select a.menuID,menuName,count(a.menuID)*orderingNum orderingNum from sys_ordering a,sys_menu b where a.menuID = b.menuID group BY a.menuID";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);

	ResultSet rs = pstmt.executeQuery();

	List<listorderingcount> ls = new ArrayList<listorderingcount>();
	while (rs.next()) {
		menuID = rs.getString("menuID");
String 	menuName = rs.getString("menuName");
		orderingNum =rs.getString("orderingNum");
		
		listorderingcount sl = new listorderingcount(menuID,menuName,orderingNum);
		ls.add(sl);

	}
	database.close(rs,pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 
 * 会计统计员工姓名、月份、用餐次数、总费用
 */
public List<listexpenditure> listorderingexpenditure() throws Exception {

	String sql = "select b.staffID,staffName,MONTH(ordertime) months,count(orderingID) mealNum,sum(orderingNum*price) totalCost from sys_staff a,sys_ordering b,sys_menu c where b.staffID = a.staffID and b.menuID=c.menuID GROUP BY b.staffID,MONTH(ordertime)";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);

	ResultSet rs = pstmt.executeQuery();

	List<listexpenditure> ls = new ArrayList<listexpenditure>();
	while (rs.next()) {
		staffID = rs.getString("staffID");
String 	staffName = rs.getString("staffName");
String  months =rs.getString("months");
String  mealNum =rs.getString("mealNum");
String  totalCost =rs.getString("totalCost");
		listexpenditure sl = new listexpenditure( staffID,  staffName,  months, mealNum,  totalCost);
		ls.add(sl);

	}
	database.close(rs,pstmt, conn);
	return ls;
}

}
