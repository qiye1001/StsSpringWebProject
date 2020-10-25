package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamDemo {
	public static void main(String[] args) {
//		out();
		in();
	}

	public static void in() {
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");

		try {
			InputStream in = new FileInputStream(file);
			byte[] bytes = new byte[10];
			StringBuilder buf = new StringBuilder();
			int len = -1;
			// 把数据读到数组中，并返回读取的字节数，当不等于-1时，表示读取到数据， 等于-1表示数据已读完
			while ((len = in.read(bytes)) != -1) {
				buf.append(new String(bytes, 0, len));
				System.out.println(buf);
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void out() {
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");

		try {
			// 构建一个文件输出流对象
			OutputStream out = new FileOutputStream(file,true); // 为true表示追加内容
			String info = "小桥流水哗啦啦\r\n";
			// 将内容写入到文件
			out.write(info.getBytes());
			// 关闭流
			out.close();
//			System.out.println("write success");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
