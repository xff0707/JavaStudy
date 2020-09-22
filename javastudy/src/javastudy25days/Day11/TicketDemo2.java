package javastudy25days.Day11;
/*

通过分析，发现，打印出0，-1，-2等错票

多线程的运行出现了安全问题。

问题的原因：
	当多条语句在操作同一个线程共享数据时，一个线程对多条语句执行的一部分还没有执行完，
	另一个线程参与进来执行，导致了共享数据的错误。

解决办法：
	对多条操作共享数据的语句，只能让一个线程都执行完。在执行过程中，其他线程不可以参与运行



java对于多线程的安全提供了专业的解决方式。

就是同步代码块。

synchronized(对象)
{
	需要被同步的代码
}
对象如同锁，持有锁的线程可以在同步中执行。
没有持有锁的线程即使获取cpu的执行权，也进不去，因为没有获取锁。


火车上的卫生间-经典。

同步的前提：
1.必须要有两个或者两个以上的线程。
2.必须是多个线程使用同一个锁。

必须保证同步中只能由一个线程在运行。


好处：解决了多线程的安全问题。

弊端：多个线程需要判断锁，较为消耗资源。


*/

class Ticket4 implements Runnable//extendsThread
{
	//private static int tick=100;
	private int tick=10000;
	Object obj = new Object();
	public void run()
	{
		long start = System.currentTimeMillis();
		//while(true)
		while(tick>0)
		{
			synchronized(obj)
			{
				if(tick>0)
				{
					// try
					// {
						// Thread.sleep(3);
					// }
					// catch(Exception e)
					// {
						
					// }
					System.out.println(Thread.currentThread().getName()+"卖出票号："+tick--);
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+"耗时："+(end-start));
	}
}


class TicketDemo2
{
	public static void main(String[] args)
	{
		/*
		Ticket t1 = new Ticket();
		// Ticket t2 = new Ticket();
		// Ticket t3 = new Ticket();
		// Ticket t4 = new Ticket();
		
		// t1.start();
		// t2.start();
		// t3.start();
		// t4.start();
		
		t1.start();
		t1.start();
		t1.start();
		t1.start();
		
		*/
		Ticket4 t = new Ticket4();
		
		Thread t1 = new Thread(t);//创建了一个线程
		Thread t2 = new Thread(t);//创建了一个线程
		Thread t3 = new Thread(t);//创建了一个线程
		Thread t4 = new Thread(t);//创建了一个线程
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}


/*

*/









