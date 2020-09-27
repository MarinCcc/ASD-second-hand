package cn.second_hand.cart.servlet;

import cn.second_hand.cart.service.CartService;
import cn.second_hand.cart.vos.CartVo;
import cn.second_hand.user.domain.User;
import cn.second_hand.user.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CartServlet extends BaseServlet {

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
}
