package Mina;

import java.net.InetSocketAddress;
import java.util.Scanner;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class Client {
	public static void main(String[] args) {
		// 创建NioSocketConnector连接服务端并发送请求
		NioSocketConnector connector = new NioSocketConnector();
		// 创建一个过滤链
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		// 设置一个过滤器
//		chain.addLast("myChain", new ProtocolCodecFilter(new TextLineCodecFactory()));
		// 设置过滤器以对象为单位读取数据
		chain.addLast("ojectChain", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		// 设置消息处理器
		connector.setHandler(new MinaClientHandler());
		
		// 连接服务器
		ConnectFuture cf = connector.connect(new InetSocketAddress("localhost", 9999));
		cf.awaitUninterruptibly();	// 等待连接成功
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
//			System.out.println("请输入:");
//			String info = sc.nextLine();
//			cf.getSession().write(info);
			
			Message msg = new Message();
			System.out.println("form:");
			String form  = sc.nextLine();
			msg.setFrom(form);
			System.out.println("to:");
			String to = sc.nextLine();
			msg.setTo(to);
			System.out.println("info:");
			String info = sc.nextLine();
			msg.setInfo(info);
			
			msg.setType("send");
			cf.getSession().write(msg);
		}
		
		// 等待服务器连接关闭 结束长连接
//		cf.getSession().getCloseFuture().awaitUninterruptibly(); 
//		connector.dispose();
	}
}
