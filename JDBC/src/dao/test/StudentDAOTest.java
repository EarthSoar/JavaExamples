package dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.dao.impl.StudentDAOImpl;
import dao.daomain.Student;

public class StudentDAOTest {
	StudentDAOImpl dao = new StudentDAOImpl();
	@Test
	public void testDelete() throws Exception {
		dao.delete(1L);
	}
	@Test
	public void testSave() throws Exception {
		dao.save(new Student("’‘√Ù",23));
	}
	@Test
	public void testUpdate() throws Exception {
		Student newStu = new Student(3L, "«ÿËÌ", 99);
		dao.update(newStu);
	}
	@Test
	public void testGet() throws Exception {
		Student stu = dao.get(10L);
		System.out.println(stu);
	}
	@Test
	public void testList() throws Exception {
		List<Student> list = new ArrayList<>();
		list = dao.list();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
