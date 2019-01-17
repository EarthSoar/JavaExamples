package action;

//方法二：实现com.opensymphony.xwork2.Action 接口 ,接口中有定义好的常量
public class Action2 implements com.opensymphony.xwork2.Action {
	@Override
	public String execute() throws Exception {
		System.out.println("action2");
		return SUCCESS;
	}
}
