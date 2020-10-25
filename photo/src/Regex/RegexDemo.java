package Regex;

import org.junit.Test;

public class RegexDemo {
	
	@Test
	public void test() {
		String phoneNumber = "010-38389438";
		boolean b = phoneNumber.matches("\\d{3,4}-\\d{7,8}");  // \d(数字)  3~4位     -(原意)    \d(数字) 7~8位			
		System.out.println(b);
		
		// 匹配手机号码
		String phone = "13812345674";
		System.out.println(phone.matches("[1][3-9]\\d{9}"));
		
		// 用户名： 字母开头，数字字母下划线组合
		String username = "abc123";
		System.out.println(username.matches("[a-zA-Z]+[\\w|_]*"));	//[a-zA-Z]字母开头    +(出现一次或多次)  \w(单词字符 0-9) |(或)  *(0次或多次)
		
		// 匹配IP地址
		String IP = "20.10.20.123";
		System.out.println(IP.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));
		
		// 匹配网址
		String address = "http://www.baidu.com";
		System.out.println(address.matches("http://\\w+.\\w.\\S*"));
		
		// 匹配年龄
		String age = "18";
		System.out.println(age.matches("\\d{1,3}"));
		
		// 匹配金额
		String price = "19.8";
		System.out.println(price.matches("\\d+.\\d*"));
	}
}
