package register.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import register.damain.User;
import register.service.IUserService;

@Controller
public class UserAction {
	@Autowired
	private  IUserService service;
	
	public void execute() {
		System.out.println("保存  action方法");
		service.save(new User());
	}
}
