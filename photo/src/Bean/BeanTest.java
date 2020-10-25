package Bean;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class BeanTest {
	
	@Test
	public void test() {
		// 从客户端获取到的数据
		String name = "Marry";
		String age = "19";
		String saraly = "20000";
		
		Emp emp = new Emp();
		
		try {
			
			BeanUtils.setProperty(emp, "name", name);
			BeanUtils.setProperty(emp, "age", age);
			BeanUtils.setProperty(emp, "saraly", saraly);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(emp.getInfo());
	}
}
