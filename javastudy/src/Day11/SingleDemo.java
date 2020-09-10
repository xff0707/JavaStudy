package Day11;
/*
单例设计模式

称为：饿汉式。

Single类一进内存就已经创建好了对象
class Single
{
	private static final Single s = new Single();	
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}
*/

//懒汉式
//实例的延迟加载
class Single
{
	private static Single s = null;
	private Single(){}
	public static Single getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class)
			{
				if(s==null)
				{
					s = new Single();
				}
			}
		}
		return s;
		
	}

	public void setnumber(int i) {
	}

	public boolean getnumber() {
		return false;
	}
}

class  SingleDemo
{
	public static void main(String[] args) 
	{
		
		Single ss = Single.getInstance();
		Single s1 = Single.getInstance();
		s1.setnumber(50);
		System.out.println(ss.getnumber());
		
		
	}
}