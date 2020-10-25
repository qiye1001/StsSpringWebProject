package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1();
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t1);
		th1.start();
		th2.start();
		
	}
}


class Thread1 implements Runnable{
	int n = 10;
	
	@Override
	public void run() {
		for(int i = 0; i < 300; ++i) {
//			synchronized (this) {
//				if(n > 0) {
//					n--;
//					try {
//						Thread.sleep(150);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("当前剩余的票数为：" + n + "张");
//				}
//			}
			money();
		}
	}
	
	ReentrantLock lock = new ReentrantLock();
	
	public void money() {
		lock.lock();
		try {
			if(n > 0) {
				n--;
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("当前剩余的票数为：" + n + "张");
			}
		} finally {
			lock.unlock();
		}
	}
	
//	public synchronized void money() {
//		if(n > 0) {
//			n--;
//			try {
//				Thread.sleep(150);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("当前剩余的票数为：" + n + "张");
//		}
//	}
}