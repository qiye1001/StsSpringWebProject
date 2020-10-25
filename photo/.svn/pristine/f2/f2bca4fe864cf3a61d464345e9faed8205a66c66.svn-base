package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IteratorDemo {
	
	// 断言接口
	public static void  predicateTest() {
		List<String> list = Arrays.asList("hufa", "fhuai", "fajuio", "gjsi");
		List<String> result = filter(list, (str) -> str.contains("f"));
		result.forEach(System.out::println);
	}
	
	public static List<String> filter(List<String> list , Predicate<String> p) {
		List<String> results = new ArrayList<>();
		for(String s : list) {
			if(p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}
	
	// Supplier 代表结果的供应商
	public static void supplierTest() {
		List<Integer> list = getNum(10, () -> (int)(Math.random() * 100));
		list.forEach(System.out::println);
	}
	
	public static List<Integer> getNum(int num, Supplier<Integer> nums){
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < num; ++i) {
			list.add(nums.get());
		}
		return list;
	}
	
	// function 表示接受一个参数并返回一个结果的函数
	public static void functionTest() {
		String s = toUpp("hfaiuh agag", str -> str.toUpperCase());
		System.out.println(s);
	}
	
	public static String toUpp(String str, Function<String, String> f) {
		return f.apply(str);
	}
	
	
	public static void forEach() {
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("jack");
		list.add("job");
		list.add("lily");
		
		list.forEach(s -> System.out.println(s));
		list.forEach(System.out::println);
	}
	
	public static void forEach(Collection<Cat> c) {
		for(Cat cat : c) {
			System.out.println(cat);
		}
	}
	
	public static void enumeration() {
		Vector<String> vs = new Vector<>();
		vs.add("tom");
		vs.add("jack");
		vs.add("job");
		vs.add("lily");
		  
		Enumeration<String> es = vs.elements();
		while(es.hasMoreElements()) {
			System.out.println(es.nextElement());
		}
	}
	
	public static void iterator(Collection<Cat> c) {
		Iterator<Cat> iterator = c.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator);
		}
	}
	
	public static void main(String[] args) {
//		enumeration();
//		forEach();
//		supplierTest();
//		functionTest();
		predicateTest();
	}
}
