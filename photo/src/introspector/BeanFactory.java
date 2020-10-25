package introspector;

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
	private static Properties properties = new Properties();
	
	// 使用静态代码块读取配置文件
	static {
		InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("introspector/conf.properties");
		
		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一个Bean
	 * 
	 */
	public static Object getBean(String name) {
		Object bean = null;
		try {
			Class<?> aClass = Class.forName(properties.getProperty(name));
			bean = aClass.newInstance();
			// 通过类信息获取JavaBean的描述信息
			BeanInfo beaninfo = Introspector.getBeanInfo(aClass);
			// 通过JavaBean描述信息获取所有属性的描述器
			PropertyDescriptor[] propertyDescriptors = beaninfo.getPropertyDescriptors();
			for(int i = 0; i < propertyDescriptors.length; ++i) {
				String username = propertyDescriptors[i].getName();
				Method writeMethod = propertyDescriptors[i].getWriteMethod();
				
				if("name".equals(username)) {
					writeMethod.invoke(bean, properties.getProperty("Bean.userName"));
				} else if ("password".equals(username)) {
					writeMethod.invoke(bean, properties.getProperty("Bean.password"));
				} else if ("url".equals(username)) {
					writeMethod.invoke(bean, properties.getProperty("Bean.url"));
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
