package cn.second_hand.category.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import cn.second_hand.category.domain.Category;
import cn.second_hand.category.domain.CategoryException;
import cn.second_hand.category.service.CategoryService;
import cn.second_hand.user.servlet.BaseServlet;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends BaseServlet {
	
	private CategoryService categoryService = new CategoryService();
	
	public String edit(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Category category = new Category();
		category.setCategoriesName(request.getParameter("categoriesName"));
		category.setDescription(request.getParameter("description"));
		categoryService.edit(category);
		return findAll(request, response);
	}
	
	/**
	 * 修改之前的加载工作
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String editPre(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ObjectId oid = new ObjectId(request.getParameter("oid"));
		request.setAttribute("category", categoryService.load(oid));
		return "f:/editCategory.jsp";
	}
	
	
	/*
	 * 查询所有分类
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("categoryList", categoryService.findAll());
	    return "f:/viewCategory.jsp";
	}

	/*
	 * 添加分类
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Category category = new Category();
		category.setCategoriesName(request.getParameter("categoriesName"));
		category.setDescription(request.getParameter("description"));
		categoryService.add(category);
		return findAll(request, response);
		
	}
	

	public String delete(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		
		ObjectId oid = new ObjectId(request.getParameter("oid"));
		
		
//		try {
			categoryService.delete(oid);
			return findAll(request, response);
			
//		}catch(CategoryException e) {
//			request.setAttribute("msg", e.getMessage());
//			return "f:/msg.jsp";
//		}
		
	}
	
	
	
	

}
