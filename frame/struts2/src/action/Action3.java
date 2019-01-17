package action;

import com.opensymphony.xwork2.ActionSupport;

//方式3：继承ActionSupport
public class Action3 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		System.out.println("action3");
		return super.execute();
	}
}
