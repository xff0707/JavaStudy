package javastudy25days.Day11;/*
ͬ�������õ�����һ�����أ�
������Ҫ��������ã���ô��������һ�������������ã�����this��
����ͬ������ʹ�õ�����this��

ͨ���ĳ��������֤��

ʹ�������߳̽�����Ʊ��
һ���߳���ͬ��������С�
һ���߳���ͬ�������С�
����ִ����Ʊ������

*/

class Ticket2 implements Runnable
{
	private int tick=100;
	// Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(this)
				{
					if(tick>0)
					{
						try{Thread.sleep(10);}catch(Exception e){}
						System.out.println(Thread.currentThread().getName()+"...code..."+tick--);
					}
				}
			}
		}
		else
			while(true)
				show();//this
	}
	public synchronized void show()
	{
		if(tick>0)
		{
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"...show..."+tick--);
		}
	}
}


class ThisLockDemo
{
	public static void main(String[] args)
	{
		Ticket2 t = new Ticket2();
		
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