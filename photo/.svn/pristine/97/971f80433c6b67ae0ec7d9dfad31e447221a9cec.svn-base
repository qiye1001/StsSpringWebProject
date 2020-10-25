package Mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class MinaSercverHandler extends IoHandlerAdapter{
	
	// 第一次会话被打开
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		super.sessionOpened(session);
		System.out.println("welcome client:"+session.getRemoteAddress());
	}
	
	// 会话关闭
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
		System.out.println("client close");
	}
	
	// 接收消息
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		super.messageReceived(session, message);
//		String info = (String)message;	// 接收到的消息对象
		Message msg = (Message)message;
		String info = msg.getInfo();
		System.out.println("收到客户端发来的消息:"+info);
		// 向客户端发送消息对象
		session.write("echo:" + info);
	}
}
