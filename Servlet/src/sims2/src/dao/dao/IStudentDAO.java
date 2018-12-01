package dao.dao;

import java.util.List;

import dao.daomain.Student;

public interface IStudentDAO {
	void save(Student stu);
	void delete(Long id);
	void update(Student stu);
	Student get(Long id);
	List<Student> list();
}
