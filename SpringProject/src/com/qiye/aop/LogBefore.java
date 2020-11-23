package com.qiye.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// 普通类 --> 前置通知
public class LogBefore implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("前置通知  调用的方法名："+arg0.getName()+", 方法的参数个数: "+arg1.length+", 目标对象："+arg2);
		
	}
	
}
