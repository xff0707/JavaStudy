package Day11;/*
死锁。
同步中嵌套同步，而锁却不同

*/


class Ticket implements Runnable
{
	private static int tick=1000;
	Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(obj)
				{
					show();
				}
			}
		}
		else
			while(true)
				show();//this
	}
	public synchronized void show()//this
	{
		synchronized(obj)
		{
		if(tick>0)
		{
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"...show......"+tick--);
		}
		}
	}
}


class DeadLockDemo
{
	public static void main(String[] args)
	{
		Ticket t = new Ticket();
		
		Thread t1 = new Thread(t);//创建了一个线程
		Thread t2 = new Thread(t);//创建了一个线程
		// Thread t3 = new Thread(t);//创建了一个线程
		// Thread t4 = new Thread(t);//创建了一个线程
		
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}
		t.flag = false;
		t2.start();
		// t3.start();
		// t4.start();
		
	}
}