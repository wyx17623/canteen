package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.gxuwz.bean.BO.actioncanteenAdmin;
import com.gxuwz.bean.entity.sys_canteenadmin;
/**
 * 
 * @author 
 * 时间：2019年6月16日下午8:56:11
 * Description:食堂管理员逻辑处理
 */
public class canteenAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("list")) {
			actioncanteenAdmin as = new actioncanteenAdmin();
			try {
				List<sys_canteenadmin> sl = as.listcanteenAdmin();
				request.setAttribute("canteenAdminlist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/canteenAdmin/canteenAdmin_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		if (type.equals("add")) {
			String canteenAdminID = request.getParameter("canteenAdminID");
			String canteenAdminName = request.getParameter("canteenAdminName");
			String canteenAdminTel = request.getParameter("canteenAdminTel");
			actioncanteenAdmin as = new actioncanteenAdmin(canteenAdminID,
					canteenAdminName, canteenAdminTel);
			try {
				as.addcanteenAdmin();
				List<sys_canteenadmin> sl = as.listcanteenAdmin();
				request.setAttribute("canteenAdminlist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/canteenAdmin/canteenAdmin_list.jsp");
			rd.forward(request, response);
		}
		if (type.equals("update")) {
			String canteenAdminID = request.getParameter("canteenAdminID");
			String canteenAdminName = request.getParameter("canteenAdminName");
			String canteenAdminTel = request.getParameter("canteenAdminTel");
			actioncanteenAdmin as = new actioncanteenAdmin(canteenAdminID,
					canteenAdminName, canteenAdminTel);
			try {
				as.updatecanteenAdmin();
				List<sys_canteenadmin> sl = as.listcanteenAdmin();
				request.setAttribute("canteenAdminlist", sl);

			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/canteenAdmin/canteenAdmin_list.jsp");
			rd.forward(request, response);
		}
		if (type.equals("remove")) {
			String canteenAdminID = request.getParameter("canteenAdminID");
			actioncanteenAdmin as = new actioncanteenAdmin();
			try {
				as.removecanteenAdmin(canteenAdminID);
				List<sys_canteenadmin> sl = as.listcanteenAdmin();
				request.setAttribute("canteenAdminlist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/canteenAdmin/canteenAdmin_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		if (type.equals("listpersonal")) {
			HttpSession session = request.getSession();
			String canteenAdminID = (String) session.getAttribute("userID");
			actioncanteenAdmin as = new actioncanteenAdmin();
			try {
				List<sys_canteenadmin> sl = as.listcanteenAdmin(canteenAdminID);
				request.setAttribute("canteenAdminlist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/canteenAdmin/canteenAdminpersonal_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		if (type.equals("updatepersonal")) {
			String canteenAdminID = request.getParameter("canteenAdminID");
			String canteenAdminName = request.getParameter("canteenAdminName");
			String canteenAdminTel = request.getParameter("canteenAdminTel");
			actioncanteenAdmin as = new actioncanteenAdmin(canteenAdminID,
					canteenAdminName, canteenAdminTel);
			try {
				as.updatecanteenAdmin();
				List<sys_canteenadmin> sl = as.listcanteenAdmin(canteenAdminID);
				request.setAttribute("canteenAdminlist", sl);

			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/canteenAdmin/canteenAdminpersonal_list.jsp");
			rd.forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
