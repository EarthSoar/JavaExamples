package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao.IStudentDAO;
import dao.dao.impl.StudentDAOImpl;
import dao.daomain.Student;

@WebServlet("/student/list")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接受请求参数,并封装成对象
		//2.调用业务方法
		List<Student> list = dao.list();
		//3.控制页面跳转
		req.setAttribute("students", list);
		req.getRequestDispatcher("/WEB-INF/students_list.jsp").forward(req, resp);
	}
	
}
