package web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import damain.CartItem;
import damain.Product;
import damain.ShoppingCart;
import dao.IProductDAO;
import dao.IProductDirDAO;
import dao.impl.ProductDAOImpl;
import dao.impl.ProductDirDAOImpl;
import page.PageResult;
import query.ProductQueryObject;
import util.StringUtil;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProductDAO dao;
	private IProductDirDAO dirDAO;

	public void init() throws ServletException {
		dao = new ProductDAOImpl();
		dirDAO = new ProductDirDAOImpl();
	}

	// 分发操作
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码格式,必须在第一行书写
		req.setCharacterEncoding("UTF-8");

		// ================
		// 检查当前账户是否已经登录
		Object user = req.getSession().getAttribute("USER_IN_SESSION");
		if (user == null) {// 用户未登录
			// 返回登录页面
			resp.sendRedirect("/login.jsp");
			return;
		}
		// ================
		String token = UUID.randomUUID().toString();
		//把随机令牌设置到session作用域中, 在login.jsp中可以用el表达式获取到session中的数据,
		//并且放在隐藏域中,在后台比较,防止重复提交表单
		req.getSession().setAttribute("TOKEN_IN_SESSION", token);
		// ===============
		String cmd = req.getParameter("cmd");
		if ("save".equals(cmd)) {
			this.save(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		} else if ("edit".equals(cmd)) {
			this.edit(req, resp);
		} else if ("add".equals(cmd)) {
			this.addCart(req, resp);
		} else {
			this.list(req, resp);
		}
	}

	private void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数
		String productName = req.getParameter("productName");
		productName = new String(productName.getBytes("ISO-8859-1"),"utf-8");
		BigDecimal salePrice = new BigDecimal(req.getParameter("salePrice"));
		Long id = Long.valueOf(req.getParameter("id"));
		Product product = new Product(id,productName,salePrice);
		
		// 调用业务方法处理请求
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
		if (cart == null) {// 没有购物车就创建一个
			cart = new ShoppingCart();
			req.getSession().setAttribute("SHOPPINGCART_IN_SESSION", cart);// 设置到session作用域供供下次使用, 在结算jsp页面使用
		}
		cart.save(new CartItem(product, 1));
		// 控制页面跳转
		req.setAttribute("succeed", "添加成功");
		req.getRequestDispatcher("/WEB-INF/product/save.jsp").forward(req, resp);
	}

	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// =====令牌机制,防止表单的重复提交=======
		String token = req.getParameter("token");
		String sessionToken = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
		if (StringUtil.hasLength(token)) {
			if (token.equals(sessionToken)) {
				req.getSession().removeAttribute("TOKEN_IN_SESSION");
			}
			return;
		}
		// 接受请求参数封装成对象
		String productName = req.getParameter("productName");
		String brand = req.getParameter("brand");
		String supplier = req.getParameter("supplier");
		BigDecimal salePrice = new BigDecimal(req.getParameter("salePrice"));
		BigDecimal costPrice = new BigDecimal(req.getParameter("costPrice"));
		Double cutoff = Double.valueOf(req.getParameter("cutoff"));
		Long dir_id = Long.valueOf(req.getParameter("dir_id"));
		Product pro = new Product(productName, brand, supplier, salePrice, costPrice, cutoff, dir_id);

		String sid = req.getParameter("id");
		if (hasLength(sid)) {
			Long id = Long.valueOf(sid);
			pro.setId(id);
			dao.update(pro);
		} else {
			dao.save(pro);
		}

		// 控制页面跳转
		resp.sendRedirect("/product");
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受请求参数
		String sid = req.getParameter("id");
		Long id = Long.valueOf(sid);
		// 调用业务方法
		dao.delete(id);
		// 控制页面跳转
		resp.sendRedirect("/product");
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		if (hasLength(sid)) {
			Long id = Long.valueOf(sid);
			// 回显表单数据
			Product pro = dao.get(id);
			req.setAttribute("pro", pro);
		}
		// 把分类名称传到edit.jsp页面中
		req.setAttribute("dirs", dirDAO.list());

		req.getRequestDispatcher("/WEB-INF/product/edit.jsp").forward(req, resp);
	}

	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductQueryObject qo = new ProductQueryObject();
		req.setAttribute("dirs", dirDAO.list());
		// 接受请求参数,封装成查询对象
		request2Object(req, qo);
		// 调用业务方法,调用DAO的查询方法
		List<Product> list = dao.list(qo);
		// 控制页面跳转
		req.setAttribute("list", list);
		req.setAttribute("qo", qo);

		String sCurrentPage = req.getParameter("currentPage");
		String sCount = req.getParameter("count");
		Integer currentPage = 1;
		Integer count = 4;
		if (StringUtil.hasLength(sCurrentPage)) {
			currentPage = Integer.valueOf(sCurrentPage);
		}
		if (StringUtil.hasLength(sCount)) {
			count = Integer.valueOf(sCount);
		}
		PageResult pageResult = dao.queryPage(currentPage, count);
		req.setAttribute("pageResult", pageResult);
		req.getRequestDispatcher("/WEB-INF/product/list.jsp").forward(req, resp);
		;
	}

	private void request2Object(HttpServletRequest req, ProductQueryObject qo) {
		String productName = req.getParameter("productName");
		String minSalePrice = req.getParameter("minSalePrice");
		String maxSalePrice = req.getParameter("maxSalePrice");
		String dirId = req.getParameter("dirId");
		String keyword = req.getParameter("keyword");
		if (StringUtil.hasLength(productName)) {
			qo.setProductName(productName);
		}
		if (StringUtil.hasLength(minSalePrice)) {
			qo.setMinSalePrice(new BigDecimal(minSalePrice));
		}
		if (StringUtil.hasLength(maxSalePrice)) {
			qo.setMaxSalePrice(new BigDecimal(maxSalePrice));
		}
		if (StringUtil.hasLength(keyword)) {
			qo.setKeyword(keyword);
		}
		if (StringUtil.hasLength(dirId)) {
			qo.setDirId(Long.valueOf(dirId));
		}
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
