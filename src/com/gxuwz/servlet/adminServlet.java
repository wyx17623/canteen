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

import com.gxuwz.bean.BO.actionadmin;
import com.gxuwz.bean.entity.sys_admin;

/**
 * 
 * @author 
 * 时间：2019年6月15日下午4:54:30
 * Description:系统管理员逻辑处理类
 */
public class adminServlet extends HttpServlet {	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {     
         	 String type =request.getParameter("type");
    		if(type.equals("list")){
    			HttpSession session =request.getSession();
    			String adminID=(String)session.getAttribute("userID");
    			actionadmin as =new actionadmin();
    			 try {
    				List<sys_admin> sl=as.listadmin(adminID);
    				request.setAttribute("adminlist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/admin/admin_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("update")){
    			String adminID = request.getParameter("adminID");
                String adminName = request.getParameter("adminName");
                String adminTel = request.getParameter("adminTel");
    			actionadmin as =new actionadmin( adminID, adminName, adminTel);
    			try {
    				as.updateadmin();
    				List<sys_admin> sl=as.listadmin(adminID);
    				request.setAttribute("adminlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/admin/admin_list.jsp");
    		    rd.forward(request, response);
    		}
    	
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  doGet(request,response);
	}

}
