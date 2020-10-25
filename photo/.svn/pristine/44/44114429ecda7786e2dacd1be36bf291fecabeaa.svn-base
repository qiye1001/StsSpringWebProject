package Preoky;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CreateProxy implements InvocationHandler{

	public Object target;
	
	public Object CreateProxy(Object target) {
		this.target = target;
		
		Object proxy = Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
		return proxy;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("∫£Ã‘÷–...");
		method.invoke(target, args);
		return null;
	}
	
}
