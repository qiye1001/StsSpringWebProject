package IO;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
	public static void main(String[] args) {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		
		try {
			pis.connect(pos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ReadThread readThread = new ReadThread(pis);
		WriteThread writeThread = new WriteThread(pos);
		
		new Thread(readThread).start();
		new Thread(writeThread).start();
	}
}

class WriteThread implements Runnable{
	PipedOutputStream pos;
	
	public WriteThread (PipedOutputStream pos) {
		this.pos = pos;
	}
	
	@Override
	public void run() {
		try {
			pos.write("°¢Æ®".getBytes());
			pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ReadThread implements Runnable {
	PipedInputStream pis;

	public ReadThread(PipedInputStream pis) {
		this.pis = pis;
	}

	@Override
	public void run() {
		try {
			byte[] bytes = new byte[1024];
			int len = pis.read(bytes);
			String s = new String(bytes, 0, len);
			System.out.println("¶Á³ö£º" + s);
			pis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
