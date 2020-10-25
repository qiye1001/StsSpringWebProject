package Collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map接口:
 * 1、键值对存储一对数组
 * 2、Key不能重复（唯一），Value可以重复
 * 3、具体的实现类：HashMap、 TreeMap、 HashTable、 LinkHashMap
 * 
 *
 */

public class MapDemo {
	
	/**
	 * TreeMap
	 * 	基于二叉树中的红黑树实现
	 */
	public static void TreeMapTest() {
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(1, "fha");
		treeMap.put(2, "hdr");
		treeMap.put(3, "fid");
		treeMap.put(4, "heds");
		treeMap.put(5, "nrec");
		treeMap.forEach((k, v) -> System.out.println(k + "->" + v));
	}
	
	/**
	 * linkHashMap(继承hashMap) 采用由于HashMap不能保证顺序恒久不变，此类采用双向链表来维护
	 * 	元素添加的顺序
	 */
	public static void linkHashMapTest() {
		Map<Integer, String> linkHashMap = new LinkedHashMap<>();
		linkHashMap.put(1, "fha");
		linkHashMap.put(2, "hdr");
		linkHashMap.put(3, "fid");
		linkHashMap.put(4, "heds");
		linkHashMap.put(5, "nrec");
		linkHashMap.forEach((k, v) -> System.out.println(k + "->" + v));
	}
	
	/**
	 * hashTable (继承Dictionary)
	 * 	基于哈希表（数组+链表）
	 * 	默认创建大小为11的数组
	 * 	扩充算法：newCapacity = (oldCapacity << 1) + 1
	 * 	线程安全，适合在多线程中使用
	 */
	public static void hashTable() {
		Map<Integer, String> hashTable = new Hashtable<>();
		hashTable.put(1, "fha");
		hashTable.put(2, "hdr");
		hashTable.put(3, "fid");
		hashTable.put(4, "heds");
		hashTable.put(5, "nrec");
		hashTable.forEach((k, v) -> System.out.println(k + "->" + v));
	}
	
	/**
	 * hashMap实现原理（继承AbstractMap）
	 * 1、数组+链表  	jdk1.8之后（数组 + 链表 + 二叉树（红黑树））
	 * 2、默认加载因子0.75，默认数组大小16
	 * 3、对象存储到哈希表中，如何存储？
	 * 	把key对象通过hash()计算出hash值（key.hashcode() ^ key >>> 16），将计算出的hash值对数组的长度进行取余
	 * 	默认长度为16（hash & （table.length-1）） 决定该key对象存储在数组的位置，当该位置有多个对象时，以链表的形式存储
	 *  jdk1.8之后，链表长度大于8时，链表会转换为红黑树结构存储	
	 * 4、扩充原理：当数组的容量超过75%，那么给数组需要重新扩充
	 * 	    扩充算法：当前数组大小 << 1 (扩充一倍)，当扩充次数过多，会影响性能，每次扩充会重新散列（重新计算每个对象的存储位置）
	 * 5、线程不安全，适合在单线程中使用
	 */
	public static void hashMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "fha");
		map.put(2, "hdr");
		map.put(3, "fid");
		map.put(4, "heds");
		map.put(5, "nrec");
		
		Set<Entry<Integer, String>> entry = map.entrySet();
		for(Entry<Integer, String> e : entry) {
			System.out.println(e.getKey() +"->"+ e.getValue());
		}
		
		System.out.println("----------------");
		
		Set<Integer> key = map.keySet();
		for(Integer i : key) {
			String value = map.get(i);
			System.out.println(i + "->" + value);
		}
		
		System.out.println("----------------");
		
		Collection<String> c = map.values();
		for(String str : c) {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		hashMap();
//		hashTable();
	}
}
