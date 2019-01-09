package dao;

import daomain.Product;
import page.PageResult;
import query.ProductQueryObject;

import java.util.List;

/**
 * @author Willing
 * @date 2018/12/18
 */
public interface IProductDAO {
    void save(Product product);
    void delete(Long id);
    void update(Product product);
    Product get(Long id);
    List<Product> list(ProductQueryObject queryObject);//高级查询
    PageResult query(ProductQueryObject queryObject);//高级查询 + 分页
}
