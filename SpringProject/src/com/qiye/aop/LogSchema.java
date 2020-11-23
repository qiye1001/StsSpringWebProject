package com.qiye.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogSchema {

	// 前置通知
	public void before(JoinPoint jp) {
		System.out.println("》》》》前置通知");
	}
	
	// 后置通知
	public void after(JoinPoint jp, Object returningValue) {
		System.out.println("》》》》后置通知");
	}
	
	// 异常通知
	public void wenException(JoinPoint jp, NullPointerException e) {
		System.out.println("》》》》 异常通知");
	}
	
	// 环绕通知
	public Object around(ProceedingJoinPoint jp) {
		Object result = null;
		try {
			System.out.println("》》》》 环绕通知实现的前置通知");
			result = jp.proceed();
			System.out.println("》》》》 环绕通知实现的后置通知");
		} catch (Throwable e) {
			System.out.println("》》》》 环绕通知实现的异常通知");
		}  finally {
			System.out.println("》》》》 环绕通知实现的最终通知");
		}
		return result;
	}
}
