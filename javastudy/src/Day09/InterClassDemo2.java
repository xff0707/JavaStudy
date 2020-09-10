package Day09;/*
内部类访问规则：
1.内部类可以直接访问外部类中的成员，包括私有.
	之所以可以直接访问外部类中的成员，是因为内部类中持有了一个外部类的引用 格式：外部类名.this
2.外部类要访问内部类必须建立内部类对象

访问格式：
当内部类定义在外部类的成员位置上，而且非私有，可以在外部其他类中
可以直接建立内部类对象
格式：
	外部类名.内部类名 变量名 = 外部类对象.内部类对象
	Outer.Inter in = new Outer().new Inter();
	
2.当内部类在成员位置上，就可以被成员修饰符修饰
	比如：private：将内部类在外部类中进行封装
		static：内部类就具备static的特性
		当内部类被static修饰后，只能直接访问外部类中的static成员，出现了访问局限
		
		在外部其他类中，如何直接访问static内部类的非静态成员呢？
		new Outer.Inter().function();
		
		在外部其他类中，如何直接访问static内部类的静态成员呢？
		Outer.Inter.function();
	
	注意：当内部类中定义了静态成员，该内部类必须是static的
			当外部类中的静态方法访问内部类时，内部类也必须是static的

			
			

当描述事物时，事物的内部还有事物，该事物用内部类来描述，
因为内部事物在使用外部类事物的内容

class Body
{
	
	private class Xinzang
	{
			
	}
	
	public void show()
	{
		new Xinzang();
	}
}



*/

class Outer
{
	private static int x = 3;
	
	
	static class Inter//内部类，静态
	{
		// int x = 5;
		static void function()
		{
			// int x = 6;
			System.out.println("Inter :"+x);
			// System.out.println("Inter :"+this.x);
			// System.out.println("Inter :"+Outer.this.x);
		}		
	}
	
	static class Inter2
	{
		void show()
		{
			System.out.println("2Show");
		}
	}
	
	
	public static void method()
	{
		// Inter in = new Inter();
		// in.function();
		// System.out.println("");
		// Inter.function();
		new Inter2().show();//需要将Inter2静态
	}
}

class InterClassDemo2
{
	public static void main(String[] args)
	{
		// Outer out = new Outer();
		// out.method();
		
		//直接访问内部类中的成员
		// Outer.Inter in = new Outer().new Inter();
		// in.function();
		
		//Outer.Inter.function();
		
		Outer.method();
	}
}