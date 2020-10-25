package Mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class Server {
	public static void main(String[] args) {
		//创建NioSocketAcceptor接收请求
		SocketAcceptor acceptor = new NioSocketAcceptor();
		// 获取过滤链
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		// 设定一个过滤器 一行一行的读取数据/r/n
//		chain.addLast("myChain", new ProtocolCodecFilter(new TextLineCodecFactory()));
		chain.addLast("objectChain", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		// 设置服务端的消息处理器
		acceptor.setHandler(new MinaSercverHandler());
		
		int port = 9999;	// 服务器的端口号
		try {
			
			// 绑定端口 启动服务器 不会阻塞 立即返回
			acceptor.bind(new InetSocketAddress(port));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
