package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gxuwz.base.database;

/**
 * 
 * @author 
 * ʱ�䣺2019��6��21������5:04:15
 * Description:�ɹ��嵥�ܽ�����
 */
public class countTotalMoney{
	/*
	 * 
	 * 
	 * ͨ����ϸ�����ɹ��嵥���ܽ��
	 */
	public static String  totalMoney(String shoppingID) throws Exception{
		String sql = "select price,materialsNum from sys_detaillist where shoppingID=?";
		Connection conn = database.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, shoppingID); 
		ResultSet rs = pstmt.executeQuery();
		double totalMoney=0;
	while(rs.next()){
		float price =rs.getFloat("price");
		float materialsNum = rs.getInt("materialsNum");
		totalMoney+=price*materialsNum;
	}
	database.close(rs,pstmt, conn);
	return totalMoney+"";
		
		
	}
	/*
	 * 
	 * 
	 * �޸Ĳɹ��嵥�е��ܽ��
	 */
	public static void updatetotalMoney(String shoppingID) throws SQLException, Exception{
		String sql = "update sys_shoppinglist set totalMoney=? where shoppingID=?";
		Connection conn = database.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, totalMoney(shoppingID)); 
		pstmt.setString(Index++, shoppingID); 
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
}
