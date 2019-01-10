package dao;

import damain.User;

public interface IUserDAO {
	
	/**
	 * 	根据账号查找用户对象
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
}
