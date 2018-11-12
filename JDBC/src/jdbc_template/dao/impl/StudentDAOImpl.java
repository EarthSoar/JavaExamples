package jdbc_template.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc_template.dao.IStudentDAO;
import jdbc_template.daomain.Student;
import jdbc_template.handler.IResultSetHandler;
import jdbc_template.template.JdbcTemplate;

/**
 * @author 15626 dao接口的实现类
 */
public class StudentDAOImpl implements IStudentDAO {
	
	public void save(Student stu) {
		String sql = "INSERT INTO  s_student(name,age) VALUES(?,?)";
		JdbcTemplate.update(sql,stu.getName(),stu.getAge());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM s_student WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}
	
	public void update(Student newStu) {
		String sql = "UPDATE s_student SET name = ?,age = ? WHERE id = ?;";
		JdbcTemplate.update(sql, newStu.getName(),newStu.getAge(),newStu.getId());
	}

	public Student get(Long id) {
		String sql = "SELECT * FROM s_student WHERE id = ? "; 
		List<Student> list = JdbcTemplate.query(sql,new StudentHandler(), id);
		return list.size() == 1?list.get(0) : null;
	}

	public List<Student> list() {
		String sql = "SELECT * FROM s_student";
		return JdbcTemplate.query(sql,new StudentHandler());
	}
	
	public class StudentHandler implements IResultSetHandler<List<Student>>{

		@Override
		public List<Student> handle(ResultSet rs) throws Exception {
			
			List<Student> list = new ArrayList<>();
			while(rs.next()){
				Student stu = new Student();
				stu.setAge(rs.getInt("age"));
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				
				list.add(stu);
			}
			return list;
		}
	}
}
