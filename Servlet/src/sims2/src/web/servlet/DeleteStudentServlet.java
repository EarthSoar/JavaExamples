package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao.IStudentDAO;
import dao.dao.impl.StudentDAOImpl;

@WebServlet("/student/delete")
public class DeleteStudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求参数
		String parameter = req.getParameter("id");
		Long id = Long.valueOf(parameter);
		//调用业务方法
		dao.delete(id);
		//控制页面跳转
		resp.sendRedirect("/student/list");
	}
}
