package Collection;

import java.awt.datatransfer.FlavorMap;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("gog", "fa", "fafga", "fagaw", "fagaw");
//		stream.forEach(System.out::println);
		
		// filter ¹ýÂË
//		stream.filter((s) -> s.length() > 3).forEach(System.out::println);
		
		// distinct È¥ÖØ
//		stream.distinct().forEach(System.out::println);

		// map
//		stream.map((str) -> str.toUpperCase()).forEach(System.out::println);
		
		// flatMap
		Stream<List<Integer>> ss = Stream.of(Arrays.asList(1, 9, 3, 9), Arrays.asList(5, 6, 5));
		ss.flatMap(list -> list.stream()).forEach(System.out::println);
		
//		Optional<String> opt = stream.reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
//		System.out.println(opt.get());
//		
//		List<String> list = stream.collect(Collectors.toList());
//		list.forEach(System.out::println);
	}
}
