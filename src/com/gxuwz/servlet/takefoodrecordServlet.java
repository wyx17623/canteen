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

import com.gxuwz.bean.BO.actiontakefoodrecord;
import com.gxuwz.bean.vo.listtakefoodrecord;


public class takefoodrecordServlet extends HttpServlet {

	
	private boolean flase;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    
         	 String type =request.getParameter("type");
         	 /*
         	  * 
         	  * 机关工作人员查询消费记录
         	  */
    		if(type.equals("list")){
    			actiontakefoodrecord as =new actiontakefoodrecord();
    			HttpSession session =request.getSession();
    			String staffID=(String)session.getAttribute("userID");
    			 try {
    				List<listtakefoodrecord> sl=as.listtakefoodrecord(staffID);
    				request.setAttribute("takefoodrecordlist",sl);
    				RequestDispatcher rd=request.getRequestDispatcher("/page/takefoodrecord/takefoodrecord_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
              /*
               * 
               * 
               * 当扫码消费时添加消费记录
               */
    		if(type.equals("add")){
				boolean sign=flase;
    			String orderingID = request.getParameter("orderingID");
                String staffID = request.getParameter("staffID");
    			actiontakefoodrecord as =new actiontakefoodrecord();
    			try {
    				 sign =as.addtakefoodrecord( staffID, orderingID);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			if(sign==flase){
                 //返回一个失败的页面，这个页面还未定义
    			RequestDispatcher rd=request.getRequestDispatcher("/");
    		      rd.forward(request, response);
    			}
    		}
    		
    	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  doGet(request,response);
	}

}
