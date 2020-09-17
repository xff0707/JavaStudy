package Day12;

/*
�̼߳�ͨѶ��
��ʵ���Ƕ���߳��ڲ���ͬһ����Դ��
���ǲ����Ķ�����ͬ��

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
				r.set("����","ŮŮŮŮŮ");
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
		// System.out.println("������");
	}
}

/*
wait
notify
notifyAll

��ʹ����ͬ���У���ΪҪ�Լ�����(��)���̲߳�����
����Ҫʹ����ͬ���У���Ϊֻ��ͬ���ž�������

Ϊʲô��Щ�����̵߳ķ���Ҫ������Object���أ�
��Ϊ��Щ�����ڲ���ͬ�����߳�ʱ��������Ҫ��ʶ�����������߳�ֻ�е�����
ֻ��ͬһ�����ϵı��ȴ��̣߳����Ա�ͬһ������notify���ѡ�
�����ԶԲ�ͬ���е��߳̽��л���

Ҳ����˵���ȴ��ͻ��ѱ�����ͬһ������

��������������������Կ��Ա����������õķ���������Object���С�

*/

/*
public final void notify()�������ڵȴ�����������ĵ����̡߳� ����κ��߳����ڵȴ������������һ����ѡ�񱻻��ѡ� ѡ��������ģ�������ʵʩ���жϷ����� �߳�ͨ������wait����֮һ�ȴ�����ļ������� 
���ѵ��߳̽��޷�������ֱ����ǰ�̷߳����˶����ϵ�����Ϊֹ�� ���ѵ��߳̽���ͨ���ķ�ʽ���κ������߳̾�������Щ�߳̿������ڻ����ؾ����ڸö����Ͻ���ͬ��; ���磬���ѵ��߳�����һ�������ö�����߳���û�пɿ���Ȩ�޻�ȱ�㡣 

�÷���ֻ������Ϊ�ö���ļ������������ߵ��̵߳��á� �߳������ַ�ʽ֮һ��Ϊ����������������ߣ� 

ͨ��ִ�иö����ͬ��ʵ�������� 
ͨ��ִ���ڶ�����synchronized synchronized�������ġ� 
��������ΪClass,�Ķ���ͨ��ִ�и����ͬ����̬������ 
һ��ֻ����һ���߳̿���ӵ��һ���������ʾ���� 

�쳣 
IllegalMonitorStateException - �����ǰ�̲߳��Ǵ˶���ļ������������ߡ�



public final void notifyAll()�������ڵȴ�����������������̡߳� �߳�ͨ������wait����֮һ�ȴ�����ļ������� 
���ѵ��߳̽��޷�������ֱ����ǰ�߳��ͷŸö����ϵ����� ���ѵ��߳̽���ͨ���ķ�ʽ���κ������߳̾�������Щ�߳̿������ڻ����ؾ����ڸö����Ͻ���ͬ��; ���磬���ѵ��߳�����һ�������ö�����߳��в����пɿ�����Ȩ��ȱ�㡣 

�÷���ֻ������Ϊ�ö���ļ������������ߵ��̵߳��á� �й��߳̿��Գ�Ϊ�����������ߵķ�����˵���������notify������

*/

















