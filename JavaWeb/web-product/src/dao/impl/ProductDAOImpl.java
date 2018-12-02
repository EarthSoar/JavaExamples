package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import damain.Product;
import dao.IProductDAO;
import util.JdbcUtil;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public void save(Product pro) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO product(productName,dir_id,salePrice,supplier,brand,cutoff,costPrice) VALUES(?,?,?,?,?,?,?)";
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,pro.getProductName());
			ps.setLong(2, pro.getDir_id());
			ps.setBigDecimal(3,pro.getSalePrice());
			ps.setString(4, pro.getSupplier());
			ps.setString(5, pro.getBrand());
			ps.setDouble(6, pro.getCutoff());
			ps.setBigDecimal(7,pro.getCostPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, null);
		}
	}

	@Override
	public void delete(Long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM product WHERE id = ?";
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, null);
		}
	}

	@Override
	public void update(Product pro) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE product SET productName = ?,dir_id = ?,salePrice = ?,supplier = ?,brand = ?,cutoff = ?,costPrice = ? WHERE id = ?";
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,pro.getProductName());
			ps.setLong(2, pro.getDir_id());
			ps.setBigDecimal(3,pro.getSalePrice());
			ps.setString(4, pro.getSupplier());
			ps.setString(5, pro.getBrand());
			ps.setDouble(6, pro.getCutoff());
			ps.setBigDecimal(7,pro.getCostPrice());
			ps.setLong(8,pro.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, null);
		}
		
	}

	@Override
	public Product get(Long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product WHERE id = ?";
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return getObject(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Product> list() {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product";
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product pro = getObject(rs);
				list.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return list;
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
}
