package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import damain.Product;
import dao.IProductDAO;
import dao.impl.ProductDAOImpl;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProductDAO dao;
	public void init() throws ServletException {
		dao = new ProductDAOImpl();
	}
	//分发操作
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		String cmd = req.getParameter("cmd");
		if("save".equals(cmd)) {
			this.save(req, resp);
		}else if("delete".equals(cmd)) {
			this.delete(req, resp);
		}else if("edit".equals(cmd)) {
			this.edit(req, resp);
		}else {
			this.list(req, resp);
		}
	}
	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求参数封装成对象
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String brand = req.getParameter("brand");
		Product pro = new Product(null, null, null, null, null, null, null);
				
				
				
				
		String sid = req.getParameter("id");
		if(hasLength(sid)) {
			Long id = Long.valueOf(sid);
			pro.setId(id);
			dao.update(pro);
		}
		dao.save(pro);
		
		//控制页面跳转
		resp.sendRedirect("/product");
	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求参数
		String sid = req.getParameter("id");
		Long id = Long.valueOf(sid);
		//调用业务方法
		dao.delete(id);
		//控制页面跳转
		resp.sendRedirect("/product");
	}
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		if(hasLength(sid)) {
			Long id = Long.valueOf(sid);
			//回显表单数据
			Product pro = dao.get(id);
			req.setAttribute("pro", pro);
		}
		req.getRequestDispatcher("/WEB-INF/product/edit.jsp");
	}
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求参数
		//调用业务方法
		List<Product> list = dao.list();
		//控制页面跳转
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/product/list.jsp").forward(req, resp);;
	}
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
