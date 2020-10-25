package AOP;

import java.io.InputStream;

import org.junit.Test;

public class AOPTest {

	@Test
	public void test() {
		// 读取配置文件
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("AOP/conf.properties");
		// 创建Bean的工厂对象
		BeanFactory bean = new BeanFactory(in);
		// 获取代理对象
		ProxyFactory proxyFactory = (ProxyFactory)bean.getBean("bean");
		IManger proxy = (IManger)proxyFactory.getProxy();
		proxy.add("hahahha");
	}
}
