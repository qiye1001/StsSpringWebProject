package SocketDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerDemo {
	public static void main(String[] args) {
		// 创建一个服务器的Socket（1024 - 65535）
		try {
			ServerSocket server = new ServerSocket(6666);	// 端口号
			System.out.println("服务器已启动，正在等待连接...");
			// 等待客户连接，造成阻塞，如果成功连接，立即返回一个Socket对象
			Socket socket = server.accept();
			System.out.println("服务器连接成功"+socket.getInetAddress().getHostAddress());
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// 通过输入流读取网络数据对象 没有获取数据 也会造成阻塞
			String info = br.readLine();
			// 获取输入流 向客户端返回消息
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("echo:"+info);
			ps.flush();
			ps.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
