package register.dao.impl;

import org.springframework.stereotype.Repository;

import register.damain.User;
import register.dao.IUserDAO;

@Repository
public class UserDAOImpl implements IUserDAO {

	@Override
	public void save(User user) {
		System.out.println("保存   dao方法");
	}

}
