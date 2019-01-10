package damain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//购物车
public class ShoppingCart {
	// 购物车中的商品集合
	private List<CartItem> items = new ArrayList<>();

	// 向购物车中添加商品
	public void save(CartItem newItem) {
		for (CartItem cartItem : items) {
			// 如果购物车中有相同的产品,数量增加
			if (cartItem.getProduct().getId() == (newItem.getProduct().getId())) {
				cartItem.setNum(cartItem.getNum() + newItem.getNum());
				return;
			}
			// 否则把新的产品对象加入到购物车中
			items.add(newItem);
		}
	}

	// 删除购物车中的商品
	public void delete(Long id) {
		Iterator<CartItem> it = items.iterator();// 获取集合的一个迭代器
		while (it.hasNext()) {
			CartItem item = it.next();
			if (id == item.getProduct().getId()) {
				// items.remove(item);//错误的, 不能边迭代别删除
				it.remove();
				break;// 找到商品没必要再去迭代了
			}
		}
	}

	// 结算金额
	public BigDecimal getTotalPrice() {
		BigDecimal tatalPrice = BigDecimal.ZERO;// 默认为总价格为0
		for (CartItem cartItem : items) {
			tatalPrice = tatalPrice//    totalPrice += salePrice * num
					.add(cartItem.getProduct().getSalePrice().multiply(new BigDecimal(cartItem.getNum())));
		}
		return tatalPrice;
	}

	// 购物车清单
	public List<CartItem> getItems() {
		return this.items;
	}
}
