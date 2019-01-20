package web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import damain.Product;
import dao.IProductDirDAO;
import dao.impl.ProductDirDAOImpl;
import exception.LogicException;
import factoy.BeanFactoy;
import page.PageResult;
import query.ProductQueryObject;
import service.IProductService;

public class ProductAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private IProductService service  = BeanFactoy.INSTANCE.getBean("productService",IProductService.class);
	private ProductQueryObject qo = new ProductQueryObject();
	private Product product = new Product();
	private IProductDirDAO dirDAO = new ProductDirDAOImpl();

	public String input() {
		// 把商品的分类共享到jsp
		ActionContext.getContext().put("dirs", dirDAO.list());
		// 回显数据
		if (product.getId() != null) {
			product = service.get(product.getId());
		}
		return INPUT;
	}

	public String save() {
		try {
			// 保存操作前台传过来没有id
			if (product.getId() == null) {
				service.save(product);
			} else {
				service.update(product);
			}
		} catch (LogicException e) {
			//出现异常回到input视图
			super.addFieldError("product.productName", e.getMessage());
			return input();
		}
		return SUCCESS;
	}

	public String execute() throws Exception {
		// 把数据共享到jsp
		PageResult pageResult = service.query(qo);
		ActionContext.getContext().put("pageResult", pageResult);
		ActionContext.getContext().put("dirs", dirDAO.list());
		return "list";
	}

	// 删除操作
	public String delete() {
		service.delete(product.getId());
		return SUCCESS;
	}

	// 对save方法做校验
	public void validateSave() {
		ActionContext.getContext().put("dirs", dirDAO.list());
		if (product.getProductName() == null || product.getProductName().trim().length() < 2) {
			super.addFieldError("product.productName", "商品名称不能少于2个字");
		}
	}

	// ===========
	public Product getProduct() {
		return product;
	}

	public ProductQueryObject getQo() {
		return qo;
	}
}
