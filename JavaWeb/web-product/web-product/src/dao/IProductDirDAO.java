package dao;

import daomain.ProductDir;

import java.util.List;

/**
 * @author Willing
 * @date 2019/1/8
 */
public interface IProductDirDAO {
    void save(ProductDir dir);
    void delete(Long id);
    void update(ProductDir dir);
    ProductDir get(Long id);
    List<ProductDir> list();
}
