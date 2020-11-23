package com.qiye.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfter implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("后置通知 返回值："+arg0+", 调用的方法名："+arg1.getName()+", 方法的参数个数: "+arg2.length+", 目标对象："+arg3);
	}
}
