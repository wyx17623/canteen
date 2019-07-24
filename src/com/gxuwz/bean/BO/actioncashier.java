package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_cashier;
import com.gxuwz.bean.entity.sys_cashier;
/**
 * 
 * @author 
 * 时间：2019年6月16日下午3:42:06
 * Description:出纳人员业务处理类
 */
public class actioncashier {
	private String cashierID;
	private String cashierName;
	private String cashierTel;

	
	public actioncashier() {
		super();
	}

	public actioncashier(String cashierID, String cashierName, String cashierTel) {
		super();
		this.cashierID = cashierID;
		this.cashierName = cashierName;
		this.cashierTel = cashierTel;
	}

	public String getCashierID() {
		return cashierID;
	}

	public void setCashierID(String cashierID) {
		this.cashierID = cashierID;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	public String getCashierTel() {
		return cashierTel;
	}

	public void setCashierTel(String cashierTel) {
		this.cashierTel = cashierTel;
	}
/*
 * 系统管理员查询所有出纳人员信息
 */
	public List<sys_cashier> listcashier() throws Exception {

		String sql = "select * from sys_cashier";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		List<sys_cashier> ls = new ArrayList<sys_cashier>();
		while (rs.next()) {
			cashierID = rs.getString("cashierID");
			cashierName = rs.getString("cashierName");
			cashierTel = rs.getString("cashierTel");
			sys_cashier sl = new sys_cashier(cashierID,
					cashierName, cashierTel);
			ls.add(sl);

		}
		database.close(rs,pstmt, conn);
		return ls;
	}
	/*
	 * 系统管理员添加出纳人员信息
	 */

	public void addcashier() throws Exception {

		String sql = "insert into sys_cashier(cashierID,cashierName,cashierTel) values(?,?,?)";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, cashierID);
		pstmt.setString(Index++, cashierName);
		pstmt.setString(Index++, cashierTel);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
/*
 * 
 * 系统管理员修改出纳人员信息
 */
	public void updatecashier() throws Exception {

		String sql = "update sys_cashier set cashierName=?,cashierTel=? where cashierID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, cashierName);
		pstmt.setString(Index++, cashierTel);
		pstmt.setString(Index++, cashierID);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
/*
 * 系统管理员删除出纳人员信息
 */
	public void removecashier(String cashierID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_cashier where cashierID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, cashierID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
	/*
	 * 
	 * 出纳查看个人信息
	 */
		public List<sys_cashier> listcashier(String cashierID) throws Exception {

			String sql = "select * from sys_cashier where cashierID=?";

			Connection conn = database.getConn();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			int parameterIndex = 1;
			pstmt.setString(parameterIndex, cashierID);
			ResultSet rs = pstmt.executeQuery();

			List<sys_cashier> ls = new ArrayList<sys_cashier>();
			while (rs.next()) {
				cashierID = rs.getString("cashierID");
				cashierName = rs.getString("cashierName");
				cashierTel = rs.getString("cashierTel");
				sys_cashier sl = new sys_cashier(cashierID,
						cashierName, cashierTel);
				ls.add(sl);

			}
			database.close(rs,pstmt, conn);
			return ls;
		}
}
