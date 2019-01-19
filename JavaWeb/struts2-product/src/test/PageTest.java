package test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import damain.Product;
import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import page.PageResult;
import template.IResultSetHandler;
import template.JdbcTemplate;

public class PageTest {
	
	IProductDAO dao = new ProductDAOImpl();
	@Test
	public void testPage2() throws Exception {
		Integer currentPage = 5;
		Integer pageSize = 5;
		PageResult pr = dao.queryPage(currentPage, pageSize);
		System.out.println("上一页:"+ pr.getPrevPage());
		System.out.println("下一页:" + pr.getNextPage());
		System.out.println("总页数:" + pr.getTotalPage());
		System.out.println("结果总数:" + pr.getTotalCount());
		List<?> list = pr.getListData();
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
	@Test
	public <T> void testPage() throws Exception {
		Integer currentPage = 2;
		Integer pageSize = 10;
		
		//查询符合条件的结果集,SELECT *FROM product LIMIT beginIndex,pageSize
		//beginIndex = (currentPage - 1)*pageSize  每页开始的索引
		String sql = "SELECT * FROM product LIMIT ?,? ";
		List<Product> list = JdbcTemplate.qurey(sql, new ProductResultHandle(), (currentPage - 1)*pageSize,pageSize);
		for (Product product : list) {
			System.out.println(product);
		}
		//查询结果总数
		String countSql = "SELECT COUNT(*) FROM product";
		 Integer count = JdbcTemplate.qurey(countSql,new IResultSetHandler<Long>() { //处理结果集.只有一行
			@Override
			public Long handle(ResultSet rs) throws Exception {
				if(rs.next()) {
					return rs.getLong(1);
				}
				return 0L;
			}
		}).intValue();
		 System.out.println(count);
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
