package cn.second_hand.product.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import cn.second_hand.product.domain.Product;
import cn.second_hand.product.service.ProductService;
import cn.second_hand.query.AuditQueryObject;
import cn.second_hand.query.PageResult;
import cn.second_hand.user.domain.User;
import cn.second_hand.user.servlet.BaseServlet;

public class ProductServlet extends BaseServlet {
	
	private ProductService productService = new ProductService();

	public String saleApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setTitle(request.getParameter("title"));
		product.setPicture1(request.getParameter("image1").equals("")?null:request.getParameter("image1"));
		product.setPicture2(request.getParameter("image2").equals("")?null:request.getParameter("image2"));
		User user = (User)request.getSession().getAttribute("session_user");
		product.setApplierEmail(user.getEmail());
		product.setApplyTime(new Date());
		product.setHide(false);
		product.setCategory(request.getParameter("category"));
		product.setDescription(request.getParameter("description"));
		product.setPrice(new Integer(request.getParameter("salePrice")));
		product.setBargainStatus(request.getParameter("bargainStatus").equals("0")?true:false);
		productService.saveSaleApp(product);
		return "";
	}
	
	public String auditSaleApplyPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		AuditQueryObject auditQueryObject = new AuditQueryObject();
		auditQueryObject.setPageSize(1);
//		auditQueryObject.setBeginDate(new Date(request.getParameter("beginDate")));
//		auditQueryObject.setEndDate(new Date(request.getParameter("endDate")));
		int currentPage = 1;
		if(request.getParameter("currentPage")==null || request.getParameter("currentPage").equals("")) {
			auditQueryObject.setCurrentPage(currentPage);
		}
		else 
		{
			auditQueryObject.setCurrentPage(Integer.valueOf(request.getParameter("currentPage")));
		}
		PageResult pageResult;
		if(request.getParameter("state")!=null && !request.getParameter("state").equals("-1") ) 
		{
			int state = new Integer(request.getParameter("state"));
			pageResult = productService.query(auditQueryObject,state);
			request.setAttribute("state", state);
		}
		else
		{
			pageResult = productService.query(auditQueryObject);
			request.setAttribute("state", null);
		}
		request.setAttribute("pageResult", pageResult);
		return "f:/auditSaleApplication.jsp";

	}
	
	public String saleApplyingListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		AuditQueryObject auditQueryObject = new AuditQueryObject();
		auditQueryObject.setPageSize(2);
		User user = (User)request.getSession().getAttribute("session_user");
		String currentUserEmail = user.getEmail();
		int currentPage = 1;
		if(request.getParameter("currentPage")==null || request.getParameter("currentPage").equals("")) {
			auditQueryObject.setCurrentPage(currentPage);
		}
		else 
		{
			auditQueryObject.setCurrentPage(Integer.valueOf(request.getParameter("currentPage")));
		}
		PageResult	pageResult = productService.queryApplyingList(auditQueryObject,currentUserEmail);
		request.setAttribute("pageResult", pageResult);
		return "f:/saleApplyOrderList.jsp";

	}
	
	public String editSaleApplyingListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		Product product = new Product();
		product.setOid(new ObjectId(request.getParameter("oid")));
		product.setPicture1(request.getParameter("image1"));
		product.setPicture2(request.getParameter("image2"));
		product.setBargainStatus(request.getParameter("bargainStatus").equals("0")?true:false);
		product.setCategory(request.getParameter("category"));
		product.setDescription(request.getParameter("description"));
		product.setPrice(new Integer(request.getParameter("price")));
		product.setTitle(request.getParameter("title"));
		productService.editSaleApplyingListPage(product);
		return "f:/saleApplyOrderList.jsp";
	}
	public String withdrawSaleApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		ObjectId id = new ObjectId(request.getParameter("oid"));
		productService.hideSaleApplication(id);
		return "ProductServlet?method=saleApplyingListPage";
	}
	
	
	
}
