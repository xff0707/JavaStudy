package Day12;/*
stop方法已经过时。

如何停止线程？
只有一种，run方法结束。
开启多线程运行，运行代码通常是循环结构

只要控制住循环，运行可以让run方法结束，也就是线程结束


特殊情况：
当线程处于冻结状态。
就不会读取到标记，那么线程就不会结束

当没有指定的方式让冻结的线程恢复到运行状态时，这时需要对冻结进行清楚
强制让线程恢复到运行状态中来，这样就可以操作标记让线程结束。

Thread类中提供了该方法 interrupt();

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
将此线程标记为daemon线程或用户线程。 当运行的唯一线程都是守护进程线程时，Java虚拟机将退出。 
线程启动前必须调用此方法。

*/