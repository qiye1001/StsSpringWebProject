package introspector;

import org.junit.Test;

public class IntrospectorDemo {
	@Test
	public void test() {
		Config bean = (Config)BeanFactory.getBean("Bean.name");
		System.out.println(bean);
	}
}
