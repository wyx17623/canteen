package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import com.gxuwz.base.database;
import com.gxuwz.base.base;

public class loginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		try {
			// 2:身份认证
			conn = database.getConn();
			String sql = "select * from sys_user where userID=? and password=? and type=?";
			pstmt = conn.prepareStatement(sql);
			// 设置动态参数对应的值
			int index = 1;
			pstmt.setString(index++, userID);
			pstmt.setString(index++, password);
			pstmt.setString(index++, type);
			// 执行查询
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			database.close(rs, pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 3:跳转目标页面
		if (flag) {
			// 将用户编号绑定到session对象，方便功能菜单取值
			session.setAttribute("userID", userID);
			if (type.equals("0")) {
				base.process(request, response, "/admin_index.jsp");
			} else if (type.equals("1")) {
				base.process(request, response, "/staff_index.jsp");
			} else if (type.equals("2")) {
				base.process(request, response, "/canteenAdmin_index.jsp");
			} else if (type.equals("3")) {
				base.process(request, response, "/cashier_index.jsp");
			} else if (type.equals("4")) {
				base.process(request, response, "/buyer_index.jsp");
			} else if (type.equals("5")) {
				base.process(request, response, "/accountant_index.jsp");
			}
		} else if (type.equals("staffLoginout")) {
			session.invalidate();
			response.sendRedirect(path + "/staffLogin.jsp");
		} else if (type.equals("adminLoginout")) {
			session.invalidate();
			response.sendRedirect(path + "/adminLogin.jsp");
		} else if (type.equals("canteenLoginout")) {
			session.invalidate();
			response.sendRedirect(path + "/canteenLogin.jsp");
		} else if (type.equals("0")) {
			response.sendRedirect(path + "/adminLogin.jsp");
		} else if (type.equals("1")) {
			response.sendRedirect(path + "/staffLogin.jsp");
		} else if (type.equals("2") || type.equals("3") || type.equals("4")
				|| type.equals("5")) {
			response.sendRedirect(path + "/canteenLogin.jsp");
		} else {
			response.sendRedirect(path + "/adminLogin.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
