package com.qiye.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object result = null;
		try {
			
			System.out.println("用[[环绕通知]]实现的前置通知");
			
			// invocation.proceed() 之前的是前置通知
			result = invocation.proceed();	// 控制着目标方法的执行 返回值为方法的返回值
			// invocation.proceed() 之后的是后置通知
			 
			System.out.println("用[[环绕通知]]实现的后置通知  目标对象："+invocation.getThis()+", 调用的方法："+invocation.getMethod()+", 方法的参数个数："+invocation.getArguments().length+", 方法的返回值："+result);
			
		}catch(Exception e){
			// 异常通知
			System.out.println("用[[环绕通知]]实现的异常通知");
		} finally{
			// 最终通知
			System.out.println("用[[环绕通知]]实现的最终通知");
		};
		
		return result;
	}

}
