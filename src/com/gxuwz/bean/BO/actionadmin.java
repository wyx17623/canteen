 package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_admin;
/**
 * 
 * @author 
 * 时间：2019年6月16日上午10:32:30
 * Description:系统管理员业务处理类
 */
public class actionadmin {
  private String adminID;
  private String adminName;
  private String adminTel;
  
public actionadmin() {
	super();
}
public actionadmin(String adminID, String adminName, String adminTel) {
	super();
	this.adminID = adminID;
	this.adminName = adminName;
	this.adminTel = adminTel;
}
public String getadminID() {
	return adminID;
}
public void setadminID(String adminID) {
	this.adminID = adminID;
}
public String getadminName() {
	return adminName;
}
public void setadminName(String adminName) {
	this.adminName = adminName;
}
public String getadminTel() {
	return adminTel;
}
public void setadminTel(String adminTel) {
	this.adminTel = adminTel;
}
/*
 * 
 * 系统管理员查询个人信息
 */
public List<sys_admin> listadmin (String adminID) throws Exception{
    
String sql="select adminID,adminName,adminTel from sys_admin where adminID=?";


Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, adminID);
ResultSet rs = pstmt.executeQuery();

List<sys_admin> ls =new ArrayList<sys_admin>();
while (rs.next()) {
adminID = rs.getString("adminID");
adminName = rs.getString("adminName");
 adminTel = rs.getString("adminTel");
sys_admin sl =new sys_admin(adminID,adminName,adminTel);
ls.add(sl);

}
database.close(pstmt, conn);
	  return ls;
 }
/*
 * 系统管理员修改个人信息
 */
public void  updateadmin () throws Exception{
     
	  String sql="update sys_admin set adminName=? ,adminTel=? where adminID=?";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, adminName);
	   pstmt.setString(Index++, adminTel);
	   pstmt.setString(Index++, adminID);
	   pstmt.executeUpdate();
	  //定义int序号变量

	   database.close(pstmt, conn);
	  	  
	    }

}
