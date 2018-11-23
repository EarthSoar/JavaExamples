package calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	一个网页版的简易计算器
 */
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求和响应的编码都为utf-8
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		//接收表单中的数据
		String snum1 = req.getParameter("num1");
		String snum2= req.getParameter("num2");
		String op = req.getParameter("op");

		//结果
		String ret = "";
		//判断字符串是否为空
		if(hasLength(snum1) && hasLength(snum2)) {
			//把String类型转换位整数类型
			Integer num1 = Integer.valueOf(snum1);
			Integer num2 = Integer.valueOf(snum2);
			if("+".equals(op)) {
				ret = num1 + num2 + "";
			}else if("-".equals(op)){
				ret = num1 - num2 + "";
			}else if("*".equals(op)) {
				ret = num1*num2 + "";
			}else if("/".equals(op)){
				ret = num1/num2 + "";
			}
		}
		PrintWriter writer = resp.getWriter();
		
		writer.println("<form action='/clac' method='post'>");
		writer.println("<input type='number' name='num1' value='"+snum1+"'/>");
		writer.println("<select name='op'>");
		writer.println("<option>+</option>");
		writer.println("<option>-</option>");
		writer.println("<option>*</option>");
		writer.println("<option>/</option>");
		writer.println("</select>");
		writer.println("<input type='number' name='num2' value='"+snum2+"'/>");
		writer.println("<input type='submit' value='='/>");
		writer.println("<input type='text' value='"+ret+"' disabled='disabled'/>");
		writer.println("</form>");
	}
	public  boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}	
}
