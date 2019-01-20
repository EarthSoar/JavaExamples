package query;

import java.math.BigDecimal;

import util.StringUtil;

/**
 * 	商品的查询对象  
 * @author Willing
 * 	封装了
 * 		1.查询所需要的条件信息
 * 		2.查询的条件语句 
 * 		3.查询的条件中所需的参数, 
 */
public class ProductQueryObject extends QueryObject {
	private String productName;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;
	private Long dirId;
	private String keyword;


	//定制自身查询条件和查询SQL语句中所需要的参数
	protected void customizedQuery() {
		if(StringUtil.hasLength(productName)) {
			super.addQuery(" productName LIKE ? ", "%"+productName+"%");
		}
		if(minSalePrice != null) {
			super.addQuery(" SalePrice > ? ", minSalePrice);
		}
		if(maxSalePrice != null) {
			super.addQuery(" SalePrice < ? ", maxSalePrice);
		}
		if(dirId != null && dirId != -1) {
			super.addQuery(" dir_id = ? ", dirId);
		}
		if(StringUtil.hasLength(keyword)) {
			super.addQuery(" productName LIKE ? OR brand LIKE ? ", "%"+keyword+"%","%"+keyword+"%");
		}
		
		//SELECT * FROM product ORDER BY dir_id ASC,salaPrice DESC
		super.setOrderBy("dir_id",OrderBy.ASC);
		super.setOrderBy("salePrice",OrderBy.DESC);
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getDirId() {
		return dirId;
	}
	public void setDirId(Long dirId) {
		this.dirId = dirId;
	}

}
