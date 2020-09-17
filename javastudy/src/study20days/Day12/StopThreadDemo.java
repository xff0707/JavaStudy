package Day12;/*
stop�����Ѿ���ʱ��

���ֹͣ�̣߳�
ֻ��һ�֣�run����������
�������߳����У����д���ͨ����ѭ���ṹ

ֻҪ����סѭ�������п�����run����������Ҳ�����߳̽���


���������
���̴߳��ڶ���״̬��
�Ͳ����ȡ����ǣ���ô�߳̾Ͳ������

��û��ָ���ķ�ʽ�ö�����ָ̻߳�������״̬ʱ����ʱ��Ҫ�Զ���������
ǿ�����ָ̻߳�������״̬�����������Ϳ��Բ���������߳̽�����

Thread�����ṩ�˸÷��� interrupt();

*/

class StopThread implements Runnable
{
	private boolean flag = true;
	public synchronized void run()
	{
		while(flag)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println(Thread.currentThread().getName()+"....Exception");
				flag = false;
			}
			System.out.println(Thread.currentThread().getName()+"....run");
		}
		System.out.println("....Over");
	}
	public void changeflag()
	{
		flag = false;
	}
}


class StopThreadDemo
{
	public static void main(String[] args)
	{
		StopThread st = new StopThread();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		t1.start();
		t2.start();
		
		int num = 0;
		
		while(true)
		{
			if(num++ == 60)
			{
				// st.changeflag();
				// t1.interrupt();
				// t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......"+num);
		}
		System.out.println("Over");
	}
}

/*
�����̱߳��Ϊdaemon�̻߳��û��̡߳� �����е�Ψһ�̶߳����ػ������߳�ʱ��Java��������˳��� 
�߳�����ǰ������ô˷�����

*/