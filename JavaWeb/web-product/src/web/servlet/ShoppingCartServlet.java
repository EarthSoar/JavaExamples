package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import damain.ShoppingCart;

@WebServlet("/cart")
public class ShoppingCartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
		cart.delete(id);
		resp.sendRedirect("/shopping/cart.jsp");
	}
}
