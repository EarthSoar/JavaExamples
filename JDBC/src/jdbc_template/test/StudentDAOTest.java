package jdbc_template.test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jdbc_template.dao.IStudentDAO;
import jdbc_template.dao.impl.StudentDAOImpl;
import jdbc_template.daomain.Student;
import jdbc_template.handler.IResultSetHandler;
import jdbc_template.template.JdbcTemplate;

public class StudentDAOTest {

	IStudentDAO dao = new StudentDAOImpl();
	@Test
	public void testDelete() throws Exception {
		dao.delete(13002L);
	}
	@Test
	public void testSave() throws Exception {
		dao.save(new Student("张无忌",23));
	}
	@Test
	public void testUpdate() throws Exception {
		Student newStu = new Student(13003L, "秦桧老贼", 99);
		dao.update(newStu);
	}
	@Test
	public void testGet() throws Exception {
		Student stu = dao.get(13007L);
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
	@Test//  查询中有多少条数据
	public void testTotalCount() throws Exception {
		String sql = "SELECT COUNT(id) FROM s_student";
		Long totalCount = JdbcTemplate.query(sql, new IResultSetHandler<Long>(){

			@Override
			public Long handle(ResultSet rs) throws Exception {
				if(rs.next()){
					return rs.getLong(1);
				}
				return 0L;
			}
		});
		System.out.println(totalCount);
	}
}
