package Enum;

import java.util.EnumMap;
import java.util.EnumSet;

import org.junit.Test;

public class EnumDemo {
	
	/**
	 *	枚举独立运行 消耗的内存空间会大一些 可根据需求使用枚举还是常量 
	 *   Android开发对内存会更敏感  javaEE开发无伤大雅
	 */
	
	// 作用：只能在枚举的范围内选择该范围内的值
	public static final int RED = 0x0;
	public static final int BLUE = 0x2;
	public static final int GREEN = 0x3;
	public int color;
	
	@Test
	public void test01() {
		color = RED;
		color = BLUE;
		color = GREEN;
		color = 4;
	}
	
	public Color colorEnum;
	
	@Test
	public void test02() {
		colorEnum = Color.RED;
		colorEnum = Color.BLUE;
		colorEnum = Color.GREEN;
		System.out.println(colorEnum.name());
		System.out.println(colorEnum.ordinal());	// 序号 编号
		System.out.println(colorEnum.toString());
		
		Color[] values = Color.values();
		for(Color col:values) {
			System.out.println(col);
		}
		
	}
	
	@Test
	public void test3() {
		EnumSet<Color> set = EnumSet.allOf(Color.class);
		set.forEach(System.out::println);
		
		EnumMap<Color, String> map = new EnumMap<>(Color.class);
		map.put(Color.BLUE, "blue");
		map.forEach((k, v)->System.out.println(k + "->" + v));
		
	}
	
	@Test
	public void test04() {
		System.out.println(Color.RED.getColor());
		System.out.println(Color.RED.getColor2());
	}
	
	// 使用枚举实现单例设计模式
	@Test
	public void test5() {
		Singleton.Singleton.method();
	}
}
