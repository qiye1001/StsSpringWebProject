package IO;

import java.nio.ByteBuffer;

public class NIODemo {
	public static void main(String[] args) {
		//创建一个字符缓冲区，申请内存空间为20字节
		ByteBuffer buf = ByteBuffer.allocate(40);
//		buf.put("faga1".getBytes());
//		buf.put("faga2".getBytes());
//		buf.put("faga3".getBytes());
//		buf.put("faga4".getBytes());
		buf.put((byte)10);
		buf.put((byte)20);
		buf.put((byte)30);
		buf.put((byte)40);
		
		System.out.println("position="+buf.position());
		System.out.println("limit="+buf.limit());
		System.out.println("capacity="+buf.capacity());
		System.out.println("-----------------");
		
		// 缓冲区反转
		buf.flip();
		System.out.println("position="+buf.position());
		System.out.println("limit="+buf.limit());
		System.out.println("capacity="+buf.capacity());
		
		// 告知在当前位位置和限制之间是否有元素
		if(buf.hasRemaining()) {
			// 返回当前位置与限制之间的元素数
			for(int i = 0; i < buf.remaining(); ++i) {
//				System.out.print((char)buf.get(i));
				System.out.println(buf.get(i));
			}
		}
	}
}
