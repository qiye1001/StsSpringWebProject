package AOP;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {
	
	private Properties prop = new Properties();
	
	public BeanFactory(InputStream in) {
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String name) {
		String className = prop.getProperty(name);
		
		Object bean = null;
		
		try {
			Class<?> aClass = Class.forName(className);
			Object target = Class.forName(prop.getProperty(name+".target")).newInstance();
			Object advice = Class.forName(prop.getProperty(name+".advice")).newInstance();
			bean = aClass.newInstance();
			
			BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			
			for(PropertyDescriptor pro: propertyDescriptors) {
				Method writeMethod = pro.getWriteMethod();
				String propertyName = pro.getName();
				if("target".equals(propertyName)) {
					writeMethod.invoke(bean, target);
				} else if("advice".equals(propertyName)) {
					writeMethod.invoke(bean, advice);
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		
		return bean;
	}
}
