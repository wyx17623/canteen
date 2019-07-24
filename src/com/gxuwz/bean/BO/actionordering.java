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
 * ʱ�䣺2019��6��17������1:14:13
 * Description:����ҵ������
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
 * ȡ��ʱ���ø÷������ı�ʣ���Ʒ��������ʵ��û��ȡ�͹��ܣ�
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
 * ���ع�����Ա����
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
//���ع�����Ա�޸Ķ���������Ŀǰ����ƽ̨û���޸�������ܣ�����ȡ���������
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
 * ���ع�����Ա�˵�
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
 * �����֮�󷵻ص�ҳ�棬��ʾ��ǰ�Ķ�����Ϣ,ͬʱҲ�ǲ�ѯ��һ�����ķ���
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
 * ���ع�����Ա��ѯ���ж���
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
 * �ɹ�Ա��ͳ�ƶ����������Ʒ���������
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
 * ���ͳ��Ա���������·ݡ��òʹ������ܷ���
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
