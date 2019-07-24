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

import com.gxuwz.bean.BO.actionaccountant;
import com.gxuwz.bean.entity.sys_accountant;

/**
 * 
 * @author 
 * 时间：2019年6月16日下午5:42:32
 * Description:会计逻辑处理类
 */
public class accountantServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    
         	 String type =request.getParameter("type");
    		if(type.equals("list")){
    			actionaccountant as =new actionaccountant();
    			 try {
    				List<sys_accountant> sl=as.listaccountant();
    				request.setAttribute("accountantlist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/accountant/accountant_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}

    		if(type.equals("add")){
    			String accountantID = request.getParameter("accountantID");
                String accountantName = request.getParameter("accountantName");
                String accountantTel = request.getParameter("accountantTel");
    			actionaccountant as =new actionaccountant( accountantID,  accountantName,accountantTel);
    			try {
    				as.addaccountant();
    				List<sys_accountant> sl=as.listaccountant();
    				request.setAttribute("accountantlist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/accountant/accountant_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			String accountantID = request.getParameter("accountantID");
                String accountantName = request.getParameter("accountantName");
                String accountantTel = request.getParameter("accountantTel");
    			actionaccountant as =new actionaccountant( accountantID,  accountantName,accountantTel);
    			try {
    				as.updateaccountant();
    				List<sys_accountant> sl=as.listaccountant();
    				request.setAttribute("accountantlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/accountant/accountant_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		String accountantID = request.getParameter("accountantID");
    		actionaccountant as =new actionaccountant();
    		 try {
    			 as.removeaccountant(accountantID);
    			List<sys_accountant> sl=as.listaccountant();
    			request.setAttribute("accountantlist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/accountant/accountant_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
    	if(type.equals("listpersonal")){
    		HttpSession session = request.getSession();
    		String accountantID = (String)session.getAttribute("userID");
			actionaccountant as =new actionaccountant();
			 try {
				List<sys_accountant> sl=as.listaccountant(accountantID);
				request.setAttribute("accountantlist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/accountant/accountantpersonal_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
    	if(type.equals("updatepersonal")){
			String accountantID = request.getParameter("accountantID");
            String accountantName = request.getParameter("accountantName");
            String accountantTel = request.getParameter("accountantTel");
			actionaccountant as =new actionaccountant( accountantID,  accountantName,accountantTel);
			try {
				as.updateaccountant();
				List<sys_accountant> sl=as.listaccountant(accountantID);
				request.setAttribute("accountantlist",sl);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("/page/accountant/accountantpersonal_list.jsp");
		    rd.forward(request, response);
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  doGet(request,response);
	}

}
