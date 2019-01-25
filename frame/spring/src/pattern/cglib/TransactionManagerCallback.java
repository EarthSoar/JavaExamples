package pattern.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;

import pattern.TransactionManager;

public class TransactionManagerCallback implements org.springframework.cglib.proxy.InvocationHandler{

	private Object target;//真实对象,被代理的对象
	private TransactionManager txManager;
	
	
	public Object getProxy() {
		Enhancer enhancer = new  Enhancer();//创建一个增强对象
		enhancer.setSuperclass(target.getClass());//需要增强的类
		enhancer.setCallback(this);//需要做的增强
		return enhancer.create();//返回代理对象
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		txManager.begin();
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
