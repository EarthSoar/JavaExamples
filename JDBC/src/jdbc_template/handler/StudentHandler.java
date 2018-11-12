package jdbc_template.handler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc_template.daomain.Student;

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
