package register.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import register.damain.User;
import register.dao.IUserDAO;
import register.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public void save(User user) {
		System.out.println("保存 service方法");
		userDAO.save(user);
	}

}
