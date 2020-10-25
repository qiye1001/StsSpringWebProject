package photo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Server{
	
	public static void main(String[] args) {
		Map<String, UserThread> user = new HashMap<>();
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		try {
			ServerSocket socket = new ServerSocket(9999);
			System.out.println("服务器连接中...");
			
			while(true) {
				
				Socket accept = socket.accept();
				System.out.println("服务器"+socket.getInetAddress().getHostAddress()+"连接成功");
				newFixedThreadPool.execute(new UserThread(accept, user));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	private static class UserThread implements Runnable{
		String id; 	// 用户账户 唯一
		Socket socket;
		Message message;
		ObjectInputStream ois;	
		ObjectOutputStream oos;
		Map<String, UserThread> user;
		
		public UserThread(Socket socket, Map<String, UserThread> user) {
			this.socket = socket;
			this.user = user;
		}
		
		public boolean signIn(String id) {
			if(!user.containsKey(id)) {
				user.put(id, this);
				user.forEach((k, v) -> System.out.println(k));
				return true;
			}
			return false;
		}
		
		@Override
		public void run() {
			while(true){
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					oos = new ObjectOutputStream(socket.getOutputStream());
					message = (Message)ois.readObject();
					int type = message.getInfoType();
					System.out.println("type:"+message.getInfoType());
					System.out.println(message.getFrom());
					
					// 判断消息的类型
					switch(type){
					case MessageType.send:		// 发送消息
						String to = message.getTo();
						user.get(to).oos.writeObject(message);
						break;
					case MessageType.login:		// 注册 登录
						id = message.getFrom();
						System.out.println("id:"+id);
						if(signIn(id)) {
							message.setInfo("注册成功 账号为:" + id);
						} else {
							message.setInfo("注册失败 该账号已被注册");
						}
						oos.writeObject(message);
						break;
					}
				
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

