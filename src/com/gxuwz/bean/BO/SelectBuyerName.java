package com.gxuwz.bean.BO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.gxuwz.base.database;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��21������5:03:50
 * Description:�ɹ�Ա������ѯ
 */
public class SelectBuyerName {
private String buyerName;
/*
 * 
 * 
 * ��ѯ�ɹ�Ա����
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
