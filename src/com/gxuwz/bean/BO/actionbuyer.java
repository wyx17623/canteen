package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_buyer;
/**
 * 
 * @author 
 * 时间：2019年6月16日下午2:07:44
 * Description:采购员业务处理类
 */
public class actionbuyer {
	private String buyerID;
	private String buyerName;
	private String buyerTel;

	public String getbuyerTel() {
		return buyerTel;
	}

	public void setbuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public String getbuyerID() {
		return buyerID;
	}

	public void setbuyerID(String buyerID) {
		this.buyerID = buyerID;
	}

	public String getbuyerName() {
		return buyerName;
	}

	public void setbuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public actionbuyer() {
		super();
	}

	public actionbuyer(String buyerID, String buyerName,
			String buyerTel) {
		super();
		this.buyerID = buyerID;
		this.buyerName = buyerName;
		this.buyerTel = buyerTel;
	}
/*
 * 系统管理员查询所有采购员的信息
 */
	public List<sys_buyer> listbuyer() throws Exception {

		String sql = "select * from sys_buyer";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		List<sys_buyer> ls = new ArrayList<sys_buyer>();
		while (rs.next()) {
			buyerID = rs.getString("buyerID");
			buyerName = rs.getString("buyerName");
			buyerTel = rs.getString("buyerTel");
			sys_buyer sl = new sys_buyer(buyerID,
					buyerName, buyerTel);
			ls.add(sl);

		}
		database.close(rs,pstmt, conn);
		return ls;
	}
	/*
	 * 系统管理员添加采购员
	 */

	public void addbuyer() throws Exception {

		String sql = "insert into sys_buyer(buyerID,buyerName,buyerTel) values(?,?,?)";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, buyerID);
		pstmt.setString(Index++, buyerName);
		pstmt.setString(Index++, buyerTel);
		pstmt.executeUpdate();
		database.close(pstmt, conn);

	}
/*
 * 系统管理员修改采购员信息
 */
	public void updatebuyer() throws Exception {

		String sql = "update sys_buyer set buyerName=?,buyerTel=? where buyerID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, buyerName);
		pstmt.setString(Index++, buyerTel);
		pstmt.setString(Index++, buyerID);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
/*
 * 系统管理员删除采购员信息
 */
	public void removebuyer(String buyerID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_buyer where buyerID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, buyerID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
	//采购员查看个人信息
	public List<sys_buyer> listbuyer(String buyerID) throws Exception {

		String sql = "select * from sys_buyer where buyerID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int parameterIndex = 1;
		pstmt.setString(parameterIndex, buyerID);
		ResultSet rs = pstmt.executeQuery();

		List<sys_buyer> ls = new ArrayList<sys_buyer>();
		while (rs.next()) {
			buyerID = rs.getString("buyerID");
			buyerName = rs.getString("buyerName");
			buyerTel = rs.getString("buyerTel");
			sys_buyer sl = new sys_buyer(buyerID,
					buyerName, buyerTel);
			ls.add(sl);

		}
		database.close(rs,pstmt, conn);
		return ls;
	}
}
