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

import com.gxuwz.bean.BO.actioncashier;
import com.gxuwz.bean.BO.actioncashier;
import com.gxuwz.bean.entity.sys_cashier;
import com.gxuwz.bean.entity.sys_cashier;


public class cashierServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    
         	 String type =request.getParameter("type");
    		if(type.equals("list")){
    			actioncashier as =new actioncashier();
    			 try {
    				List<sys_cashier> sl=as.listcashier();
    				request.setAttribute("cashierlist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/cashier/cashier_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			String cashierID = request.getParameter("cashierID");
                String cashierName = request.getParameter("cashierName");
                String cashierTel = request.getParameter("cashierTel");
    			actioncashier as =new actioncashier( cashierID,  cashierName,cashierTel);
    			try {
    				as.addcashier();
    				List<sys_cashier> sl=as.listcashier();
    				request.setAttribute("cashierlist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/cashier/cashier_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			String cashierID = request.getParameter("cashierID");
                String cashierName = request.getParameter("cashierName");
                String cashierTel = request.getParameter("cashierTel");
    			actioncashier as =new actioncashier( cashierID,  cashierName,cashierTel);
    			try {
    				as.updatecashier();
    				List<sys_cashier> sl=as.listcashier();
    				request.setAttribute("cashierlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/cashier/cashier_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		String cashierID = request.getParameter("cashierID");
    		actioncashier as =new actioncashier();
    		 try {
    			 as.removecashier(cashierID);
    			List<sys_cashier> sl=as.listcashier();
    			request.setAttribute("cashierlist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/cashier/cashier_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
    	if(type.equals("listpersonal")){
    		HttpSession session = request.getSession();
    		String cashierID = (String)session.getAttribute("userID");
			actioncashier as =new actioncashier();
			 try {
				List<sys_cashier> sl=as.listcashier(cashierID);
				request.setAttribute("cashierlist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/cashier/cashierpersonal_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
    	if(type.equals("updatepersonal")){
			String cashierID = request.getParameter("cashierID");
            String cashierName = request.getParameter("cashierName");
            String cashierTel = request.getParameter("cashierTel");
			actioncashier as =new actioncashier( cashierID,  cashierName,cashierTel);
			try {
				as.updatecashier();
				List<sys_cashier> sl=as.listcashier();
				request.setAttribute("cashierlist",sl);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("/page/cashier/cashierpersonal_list.jsp");
		    rd.forward(request, response);
		}
	
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  doGet(request,response);
	}

}
