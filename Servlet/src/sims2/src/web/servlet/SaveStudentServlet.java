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

@WebServlet("/student/save")
public class SaveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		Integer age = Integer.valueOf(req.getParameter("age"));
		String sid = req.getParameter("id");
		
		if(hasLength(sid)) {
			Long id = Long.valueOf(sid);
			dao.update(new Student(id, name, age));
		} else {
			dao.save(new Student(name, age));
		}
		resp.sendRedirect("/student/list");
	}
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
