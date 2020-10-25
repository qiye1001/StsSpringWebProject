package I18N;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18Ndemo {
	public static void main(String[] args) {
		// properties文件：属性文件（配置文件），内容以键值对的形式存放（key-value）只读文件
		// ResourceBundle工具类，来绑定属性文件，并指定Locale对象
		
		// 创建一个本地语言环境对象,该对象会根据参数设置来自动选择与之相关的语言环境
		// 参数: 语言, 地区
		Locale locale_CN = new Locale("zh", "CN");
		Locale locale_US = new Locale("en", "US");
		
		// 获取当前系统默认的语言环境
		Locale locale_default = Locale.getDefault();
		
		// 用于绑定属性文件的工具类(参数:属性文件的基本名(就是前缀,比如,info))
		// 强制使用英文环境 :
//		ResourceBundle r = ResourceBundle.getBundle("I18N.info", locale_US);	
		
		ResourceBundle r = ResourceBundle.getBundle("I18N.info");
		
		String welcome = r.getString("welcome");
		welcome = MessageFormat.format(welcome, "bin");
		
		System.out.println(r.getString("system.name"));
		System.out.println(r.getString("login.success"));
		System.out.println(welcome);
	}
}
