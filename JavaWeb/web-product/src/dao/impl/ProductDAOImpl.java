package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import damain.Product;
import dao.IProductDAO;
import page.PageResult;
import query.ProductQueryObject;
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
				pro.getCutoff(),pro.getCostPrice(),pro.getId() };
		JdbcTemplate.update(sql, params);
	}

	@Override
	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		List<Product> list =  JdbcTemplate.qurey(sql,new ProductResultHandle(), id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<Product> list(ProductQueryObject qo) {
		StringBuilder sql = new StringBuilder(80);
		sql.append("SELECT * FROM product" + qo.getQuery());
		System.out.println(sql);
		System.out.println(qo.getParameters());
		return JdbcTemplate.qurey(sql.toString(), new ProductResultHandle(),qo.getParameters().toArray());
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
	
	
	@Override
	public PageResult queryPage(Integer currentPage,Integer pageSize) {
		//-------查询结果总数------------
		String countSql = "SELECT COUNT(*) FROM product";
		
		Integer totalCount = JdbcTemplate.qurey(countSql, new IResultSetHandler<Long>() {
			@Override
			public Long handle(ResultSet rs) throws Exception {
				if(rs.next()) {
					return rs.getLong(1);
				}
				return 0L;
			}
		}).intValue();
		
		List<?> listData = null;
		if(totalCount == 0) {//结果总数为0,没有必要查询结果集,返回一个空集合
			listData = Collections.emptyList();
		}
		//-------查询结果集合-----------
		String dataSql = "SELECT * FROM product LIMIT ?,?";
		listData = JdbcTemplate.qurey(dataSql, new ProductResultHandle(), (currentPage - 1)*pageSize,pageSize);
		return new PageResult(listData, totalCount, currentPage, pageSize);
	}
}
