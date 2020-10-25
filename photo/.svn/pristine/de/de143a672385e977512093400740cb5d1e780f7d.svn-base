package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadDemo3 {
	public static void main(String[] args) {
		// 创建一个单线程的线程池
//		ExecutorService es = Executors.newSingleThreadExecutor();
		// 创建一个固定大小的线程池
//		ExecutorService es = Executors.newFixedThreadPool(2);
		// 创建一个可缓存的线程池，如果线程池的大小超过处理任务所需要的线程，
		// 那么就会回收部分空闲的线程（60秒不执行任务的线程），当任务数增加时，
		// 此线程池又会智能的添加新的线程来处理任务，此线程池不会对线程池的大小做限制，
		// 线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小
//		ExecutorService es = Executors.newCachedThreadPool();
		
		// 创建一个大小无限的线程池，此线程池支持定时以及周期性执行任务的需求
		ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
//		es.execute(new MyThread());
//		es.execute(new MyThread());
		es.schedule(new MyThread(), 3000, TimeUnit.MILLISECONDS);
		es.shutdown();
	}
}

class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 50; ++i) {
			System.out.println(Thread.currentThread().getName() + "--" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}