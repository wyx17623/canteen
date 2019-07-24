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

import com.gxuwz.bean.BO.actionshoppinglist;
import com.gxuwz.bean.entity.sys_shoppinglist;
import com.gxuwz.bean.vo.listshoppinglist;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��18������6:12:49
 * Description:�ɹ��嵥�߼�������
 */
public class shoppinglistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		/*
		 * 
		 * 
		 * �ɹ�Ա�鿴�Ѿ�ͨ���Ĳɹ��嵥
		 */
		if (type.equals("list")) {
			HttpSession session = request.getSession();
			String buyerID = (String)session.getAttribute("userID");
			actionshoppinglist as = new actionshoppinglist(buyerID);
			try {
				List<listshoppinglist> sl = as.listshoppinglist();
				request.setAttribute("shoppinglist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/shoppinglist/shoppinglist_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 
		 * 
		 * ��ѯ�ɹ�Աδͨ������δ��˵Ĳɹ�������ʱ�ɹ��������޸�
		 */
		if (type.equals("updatelist")) {
			HttpSession session = request.getSession();
			String buyerID = (String)session.getAttribute("userID");
			actionshoppinglist as = new actionshoppinglist(buyerID);
			try {
				List<listshoppinglist> sl = as.listshoppingUpdatelist();
				request.setAttribute("shoppinglist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/shoppinglist/shoppingupdatelist_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
         /*
          * 
          * 
          * �ɹ�Ա��д�ɹ��嵥
          */
		if (type.equals("add")) {
			String shoppingID = request.getParameter("shoppingID");
			String buyerID = request.getParameter("buyerID");
			String shoppingTime = request.getParameter("shoppingTime");
			String totalMoney = request.getParameter("totalMoney");
			String status = request.getParameter("status");
			actionshoppinglist as = new actionshoppinglist(shoppingID,
					buyerID, shoppingTime,totalMoney,status);
			try {
				as.addshoppinglist();
				List<listshoppinglist> sl = as.listshoppingUpdatelist();
				request.setAttribute("shoppinglist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/detaillist/detaillist_add.jsp?shoppingID="+shoppingID);
			rd.forward(request, response);
		}
		/*
		 * 
		 * 
		 * �ɹ�Ա�޸Ĳɹ��嵥
		 */
		if (type.equals("update")) {
			String shoppingID = request.getParameter("shoppingID");
			String buyerID = request.getParameter("buyerID");
			String shoppingTime = request.getParameter("shoppingTime");
			String totalMoney = request.getParameter("totalMoney");
			String status = request.getParameter("status");
			actionshoppinglist as = new actionshoppinglist(shoppingID,
					buyerID, shoppingTime,totalMoney,status);
			try {
				as.updateshoppinglist(shoppingID);
				List<listshoppinglist> sl = as.listshoppingUpdatelist();
				request.setAttribute("shoppinglist", sl);

			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/shoppinglist/shoppingupdatelist_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * 
		 * 
		 * �ɹ�Աɾ������
		 */
		if (type.equals("remove")) {
			HttpSession session = request.getSession();
			String buyerID = (String)session.getAttribute("userID");
			actionshoppinglist as = new actionshoppinglist(buyerID);
			String shoppingID = request.getParameter("shoppingID");
			try {
				as.removeshoppinglist(shoppingID);
				List<listshoppinglist> sl = as.listshoppingUpdatelist();
				request.setAttribute("shoppinglist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/shoppinglist/shoppingupdatelist_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 
		 * 
		 * ���ɲ鿴δ��˵Ĳɹ���
		 */
		if (type.equals("listreview")) {
			actionshoppinglist as = new actionshoppinglist();
			try {
				List<listshoppinglist> sl = as.listshoppingcashier();
				request.setAttribute("shoppinglist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/shoppinglist/shoppinglistReview_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 
		 * 
		 * ���ɲ鿴����˵Ķ���
		 */
		if (type.equals("listcashir")) {
			actionshoppinglist as = new actionshoppinglist();
			try {
				List<listshoppinglist> sl = as.listshoppingcashierReview();
				request.setAttribute("shoppinglist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/shoppinglist/shoppinglistReview_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 
		 * 
		 * ������˲ɹ����������޸Ĳɹ�����״̬
		 */
		if (type.equals("updatestatus")) {
			String shoppingID = request.getParameter("shoppingID");
			String status = request.getParameter("status");
			actionshoppinglist as = new actionshoppinglist();
			try {
				as.updateshoppinglist(shoppingID,status);
				List<listshoppinglist> sl = as.listshoppingcashier();
				request.setAttribute("shoppinglist", sl);
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/shoppinglist/shoppinglistReview_list.jsp");
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
