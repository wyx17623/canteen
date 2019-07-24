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
 * ʱ�䣺2019��6��18������12:09:54
 * Description:�ɹ���ҵ������
 */
public class actionshoppinglist {
private String shoppingID;
private String buyerID;
private String shoppingTime;
private String totalMoney;
private String status;//0����δ��ˣ�1����ͨ����2����δͨ��
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
 * �ɹ�Ա��ѯ�Լ�ͨ����˵Ĳɹ��嵥
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
     		status="��ͨ��";
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
 * ��ѯ�ɹ�Ա�����޸ĵĲɹ���,��δ��˻�δ���ͨ����
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
     		status="δ���";
     	}
if(status.equals("2")){
	status="δͨ��";
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
 * �ɹ�Ա�޸Ĳɹ��嵥
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
 * �ɹ�Ա��д����
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
 * �ɹ�Ա��ѯ��һ�����ķ���
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
 * ���ɲ�ѯδ��˵Ĳɹ���
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
     		status="δ���";
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
 * ���ɲ�ѯ����˹��Ķ���
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
     		status="��ͨ��";
     	}
     	if(status.equals("2")){
     		status="δͨ��";
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
 * ������˲ɹ����������޸Ĳɹ�����״̬����δ��˱�Ϊͨ����δͨ��
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
