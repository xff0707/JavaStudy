package Day11;/*
���󣺼򵥵���Ʊ����
�������ͬʱ��Ʊ



�����̵߳ĵڶ��ַ�ʽ��ʵ��Runnable�ӿ�

���裺
1.������ʵ��Runnable�ӿ�
2.����Runnable�ӿ��е�run����
	���߳�Ҫ���еĴ�������run������
	
3.ͨ��Thread�ཨ���̶߳���
4.��Runnable�ӿڵ����������Ϊʵ�ʲ������ݸ�Thread��Ĺ��캯��
	ΪʲôҪ��Runnable�ӿڵ�������󴫵ݸ�Thread�Ĺ��캯��
	��Ϊ���Զ����run���������Ķ�����Runnable�ӿڵ��������
	����Ҫ���߳�ȥָ�������run�������ͱ�����ȷ��run������������
	
	
5.����Thread���start���������̲߳�����Runnable�ӿ������run����



ʵ�ַ�ʽ�ͼ̳з�ʽ��ʲô�����أ�

ʵ�ַ�ʽ�ô��������˵��̳еľ�����
�ڶ����߳�ʱ������ʹ��ʵ�ַ�ʽ

���ַ�ʽ������
�̳�Thread���̴߳�������Thread����run������
ʵ��Runnable���̴߳�����ڽӿڵ������run������

*/

class Ticket3 implements Runnable//extends Thread
{
	// private static int tick = 100;
	private int tick = 100;
	public void run()
	{
		while(true)
		{
			if(tick>0)
			{
				System.out.println(Thread.currentThread().getName()+"ʣ��Ʊ��"+tick--);
			}
			
		}
	}
}


class TicketDemo
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
		Ticket3 t = new Ticket3();
		
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









