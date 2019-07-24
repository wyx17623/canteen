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

import com.gxuwz.bean.BO.actionordering;
import com.gxuwz.bean.vo.listordering;
import com.gxuwz.bean.vo.listorderingcount;
import com.gxuwz.bean.vo.listexpenditure;

public class orderingServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    
         	 String type =request.getParameter("type");
         	/*
         	 * 
         	 * 
         	 * 机关工作人员查询自己订单的方法
         	 */
         	if(type.equals("liststaff")){
     			actionordering as =new actionordering();
     			HttpSession session =request.getSession();
     			String staffID=(String)session.getAttribute("userID");
     			 try {
     				List<listordering> sl=as.listordering(staffID);
     				request.setAttribute("orderinglist",sl);
     				RequestDispatcher rd=request.getRequestDispatcher("/page/ordering/orderingstaff_list.jsp");
     			      rd.forward(request, response);
     			} catch (Exception e) {
     				e.printStackTrace();
     			}
     		}
              /*
               * 
               * 
               * 只有机关单位工作人员才能添加订单
               */
    		if(type.equals("add")){
    			String orderingID = request.getParameter("orderingID");
                String menuID = request.getParameter("menuID");
                String staffID = request.getParameter("staffID");
                String orderingNum = request.getParameter("orderingNum");
    			actionordering as =new actionordering(orderingID,menuID,staffID,orderingNum);
    			try {
    				as.addordering();
    				List<listordering> sl=as.listordering(staffID,orderingID);
    				request.setAttribute("orderinglist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/ordering/orderingstaff_list.jsp");
    		      rd.forward(request, response);
    		}//取消此功能，并未在各大平台上看到过修改订单功能
    		/*if(type.equals("update")){
    			String orderingID = request.getParameter("orderingID");
                String menuID = request.getParameter("menuID");
                String staffID = request.getParameter("staffID");
                String orderingNum = request.getParameter("orderingNum");
    			actionordering as =new actionordering( orderingID,menuID,staffID,orderingNum);
    			try {
    				as.updateordering();
    				List<listordering> sl=as.listordering();
    				request.setAttribute("orderinglist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("/page/ordering/ordering_list.jsp");
    		    rd.forward(request, response);
    		}*/
    		/*
    		 * 
    		 * 
    		 * 
    		 * 机关工作人员退单
    		 */
    	if(type.equals("remove")){
    		String orderingID = request.getParameter("orderingID");
    		actionordering as =new actionordering();
    		HttpSession session =request.getSession();
			String staffID=(String)session.getAttribute("userID");
    		 try {
    			 as.removeordering(orderingID);
    			List<listordering> sl=as.listordering(staffID);
    			request.setAttribute("orderinglist",sl);
    			RequestDispatcher rd=request.getRequestDispatcher("/page/ordering/orderingstaff_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
    	/*
    	 * 
    	 * 
    	 * 采购员统计订单
    	 */
    	if(type.equals("listcount")){
			actionordering as =new actionordering();
			 try {
				List<listorderingcount> sl=as.listorderingcount();
				request.setAttribute("orderingcountlist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/ordering/orderingcount_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	/*
    	 * 
    	 * 
    	 * 会计统计每个人的消费情况
    	 */
    	if(type.equals("listexpenditure")){
			actionordering as =new actionordering();
			 try {
				List<listexpenditure> sl=as.listorderingexpenditure();
				request.setAttribute("orderinglist",sl);
				RequestDispatcher rd=request.getRequestDispatcher("/page/ordering/orderinglistexpenditure_list.jsp");
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
