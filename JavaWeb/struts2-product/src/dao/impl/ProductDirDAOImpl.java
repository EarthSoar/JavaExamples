package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import damain.ProductDir;
import dao.IProductDirDAO;
import template.IResultSetHandler;
import template.JdbcTemplate;

public class ProductDirDAOImpl implements IProductDirDAO{

	@Override
	public void save(ProductDir dir) {
		String sql = "INSERT INTO productdir(dirName,parent_id) VALUES(?,?)";
		Object params[] = {dir.getId(),dir.getDirName(),dir.getParent_id()};
		JdbcTemplate.update(sql, params);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM productdir WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public void update(ProductDir dir) {
		String sql = "UPDATE productdir SET id=?,dirName=?,parent_id=?";
		Object params[] = {dir.getId(),dir.getDirName(),dir.getParent_id()};
		JdbcTemplate.update(sql, params);
	}

	@Override
	public ProductDir get(Long id) {
		String sql = "SELECT * FROM productdir WHERE id = ?";
		List<ProductDir> list = JdbcTemplate.qurey(sql, new ProductdirResultHandle(), id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<ProductDir> list() {
		String sql = "SELECT * FROM productdir";
		return JdbcTemplate.qurey(sql, new ProductdirResultHandle());
	}
	
	class ProductdirResultHandle implements IResultSetHandler<List<ProductDir>>{
		List<ProductDir> list = new ArrayList<>();
		public List<ProductDir> handle(ResultSet rs) throws Exception {
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
