package IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	
	public static void main(String[] args) {
		try {
			RandomAccessFile r = new RandomAccessFile("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt", "r");
			RandomAccessFile w = new RandomAccessFile("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt(2)", "rw");
			
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = r.read(bytes)) != -1) {
				w.write(bytes, 0, len);
			}
			
			w.close();
			r.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
