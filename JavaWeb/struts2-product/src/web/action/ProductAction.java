package web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import damain.Product;
import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import query.ProductQueryObject;

public class ProductAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private IProductDAO dao = new ProductDAOImpl();
	private ProductQueryObject qo = new ProductQueryObject();
	private Product product = new Product();
	public String input() {
		return INPUT;
	}
	
	public String save() {
		if(product.getId() == null) {
			dao.save(product);
		}
		return SUCCESS;
	}
	public String execute() throws Exception {
		List<Product> list = dao.list(qo);
		//把数据共享到jsp
		ActionContext.getContext().put("list", list);
		return "list";
	}
	
	//===========
	public Product getProduct() {
		return product;
	}
}
