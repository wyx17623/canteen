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
 * ʱ�䣺2019��6��18������6:12:49
 * Description:�ɹ��嵥��ϸ�߼�������
 */
public class detaillistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���մ�ֵ
		String shoppingID = request.getParameter("shoppingID");
		//����request������ʾҳ�棬������ʱ��ϸ��ʱ����
		request.setAttribute("shoppingID", shoppingID);
	//����ҳ�洫ֵ���ж�ִ��·��
		String type = request.getParameter("type");
		/*
		 * 
		 * �ɹ�Ա���˷�����ͨ����˵Ĳɹ��嵥���ã���ʾ���е���ϸ�嵥�����ǲ��ɶ���ϸ�嵥���в���
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
		 * �ɹ�Ա���˷��������޸���ϸ������ϸ�����в�������δͨ����δ��˵Ĳɹ��嵥�޸�ʱ����,
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
          * �ɹ�Ա��д�ɹ��嵥
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
		 * �ɹ�Ա�޸Ĳɹ��嵥
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
		 * �ɹ�Աɾ���ɹ���ϸ��
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
		 * ���ɣ��˷��������еĲɹ��嵥���ã���ʾ���е���ϸ�嵥�����ǲ��ɶ���ϸ�嵥���в���
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
