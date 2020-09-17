package Day09;/*


*/

interface Inter1
{
	void method();
}

class Test1
{
	//补足代码，通过匿名内部类
	
	// static class Inner implements Inter
	// {
		// public void method()
		// {
			// System.out.println("Fuc");
		// }
	// }
	
	static Inter1 function()
	{
		return new Inter1()
		{
			public void method()
			{
				System.out.println("Fuc");
			}
		};
	}
}

class InterClassTest
{
	public static void main(String[] args)
	{
		//Test.function()：Test类中有一个静态方法function
		//.method()：function这个方法运算后的结果时一个对象，而且是一个Inter类型的对象
		//因为只有是Inter类型的对象才可以调用method方法
		Test1.function().method();
		
		//相当于
		// Inter in = new Test.function();
		// in.method();
		
		show(new Inter1()
		{
			public void method()
			{
				System.out.println("FucK");
			}
		});
	}
	
	public static void show(Inter1 in)
	{
		in.method();
	}
}

class InterTest
{
	public static void main(String[] args)
	{
		new Object()
		{
			public void function()
			{
				System.out.println("别装了");
			}
		}.function();
	}
}