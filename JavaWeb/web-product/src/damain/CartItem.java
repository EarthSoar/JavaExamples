package damain;

//购物车商品对象
public class CartItem {
	private Product product;
	private Integer num;// 商品的数量

	
	public CartItem(Product product, Integer num) {
		this.product = product;
		this.num = num;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
