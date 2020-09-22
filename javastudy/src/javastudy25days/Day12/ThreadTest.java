package javastudy25days.Day12;

class ThreadTest
{
	public static void main(String[] args)
	{
		new Thread()
		{
			public void run()
			{
				for(int x = 0;x<100;x++)
				{
					System.out.println(Thread.currentThread().getName()+"......"+x);
				}
			}
		}.start();

		Runnable r = new Runnable()
		{
			public void run()
			{
				for(int x = 0;x<100;x++)
				{
					System.out.println(Thread.currentThread().getName()+"......"+x);
				}
			}
		};
		new Thread(r).start();

		for(int x = 0;x<100;x++)
		{
			System.out.println(Thread.currentThread().getName()+"......"+x);
		}
	}
}