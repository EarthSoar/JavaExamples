package hello.dao;

import java.util.List;

import hello.domain.User;

public interface IUserDAO {
	void save(User user);

	void delete(User user);

	void update(User user);

	User get(Long id);

	List<User> list();
}
