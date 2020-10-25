package XML;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XMLDemo {
	
	@Test
	public void test01() throws ParserConfigurationException, SAXException, IOException {
		
		// 创建一个sax解析器工厂对象
		SAXParserFactory newInstance = SAXParserFactory.newInstance();
		// 通过工厂获取sax的解析器
		SAXParser newSAXParser = newInstance.newSAXParser();
		// 创建解析处理（自己编写）
		PersonHandler personHandler = new PersonHandler();
		// 进行解析
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("XML/Person.xml");
		newSAXParser.parse(is, personHandler);
	
		List<Person> list = personHandler.getPersons();
		list.forEach(System.out::println);
		
	}
}
