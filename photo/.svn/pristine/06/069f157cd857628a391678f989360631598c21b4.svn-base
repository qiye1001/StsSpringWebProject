package SocketDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class URLDemo {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://c-ssl.duitang.com/uploads/item/201503/03/20150303105214_hKxvi.thumb.700_0.png");

			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			
//			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("G://kenan1.jpg"));
			int len = -1;
			byte[] bytes = new byte[1024];
			while((len = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
			}
			System.out.println("œ¬‘ÿÕÍ≥…");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
