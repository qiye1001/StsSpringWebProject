package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesDemo {
	private static String version = "";
	private static String name = "";
	private static String password = "";
	
	static {
//		readProperties();
	}
	
	private static void writeProperties(String version, String name, String password) {
		Properties p = new Properties();
		p.put("app.version", version);
		p.put("db.name", name);
		p.put("db.password", password);
		try {
			OutputStream out = new FileOutputStream("./src/res/config.properties");
			p.store(out, "update config");
			out.close();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readProperties() {
		Properties p = new Properties();
		try {
			InputStream inStream = Thread.currentThread().getContextClassLoader().
					getResourceAsStream("res/config.properties");
//			InputStream inStream = new FileInputStream("./src/res/config.properties");
			
			p.load(inStream);
			
			version = p.getProperty("app.version");
			name = p.getProperty("db.name");
			password = p.getProperty("db.password");
			inStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		writeProperties("2", "admin", "121314");
		readProperties();
		System.out.println(PropertiesDemo.version);
		System.out.println(PropertiesDemo.name);
		System.out.println(PropertiesDemo.password);
	}
}
