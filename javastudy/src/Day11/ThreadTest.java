package Day11;

/*
��ϰ��
���������̣߳������߳̽�������

ԭ���̶߳����Լ�Ĭ�ϵ����ơ�
Thread-��� �ñ�Ŵ�0��ʼ


static Thread currentThread()����ȡ��ǰ�̶߳���
getName����ȡ�߳����ơ�

�����߳����ƣ�setName���߹��캯����


*/
class Test2 extends Thread
{
	// private String name;
	Test2(String name)
	{
		// this.name = name;
		super(name);
	}
	public void run()
	{
		for(int x = 1;x<60;x++)
		{
			System.out.println((Thread.currentThread()==this)+"..."+this.getName()+"Test run."+x);
		}
	}
}


class ThreadTest
{
	public static void main(String[] args)
	{
		Test2 t1 = new Test2("one");
		Test2 t2 = new Test2("two");
		t1.start();
		t2.start();
		
		for(int x = 1;x<60;x++)
		{
			System.out.println("main....."+x);
		}
	}
}