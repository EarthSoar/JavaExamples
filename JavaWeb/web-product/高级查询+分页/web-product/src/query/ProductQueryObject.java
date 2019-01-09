package query;

import lombok.Data;
import util.StringUtil;

import java.math.BigDecimal;

/**
 * @author Willing
 * @date 2019/1/8
 */

/**
 * 查询条件 和 查询所需要的参数
 */
@Data
public class ProductQueryObject extends QueryObject {
    private String productName;
    private BigDecimal minSalePrice;
    private BigDecimal maxSalePrice;
    private Long dirId;
    private String keyword;

    @Override
    protected void customizedQuery() {
        if(StringUtil.hasLength(productName)){
            super.addQuery(" productName LIKE ? ","%"+this.getProductName()+"%");
        }
        if(this.minSalePrice != null){
            super.addQuery(" salePrice > ? ",this.getMinSalePrice());
        }
        if(this.maxSalePrice != null){
            super.addQuery(" salePrice < ? ",this.getMaxSalePrice());
        }
        if(dirId != null && dirId != -1) {
            super.addQuery(" dir_id = ? ", dirId);
        }
        if(StringUtil.hasLength(keyword)) {
            super.addQuery(" productName LIKE ? OR brand LIKE ? ", "%"+keyword+"%","%"+keyword+"%");
        }
    }
}
