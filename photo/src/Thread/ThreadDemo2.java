package Thread;

/**
 * 
 * sleep 与 wait的区别
 * sleep: 让线程进入休眠状态，会让出CPU的时间片， 不释放对象监视器的所有权（对象锁）
 * wait：让线程进入等待状态，让出CPU的时间片，并释放对象监视器的所有权，等待其它线程通过notify唤醒
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		Food food = new Food();
		T t = new T(food);
		S s = new S(food);
		
		Thread thread1 = new Thread(t);
		Thread thread2 = new Thread(s);
		thread1.start();
		thread2.start();
		
	}
}

// 消费者
class T implements Runnable{
	private Food food;

	public T(Food food) {
		this.food = food;
	}
	@Override
	public void run() {
		for(int i = 0; i < 30; ++i) {	
			food.getFood();
		}
	}
	
}
// 生产者
class S implements Runnable{
	private Food food;
	public S (Food food) {
		this.food = food;
	}
	@Override
	public void run() {
		for(int i = 0; i < 30; ++i) {
			if((i&1) == 1) {
				food.setFood("四星望月", "好吃");
			} else {				
				food.setFood("清蒸鲈鱼", "还行");
			}
			
		}
 	}
}


class Food {
	private String name;
	private String desc;

	private boolean flag = true; 	// true表示可以生产，false表示可以消费
	
	/**
	 * 	生产产品
	 */
	public synchronized void setFood(String name, String desc) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		setName(name);
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setDesc(desc);
		flag = false;
		this.notify();// 随机唤醒一个等待的线程
	}
	
	/**
	 * 	获取产品
	 */
	public synchronized void getFood() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + "->" + getDesc());
		flag = true;
		this.notify();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	
	public Food() {
		super();
	}

	public Food(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", desc=" + desc + "]";
	}

}