package SocketDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServerDemo {
	public static void main(String[] args) {
		try {
			String info = "good good 学习, 天天 up";
			byte[] bytes = info.getBytes();
			DatagramPacket dp = new DatagramPacket(
					bytes, 
					0, 
					bytes.length, 
					InetAddress.getByName("127.0.0.1"),
					8000);
			// 本程序的端口
			DatagramSocket ds = new DatagramSocket(9000);
			ds.send(dp);
			ds.close();
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
