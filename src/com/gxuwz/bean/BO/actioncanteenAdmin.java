package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_canteenadmin;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��16������12:20:06
 * Description:ʳ�ù���Աҵ������
 */
public class actioncanteenAdmin {
	private String canteenAdminID;
	private String canteenAdminName;
	private String canteenAdminTel;

	

	public actioncanteenAdmin() {
		super();
	}

	public actioncanteenAdmin(String canteenAdminID, String canteenAdminName,
			String canteenAdminTel) {
		super();
		this.canteenAdminID = canteenAdminID;
		this.canteenAdminName = canteenAdminName;
		this.canteenAdminTel = canteenAdminTel;
	}

	public String getCanteenAdminID() {
		return canteenAdminID;
	}

	public void setCanteenAdminID(String canteenAdminID) {
		this.canteenAdminID = canteenAdminID;
	}

	public String getCanteenAdminName() {
		return canteenAdminName;
	}

	public void setCanteenAdminName(String canteenAdminName) {
		this.canteenAdminName = canteenAdminName;
	}

	public String getCanteenAdminTel() {
		return canteenAdminTel;
	}

	public void setCanteenAdminTel(String canteenAdminTel) {
		this.canteenAdminTel = canteenAdminTel;
	}
/*
 * ϵͳ����Ա��ѯ���вɹ�Ա��Ϣ
 */
	public List<sys_canteenadmin> listcanteenAdmin() throws Exception {

		String sql = "select * from sys_canteenAdmin";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		List<sys_canteenadmin> ls = new ArrayList<sys_canteenadmin>();
		while (rs.next()) {
			canteenAdminID = rs.getString("canteenAdminID");
			canteenAdminName = rs.getString("canteenAdminName");
			canteenAdminTel = rs.getString("canteenAdminTel");
			sys_canteenadmin sl = new sys_canteenadmin(canteenAdminID,
					canteenAdminName, canteenAdminTel);
			ls.add(sl);

		}
		database.close(rs,pstmt, conn);
		return ls;
	}
/*
 * ϵͳ����Ա���ʳ�ù���Ա��Ϣ
 */
	public void addcanteenAdmin() throws Exception {

		String sql = "insert into sys_canteenadmin(canteenAdminID,canteenAdminName,canteenAdminTel) values(?,?,?)";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, canteenAdminID);
		pstmt.setString(Index++, canteenAdminName);
		pstmt.setString(Index++, canteenAdminTel);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
/*
 * 
 * ϵͳ����Ա�޸�ʳ�ù���Ա��Ϣ
 */
	public void updatecanteenAdmin() throws Exception {

		String sql = "update sys_canteenadmin set canteenAdminName=?,canteenAdminTel=? where canteenAdminID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Index = 1;
		pstmt.setString(Index++, canteenAdminName);
		pstmt.setString(Index++, canteenAdminTel);
		pstmt.setString(Index++, canteenAdminID);
		pstmt.executeUpdate();
		database.close(pstmt, conn);
	}
	/*
	 * ϵͳ����Աɾ��ʳ�ù���Ա��Ϣ
	 */

	public void removecanteenAdmin(String canteenAdminID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_canteenadmin where canteenAdminID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, canteenAdminID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
	/*
	 * ʳ�ù���Ա��ѯ������Ϣ
	 */
	public List<sys_canteenadmin> listcanteenAdmin(String canteenAdminID) throws Exception {

		String sql = "select * from sys_canteenAdmin where canteenAdminID=?";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, canteenAdminID);
		ResultSet rs = pstmt.executeQuery();

		List<sys_canteenadmin> ls = new ArrayList<sys_canteenadmin>();
		while (rs.next()) {
			canteenAdminID = rs.getString("canteenAdminID");
			canteenAdminName = rs.getString("canteenAdminName");
			canteenAdminTel = rs.getString("canteenAdminTel");
			sys_canteenadmin sl = new sys_canteenadmin(canteenAdminID,
					canteenAdminName, canteenAdminTel);
			ls.add(sl);

		}
		database.close(rs,pstmt, conn);
		return ls;
	}
}
