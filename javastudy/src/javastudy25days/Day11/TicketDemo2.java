package javastudy25days.Day11;
/*

ͨ�����������֣���ӡ��0��-1��-2�ȴ�Ʊ

���̵߳����г����˰�ȫ���⡣

�����ԭ��
	����������ڲ���ͬһ���̹߳�������ʱ��һ���̶߳Զ������ִ�е�һ���ֻ�û��ִ���꣬
	��һ���̲߳������ִ�У������˹������ݵĴ���

����취��
	�Զ��������������ݵ���䣬ֻ����һ���̶߳�ִ���ꡣ��ִ�й����У������̲߳����Բ�������



java���ڶ��̵߳İ�ȫ�ṩ��רҵ�Ľ����ʽ��

����ͬ������顣

synchronized(����)
{
	��Ҫ��ͬ���Ĵ���
}
������ͬ�������������߳̿�����ͬ����ִ�С�
û�г��������̼߳�ʹ��ȡcpu��ִ��Ȩ��Ҳ����ȥ����Ϊû�л�ȡ����


���ϵ�������-���䡣

ͬ����ǰ�᣺
1.����Ҫ�����������������ϵ��̡߳�
2.�����Ƕ���߳�ʹ��ͬһ������

���뱣֤ͬ����ֻ����һ���߳������С�


�ô�������˶��̵߳İ�ȫ���⡣

�׶ˣ�����߳���Ҫ�ж�������Ϊ������Դ��


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
					System.out.println(Thread.currentThread().getName()+"����Ʊ�ţ�"+tick--);
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+"��ʱ��"+(end-start));
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
		
		Thread t1 = new Thread(t);//������һ���߳�
		Thread t2 = new Thread(t);//������һ���߳�
		Thread t3 = new Thread(t);//������һ���߳�
		Thread t4 = new Thread(t);//������һ���߳�
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}


/*

*/









