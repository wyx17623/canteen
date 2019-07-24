package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_accountant;
/**
 * 
 * @author 
 * 时间：2019年6月16日下午12:20:06
 * Description:会计业务处理类
 */
public class actionaccountant {
	private String accountantID;
	private String accountantName;
	private String accountantTel;

	public String getaccountantTel() {
		return accountantTel;
	}

	public void setaccountantTel(String accountantTel) {
		this.accountantTel = accountantTel;
	}

	public String getAccountantID() {
		return accountantID;
	}

	public void setAccountantID(String accountantID) {
		this.accountantID = accountantID;
	}

	public String getAccountantName() {
		return accountantName;
	}

	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}

	public actionaccountant() {
		super();
	}

	public actionaccountant(String accountantID, String accountantName,
			String accountantTel) {
		super();
		this.accountantID = accountantID;
		this.accountantName = accountantName;
		this.accountantTel = accountantTel;
	}
/*
 * 
 * 
 * 系统管理员查询所有会计人员信息
 */
	public List<sys_accountant> listaccountant() throws Exception {

		String sql = "select * from sys_accountant";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		List<sys_accountant> ls = new ArrayList<sys_accountant>();
		while (rs.next()) {
			accountantID = rs.getString("accountantID");
			accountantName = rs.getString("accountantName");
			accountantTel = rs.getString("accountantTel");
			sys_accountant sl = new sys_accountant(accountantID,
					accountantName, accountantTel);
			ls.add(sl);

		}
		database.close(rs,pstmt, conn);
		return ls;
	}
/*
 * 
 * 系统管理员添加会计
 */
	public void addaccountant() throws Exception {

		String sql = "insert into sys_accountant(accountantID,accountantName,accountantTel) values(?,?,?)";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, accountantID);
		pstmt.setString(Index++, accountantName);
		pstmt.setString(Index++, accountantTel);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
/*
 * 
 * 系统管理员修改会计人员信息
 */
	public void updateaccountant() throws Exception {

		String sql = "update sys_accountant set accountantName=?,accountantTel=? where accountantID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, accountantName);
		pstmt.setString(Index++, accountantTel);
		pstmt.setString(Index++, accountantID);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
/*
 * 
 * 系统管理员删除会计人员信息
 */
	public void removeaccountant(String accountantID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_accountant where accountantID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, accountantID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
	/*
	 * 
	 * 
	 * 
	 * 会计查询个人信息
	 */
	public List<sys_accountant> listaccountant(String accountantID) throws Exception {

		String sql = "select * from sys_accountant where accountantID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int parameterIndex = 1;
		pstmt.setString(parameterIndex, accountantID);
		ResultSet rs = pstmt.executeQuery();

		List<sys_accountant> ls = new ArrayList<sys_accountant>();
		while (rs.next()) {
			accountantID = rs.getString("accountantID");
			accountantName = rs.getString("accountantName");
			accountantTel = rs.getString("accountantTel");
			sys_accountant sl = new sys_accountant(accountantID,
					accountantName, accountantTel);
			ls.add(sl);

		}
		database.close(pstmt, conn);
		return ls;
	}
}
