package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao.IStudentDAO;
import dao.dao.impl.StudentDAOImpl;
import dao.daomain.Student;

@WebServlet("/student/edit")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求参数,封装成对象
		//调用业务方法
		String sid = req.getParameter("id");
		if(hasLength(sid)) {
			Long id = Long.valueOf(sid);
			Student stu = dao.get(id);
			req.setAttribute("stu",stu);
			req.setAttribute("id", id);
		}
		
		//控制页面跳转
		req.getRequestDispatcher("/WEB-INF/students_save.jsp").forward(req, resp);
	}
	private boolean hasLength(String str) {
		return str!= null && !"".equals(str.trim());
	}
}
