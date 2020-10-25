package Preoky;

import org.junit.Test;

public class testDemo {
	@Test
	 public void test() {
		CreateProxy createProxy = new CreateProxy();
		Person person = new Person();
		
		Person proxy = (Person)createProxy.CreateProxy(person);
		proxy.shopping();
	}
}
