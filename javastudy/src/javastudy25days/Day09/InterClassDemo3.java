package javastudy25days.Day09;/*
内部类定义在局部时
1.不可以被成员修饰符修饰
2.可以直接访问外部类中的成员，因为还有外部类中的引用
	但是不可以访问它所在的局部中的变量，只能访问被final修饰的局部变量
*/

class Outer3
{
	int x = 3;
	
	void method(final int a)
	{
		int y = 4;//从内部类中访问局部变量y，需要被声明为最终类型
		class Inter//局部内部类不能有静态成员
		{
			void function()
			{
				System.out.println(a);
			}
		}
		new Inter().function();//不能放前边
	}
}

class InterClassDemo3
{
	public static void main(String[] args)
	{
		
		// new Outer().method();
		
		Outer3 out = new Outer3();
		out.method(7);
		out.method(8);
	}
}