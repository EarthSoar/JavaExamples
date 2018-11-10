package dao.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.dao.IStudentDAO;
import dao.daomain.Student;
import dao.jdbcUtil.JdbcUtil;

/**
 * @author 15626 dao�ӿڵ�ʵ����
 */
public class StudentDAOImpl_bak implements IStudentDAO {
	//INSERT INTO FROM s_student(name,age) VALUES(stu.getName(),stu.getAge());
	public void save(Student stu) {
		StringBuilder sql = new StringBuilder(80);
		sql.append("INSERT INTO s_student(name,age) VALUES(");
		sql.append("'").append(stu.getName()).append("'").append(",");
		sql.append(stu.getAge()).append(")");
		Connection conn = null;
		Statement st = null;
		try {
			//����ע������
			//��ȡ���Ӷ���
			conn = JdbcUtil.getConn();
			//��ȡ������
			st = conn.createStatement();
			//ִ��sql���
			st.executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			JdbcUtil.close(conn, st, null);
		}
	}

	public void delete(Long id) {
		String sql = "DELETE FROM s_student WHERE id = " + id;
		Connection conn = null;
		Statement st = null;
		try {
			//����ע������
			//��ȡ���Ӷ���
			conn = JdbcUtil.getConn();
			//��ȡ������
			st = conn.createStatement();
			//ִ��sql���
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			JdbcUtil.close(conn, st, null);
		}
	}
	//UPDATE s_student SET name = 'newStu.getName()',age = newStu.getAge() WHERE id = newStu.getId();
	public void update(Student newStu) {
		StringBuilder sql = new StringBuilder(80);
		sql.append("UPDATE s_student SET name = ").append("'");
		sql.append(newStu.getName()).append("'").append(", age = ");
		sql.append(newStu.getAge()).append(" WHERE id = ").append(newStu.getId());
		Connection conn = null;
		Statement st = null;
		try {
			//����ע������
			//��ȡ���Ӷ���
			conn = JdbcUtil.getConn();
			//��ȡ������
			st = conn.createStatement();
			//ִ��sql���
			st.executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			JdbcUtil.close(conn, st, null);
		}
	}

	public Student get(Long id) {
		String sql = "SELECT * FROM s_student WHERE id = " + id;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//����ע������
			//��ȡ���Ӷ���
			conn = JdbcUtil.getConn();
			// ��ȡ������
			st = conn.createStatement();
			// ִ��SQL���
			rs = st.executeQuery(sql);
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
			JdbcUtil.close(conn, st, rs);
		}
		return null;
	}

	public List<Student> list() {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM s_student";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//����ע������
			//��ȡ���Ӷ���
			conn = JdbcUtil.getConn();
			//��ȡ������
			st = conn.createStatement();
			//ִ��sql���
			rs = st.executeQuery(sql);
			//��ѯ����
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
			JdbcUtil.close(conn, st, rs);
		}
		return list;
	}
}
