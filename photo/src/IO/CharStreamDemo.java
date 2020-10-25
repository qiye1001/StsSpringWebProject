package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharStreamDemo {
	public static void main(String[] args) {
		out();
		in();
	}

	private static void in() {
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
		try {
			Reader in = new FileReader(file);
			char[] cs = new char[1];
			StringBuilder buf = new StringBuilder();
			int len = -1;
			while((len = in.read(cs)) != -1) {
				buf.append(cs);
			}
			System.out.println(buf);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void out() {
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
		
		try {
			Writer out = new FileWriter(file, true);
			
			out.write("HHHHH");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
