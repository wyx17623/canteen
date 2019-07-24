package com.gxuwz.bean.BO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.gxuwz.base.database;
/**
 * 
 * @author 
 * 时间：2019年6月21日下午5:03:50
 * Description:采购员姓名查询
 */
public class SelectBuyerName {
private String buyerName;
/*
 * 
 * 
 * 查询采购员姓名
 */
public String selectBuyerName(String buyerID) throws Exception {

	String sql = "select buyerName from sys_buyer where buyerID=? ";
	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, buyerID); 
	ResultSet rs = pstmt.executeQuery();

	while (rs.next()) {
	buyerName = rs.getString("buyerName");
	}
         database.close(rs, pstmt, conn);
	return buyerName;
}
}
