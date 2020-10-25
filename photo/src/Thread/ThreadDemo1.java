package Thread;


public class ThreadDemo1 {
	public static void main(String[] args) {
		ThreadTest thread1 = new ThreadTest();
		thread1.start();
		
		ThreadTest2 test2 = new ThreadTest2();
		Thread thread2 = new Thread(test2);
		thread2.start();
//		thread2.setDaemon(true);	// 设置守护线程
		for(int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i == 20) {
				test2.flag = false;
				try {
					thread1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				thread1.interrupt(); 	//  中断标记
			}
		}
	}
}

class ThreadTest extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 50; ++i) {
			if(Thread.interrupted()) {	// 测试中断状态，此方法会把中断状态清除
				break;
			}
			System.out.println(Thread.currentThread().getName() + "-" + i);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
//				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
}

class ThreadTest2 implements Runnable{
	boolean flag = true;
	public ThreadTest2() {
		flag = true;
	}
	@Override
	public void run() {
		int i = 0;
		while(flag) {
			System.out.println(Thread.currentThread().getName() + "->" + (
					i++));
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
		}
	}
	
}