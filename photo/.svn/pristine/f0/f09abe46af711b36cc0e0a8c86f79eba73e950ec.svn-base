package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/*
 * 	title：通道文件与内存映射
 * 
 * IO操作的性能比较
 * 1、内存映射
 * 2、NIO读写文件
 * 3、使用缓冲的IO流
 * 4、无缓冲的IO流
 */

public class CopyFileDemo {
	
	public static void RandomAccessFileCopy() throws Exception {
		RandomAccessFile in = new RandomAccessFile("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt", "r");
		RandomAccessFile out = new RandomAccessFile("G:\\新建文件夹 (4)\\于晓成\\web\\新建文件按键.txt", "rw");
		
//		FileChannel fcIn = in.getChannel();
		FileChannel fcOut = out.getChannel();
		
//		long size = fcIn.size();	// 输入流的字节大小
		

		String info = "aabbcc";
		long size = info.length();
		
		// 输入流的缓冲区
//		MappedByteBuffer inBuf = fcIn.map(MapMode.READ_ONLY, 0, size);
		// 输出流的缓冲区
		MappedByteBuffer outBuf = fcOut.map(MapMode.READ_WRITE, 0, size);
		
//		for(int i = 0; i < size; ++i) {
//			outBuf.put(inBuf.get());
//		}
		outBuf.put(info.getBytes());
		// 关闭（关闭通道时会写入数据）
//		fcIn.close();
		fcOut.close();
		in.close();
		out.close();
	}
	
	public static void copyFile() throws Exception {
		// 创建一个输入文件的管道
//		FileChannel fcIn = new FileInputStream("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt").getChannel();
		// 创建一个输出文件的管道
		FileChannel fcOut = new FileOutputStream("G:\\新建文件夹 (4)\\于晓成\\web\\新建文件按键.txt").getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(1024);
//		while(fcIn.read(buf) != -1) {
//			buf.flip();
//			fcOut.write(buf);
//			buf.clear();
//		}
		String b = "zzvvzz";
		buf.put(b.getBytes());
		buf.flip();
		fcOut.write(buf);
		fcOut.close();
//		fcIn.close();
	}
	
	public static void main(String[] args) {
		try {
			copyFile();
//			RandomAccessFileCopy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
