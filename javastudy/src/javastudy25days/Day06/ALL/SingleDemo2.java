package javastudy25days.Day06.ALL;
/*
这个是先初始化对象。
称为：饿汉式。

Single类一进内存就已经创建好了对象
class Single
{
	private static Single s = new Single();	
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}
*/

//对象是方法被调用的时候才初始化，也叫做对象的延时加载，称为：懒汉式
//Single类进内存对象还没有存在，只有调用了get方法时才建立对象
class Single2
{
	private static Single2 s = null;
	private Single2(){}
	public static Single2 getInstance()//可以加synchronized锁，但是效率低
	{
		if(s==null)
		{
			synchronized(Single2.class)
			{
				if(s==null)
					s = new Single2();
			}
		}
		
		return s;
	}
}

//记录原则：定义单例，建议使用饿汉式
class  SingleDemo2
{
	public static void main(String[] args) 
	{
		
		Single ss = Single.getInstance();
		Single s1 = Single.getInstance();
		s1.setnumber(50);
		System.out.println(ss.getnumber());
		
		
	}
}