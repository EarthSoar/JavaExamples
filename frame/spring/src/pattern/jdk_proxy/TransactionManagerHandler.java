package pattern.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import pattern.TransactionManager;

public class TransactionManagerHandler implements InvocationHandler{

	private Object target;//真实对象,被代理的对象
	private TransactionManager txManager;
	
	//创建一个代理对象
	public Object getProxy() {
		Object obj =  Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		return obj;
	}
	
	@Override
	//在真实对象上进行增强操作
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//System.out.println(method);//这里执行的方法为接口中定义的方法
		txManager.begin();//开启事务
		Object ret = null;
		try {
			ret = method.invoke(target, args);
			txManager.commit();
		} catch (Exception e) {
			txManager.rollback();
		}
		return ret;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setTxManager(TransactionManager txManager) {
		this.txManager = txManager;
	}

}
