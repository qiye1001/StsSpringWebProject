package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * set接口
 * 1、无序的（不保证顺序）
 * 2、不允许重复元素
 * HashSet、TreeSet、LinkedHashSet
 * 
 * 	如果要排序，选择TreeSet
 * 	如果不要排序，也不要保证顺序，选择hashSet
 * 	不要排序，要保证顺序，选择LinkedHashSet
 */

public class setDemo {
	
	public static void linkedHashSet() {
		LinkedHashSet<Cat> linkedHashSet = new LinkedHashSet<>();
		Cat cat1 = new Cat("花花", 2, 3);
		Cat cat2 = new Cat("环境", 1, 1);
		Cat cat3 = new Cat("润肺啥", 4, 3);
		Cat cat4 = new Cat("润肺啥", 4, 3);
		
		linkedHashSet.add(cat1);
		linkedHashSet.add(cat2);
		linkedHashSet.add(cat3);
		linkedHashSet.add(cat4);
		
		for(Cat c : linkedHashSet) {
			System.out.println(c);
		}
	}
	
	/** TreeSet
	 * 	有序的， 基于TreeMap(二叉树数据结构)，对象需要比较大小，通过对象比较器实现
	 *	对象比较器还可以去除重复元素，如果自定义的数据类，没有实现比较器接口，将无法添加到TreeSet集合中
	 */
	public static void treeSet() {
		TreeSet<Cat> tree = new TreeSet<>((o1, o2) -> o1.getId() - o2.getId());
		Cat cat1 = new Cat("花花", 2, 3);
		Cat cat2 = new Cat("环境", 1, 1);
		Cat cat3 = new Cat("润肺啥", 4, 3);
		Cat cat4 = new Cat("润肺啥", 4, 3);
		
		tree.add(cat1);
		tree.add(cat2);
		tree.add(cat3);
		tree.add(cat4);
		
		for(Cat c : tree) {
			System.out.println(c);
		}
	}
	
	/**
	 * hashSet
	 * 1、实现原理，基于哈希表（hashMap）实现
	 * 2、不允许重复，可以有一个null元素
	 * 3、保证顺序恒久不变
	 * 4、添加元素时，把元素作为haspMap的key值， hashMap的value使用的是一个固定的object对象
	 * 5、排除重复元素是使用equals来检查是否相同
	 * 6、判断两个对象是否相同，先判断两个对象的hashcode是否相同，（如果两个对象的hashcode相同，两个对象不一定相等，如果不同，则一定不相等），
	 * 	如果相同，还要进行equals比较，如果相同，则是同一个对象，否则不是同一个对象
	 * 7、自定义对象要认为属性值都是同一个对象，有这种需求时，那么我们要重写hashcode和equals方法
	 * 
	 *	小结
	 *	（1）哈希表的存储结构：数组+链表， 数组里的每一个元素以链表的形式存储
	 *	（2）如何把对象存进哈希表中，先计算对象的hashcode值，在对数组的长度取余，来决定对象需要存储在数组的那个位置
	 * 	（3）解决hashcode中去重问题，参考第六点
	 * 
	 */
	public static void hashSet() {
		Set<Cat> cats = new HashSet<>();
		Cat cat1 = new Cat("花花", 2, 3);
		Cat cat2 = new Cat("环境", 1, 1);
		Cat cat3 = new Cat("润肺啥", 4, 3);
		Cat cat4 = new Cat("润肺啥", 4, 3);
		
		cats.add(cat1);
		cats.add(cat2);
		cats.add(cat3);
		cats.add(cat4);
		
 		for(Cat c : cats) {
			System.out.println(c);
		}

 		System.out.println("c1 = " + cat1.hashCode()%16);
 		System.out.println("c2 = " + cat2.hashCode()%16);
 		System.out.println("c3 = " + cat3.hashCode()%16);
 		System.out.println("c4 = " + cat4.hashCode()%16);
	}
	
	public static void main(String[] args) {
//		treeSet();
		linkedHashSet();
	}
}
