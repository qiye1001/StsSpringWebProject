package Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Collection接口：用于存储单个对象的集合
 * List接口：
 * 1、有序的， 元素可重复
 * 2、允许多个null元素
 * 3、具体的实现有常用的：ArrayList, Vector， LinkedList
 * 	在实际开发中，我们如何选择list的具体实现？
 * 1、线程安全问题
 * 2、是有频繁的插入，删除操作（LinkedList）
 * 3、是否是存储后遍历
 * 
 */

public class ListDemo {
	
	/**
	 * LinkedList
	 * 1、实现原理，采用双向链表结果实现
	 * 2、适合插入，删除操作，性能高
	 */
	public static void LinkList() {
		
		LinkedList<String> linkedList = new LinkedList<>();
		
		linkedList.add("会按会");
		linkedList.add("几条");
		
		int size = linkedList.size();
		for(int i = 0; i < size; ++i) {
			System.out.println(linkedList.get(i));
		}
	}
	
	/**
	 * ArrayList
	 * 1、实现原理，采用动态对象数组实现，默认默认构造方法创建一个空数组
	 * 2、第一次添加元素时， 扩充容量为10，之后的扩充算法： 原来的大小+原来大小的一半
	 * 3、为防止数组动态扩充次数过多，建议在创建ArrayList时，给定初始容量
	 * 4、多线程中使用线程不安全，适合在单线程访问时使用， 效率较高
	 * 5、不适合进行删除和插入操作
	 */
	public static void arrayLinkList(){
		List<String> list = new ArrayList<>();
		
		list.add("会按会");
		list.add("几条");
		
		int size = list.size();
		for(int i = 0; i < size; ++i) {
			System.out.println(list.get(i));
		}
	}
	
	/**
	 * Vector
	 * 1、实现原理：采用动态数组实现， 默认构造方法创建了一个大小为10的对象数组
	 * 2、扩充算法：当增量 <=0 时， 扩充为原来大小的两倍， 当增量>0时， 原来的大小+增量
	 * 3、不适合删除和插入操作
	 * 4、为防止动态数组扩充次数过多，建议创建Vector创建时，给定初始容量
	 * 5、线程安全，适合在多线程访问时使用， 效率较低
	 */
	public static void vector() {
		Vector<String> vector = new Vector<>();
		vector.add("会按会");
		vector.add("几条");
		
		int size = vector.size();
		for(int i = 0; i < size; ++i) {
			System.out.println(vector.get(i));
		}
	}
	
	public static void main(String[] args) {
		
		
 	}
}
