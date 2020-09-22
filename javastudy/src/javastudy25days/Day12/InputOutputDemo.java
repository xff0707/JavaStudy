package javastudy25days.Day12;

/*
�̼߳�ͨѶ��
��ʵ���Ƕ���߳��ڲ���ͬһ����Դ��
���ǲ����Ķ�����ͬ��

*/
class Res
{
	String name;
	String sex;
	boolean flag = false;
}

class Input implements Runnable
{
	private Res r;
	// Object obj = new Object();
	Input(Res r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			synchronized(r)
			{
				if(r.flag)
					try{r.wait();}catch(Exception e){}
				if(x==0)
				{
					r.name = "mike";
					r.sex = "man";
				}
				else
				{
					r.name = "����";
					r.sex = "ŮŮŮŮŮ";
				}
				x = (x+1)%2;
				r.flag = true;
				r.notify();
			}
		}
	}
}

class Output implements Runnable
{
	private Res r;
	// Object obj = new Object();
	Output(Res r)
	{
		this.r = r;
	}
	
	public void run()
	{
		while(true)
		{
			synchronized(r)
			{
				if(!r.flag)
					try{r.wait();}catch(Exception e){}
				else
				{
					System.out.println(r.name+"..."+r.sex);
					r.flag = false;
					r.notify();
				}
			}
		}
	}
}

class InputOutputDemo
{
	public static void main(String[] args)
	{
		Res r = new Res();
		
		Input in = new Input(r);
		Output out = new Output(r);
		
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		
		t1.start();
		t2.start();
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

















