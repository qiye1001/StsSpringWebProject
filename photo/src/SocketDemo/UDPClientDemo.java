package SocketDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClientDemo {
	public static void main(String[] args) {
		try {
			byte[] bytes = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
			DatagramSocket ds = new DatagramSocket(8000);
			System.out.println("正在接收数据...");
			ds.receive(dp);	// 接收数据
			String info = new String(dp.getData(), 0, dp.getLength());
			System.out.println(info);
			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
