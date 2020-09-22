package javastudy25days.Day11;/*
���ͬ����������̬���κ�ʹ�õ�����ʲô�أ�

ͨ����֤�����ֲ�����this����Ϊ��̬������Ҳ�����Զ���this

��̬���ڴ�ʱ���ڴ���û�б�����󣬵���һ���и����Ӧ���ֽ����ļ�����

����.class �ö����������class


��̬��ͬ��������ʹ�õ����Ǹ÷�����������ֽ����ļ����� ����.class

*/

class Ticket1 implements Runnable
{
	private static int tick=100;
	// Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(Ticket1.class)
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
	public static synchronized void show()//this
	{
		if(tick>0)
		{
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"...show......"+tick--);
		}
	}
}


class StaticMethodDemo
{
	public static void main(String[] args)
	{
		Ticket1 t = new Ticket1();
		
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