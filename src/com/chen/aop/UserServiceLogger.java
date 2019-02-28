package com.chen.aop;
import java.util.Arrays;
//import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
/**
 * 使用注解定义切面
 */
@Aspect
public class UserServiceLogger {
//	private static final Logger log = Logger.getLogger(UserServiceLogger.class);
	@Pointcut("execution(* com.chen.service.UserService.*(..))")
	public void pointcut() {}

	@Before("pointcut()")
	public void before(JoinPoint jp) {
//		log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
//				+ " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
		System.out.println("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
				+ " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
	}

	@AfterReturning(pointcut = "pointcut()", returning = "returnValue")
	public void afterReturning(JoinPoint jp, Object returnValue) {
//		log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
//				+ " 方法。方法返回值：" + returnValue);
		System.out.println("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
				+ " 方法。方法返回值：" + returnValue);
	}
}