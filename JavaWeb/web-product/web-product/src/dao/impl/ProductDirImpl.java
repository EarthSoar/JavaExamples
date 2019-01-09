package dao.impl;

import dao.IProductDirDAO;
import daomain.ProductDir;
import template.IResultSetHandler;
import template.JdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Willing
 * @date 2019/1/8
 */
public class ProductDirImpl implements IProductDirDAO {
    public void save(ProductDir dir) {

    }

    public void delete(Long id) {

    }

    public void update(ProductDir dir) {

    }

    public ProductDir get(Long id) {
        return null;
    }

    public List<ProductDir> list() {
        String sql = "SELECT * FROM productdir";
        return JdbcTemplate.query(sql, new ProductdirResultHandle());
    }

    private class ProductdirResultHandle implements IResultSetHandler<List<ProductDir>> {
        public List<ProductDir> handle(ResultSet rs) throws Exception {
            List<ProductDir> list = new ArrayList<ProductDir>();
            while(rs.next()) {
                ProductDir dir = new ProductDir();
                list.add(dir);
                dir.setId(rs.getLong("id"));
                dir.setDirName(rs.getString("dirName"));
                dir.setParent_id(rs.getLong("parent_id"));
            }
            return list;
        }
    }
}
