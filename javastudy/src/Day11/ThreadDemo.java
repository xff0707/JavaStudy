package Day11;/*
���̣���һ������ִ���еĳ���
		ÿһ������ִ�ж���һ��ִ��˳�򣬸�˳����һ��ִ��·��(�龰)�����߽�һ�����Ƶ�Ԫ

�̣߳����ǽ����е�һ�������Ŀ��Ƶ�Ԫ
		�߳��ڿ����Ž��̵�ִ��
		
һ��������������һ���߳�



Java VM ������ʱ�����һ������java.exe

�ý�����������һ���߳��ڸ���java��ִ��
��������߳����еĴ��������main������
���̳߳�֮Ϊ���߳�

��չ����ʵ��ϸ��˵��jvm��jvm������ֹһ���̣߳����и����������ջ��Ƶ��߳�



1.������Զ���Ĵ����У��Զ���һ���߳��أ�

ͨ����api�Ĳ��ң�java�Ѿ��ṩ�˶��߳������������������Thread��

�����̵߳ĵ�һ�ַ�ʽ���̳�Thread��
���裺
1.������̳�Thread
2.��дThread���е�run����
	Ŀ�ģ����Զ���Ĵ���洢��run�����У����߳����С�
3.�����̵߳�start������
	�÷�����2�����ã������̣߳�����run����

	
	
�������н��ÿһ�ζ���ͬ
��Ϊ����̶߳���ȡcpu��ִ��Ȩ��cpuִ�е�˭��˭��ִ��
��ȷһ�㣬��ĳһ��ʱ�̣�ֻ����һ�����������С�(��˳���)
cpu�����ſ��ٵ��л����Դﵽ����ȥ��ͬʱ���е�Ч����
���ǿ�������Ѷ��߳�������Ϊ�ڻ�������cpu��ִ��Ȩ

����Ƕ��̵߳�һ�����ԣ�����ԣ�˭����˭ִ�У�����ִ�ж೤��cpu˵����



ΪʲôҪ����run�����أ�

Thread�����������̡߳�
����Ͷ�����һ�����ܣ����ڴ洢�߳�Ҫ���еĴ��룬�ô����ܾ���run������

Ҳ����˵��Thread���е�run���������ڴ洢�߳�Ҫ���еĴ��롣






*/

class Demo2 extends Thread
{
	public void run()
	{
		for(int a = 1;a<50;a++)
		{
			System.out.println("Demo run!---"+a);
		}
	}
}


class ThreadDemo
{
	public static void main(String[] args)
	{

		// for(int a = 1;a<1000;a++)
		// {
			// System.out.println("Hello World!");
		// }
		
		Demo2 d = new Demo2(); //������һ���߳�
		d.start();//�����̲߳�ִ�и��̵߳�run����
		// d.run();//�����Ƕ�����÷��������̴߳����ˣ���û�����С�
		
		for(int a = 1;a<50;a++)
		{
			System.out.println("Hello World!---"+a);
		}
		// System.out.println(d.toString());
		
		Thread t = new Thread();
		
		t.start();
	
	}
}