package daomain;



import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Willing
 * @date 2018/12/18
 */
@Data
public class Product {
    private Long id;
    private String productName;
    private String brand;//制造商
    private String supplier;//供应商
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private Double cutoff;
    private Long dir_id;
    public Product(){}
    public Product(String productName, String brand, String supplier, BigDecimal salePrice,
                   BigDecimal costPrice, Double cutoff, Long dir_id) {
        this.productName = productName;
        this.brand = brand;
        this.supplier = supplier;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
        this.cutoff = cutoff;
        this.dir_id = dir_id;
    }
}

