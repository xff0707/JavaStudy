package Day11;/*
������
ͬ����Ƕ��ͬ��������ȴ��ͬ

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
		
		Thread t1 = new Thread(t);//������һ���߳�
		Thread t2 = new Thread(t);//������һ���߳�
		// Thread t3 = new Thread(t);//������һ���߳�
		// Thread t4 = new Thread(t);//������һ���߳�
		
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}
		t.flag = false;
		t2.start();
		// t3.start();
		// t4.start();
		
	}
}