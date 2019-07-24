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

import com.gxuwz.bean.BO.actionmenu;
import com.gxuwz.bean.entity.sys_menu;


public class menuServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    
         	 String type =request.getParameter("type");
    		if(type.equals("list")){
    			actionmenu as =new actionmenu();
    			 try {
    				List<sys_menu> sl=as.listmenu();
    				request.setAttribute("menulist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/menu/menu_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			String menuID = request.getParameter("menuID");
                String menuName = request.getParameter("menuName");
                String menuDescription = request.getParameter("menuDescription");
                String price = request.getParameter("price");
    			actionmenu as =new actionmenu( menuID,menuName,menuDescription,price);
    			try {
    				as.addmenu();
    				List<sys_menu> sl=as.listmenu();
    				request.setAttribute("menulist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/menu/menu_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			String menuID = request.getParameter("menuID");
                String menuName = request.getParameter("menuName");
                String menuDescription = request.getParameter("menuDescription");
                String price = request.getParameter("price");
    			actionmenu as =new actionmenu( menuID,menuName,menuDescription,price);
    			try {
    				as.updatemenu();
    				List<sys_menu> sl=as.listmenu();
    				request.setAttribute("menulist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/menu/menu_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		String menuID = request.getParameter("menuID");
    		actionmenu as =new actionmenu();
    		 try {
    			 as.removemenu(menuID);
    			List<sys_menu> sl=as.listmenu();
    			request.setAttribute("menulist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/menu/menu_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
    	if(type.equals("liststaff")){
			actionmenu as =new actionmenu();
			 try {
				List<sys_menu> sl=as.listmenu();
				request.setAttribute("menulist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/menu/menustaff_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  doGet(request,response);
	}

}
