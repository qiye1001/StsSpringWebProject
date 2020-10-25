package XML;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class PersonHandler extends DefaultHandler{
	
	private List<Person> persons = null;
	private Person person;	// 解析的对象
	private String Tag;
	/**
	 * uri 命名空间
	 * localName 不带前缀的标签名
	 * qname 带前缀的标签名
	 * attribute 属性集合
	 */

	public List<Person> getPersons() {
		return persons;
	}
	
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		persons = new ArrayList<>();
		System.out.println("开始解析文档...");
	}
	
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("解析文档结束...");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if("person".equals(qName)) {
			person = new Person();
			String personid = attributes.getValue("personid");
			person.setPersonid(personid);
		} 
		Tag = qName;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if("person".equals(qName)) {
			persons.add(person);
			System.out.println(person);
		}
		Tag = null;
	}
	

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if(Tag != null) {
			if("name".equals(Tag)) {
				person.setName(new String(ch, start, length));
			} else if ("address".equals(Tag)) {
				person.setAddress(new String(ch, start, length));
			} else if ("fax".equals(Tag)) {
				person.setFax(new String(ch, start, length));
			} else if ("tel".equals(Tag)) {
				person.setTel(new String(ch, start, length));
			}
		}
	}
}
