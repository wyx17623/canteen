package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_detaillist;

/**
 * 
 * @author 
 * 时间：2019年6月18日下午6:31:22
 * Description:采购明细表业务处理类
 */
public class actiondetaillist {
	private String detailListID;
	private String shoppingID;
	private String materialsName;
	private String price;
	private String materialsNum;
	private String supplier;
public actiondetaillist() {
	super();
}
public actiondetaillist(String detailListID, String shoppingID,
		String materialsName, String price, String materialsNum, String supplier) {
	super();
	this.detailListID = detailListID;
	this.shoppingID = shoppingID;
	this.materialsName = materialsName;
	this.price = price;
	this.materialsNum = materialsNum;
	this.supplier = supplier;
}

public actiondetaillist(String shoppingID) {
	super();
	this.shoppingID = shoppingID;
}

public String getDetailListID() {
	return detailListID;
}



public void setDetailListID(String detailListID) {
	this.detailListID = detailListID;
}



public String getShoppingID() {
	return shoppingID;
}



public void setShoppingID(String shoppingID) {
	this.shoppingID = shoppingID;
}



public String getMaterialsName() {
	return materialsName;
}



public void setMaterialsName(String materialsName) {
	this.materialsName = materialsName;
}



public String getPrice() {
	return price;
}



public void setPrice(String price) {
	this.price = price;
}



public String getMaterialsNum() {
	return materialsNum;
}



public void setMaterialsNum(String materialsNum) {
	this.materialsNum = materialsNum;
}



public String getSupplier() {
	return supplier;
}



public void setSupplier(String supplier) {
	this.supplier = supplier;
}
/*
 * 
 * 
 * 
 * 采购员查询采购清单中的所有明细表
 */
public List<sys_detaillist> listdetaillist() throws Exception {

	String sql = "select detailListID,shoppingID,materialsName,price,materialsNum,supplier from sys_detaillist where shoppingID=?";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, shoppingID);
	ResultSet rs = pstmt.executeQuery();
	List<sys_detaillist> ls = new ArrayList<sys_detaillist>();
	while (rs.next()) {
		detailListID = rs.getString("detailListID");
		shoppingID = rs.getString("shoppingID");
		materialsName = rs.getString("materialsName");
		price =rs.getString("price");
		materialsNum =rs.getString("materialsNum");
		supplier =rs.getString("supplier");
		sys_detaillist sl = new sys_detaillist(detailListID,shoppingID,materialsName,price,materialsNum,supplier);
		ls.add(sl);

	}
         database.close(rs, pstmt, conn);
	return ls;
}
/*
 * 
 * 
 * 
 * 
 * 采购员修改采购明细表
 */
public void updatedetaillist(String detailListID) throws Exception {

	String sql = "update sys_detaillist set materialsName=?,price=?,materialsNum=?,supplier=? where detailListID=?";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, materialsName);
	pstmt.setString(Index++, price);
	pstmt.setString(Index++, materialsNum);
	pstmt.setString(Index++, supplier);
	pstmt.setString(Index++, detailListID);
	pstmt.executeUpdate();
	database.close(pstmt, conn);
}
/*
 * 
 * 
 * 采购员填写(新增）明细表
 */
public void adddetaillist() throws Exception {
    
	String sql = "insert into sys_detaillist(detailListID,shoppingID,materialsName,price,materialsNum,supplier) values(?,?,?,?,?,?)";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, detailListID);
	pstmt.setString(Index++, shoppingID);
	pstmt.setString(Index++, materialsName);
	pstmt.setString(Index++, price);
	pstmt.setString(Index++, materialsNum);
	pstmt.setString(Index++, supplier);
	pstmt.executeUpdate();
	database.close(pstmt, conn);

}
public void removedetaillist(String detailListID) throws Exception {
	Connection conn = database.getConn();
	String sql = "delete from sys_detaillist where detailListID=?";

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int parameterIndex = 1;
	pstmt.setString(parameterIndex, detailListID);

	int count = pstmt.executeUpdate();
	database.close(pstmt, conn);
}
//显示当前的采购明细单信息,同时也是查询单一明细单的方法（这个方法，在实际中貌似没调用过）
public List<sys_detaillist> listdetaillist(String detailListID) throws Exception {
	String sql = "select detailListID,shoppingID,materialsName,price,materialsNum,supplier from sys_detaillist where  detailListID=? ";
	Connection conn = database.getConn();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, detailListID);
	ResultSet rs = pstmt.executeQuery();
	List<sys_detaillist> ls = new ArrayList<sys_detaillist>();
	while (rs.next()) {
		detailListID = rs.getString("detailListID");
		shoppingID = rs.getString("shoppingID");
		materialsName = rs.getString("materialsName");
		price =rs.getString("price");
		materialsNum =rs.getString("materialsNum");
		supplier =rs.getString("supplier");
		sys_detaillist sl = new sys_detaillist(detailListID,shoppingID,materialsName,price,materialsNum,supplier);
		ls.add(sl);

	}
         database.close(rs, pstmt, conn);
	return ls;
}
}
