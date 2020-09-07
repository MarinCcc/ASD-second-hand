package cn.second_hand.product.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.second_hand.product.domain.Product;
import cn.second_hand.user.servlet.BaseServlet;

public class ProductServlet extends BaseServlet {

	public String saleApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setName(request.getParameter("title"));
		product.setPicture1(request.getParameter("image1"));
		product.setPicture2(request.getParameter("image2"));
		product.setApplierEmail(request.getParameter("session_user.email"));
		product.setApplyTime(new Date());
		boolean status = Boolean.parseBoolean(request.getParameter("bargainStatus"));
		product.setBargainStatus(status);
		product.setCategories(request.getParameter("category"));
		double price = Double.parseDouble(request.getParameter("salePrice"));
		product.setPrice(price);
		System.out.println(product);
		return "";
	}
}
