package cn.second_hand.cart.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.second_hand.cart.domain.Cart;
import cn.second_hand.cart.service.CartService;
import cn.second_hand.cart.vos.CartVo;
import cn.second_hand.user.domain.User;
import cn.second_hand.user.servlet.BaseServlet;

public class CartServlet extends BaseServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CartService cartService = new CartService();

    public String cartList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("session_user");
        List<CartVo> cartVos = cartService.queryByUser(user.getEmail());
        int totalPrice = 0;
        if (!cartVos.isEmpty()) {
            for (CartVo cartVo : cartVos) {
                totalPrice += cartVo.getTotalPrice();
            }
        }
        request.setAttribute("cartVos", cartVos);
        request.setAttribute("totalPrice", totalPrice);
        return "f:/cartList.jsp";
    }
    public void cartAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//获取登录用户
    	User user = (User)request.getSession().getAttribute("session_user");
        String productId = request.getParameter("productId");
        String email = user.getEmail();
        Date date = new Date();
        Cart cart = new Cart();
        cart.setCreateAt(date);
        cart.setProductId(productId);
        cart.setQuantity(1);
        cart.setUserEmail(email);
        
        cartService.saveCart(cart);
        
    }
}
