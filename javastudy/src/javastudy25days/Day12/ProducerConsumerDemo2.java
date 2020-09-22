package javastudy25days.Day12;

import java.util.concurrent.locks.*;

class ProducerConsumerDemo2
{
	public static void main(String[] args)
	{
		Resource r = new Resource();
		
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		
		Thread t1 = new Thread(pro);Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);Thread t4 = new Thread(con);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}



/*
JDK1.5中提供了多线程升级解决方案
将同步Synchronsized替换成显式操作
将Object中的wait，notify notifyAll,替换成了Condition对象
该对象可以Lock锁 进行获取。
该实例中，实现了本方只唤醒对方操作。

*/


class Resource2
{
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	//  t1      t2
	private Lock lock = new ReentrantLock();
	
	// private Condition condition = lock.newCondition();
	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();
	
	public void set(String name) throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)
				condition_pro.await();//condition.await();
			this.name = name + "--" + count++;
			
			System.out.println(Thread.currentThread().getName()+"..生产者.."+this.name);
			flag = true;
			condition_con.signal();//condition.signalAll();
		}
		finally
		{
			lock.unlock();//释放锁的动作一定要执行
		}
	}
	
	//  t3     t4
	public void out() throws InterruptedException
	{
		lock.lock();
		try
		{
			while(!flag)
				condition_con.await();
			System.out.println(Thread.currentThread().getName()+"...消费者....."+this.name);
			flag = false;
			condition_pro.signal();
		}
		finally
		{
			lock.unlock();
		}
	}
}

class Producer2 implements Runnable
{
	private Resource2 res;
	
	Producer2(Resource2 res)
	{
		this.res = res;
	}
	
	public void run()
	{
		while(true)
		{
			try {
				res.set("+商品+");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer2 implements Runnable
{
	private Resource2 res;
	
	Consumer2(Resource2 res)
	{
		this.res = res;
	}
	
	public void run()
	{
		while(true)
		{
			try {
				res.out();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}













