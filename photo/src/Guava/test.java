package Guava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

public class test {
	
	/**
	 * 双键Map  Table（rowKey， columnKey， value）
	 */
	@Test
	public void testGuava10() {
		Table<String, String, Integer> table = HashBasedTable.create();
		table.put("小明", "男", 14);
		table.put("Marry", "女", 19);
		table.put("花花", "男", 17);
		table.put("Tom", "女", 15);
		
		Set<Cell<String, String, Integer>> set = table.cellSet();
		for(Cell<String, String, Integer> s : set) {
			System.out.println(s.getRowKey() + "->" + s.getColumnKey() + "->" + s.getValue());
		}
	}
	
	/**
	 * BiMap 双向Map（ 键和值不重复）
	 */
	@Test
	public void testGuava9() {
		BiMap<String, String> bimap = HashBiMap.create();
		bimap.put("小明", "18124324241");
		bimap.put("葛根", "15945646416");
		bimap.put("Marry", "18315646546");
		bimap.put("Marry", "18741132464");
		bimap.put("Tom", "15941564165");
		String name = bimap.inverse().get("18315646546");		// 键值反转
		System.out.println(name);
		System.out.println(bimap.get("Marry"));
	}
	
	/**
	 * MutliMap: 可重复
	 */
	@Test
	public void testGuava8() {
		Map<String, String> map = new HashMap<>();
		map.put("java从入门到精通", "Value");
		map.put("Android从入门到精通", "Mini");
		map.put("HTML从入门到精通", "Value");
		map.put("数据结构与算法", "Marry");
		map.put("人间失格", "Marry");
		map.put("人间失格", "Marry");
		Multimap<String, String> mmap = ArrayListMultimap.create();
		
		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			mmap.put(entry.getValue(), entry.getKey());
		}
		
		Set<String> keySet = mmap.keySet();
		for(String key : keySet) {
			Collection<String> value = mmap.get(key);
			System.out.println(key + "->" + value);
		}
	}
	
	/**
	 * Mutliset:  无序可重复
	 */
	@Test
	public void testGuava7() {
		String str = "good good study day day up";
		String[] ss = str.split(" ");
		HashMultiset<String> set = HashMultiset.create();
		for(String s : ss) {
			set.add(s);
		}
		Set<String> set2 = set.elementSet();
		for(String s : set2) {
			System.out.println(s + ":" + set.count(s));
		}
	}
	
	/**
	 * 	集合操作：交集、差集、并集
	 */
	@Test
	public void testGuava6() {
		Set<String> set1 = Sets.newHashSet("gga", "gsa", "gsw");
		Set<String> set2 = Sets.newHashSet("gga", "gea", "gwa");
		SetView<String> v1 = Sets.intersection(set1, set2);	// 交集
		v1.forEach(System.out::println);
		System.out.println("------------");
		SetView<String> v2 = Sets.difference(set1, set2);	// 差集 set1 为主
		v2.forEach(System.out::println);
		System.out.println("-------------");
		SetView<String> v3 = Sets.union(set1, set2);
		v3.forEach(System.out::println);
		
	}
	
	/**
	 *	 加入约束： 非空、长度验证
	 */
	@Test
	public void testGuava5() {
		Set<String> set = Sets.newHashSet();
		
//		Preconditions.checkArgument(expression);
//		Preconditions.checkNotNull(reference);
	}
	/**
	 * 组合式函数
	 */
	@Test
	public void testGuava4() {
		List<String> list = Lists.newArrayList("gsawehgse", "gesgag", "gsagg", "gsegesa");
		
		Function<String, String> f1 = new Function<String, String>() {

			@Override
			public String apply(String arg0) {
				return arg0.length() > 4 ? arg0.substring(0, 4) : arg0;
			}
		};
		
		Function<String, String> f2 = new Function<String, String>(){

			@Override
			public String apply(String arg0) {
				return arg0.toUpperCase();
			}
		};
		
		Function<String, String> f = Functions.compose(f1, f2);
		Collection<String> result = Collections2.transform(list, f);
		result.forEach(System.out::println);
	}
	/**
	 * 	转换
	 */
	@Test
	public void testGuava3() {
		Set<Long> timeSet = Sets.newHashSet(20120901L, 20120718L, 20150321L);	// 时间问题
		Collection<String> time = Collections2.transform(timeSet, (t) -> new SimpleDateFormat("yyyy-mm-dd").format(t));
		time.forEach(System.out::println);
	}
	
	/**
	 * 过滤器
	 */
	@Test
	public void testGuava2() {
		List<String> list = Lists.newArrayList("gsehgse", "gesg", "gsg", "gsegesa");
		Collection result =  Collections2.filter(list, (e) -> e.startsWith("g"));
		result.forEach(System.out::println);
	}
	
	/**
	 * 	设置只读
	 */
	@Test
	public void testGuava1() {
		System.out.println("test guava");
		
//		List<String> list = Arrays.asList("faga", "gsaga", "gsegs");
//		list.add("gaes");
		
		List<String> list = new ArrayList<>();
		list.add("gsag");
		list.add("gsaga");
		list.add("hsh");
		list.add("hahx");
		list.add("jssdg");
//		List<String> readList = Collections.unmodifiableList(list);
		Set<String> set = Sets.newHashSet("gsawehgse", "gesgag", "gsagg", "gsegesa");
//		readList.add("gseghs");
		ImmutableSet<List<String>> ISet = ImmutableSet.of(set.stream().collect(Collectors.toMap( e -> e, e -> 1, (k1, k2) -> k1 + k2)).entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.toList()));
		ImmutableList<String> IList= ImmutableList.of("gag", "hsh", "hshs");
//		IList.add("gasg");
		IList.forEach(System.out::println);
		ISet.forEach((str) -> System.out.println(str));
//		ISet.add("fgag");
		
	}
}
