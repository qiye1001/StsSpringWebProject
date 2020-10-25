package Singtecon;

import java.io.Serializable;

public class Singleton implements Serializable{
	/**
	 * 	单例模式
	 *  1、多线程访问的安全问题
	 *  2、volatile关键字保证变量的一致性
	 *  3、防止反射调用私有构造方法
	 *  4、让单例类可以被序列化
	 */
	
	/**
	 * volatile:
	 * vloatile关键字提醒编译器后面的变量可能改变，因此编译器在存储或读取这个变量时，
	 * 	都会直接从这个变量的地址读取数据， 如果没有volatile关键字，编译器可能会优化读取和存储，
	 * 	可能暂时使用寄存器中的值，如果这个变量在别的地方更新了，将会出现不一致的现象-
	 */
	
	private volatile static Singleton singleton = null;
	
	private Singleton() {
		if(singleton != null) {
			throw new RuntimeException("此对象为单例模式，已经被实例化了");
		}
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			synchronized (Singleton.class) {
				if(singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
