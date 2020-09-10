package Day12;

/*
线程间通讯：
其实就是多个线程在操作同一个资源，
但是操作的动作不同。

*/
class Res2
{
	private String name;
	private String sex;
	private boolean flag = false;
	
	public synchronized void set(String name,String sex)
	{
		if(flag)
			try{this.wait();}catch(Exception e){}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}
	
	public synchronized void out()
	{
		if(!flag)
			try{this.wait();}catch(Exception e){}
		System.out.println(name+"......"+sex);
		flag = false;
		this.notify();
	}
}

class Input2 implements Runnable
{
	private Res2 r;
	// Object obj = new Object();
	Input2(Res2 r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			try{r.wait();}catch(Exception e){}
			if(x==0)
				r.set("mike","man");
			else
				r.set("丽丽","女女女女女");
			x = (x+1)%2;
		}
	}
}

class Output2 implements Runnable
{
	private Res2 r;
	// Object obj = new Object();
	Output2(Res2 r)
	{
		this.r = r;
	}
	
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}

class InputOutputDemo2
{
	public static void main(String[] args)
	{
		Res2 r = new Res2();
		
		new Thread(new Input2(r)).start();
		new Thread(new Output2(r)).start();
		
		
		/*
		Input in = new Input(r);
		Output out = new Output(r);
		
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		
		t1.start();
		t2.start();
		*/
		// try{Thread.sleep(0,30);}catch(Exception e){}
		// System.out.println("喵喵喵");
	}
}

/*
wait
notify
notifyAll

都使用在同步中，因为要对监视器(锁)的线程操作。
所以要使用在同步中，因为只有同步才具有锁。

为什么这些操作线程的方法要定义在Object中呢？
因为这些方法在操作同步中线程时，都必须要标识它们所操作线程只有的锁，
只有同一个锁上的被等待线程，可以被同一个锁上notify唤醒。
不可以对不同锁中的线程进行唤醒

也就是说：等待和唤醒必须是同一个锁。

而锁可以是任意对象，所以可以被任意对象调用的方法定义在Object类中。

*/

/*
public final void notify()唤醒正在等待对象监视器的单个线程。 如果任何线程正在等待这个对象，其中一个被选择被唤醒。 选择是任意的，并且由实施的判断发生。 线程通过调用wait方法之一等待对象的监视器。 
唤醒的线程将无法继续，直到当前线程放弃此对象上的锁定为止。 唤醒的线程将以通常的方式与任何其他线程竞争，这些线程可能正在积极地竞争在该对象上进行同步; 例如，唤醒的线程在下一个锁定该对象的线程中没有可靠的权限或缺点。 

该方法只能由作为该对象的监视器的所有者的线程调用。 线程以三种方式之一成为对象监视器的所有者： 

通过执行该对象的同步实例方法。 
通过执行在对象上synchronized synchronized语句的正文。 
对于类型为Class,的对象，通过执行该类的同步静态方法。 
一次只能有一个线程可以拥有一个对象的显示器。 

异常 
IllegalMonitorStateException - 如果当前线程不是此对象的监视器的所有者。



public final void notifyAll()唤醒正在等待对象监视器的所有线程。 线程通过调用wait方法之一等待对象的监视器。 
唤醒的线程将无法继续，直到当前线程释放该对象上的锁。 唤醒的线程将以通常的方式与任何其他线程竞争，这些线程可能正在积极地竞争在该对象上进行同步; 例如，唤醒的线程在下一个锁定该对象的线程中不会有可靠的特权或缺点。 

该方法只能由作为该对象的监视器的所有者的线程调用。 有关线程可以成为监视器所有者的方法的说明，请参阅notify方法。

*/

















