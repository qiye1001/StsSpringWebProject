package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class FileDivisionMergeDemo {

	private static void division(File targetFile, long cutSize) {
		if (targetFile == null)
			return;

		// 计算分割的文件数
		int num = targetFile.length() % cutSize == 0 ? (int) (targetFile.length() / cutSize)
				: (int) (targetFile.length() / cutSize + 1);

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile))) {

			BufferedOutputStream out = null;

			byte[] bytes = null; // 每次读取的字节数
			int count = 0; // 每个文件读取的次数
			int len = -1; // 每次实际读取的次数
			int defaultSize = 1024 * 1024;

			// 循环次数为生成的文件个数
			for (int i = 0; i < num; i++) {
				out = new BufferedOutputStream(
						new FileOutputStream(new File("G:\\temp\\" + (i + 1) + targetFile.getName())));

				if (cutSize <= defaultSize) {
					bytes = new byte[(int) cutSize];
					count = 1;
				} else {
					bytes = new byte[defaultSize];
					count = (int) cutSize / defaultSize;
				}

				// 读取字节的条件要放后面 如果放前面 循环结束时会多读一次
				while (count > 0 && (len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
					out.flush();
					count--;
				}

				// 计算每个文件大小除以defaultSize的余数 决定是否再读取一次
				if (cutSize % defaultSize != 0) {
					bytes = new byte[(int) cutSize % defaultSize];
					len = in.read(bytes);
					out.write(bytes, 0, len);
					out.flush();
					out.close();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void merge(Enumeration<InputStream> es) {
		// 构造一个合并流
		SequenceInputStream sis = new SequenceInputStream(es);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("G:\\temp\\Java核心技术 卷I 基础知识（原书第10版）(2).pdf"));

			byte[] bytes = new byte[1024 * 1024];
			int len = -1;
			while((len = sis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
				bos.flush();
			}
			bos.close();
			sis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		division(new File("G:\\temp\\Java核心技术 卷I 基础知识（原书第10版）.pdf"), 1024 * 1024 * 50);

		try {
			InputStream file1 = new FileInputStream(new File("G:\\temp\\1Java核心技术 卷I 基础知识（原书第10版）.pdf"));
			InputStream file2 = new FileInputStream(new File("G:\\temp\\2Java核心技术 卷I 基础知识（原书第10版）.pdf"));
			InputStream file3 = new FileInputStream(new File("G:\\temp\\3Java核心技术 卷I 基础知识（原书第10版）.pdf"));
			InputStream file4 = new FileInputStream(new File("G:\\temp\\4Java核心技术 卷I 基础知识（原书第10版）.pdf"));

			// 集合工具类， 内部实现使用了数组
			Vector<InputStream> v = new Vector<InputStream>();
			v.add(file1);
			v.add(file2);
			v.add(file3);
			v.add(file4);

			Enumeration<InputStream> es = v.elements();
			merge(es);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
