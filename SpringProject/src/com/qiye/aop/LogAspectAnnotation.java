package com.qiye.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("logAnnocation")
@Aspect	// 表明此类是一个通知
public class LogAspectAnnotation {
	
	// 前置通知
	@Before("execution(public * addStudent(com.qiye.entry.Student))") // 只要是方法为addStudent 参数类型为String 返回值为任意类型的条件就会触发通知
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("<<注解形式>> 前置通知 目标对象"+joinPoint.getTarget()+", 调用的方法："+joinPoint.getSignature().getName()+", 参数列表："+Arrays.toString(joinPoint.getArgs()));
	}
	
	// 后置通知
	@AfterReturning(returning = "returningValue", pointcut = "execution(public void com.qiye.service.impl.StudentServiceImpl.addStudent(com.qiye.entry.Student))") // 指定了StudentServiceImpl的addStudent方法
	public void myAfter(JoinPoint joinPoint, Object returningValue) {
		System.out.println("<<注解形式>> 后置通知 返回值："+returningValue+" 目标对象"+joinPoint.getTarget()+", 调用的方法："+joinPoint.getSignature().getName()+", 参数列表："+Arrays.toString(joinPoint.getArgs()));

	}
	
	// 异常通知
	@AfterThrowing(pointcut = "execution(public * addStudent(..))",throwing = "e")
	public void myException(JoinPoint jp, NullPointerException e) {	// 指定异常类型(空指针异常) 才能触发通知
		System.out.println("<<注解形式>> 异常通知 ");
	}
	
	// 环绕通知
	@Around("execution(public * addStudent(com.qiye.entry.Student))")
	public Object myAround(ProceedingJoinPoint jp) {
		Object result = null;
		try {
			System.out.println("<<注解形式>> 环绕通知 实现 前置通知");
			result = jp.proceed();
			System.out.println("<<注解形式>> 环绕通知 实现 后置通知");
		} catch (Throwable e) {
			System.out.println("<<注解形式>> 环绕通知 实现 异常通知");
		} finally {
			System.out.println("<<注解形式>> 环绕通知 实现 最终通知");
		}
		return "abc";
	}
	
	// 最终通知
	@After("execution(public * addStudent(com.qiye.entry.Student))")
	public void myFinally() {
		System.out.println("<<注解形式>> 最终通知");
	}
}
