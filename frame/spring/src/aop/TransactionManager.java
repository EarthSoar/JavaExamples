package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//模拟事务管理器
@Component
@Aspect() // <!-- what： 做什么增强 -->
public class TransactionManager {
	// <aop:pointcut expression="execution(* aop.service.*Service.*(..) )"
	// id="txPointcut"/>
	//where： 在什么地方增强
	@Pointcut("execution(* aop.service.*Service.*(..) )")
	public void txPointcut() {
	}

	//@Before("txPointcut()")
	//前置增强
	public void begin() {
		System.out.println("开启事务");
	}

	//@AfterReturning("txPointcut()")
	//后置增强
	public void commit() {
		System.out.println("提交事务");
	}

	//异常增强
	@AfterThrowing(value="txPointcut()",throwing="e")
	public void rollback(Throwable e) {
		System.out.println("回滚事务" + e.getMessage());
	}

	//@After("txPointcut()")
	//最终增强
	public void close() {
		System.out.println("释放资源");
	}

	//环绕增强
	@Around("txPointcut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		System.out.println("开启事务");
		Object obj = null;
		try {
			// System.out.println(pjp.getSignature());//返回目标方法
			// System.out.println(Arrays.toString(pjp.getArgs()));//目标方法的参数
			// System.out.println(pjp.getTarget());//被增强的目标对象
			obj = pjp.proceed();// 调用执行方法
			System.out.println("提交事务");
		} catch (Throwable e) {
			System.out.println("回滚事务" + e.getMessage());
		} finally {
			System.out.println("释放资源");
		}
		return obj;
	}
}
