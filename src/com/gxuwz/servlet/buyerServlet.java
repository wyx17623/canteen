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

import com.gxuwz.bean.BO.actionbuyer;
import com.gxuwz.bean.entity.sys_buyer;


public class buyerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    
         	 String type =request.getParameter("type");
    		if(type.equals("list")){
    			actionbuyer as =new actionbuyer();
    			 try {
    				List<sys_buyer> sl=as.listbuyer();
    				request.setAttribute("buyerlist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/buyer/buyer_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			String buyerID = request.getParameter("buyerID");
                String buyerName = request.getParameter("buyerName");
                String buyerTel = request.getParameter("buyerTel");
    			actionbuyer as =new actionbuyer( buyerID,  buyerName,buyerTel);
    			try {
    				as.addbuyer();
    				List<sys_buyer> sl=as.listbuyer();
    				request.setAttribute("buyerlist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/buyer/buyer_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			String buyerID = request.getParameter("buyerID");
                String buyerName = request.getParameter("buyerName");
                String buyerTel = request.getParameter("buyerTel");
    			actionbuyer as =new actionbuyer( buyerID,  buyerName,buyerTel);
    			try {
    				as.updatebuyer();
    				List<sys_buyer> sl=as.listbuyer();
    				request.setAttribute("buyerlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/buyer/buyer_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		String buyerID = request.getParameter("buyerID");
    		actionbuyer as =new actionbuyer();
    		 try {
    			 as.removebuyer(buyerID);
    			List<sys_buyer> sl=as.listbuyer();
    			request.setAttribute("buyerlist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/buyer/buyer_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
    	if(type.equals("listpersonal")){
    		HttpSession session = request.getSession();
    		String buyerID = (String)session.getAttribute("userID");
			actionbuyer as =new actionbuyer();
			 try {
				List<sys_buyer> sl=as.listbuyer(buyerID);
				request.setAttribute("buyerlist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/buyer/buyerpersonal_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
    	if(type.equals("updatepersonal")){
			String buyerID = request.getParameter("buyerID");
            String buyerName = request.getParameter("buyerName");
            String buyerTel = request.getParameter("buyerTel");
			actionbuyer as =new actionbuyer( buyerID,  buyerName,buyerTel);
			try {
				as.updatebuyer();
				List<sys_buyer> sl=as.listbuyer();
				request.setAttribute("buyerlist",sl);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("/page/buyer/buyerpersonal_list.jsp");
		    rd.forward(request, response);
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  doGet(request,response);
	}

}
