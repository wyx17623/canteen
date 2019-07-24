package com.gxuwz.servlet;

import java.io.IOException;

import com.gxuwz.bean.BO.countTotalMoney;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxuwz.bean.BO.actiondetaillist;
import com.gxuwz.bean.entity.sys_detaillist;
import com.gxuwz.bean.entity.sys_detaillist;
/**
 * 
 * @author 
 * 时间：2019年6月18日下午6:12:49
 * Description:采购清单明细逻辑处理类
 */
public class detaillistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收传值
		String shoppingID = request.getParameter("shoppingID");
		//放入request传给显示页面，供增加时明细表时调用
		request.setAttribute("shoppingID", shoppingID);
	//接受页面传值，判断执行路径
		String type = request.getParameter("type");
		/*
		 * 
		 * 采购员：此方法给通过审核的采购清单调用，显示所有的明细清单，但是不可对明细清单进行操作
		 */
		if (type.equals("list")) {
		
			HttpSession session = request.getSession();
			String buyerID = (String)session.getAttribute("userID");
			actiondetaillist as = new actiondetaillist(shoppingID);
			try {
				List<sys_detaillist> sl = as.listdetaillist();
				
				request.setAttribute("detaillist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/detaillist/detaillist_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * 
		 * 
		 * 采购员：此方法可以修改明细单对明细单进行操作，供未通过或未审核的采购清单修改时调用,
		 */
		if (type.equals("updatelist")) {
			
			HttpSession session = request.getSession();
			String buyerID = (String)session.getAttribute("userID");
			actiondetaillist as = new actiondetaillist(shoppingID);
			try {
				List<sys_detaillist> sl = as.listdetaillist();
				
				request.setAttribute("detaillist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/detaillist/detailupdatelist_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
         /*
          * 
          * 
          * 采购员填写采购清单
          */
		if (type.equals("add")) {
			String detailListID = request.getParameter("detailListID");
			
			String materialsName = request.getParameter("materialsName");
			String price = request.getParameter("price");
			String materialsNum = request.getParameter("materialsNum");
			String supplier = request.getParameter("supplier");
			actiondetaillist as = new actiondetaillist( detailListID,  shoppingID, materialsName,  price,  materialsNum,  supplier);
			try {
				as.adddetaillist();
				List<sys_detaillist> sl = as.listdetaillist();
				request.setAttribute("detaillist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/detaillist/detailupdatelist_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * 
		 * 
		 * 采购员修改采购清单
		 */
		if (type.equals("update")) {
			String detailListID = request.getParameter("detailListID");
			
			String materialsName = request.getParameter("materialsName");
			String price = request.getParameter("price");
			String materialsNum = request.getParameter("materialsNum");
			String supplier = request.getParameter("supplier");
			actiondetaillist as = new actiondetaillist( detailListID,  shoppingID, materialsName,  price,  materialsNum,  supplier);
			try {
				as.updatedetaillist(detailListID);
				List<sys_detaillist> sl = as.listdetaillist();
				request.setAttribute("detaillist", sl);

			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/detaillist/detailupdatelist_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * 
		 * 
		 * 采购员删除采购明细单
		 */
		if (type.equals("remove")) {
			String detailListID = request.getParameter("detailListID");
		
			actiondetaillist as = new actiondetaillist(shoppingID);
			try {
				as.removedetaillist(detailListID);
				List<sys_detaillist> sl = as.listdetaillist();
				request.setAttribute("detaillist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/detaillist/detailupdatelist_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 
		 * 
		 * 出纳：此方法给所有的采购清单调用，显示所有的明细清单，但是不可对明细清单进行操作
		 */
				if (type.equals("listReview")) {
				
					actiondetaillist as = new actiondetaillist(shoppingID);
					try {
						List<sys_detaillist> sl = as.listdetaillist();
						
						request.setAttribute("detaillist", sl);
						RequestDispatcher rd = request
								.getRequestDispatcher("/page/detaillist/detaillistReview_list.jsp");
						rd.forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	
	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
