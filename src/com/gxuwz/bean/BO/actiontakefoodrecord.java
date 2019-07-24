package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listordering;
import com.gxuwz.bean.vo.listtakefoodrecord;
import com.gxuwz.bean.BO.actionordering;

/**
 * 
 * @author 
 * 时间：2019年6月17日下午3:37:21
 * Description:取餐记录业务处理类
 */
public class actiontakefoodrecord {
  private String orderingID;
  private String takefoodtime;
  


public actiontakefoodrecord() {
	super();
}
public actiontakefoodrecord(String orderingID, String takefoodtime) {
	super();
	this.orderingID = orderingID;
	this.takefoodtime = takefoodtime;
}
public String getOrderingID() {
	return orderingID;
}
public void setOrderingID(String orderingID) {
	this.orderingID = orderingID;
}
public String getTakefoodtime() {
	return takefoodtime;
}
public void setTakefoodtime(String takefoodtime) {
	this.takefoodtime = takefoodtime;
}
/*
 * 
 * 取餐记录查询
 * 
 */
public List<listtakefoodrecord> listtakefoodrecord(String staffID) throws Exception{
    
String sql="select c.orderingID,menuName,takefoodtime,surplusNum from sys_ordering a,sys_menu b,sys_takefoodrecord c "
		+ "where  c.orderingID=a.orderingID and a.menuID=b.menuID and a.staffID=? and DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(takefoodtime) order by takefoodtime DESC";


Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, staffID);
ResultSet rs = pstmt.executeQuery();

List<listtakefoodrecord> ls =new ArrayList<listtakefoodrecord>();
while (rs.next()) {
orderingID = rs.getString("orderingID");
takefoodtime = rs.getString("takefoodtime");
String menuName = rs.getString("menuName");
String surplusNum = rs.getString("surplusNum");

listtakefoodrecord sl =new listtakefoodrecord(orderingID,menuName,takefoodtime,surplusNum);
ls.add(sl);

}
database.close(rs,pstmt, conn);
	  return ls;
 }
/*
 * 每次取餐时在取餐记录表上添加记录
 */
public boolean addtakefoodrecord(String staffID,String orderingID) throws Exception {
	actionordering updateordering = new actionordering();
	List<listordering> list=updateordering.listordering(orderingID);
	listordering ls =list.get(1);
	int surplusNum=ls.getSurplusNum();
	if(surplusNum==0){
		return false;
	}else if(surplusNum>0){
		surplusNum--;
	}
	updateordering.updateordering(surplusNum,orderingID);
	String sql = "insert into sys_takefoodrecord(orderingID,takefoodtime) values(?,?)";

	Connection conn = database.getConn();

	PreparedStatement pstmt = conn.prepareStatement(sql);
	int Index = 1;
	pstmt.setString(Index++, orderingID);
	pstmt.setString(Index++, takefoodtime);
	pstmt.executeUpdate();
	database.close(pstmt, conn);
	return true;
}

}
