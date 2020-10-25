package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class ChangeDemo {

	private static void write(OutputStream out) {
		Writer write = new OutputStreamWriter(out, Charset.defaultCharset());
		
		try {
			write.write("seghhsehgges\r\n");
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void read(InputStream in) {
		Reader read = new InputStreamReader(in, Charset.defaultCharset()); // 默认编码方式
		char[] cs = new char[1024];
		int len = -1;
		try {
			while ((len = read.read(cs)) != -1) {
				System.out.println(new String(cs));
			}
			read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		OutputStream out = new FileOutputStream("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt", true);
		write(out);
		InputStream in = new FileInputStream("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
		read(in);
	}
}
