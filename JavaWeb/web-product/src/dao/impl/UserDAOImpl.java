package dao.impl;

import java.sql.ResultSet;

import damain.User;
import dao.IUserDAO;
import template.IResultSetHandler;
import template.JdbcTemplate;

public class UserDAOImpl implements IUserDAO{
	
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM t_user WHERE username = ?";
		return JdbcTemplate.qurey(sql, new IResultSetHandler<User>() {
			@Override
			public User handle(ResultSet rs) throws Exception {
				if(rs.next()) {
					User user = new User();
					user.setName(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					return user;
				}
				return null;
			}
		}, username);
	}
}
