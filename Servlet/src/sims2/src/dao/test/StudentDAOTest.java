package dao.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.dao.IStudentDAO;
import dao.dao.impl.StudentDAOImpl;
import dao.daomain.Student;

class StudentDAOTest {
	IStudentDAO dao = new StudentDAOImpl();
	@Test
	void testSave() {
		Student stu = new Student("狗哲",20);
		dao.save(stu);
	}

	@Test
	void testDelete() {
		dao.delete(13003L);
	}

	@Test
	void testUpdate() {
		Student stu = new Student(13009L,"苟哲",20);
		dao.update(stu);
	}

	@Test
	void testGet() {
		Student stu = dao.get(13003L);
		System.out.println(stu);
	}

	@Test
	void testList() {
		List<Student> list = dao.list();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
