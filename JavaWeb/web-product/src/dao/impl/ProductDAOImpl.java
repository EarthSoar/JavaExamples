package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import damain.Product;
import dao.IProductDAO;
import template.IResultSetHandler;
import template.JdbcTemplate;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public void save(Product pro) {
		String sql = "INSERT INTO product(productName,dir_id,salePrice,supplier,brand,cutoff,costPrice) VALUES(?,?,?,?,?,?,?)";
		Object params[] = {pro.getProductName(),pro.getDir_id(),pro.getSalePrice(),pro.getSupplier(),pro.getBrand(),
				pro.getCutoff(),pro.getCostPrice() };
		JdbcTemplate.update(sql, params);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM product WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Product pro) {
		String sql = "UPDATE product SET productName = ?,dir_id = ?,salePrice = ?,supplier = ?,brand = ?,cutoff = ?,costPrice = ? WHERE id = ?";
		Object params[] = {pro.getProductName(),pro.getDir_id(),pro.getSalePrice(),pro.getSupplier(),pro.getBrand(),
				pro.getCutoff(),pro.getCostPrice() };
		JdbcTemplate.update(sql, params);
	}

	@Override
	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		List<Product> list =  JdbcTemplate.qurey(sql,new ProductResultHandle(), id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<Product> list() {
		String sql = "SELECT * FROM product";
		return JdbcTemplate.qurey(sql, new ProductResultHandle());
	}

	private Product getObject(ResultSet rs) throws Exception {
		Product pro = new Product(null, null, null, null, null, null, null, null);
		pro.setId(rs.getLong("id"));
		pro.setProductName(rs.getString("productName"));
		pro.setBrand(rs.getString("brand"));
		pro.setCostPrice(rs.getBigDecimal("costPrice"));
		pro.setDir_id(rs.getLong("dir_id"));
		pro.setSupplier(rs.getString("supplier"));
		pro.setCutoff(rs.getDouble("cutOff"));
		pro.setSalePrice(rs.getBigDecimal("salePrice"));
		return pro;
	}
	class ProductResultHandle implements IResultSetHandler<List<Product>>{
		List<Product> list = new ArrayList<>();
		public List<Product> handle(ResultSet rs) throws Exception {
			while(rs.next()) {
				Product pro = getObject(rs);
				list.add(pro);
			}
			return list;
		}
	}
}
