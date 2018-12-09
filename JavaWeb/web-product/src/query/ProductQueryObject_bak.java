package query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import util.StringUtil;

/**
 * 	商品的查询对象  
 * @author Willing
 * 	封装了
 * 		1.查询所需要的条件信息
 * 		2.查询的条件语句 
 * 		3.查询的条件中所需的参数, 
 */
public class ProductQueryObject_bak implements IQuery {
	private String productName;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;
	
	
	//封装查询的参数
	private List<Object> params = new ArrayList<>();
	//封装查询的条件   
	private List<Object> condition = new ArrayList<>();
	
	
	//返回查询所需要的条件  WHERE ...
	public String getQuery() {
		//sql语句
		StringBuilder sql = new StringBuilder(80);
		
		//判断用户是否填写了条件.
		if(StringUtil.hasLength(this.getProductName())) {
			condition.add(" productName LIKE ?");
			params.add("%" + this.getProductName() + "%");
		}
		if(this.getMinSalePrice() != null) {
			condition.add(" salePrice > ?");
			params.add(this.getMinSalePrice());
		}
		if(this.getMaxSalePrice() != null) {
			condition.add(" salePrice < ?");
			params.add(this.getMaxSalePrice());
		}
		
		//遍历封装条件的集合,判断第一个条件前面加WHERE,非第一个条件前面加上AND
		for(int i = 0; i < condition.size(); i++) {
			if(i == 0) {
				sql.append(" WHERE ");
			}else {
				sql.append(" AND ");
			}
			sql.append(condition.get(i));
		}
		return sql.toString();
	}
	
	//查询条件中的参数
	public List<Object> getParameters(){
		return this.params;
	}
	
	
	
	
	
	
	
	
	
	
	//getter and setter
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getMinSalePrice() {
		return minSalePrice;
	}
	public void setMinSalePrice(BigDecimal minSalePrice) {
		this.minSalePrice = minSalePrice;
	}
	public BigDecimal getMaxSalePrice() {
		return maxSalePrice;
	}
	public void setMaxSalePrice(BigDecimal maxSalePrice) {
		this.maxSalePrice = maxSalePrice;
	}
	
}
