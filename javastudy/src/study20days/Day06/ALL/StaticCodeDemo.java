package Day06.ALL;

/*
静态代码块
格式
static
{
	静态代码块执行语句
}
特点：随着类的加载而执行，只执行一次，并优先于main执行
用于给类进行初始化

*/
class StaticCode
{
	StaticCode()
	{
		System.out.println("b");
	}
	
	static
	{
		System.out.println("a");
	}
	{
		System.out.println("c");//构造代码块
	}
	
	StaticCode(int x)
	{
		System.out.println("s");
	}

	public static void show()
	{
		System.out.println("show run");
	}
}


class  StaticCodeDemo
{
	// static
	// {
		// System.out.println("b");
	// }
	public static void main(String[] args) 
	{
		new StaticCode(4);
		// new StaticCode();
		// new StaticCode();
		// System.out.println("Over!");
		// StaticCode.show();
		// StaticCode a = null;
		// a = new StaticCode();
	}
	// static
	// {
		// System.out.println("c");
	// }
}
// d:\>java StaticCodeDemo