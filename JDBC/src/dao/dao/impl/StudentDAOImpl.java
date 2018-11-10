package dao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.dao.IStudentDAO;
import dao.daomain.Student;
import dao.jdbcUtil.JdbcUtil;

/**
 * @author 15626 dao接口的实现类
 */
public class StudentDAOImpl implements IStudentDAO {
	
	//INSERT INTO FROM s_student(name,age) VALUES(stu.getName(),stu.getAge());
	public void save(Student stu) {
		String sql = "INSERT INTO FROM s_student(name,age) VALUES(?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载注册驱动，获取连接对象
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			JdbcUtil.close(conn, ps, null);
		}
	}

	public void delete(Long id) {
		String sql = "DELETE FROM s_student WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载注册驱动
			//获取连接对象
			conn = JdbcUtil.getConn();
			//获取语句对象
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			//执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			JdbcUtil.close(conn, ps, null);
		}
	}
	//UPDATE s_student SET name = 'newStu.getName()',age = newStu.getAge() WHERE id = newStu.getId();
	public void update(Student newStu) {
		String sql = "UPDATE s_student SET name = ?,age = ? WHERE id = ?;";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载注册驱动
			//获取连接对象
			conn = JdbcUtil.getConn();
			//获取语句对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, newStu.getName());
			ps.setInt(2, newStu.getAge());
			ps.setLong(3, newStu.getId());
			//执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			JdbcUtil.close(conn, ps, null);
		}
	}

	public Student get(Long id) {
		String sql = "SELECT * FROM s_student WHERE id = ? "; 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//加载注册驱动
			//获取连接对象
			conn = JdbcUtil.getConn();
			// 获取语句对象
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			// 执行SQL语句
			rs = ps.executeQuery();
			if (rs.next()) {
				Student stu = new Student();
				Long sid = rs.getLong("id");
				String name = rs.getString("name");
				Integer age = rs.getInt("age");

				stu.setId(sid);
				stu.setName(name);
				stu.setAge(age);

				return stu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

	public List<Student> list() {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM s_student";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//加载注册驱动
			//获取连接对象
			conn = JdbcUtil.getConn();
			//获取语句对象
			ps = conn.prepareStatement(sql);
			//执行sql语句
			rs = ps.executeQuery(sql);
			//查询操作
			while(rs.next()){
				Student stu = new Student();
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				Integer age = rs.getInt("age");
				
				stu.setName(name);
				stu.setId(id);
				stu.setAge(age);
				
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}
		return list;
	}
}
