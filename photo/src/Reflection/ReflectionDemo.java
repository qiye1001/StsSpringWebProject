package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import org.junit.Test;

public class ReflectionDemo {
	
	@Test
	public void test5() {
		Class dogClass = Dog.class;
		// 获取包名
		Package Package = dogClass.getPackage();
		
		// 获取公共方法 包括继承的方法
		Method[] methods =  dogClass.getMethods();
		Dog dog = new Dog();
		for(int i = 0; i < methods.length; ++i) {
//			System.out.println(methods[i]);
			if(methods[i].getName().equals("toString")) {
				try {
					String s = (String)methods[i].invoke(dog);
					System.out.println(s);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 访问私有的方法 获取本类中的所有方法
		Method[] declaredMethods =  dogClass.getDeclaredMethods();
		
		
		for(int i = 0; i < declaredMethods.length; ++i) {
			if("set".equals(declaredMethods[i].getName())) {
				try {
					// 设置私有方法可以被访问（去除访问修饰符的检查）
					declaredMethods[i].setAccessible(true);
					String s = (String)declaredMethods[i].invoke(dog, "Marry");
					System.out.println(s);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	// 获取所有属性
	@Test
	public void test4() {
		Class dog = Dog.class;
		// 获取非私有属性
		Field[] fields = dog.getFields();
//		System.out.println(fields.length);
		
		// 获取所有属性 包括私有属性
		Field[] declaredField = dog.getDeclaredFields();
//		System.out.println(declaredField.length);
		for(int i = 0; i < declaredField.length; ++i) {
			int modifiers = declaredField[i].getModifiers();
			System.out.println(Modifier.toString(modifiers) + " " + declaredField[i].getType() + " " + declaredField[i].getName());
		}
	}
	
	// 获取所有的构造方法
	@Test
	public void test3() {
		Class<Dog> dog = Dog.class;
		
		Constructor<?>[] constructors = dog.getConstructors();
		for(int i = 0; i < constructors.length; ++i) {
			// 构造方法的参数名
			System.out.println(constructors[i].getName());
			// 构造方法的参数个数
			System.out.println(constructors[i].getParameterCount());
		}
		
		try {
			// 获取一个指定的构造方法
			Constructor<Dog> contructor = dog.getConstructor(String.class, int.class, String.class);
			Dog newInstance = contructor.newInstance("小白", 5, "白色");
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	通过反射来获取实例化对象
	 */
	@Test
	public void test2() {
		Class<Dog> dog = Dog.class;
		try {
			// 通过class对象来实例化对象， 调用了默认无参构造方法
			Dog dog1 = dog.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	 获取class类对象的三种方式
	 */
	@Test
	public void test1() {
		Dog dog = new Dog();
		Class class1 = dog.getClass();

		Class dog2 = Dog.class;
		try {
			Class.forName("Reflection.Reflection");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
