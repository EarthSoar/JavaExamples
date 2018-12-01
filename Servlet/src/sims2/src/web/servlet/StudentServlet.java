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

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentDAO dao; 
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	
	//分发操作
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmd = req.getParameter("cmd");
		if("save".equals(cmd)) {
			this.save(req, resp);
		}else if("edit".equals(cmd)){
			this.edit(req, resp);
		}else if("delete".equals(cmd)) {
			this.delete(req, resp);
		}else {
			this.list(req, resp);
		}
	}
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接受请求参数,并封装成对象
		//2.调用业务方法
		List<Student> list = dao.list();
		//3.控制页面跳转
		req.setAttribute("students", list);
		req.getRequestDispatcher("/WEB-INF/students_list.jsp").forward(req, resp);
	}
	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		
		String name = req.getParameter("name");
		Integer age = Integer.valueOf(req.getParameter("age"));
		String sid = req.getParameter("id");
		
		if(hasLength(sid)) {
			Long id = Long.valueOf(sid);
			dao.update(new Student(id, name, age));
		} else {
			dao.save(new Student(name, age));
		}
		resp.sendRedirect(req.getContextPath()+"/student");
	}
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求参数,封装成对象
		//调用业务方法
		String sid = req.getParameter("id");
		if(hasLength(sid)) {
			Long id = Long.valueOf(sid);
			Student stu = dao.get(id);
			req.setAttribute("stu",stu);
		}
		//控制页面跳转
		req.getRequestDispatcher("/WEB-INF/students_save.jsp").forward(req, resp);
	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求参数
		String parameter = req.getParameter("id");
		Long id = Long.valueOf(parameter);
		//调用业务方法
		dao.delete(id);
		//控制页面跳转
		resp.sendRedirect(req.getContextPath()+"/student");
	}
	private boolean hasLength(String str) {
		return str!= null && !"".equals(str.trim());
	}
}
