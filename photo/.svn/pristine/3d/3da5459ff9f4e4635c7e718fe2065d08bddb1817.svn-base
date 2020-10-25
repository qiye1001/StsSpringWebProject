package SocketDemo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClientDemo {
	public static void main(String[] args) {
		// 创建一个Socket对象，指定要连接的服务器
		try {
			Socket socket = new Socket("localhost", 6666);
			PrintStream ps = new PrintStream(
					new BufferedOutputStream(socket.getOutputStream()));
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			ps.println("hello my friends\n");
			ps.flush();
			
			// 读取服务端返回的数据
			String info = br.readLine();
			System.out.println(info);
			ps.close();
			br.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
