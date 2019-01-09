package dao.impl;

import dao.IProductDAO;
import daomain.Product;
import page.PageResult;
import query.ProductQueryObject;
import template.IResultSetHandler;
import template.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Willing
 * @date 2018/12/18
 */
public class ProductDAOImpl implements IProductDAO {
    public void save(Product product) {
        String sql = "INSERT INTO product(productName,dir_id,salePrice,supplier,brand,cutoff,costPrice) VALUES(?,?,?,?,?,?,?)";
        Object params[] = {product.getProductName(),product.getDir_id(),product.getSalePrice(),product.getSupplier(),product.getBrand(),
                product.getCutoff(),product.getCostPrice() };
        JdbcTemplate.update(sql, params);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM product WHERE id = ?";
        JdbcTemplate.update(sql,id);
    }

    public void update(Product product) {
        String sql = "UPDATE product SET productName = ?,dir_id = ?,salePrice = ?,supplier = ?,brand = ?,cutoff = ?,costPrice = ? WHERE id = ?";
        Object params[] = {product.getProductName(),product.getDir_id(),product.getSalePrice(),product.getSupplier(),product.getBrand(),
                product.getCutoff(),product.getCostPrice(),product.getId() };
        JdbcTemplate.update(sql,params);
    }

    public Product get(Long id) {
        String sql = "SELECT *FROM product WHERE id = ?";
        List<Product> list =JdbcTemplate.query(sql,new ProductResultSetHandle(),id);
        return  list.size() == 1 ? list.get(0) : null;
    }

    public List<Product> list(ProductQueryObject queryObject) {
        String sql = "SELECT * FROM product ";
        sql += queryObject.getQuery();//添加查询条件
        List<Object> param = queryObject.getParameter();
        System.out.println(sql);
        System.out.println(param);
        return JdbcTemplate.query(sql,new ProductResultSetHandle(),param.toArray());
    }

    public PageResult query(ProductQueryObject queryObject) {
        //查询结果总数
        String coutSql = "SELECT COUNT(*) FROM product" + queryObject.getQuery();
        Integer totalCount = JdbcTemplate.query(coutSql, new IResultSetHandler<Long>() {
            public Long handle(ResultSet rs) throws Exception {
                if(rs.next()){
                    return rs.getLong(1);
                }
                return 0L;
            }
        },queryObject.getParams().toArray()).intValue();//把Long 类型转换为Integer

        List listData = null;
        if(totalCount == 0){
            listData = Collections.EMPTY_LIST;
        }

        //查询结果集
        String listSql = "SELECT * FROM product " + queryObject.getQuery() + "LIMIT ?,?";
        //把LIMIT后面的两个? 的参数值添加到 参数集合中
        queryObject.getParameter().add((queryObject.getCurrentPage() - 1) * queryObject.getPageSize());
        queryObject.getParameter().add(queryObject.getPageSize());
        System.out.println(listSql);
        System.out.println(queryObject.getParameter());
        listData = JdbcTemplate.query(listSql,new ProductResultSetHandle(),queryObject.getParams().toArray());


        return new PageResult(listData,totalCount,queryObject.getCurrentPage(),queryObject.getPageSize());
    }


    //把查询的结果封装成对象
    private void result2Object(ResultSet rs, Product product) throws SQLException {
        product.setBrand(rs.getString("brand"));
        product.setId(rs.getLong("id"));
        product.setCostPrice(rs.getBigDecimal("costPrice"));
        product.setCutoff(rs.getDouble("cutoff"));
        product.setDir_id(rs.getLong("dir_id"));
        product.setProductName(rs.getString("productName"));
        product.setSupplier(rs.getString("supplier"));
        product.setSalePrice(rs.getBigDecimal("salePrice"));
    }
    //商品的结果集处理
    private class ProductResultSetHandle implements IResultSetHandler<List<Product>> {
        public List<Product> handle(ResultSet rs) throws Exception {
            List<Product> list = new ArrayList<Product>();
            while(rs.next()){
                Product product = new Product();
                result2Object(rs,product);
                list.add(product);
            }
            return list;
        }
    }
}
