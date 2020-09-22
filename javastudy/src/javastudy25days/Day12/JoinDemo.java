package javastudy25days.Day12;/*
join：
当A线程执行到了B线程的.join()方法时，A就会等待。等B线程都执行完，A才会执行。

join()可以用来临时加入线程执行，

*/


class Demo implements Runnable
{
	public void run()
	{
		for(int x = 0;x<60;x++)
		{
			System.out.println(Thread.currentThread().toString()+"....."+x);
			Thread.yield();
		}
	}
}


class JoinDemo
{
	public static void main(String[] args)throws Exception
	{
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		//t1.setDaemon(true);
		//t2.setDaemon(true);
		t1.start();
		
		// t1.setPriority(Thread.MAX_PRIORITY);
		// t1.join();
		
		t2.start();
		// t2.setPriority(Thread.MIN_PRIORITY);
		
		// for(int x = 0;x<80;x++)
		// {
			// System.out.println("main....."+x);
		// }
		// System.out.println("Over");
		
	}
}