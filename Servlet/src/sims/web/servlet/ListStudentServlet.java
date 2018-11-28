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

@WebServlet("/list")
public class ListStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	//初始化对象
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接受请求参数,并封装成对象
		//2.调用业务方法处理请求
		List<Student> list = dao.list();
		//3.控制页面跳转
		//3.1共享数据  
		req.setAttribute("students", list);
		//3.2跳转,  ------共享请求中的数据只能使用请求转发
		req.getRequestDispatcher("/students_list.jsp").forward(req, resp);
	}
}
