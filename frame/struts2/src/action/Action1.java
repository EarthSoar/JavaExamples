package action;

//方式一:使用公共的POJO类作为Action. 提供公共的无参数的Action方法.(不推荐)
public class Action1 {
	public String execute() {
		System.out.println("Hello");
		return "success";
	}
}
