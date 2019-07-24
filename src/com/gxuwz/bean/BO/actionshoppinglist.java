package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listshoppinglist;
/**
 * 
 * @author 
 * 时间：2019年6月18日上午12:09:54
 * Description:采购单业务处理类
 */
public class actionshoppinglist {
private String shoppingID;
private String buyerID;
private String shoppingTime;
private String totalMoney;
private String status;//0代表未审核，1代表通过，2代表未通过
public actionshoppinglist() {
	super();
}

public actionshoppinglist(String shoppingID, String buyerID,
		String shoppingTime, String totalMoney, String status) {
	super();
	this.shoppingID = shoppingID;
	this.buyerID = buyerID;
	this.shoppingTime = shoppingTime;
	this.totalMoney = totalMoney;
	this.status = status;
}
public actionshoppinglist(String buyerID) {
	super();
	
	this.buyerID = buyerID;
}
public String getShoppingID() {
	return shoppingID;
}

public void setShoppingID(String shoppingID) {
	this.shoppingID = shoppingID;
}

public String getBuyerID() {
	return buyerID;
}

public void setBuyerID(String buyerID) {
	this.buyerID = buyerID;
}

public String getShoppingTime() {
	return shoppingTime;
}

public void setShoppingTime(String shoppingTime) {
	this.shoppingTime = shoppingTime;
}

public String getTotalMoney() {
	return totalMoney;
}

public void setTotalMoney(String totalMoney) {
	this.totalMoney = totalMoney;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

/*
 * 
 * 
 * 
 * 
 * 采购员查询自己通过审核的采购清单
 */
public List<listshoppinglist> listshoppinglist() throws Exception {

	String sql = "select shoppingID,buyerName,totalMoney,shoppingTime,status"
			+" from sys_shoppinglist a,sys_buyer b"
			+" where a.buyerID=b.buyerID and a.buyerID=? and status=1 order by shoppingTime desc";

	Connection conn = database.getConn();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, buyerID); 
	ResultSet rs = pstmt.executeQuery();

	List<listshoppinglist> ls = new ArrayList<listshoppinglist>();

	while (rs.next()) {
		shoppingID = rs.getString("shoppingID");
String	buyerName = rs.getString("buyerName");
        totalMoney=rs.getString("totalMoney");
     	shoppingTime =rs.getString("shoppingTime");
     	status =rs.getString("status");
     	if(status.equals("1")){
     		status="已通过";
     	}
totalMoney=countTotalMoney.totalMoney(shoppingID);
countTotalMoney.updatetotalMoney(shoppingID);
    listshoppinglist sl = new listshoppinglist(shoppingID,buyerName,totalMoney,shoppingTime,status);
		ls.add(sl);

	}
         database.close(rs, pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 查询采购员可以修改的采购单,即未审核或未审核通过的
 */
public List<listshoppinglist> listshoppingUpdatelist() throws Exception {

	String sql = "select shoppingID,buyerName,totalMoney,shoppingTime,status"
			+" from sys_shoppinglist a,sys_buyer b"
			+" where a.buyerID=b.buyerID and a.buyerID=? and status=0 or status=2  order by shoppingTime desc";

	Connection conn = database.getConn();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, buyerID); 
	ResultSet rs = pstmt.executeQuery();
	List<listshoppinglist> ls = new ArrayList<listshoppinglist>();

	while (rs.next()) {
		shoppingID = rs.getString("shoppingID");
String	buyerName = rs.getString("buyerName");
        totalMoney=rs.getString("totalMoney");
     	shoppingTime =rs.getString("shoppingTime");
     	status =rs.getString("status");
     	if(status.equals("0")){
     		status="未审核";
     	}
if(status.equals("2")){
	status="未通过";
	}
totalMoney=countTotalMoney.totalMoney(shoppingID);
countTotalMoney.updatetotalMoney(shoppingID);
    listshoppinglist sl = new listshoppinglist(shoppingID,buyerName,totalMoney,shoppingTime,status);
		ls.add(sl);

	}
         database.close(rs, pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 采购员修改采购清单
 */
public void updateshoppinglist(String shoppingID) throws Exception {

	String sql = "update sys_shoppinglist set totalMoney=?,shoppingTime=? where shoppingID=?";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, totalMoney);
	pstmt.setString(Index++, shoppingTime);
	pstmt.setString(Index++, shoppingID);
	pstmt.executeUpdate();
	database.close(pstmt, conn);
}
/*
 * 
 * 
 * 
 * 采购员填写订单
 */
public void addshoppinglist() throws Exception {
    
	String sql = "insert into sys_shoppinglist(shoppingID,buyerID,totalMoney,shoppingTime,status) values(?,?,?,?,?)";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, shoppingID);
	pstmt.setString(Index++, buyerID);
	pstmt.setString(Index++, totalMoney);
	pstmt.setString(Index++, shoppingTime);
	pstmt.setString(Index++, status);
	pstmt.executeUpdate();

}
public void removeshoppinglist(String shoppingID) throws Exception {
	Connection conn = database.getConn();
	String sql = "delete from sys_shoppinglist where shoppingID=?";

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int parameterIndex = 1;
	pstmt.setString(parameterIndex, shoppingID);

	int count = pstmt.executeUpdate();
	database.close(pstmt, conn);
}
/*
 * 
 * 
 * 
 * 采购员查询单一订单的方法
 */
public List<listshoppinglist> listshoppinglist(String shoppingID) throws Exception {

	String sql = "select shoppingID,buyerName,totalMoney,shoppingTime,status from sys_shoppinglist a,sys_buyer b where a.buyerID=b.buyerID and a.shoppingID=? ";
	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, shoppingID); 
	ResultSet rs = pstmt.executeQuery();

	List<listshoppinglist> ls = new ArrayList<listshoppinglist>();
	while (rs.next()) {
		shoppingID = rs.getString("shoppingID");
String	buyerName = rs.getString("buyerName");
     	totalMoney = rs.getString("totalMoney");
     	shoppingTime =rs.getString("shoppingTime");
     	status =rs.getString("status");
		listshoppinglist sl = new listshoppinglist(shoppingID,buyerName,totalMoney,shoppingTime,status);
		ls.add(sl);

	}
         database.close(rs, pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 出纳查询未审核的采购单
 */
public List<listshoppinglist>listshoppingcashier() throws Exception {

	String sql = "select shoppingID,buyerName,totalMoney,shoppingTime,status"
			+" from sys_shoppinglist a,sys_buyer b"
			+" where a.buyerID=b.buyerID and status=0 order by shoppingTime desc";
	Connection conn = database.getConn();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	List<listshoppinglist> ls = new ArrayList<listshoppinglist>();
	while (rs.next()) {
		shoppingID = rs.getString("shoppingID");
String	buyerName = rs.getString("buyerName");
        totalMoney=rs.getString("totalMoney");
     	shoppingTime =rs.getString("shoppingTime");
     	status =rs.getString("status");
     	if(status.equals("0")){
     		status="未审核";
     	}
totalMoney=countTotalMoney.totalMoney(shoppingID);
countTotalMoney.updatetotalMoney(shoppingID);
    listshoppinglist sl = new listshoppinglist(shoppingID,buyerName,totalMoney,shoppingTime,status);
		ls.add(sl);

	}
         database.close(rs, pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 出纳查询已审核过的订单
 */
public List<listshoppinglist>listshoppingcashierReview() throws Exception {

	String sql = "select shoppingID,buyerName,totalMoney,shoppingTime,status"
			+" from sys_shoppinglist a,sys_buyer b"
			+" where a.buyerID=b.buyerID and status=1 or status=2 order by shoppingTime desc";
	Connection conn = database.getConn();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();

	List<listshoppinglist> ls = new ArrayList<listshoppinglist>();

	while (rs.next()) {
		shoppingID = rs.getString("shoppingID");
String	buyerName = rs.getString("buyerName");
        totalMoney=rs.getString("totalMoney");
     	shoppingTime =rs.getString("shoppingTime");
     	status =rs.getString("status");
     	if(status.equals("1")){
     		status="已通过";
     	}
     	if(status.equals("2")){
     		status="未通过";
     	}
totalMoney=countTotalMoney.totalMoney(shoppingID);
countTotalMoney.updatetotalMoney(shoppingID);
    listshoppinglist sl = new listshoppinglist(shoppingID,buyerName,totalMoney,shoppingTime,status);
		ls.add(sl);

	}
         database.close(rs, pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 出纳审核采购单，即：修改采购单的状态：由未审核变为通过或未通过
 */
public void updateshoppinglist(String shoppingID,String status) throws Exception {

	String sql = "update sys_shoppinglist set status=? where shoppingID=?";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	
	pstmt.setString(Index++, status);
	pstmt.setString(Index++, shoppingID);
	pstmt.executeUpdate();
	database.close(pstmt, conn);
}
}
