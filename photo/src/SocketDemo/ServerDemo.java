package SocketDemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerDemo {
	public static void main(String[] args) {
		Vector<UserThread> user = new Vector<>();
		try {
			ServerSocket server =  new ServerSocket(7777);
			ExecutorService executor = Executors.newFixedThreadPool(5);	// 创建大小为5的线程池
			System.out.println("服务器已启动, 等待用户连接...");
			while(true) {
				Socket socket = server.accept();
				UserThread Thread = new UserThread(socket, user);
				executor.execute(Thread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class UserThread implements Runnable{
	String name;	// 唯一的用户名
	Socket socket;
	Vector<UserThread> user;	// 客户端处理线程的方式
	ObjectInputStream ois;
	ObjectOutputStream oos;
	boolean flag = true;
	public UserThread(Socket socket, Vector<UserThread> user) {
		this.socket = socket;
		this.user = user;
		user.add(this);
	}

	@Override
	public void run() {
		try {
			System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"登录成功");
			ois = new ObjectInputStream(socket.getInputStream()); 	// 接收用户信息
			oos = new ObjectOutputStream(socket.getOutputStream());
			while(flag) {
				Message msg = (Message)ois.readObject();
				int type = msg.getType();
				
				switch(type) {
				case MessageType.TYPE_SEND:
					String to = msg.getTo();
					UserThread ut;
					int size = user.size();
					for(int i = 0; i < size; ++i) {
						ut = user.get(i);
						if(ut != this && to.equals(ut.name)) {
							ut.oos.writeObject(msg);
							break;
						}
					}
					break;
				case MessageType.TYPE_LOGIN:
					name = msg.getFrom();
					msg.setInfo("欢迎您：");
					oos.writeObject(msg);
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
