package javastudy25days.Day12;/*
join��
��A�߳�ִ�е���B�̵߳�.join()����ʱ��A�ͻ�ȴ�����B�̶߳�ִ���꣬A�Ż�ִ�С�

join()����������ʱ�����߳�ִ�У�

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