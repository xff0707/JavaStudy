package javastudy25days.Day11;/*
����
������һ����⡣
�����������ֱ��300Ԫ��ÿ�δ�100Ԫ����3��

Ŀ�ģ����߳��Ƿ��а�ȫ���⣬����У���ô�����


��������⣺
1.��ȷ��Щ�����Ƕ��߳����д��롣
2.��ȷ�������ݡ�
3.��ȷ���߳����д�������Щ����ǲ����������ݵġ�

*/

class Bank
{
	private int sum;
	Object obj = new Object();
	public synchronized void add(int n)
	{
		// synchronized(obj)
		// {
			sum = sum + n;
			try{Thread.sleep(10);}
			catch(Exception e){}
			
			System.out.println("sum="+sum);
		// }
		
	}
}

class Cus implements Runnable
{
	private Bank b = new Bank();
	public void run()
	{
		for(int x = 0;x<3;x++)
		{
			b.add(100);
		}
	}
}

class BankDemo
{
	public static void main(String[] args)
	{
		Cus c = new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
	}
}