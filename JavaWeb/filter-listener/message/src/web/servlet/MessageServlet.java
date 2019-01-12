package web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMessageDAO;
import dao.impl.MessageDAOImpl;
import daomain.Message;
import util.CommUtil;

@WebServlet("/msg")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMessageDAO dao = new MessageDAOImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if (CommUtil.hasLength(cmd)) {
			if ("save".equals(cmd)) {
				// 这里获取的请求对象是经过Filter包装过的对象
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				Message msg = new Message();
				msg.setSn(UUID.randomUUID().toString());
				msg.setTitle(title);
				msg.setContent(content);
				dao.add(msg);
			}
		}
		List<Message> list = dao.getAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}
}
