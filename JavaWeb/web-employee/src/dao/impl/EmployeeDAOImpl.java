package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.IEmployeeDAO;
import daomain.Employee;
import page.PageResult;
import query.QueryObject;
import template.IResultSetHandler;
import template.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public void save(Employee e) {
		String sql = "INSERT INTO t_employee(username,password,dept,headImg,entryDate) VALUES(?,?,?,?,?)";
		Object[] params = { e.getUsername(), e.getPassword(), e.getDept(), e.getHeadImg(), e.getEntryDate() };
		JdbcTemplate.update(sql, params);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_employee WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Employee e) {
		String sql = "UPDATE t_employee SET username = ?, password = ?, dept = ?, headImg = ?, entryDate = ? WHERE id = ?";
		Object[] params = { e.getUsername(), e.getPassword(), e.getDept(), e.getHeadImg(), e.getEntryDate(),
				e.getId() };
		JdbcTemplate.update(sql, params);
	}

	@Override
	public Employee get(Long id) {
		String sql = "SELECT * FROM t_employee WHERE id = ?";
		List<Employee> list = JdbcTemplate.query(sql, new EmployeeResultSetHandle(), id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<Employee> list() {
		String sql = "SELECT * FROM t_employee";
		return JdbcTemplate.query(sql, new EmployeeResultSetHandle());
	}

	@Override
	// 高级查询+分页
	public PageResult query(QueryObject qo) {
		// 1.查询结果总数
		String countSql = "SELECT COUNT(*) FROM t_employee " + qo.getQuery();
		Integer totalCount = JdbcTemplate.query(countSql, new IResultSetHandler<Long>() {
			@Override
			public Long handle(ResultSet rs) throws Exception {
				if (rs.next()) {
					return rs.getLong(1);
				}
				return 0L;
			}
		}, qo.getParameters().toArray()).intValue();
		
		List<Employee> listData = null;
		if (totalCount == 0) {// 如果结果总数 为0,结果集合直接给空集
			listData = Collections.emptyList();
		}
		// 2.查询结果 集
		String resultSql = "SELECT * FROM t_employee " + qo.getQuery() + "LIMIT ?, ?";
		qo.getParameters().add((qo.getCurrentPage() - 1) * qo.getPageSize());
		qo.getParameters().add(qo.getPageSize());

		System.out.println("resultSql=" + resultSql);
		System.out.println("参数=" + qo.getParameters());

		listData = JdbcTemplate.query(resultSql, new EmployeeResultSetHandle(), qo.getParameters().toArray());
		return new PageResult(listData, totalCount, qo.getCurrentPage(), qo.getPageSize());
	}

	private class EmployeeResultSetHandle implements IResultSetHandler<List<Employee>> {
		@Override
		public List<Employee> handle(ResultSet rs) throws Exception {
			List<Employee> list = new ArrayList<>();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String headImg = rs.getString("headImg");
				String dept = rs.getString("dept");
				java.util.Date entryDate = rs.getDate("entryDate");
				list.add(new Employee(id, username, password, dept, headImg, entryDate));
			}
			return list;
		}
	}

}
