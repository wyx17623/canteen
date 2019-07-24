package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_staff;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��16������2:40:54
 * Description:���ع�����Աҵ������
 */
public class actionstaff {
	private String staffID;
	private String staffName;
	private String staffTel;

	
	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffTel() {
		return staffTel;
	}

	public void setStaffTel(String staffTel) {
		this.staffTel = staffTel;
	}

	public actionstaff(String staffID, String staffName,
			String staffTel) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.staffTel = staffTel;
	}

	public actionstaff() {
		super();
	}
/*
 * 
 * ϵͳ����Ա��ѯ���еĻ��ع�����Ա��Ϣ
 * 
 */
	public List<sys_staff> liststaff() throws Exception {
		String sql = "select * from sys_staff";
		Connection conn = database.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		List<sys_staff> ls = new ArrayList<sys_staff>();
		while (rs.next()) {
			staffID = rs.getString("staffID");
			staffName = rs.getString("staffName");
			staffTel = rs.getString("staffTel");
			sys_staff sl = new sys_staff(staffID,
					staffName, staffTel);
			ls.add(sl);
		}
		database.close(rs,pstmt, conn);
		return ls;
	}
/*
 * 
 * 
 * ϵͳ����Ա���ӻ��ع�����Ա��Ϣ
 * 
 */
	public void addstaff() throws Exception {

		String sql = "insert into sys_staff(staffID,staffName,staffTel) values(?,?,?)";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, staffID);
		pstmt.setString(Index++, staffName);
		pstmt.setString(Index++, staffTel);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
/*
 * 
 * ϵͳ����Ա�޸Ļ��ع�����Ա��Ϣ
 */
	public void updatestaff() throws Exception {

		String sql = "update sys_staff set staffName=?,staffTel=? where staffID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, staffName);
		pstmt.setString(Index++, staffTel);
		pstmt.setString(Index++, staffID);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
	/*
	 * 
	 * 
	 * 
	 * ϵͳ����Ա�޸Ļ��ع�����Ա��Ϣ
	 */
	public void removestaff(String staffID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_staff where staffID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, staffID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
	/*
	 * 
	 * ���ع�����Ա��ѯ������Ϣ
	 */
	public List<sys_staff> liststaff(String staffID) throws Exception {

		String sql = "select * from sys_staff where staffID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int parameterIndex = 1;
		pstmt.setString(parameterIndex, staffID);
		ResultSet rs = pstmt.executeQuery();

		List<sys_staff> ls = new ArrayList<sys_staff>();
		while (rs.next()) {
			staffID = rs.getString("staffID");
			staffName = rs.getString("staffName");
			staffTel = rs.getString("staffTel");
			sys_staff sl = new sys_staff(staffID,
					staffName, staffTel);
			ls.add(sl);

		}
		database.close(rs,pstmt, conn);
		return ls;
	}
}
