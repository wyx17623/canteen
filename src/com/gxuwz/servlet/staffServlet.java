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

import com.gxuwz.bean.BO.actionstaff;
import com.gxuwz.bean.entity.sys_staff;


public class staffServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    
         	 String type =request.getParameter("type");
    		if(type.equals("list")){
    			actionstaff as =new actionstaff();
    			 try {
    				List<sys_staff> sl=as.liststaff();
    				request.setAttribute("stafflist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/staff/staff_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			String staffID = request.getParameter("staffID");
                String staffName = request.getParameter("staffName");
                String staffTel = request.getParameter("staffTel");
    			actionstaff as =new actionstaff( staffID,  staffName,staffTel);
    			try {
    				as.addstaff();
    				List<sys_staff> sl=as.liststaff();
    				request.setAttribute("stafflist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/staff/staff_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			String staffID = request.getParameter("staffID");
                String staffName = request.getParameter("staffName");
                String staffTel = request.getParameter("staffTel");
    			actionstaff as =new actionstaff( staffID,  staffName,staffTel);
    			try {
    				as.updatestaff();
    				List<sys_staff> sl=as.liststaff();
    				request.setAttribute("stafflist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/staff/staff_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		String staffID = request.getParameter("staffID");
    		actionstaff as =new actionstaff();
    		 try {
    			 as.removestaff(staffID);
    			List<sys_staff> sl=as.liststaff();
    			request.setAttribute("stafflist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/staff/staff_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
    	if(type.equals("listpersonal")){
    		HttpSession session =request.getSession();
    		String staffID = (String)session.getAttribute("userID");
			actionstaff as =new actionstaff();
			 try {
				List<sys_staff> sl=as.liststaff(staffID);
				request.setAttribute("stafflist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/staff/staffpersonal_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
    	if(type.equals("updatepersonal")){
			String staffID = request.getParameter("staffID");
            String staffName = request.getParameter("staffName");
            String staffTel = request.getParameter("staffTel");
			actionstaff as =new actionstaff( staffID,  staffName,staffTel);
			try {
				as.updatestaff();
				List<sys_staff> sl=as.liststaff(staffID);
				request.setAttribute("stafflist",sl);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("/page/staff/staffpersonal_list.jsp");
		    rd.forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  doGet(request,response);
	}

}
