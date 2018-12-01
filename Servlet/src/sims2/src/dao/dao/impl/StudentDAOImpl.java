package dao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.JdbcUtil;
import dao.dao.IStudentDAO;
import dao.daomain.Student;

public class StudentDAOImpl implements IStudentDAO {

	@Override
	public void save(Student stu) {
		String sql = "INSERT INTO s_student(name,age) VALUES(?,?) ";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2,stu.getAge());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps,null);
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM s_student WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setLong(1,id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps,null);
		}
		
	}

	@Override
	public void update(Student stu) {
		String sql = "UPDATE s_student SET name = ?, age = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2,stu.getAge());
			ps.setLong(3, stu.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps,null);
		}
		
	}

	@Override
	public Student get(Long id) {
		String sql = "SELECT * FROM s_student WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Student newStu = new Student();
				newStu.setId(rs.getLong("id"));
				newStu.setName(rs.getString("name"));
				newStu.setAge(rs.getInt("age"));
				return newStu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Student> list() {
		String sql = "SELECT * FROM s_student";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<>();
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Student newStu = new Student();
				newStu.setId(rs.getLong("id"));
				newStu.setName(rs.getString("name"));
				newStu.setAge(rs.getInt("age"));
				list.add(newStu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return list;
	}

}
