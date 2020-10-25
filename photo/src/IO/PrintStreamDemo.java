package IO;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class PrintStreamDemo {
	
	private static void bytePrint() {
		try {
			File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			PrintStream ps = new PrintStream(bos);
			ps.print("hello");
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void charPrint() {
		try {
			File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
			Writer write = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(write);
			PrintWriter pw = new PrintWriter(bw);
			pw.println("joiajoajioa");
			pw.flush();
			
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
//		bytePrint();
		charPrint();
	}
}
