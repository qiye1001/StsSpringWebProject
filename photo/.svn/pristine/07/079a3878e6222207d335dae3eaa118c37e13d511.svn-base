package photo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferStreamDemo {

	private static void out() {
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			String info = "哗哗哗哗哗";
			bos.write(info.getBytes());
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void in() {
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
		StringBuilder sb;
		try {
			InputStream in = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			sb = new StringBuilder();
			int len = -1;
			while ((len = in.read(bytes)) != -1) {
				sb.append(new String(bytes, 0, len));
			}
			bis.close();
			System.out.println(sb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
//		in();
		out();
	}
}
