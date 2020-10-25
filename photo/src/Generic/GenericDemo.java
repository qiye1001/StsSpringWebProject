package Generic;

import org.junit.Test;

public class GenericDemo {
	
	@Test
	public void test01() {
		Node<Integer> integerNode = new Node<>(12);
		System.out.println(integerNode.getDate());
	}
	
	public void getDate1(Node<Integer> date) {
		System.out.println(date.getDate());
	}
	
	public void getDate2(Node<?> date) {
		System.out.println(date.getDate());
	}
}
