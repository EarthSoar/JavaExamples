package valueStack;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

//获取valueStack对象
public class getValueStackAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String str;
	//给属性提供一个getter方法可以在jsp中获取(荐)
	public String getStr() {
		return str;
	}
	@Override
	public String execute() throws Exception {
		//通过请求中的属性获取值栈对象
		ValueStack vs1 = (ValueStack) ServletActionContext.getRequest().getAttribute("struts.valueStack");
		//直接用ActionCont获取值栈对象
		ValueStack vs = ActionContext.getContext().getValueStack();
		System.out.println(vs1 == vs);//true  每次请求都是一次新的值栈对象，两种方法肯定获取的是同一个对象
		str = "哈哈";
		//值栈的root区域  ,把值压入了action的上面
		ActionContext.getContext().getValueStack().getRoot().push("你好");;
		
		//值栈的context区域,向请求中共享数据
		ActionContext.getContext().getValueStack().getContext().put("name", "小明");
		ActionContext.getContext().put("password", "吃了吗");
		//context区域,向session中共享数据
		ActionContext.getContext().getSession().put("hobby", "giao");
		return SUCCESS;
	}
}
