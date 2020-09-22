package javastudy25days.Day07;

/*
3.子父类中的构造函数

在对子类对象进行初始化时，父类的构造函数也会运行
那是因为子类的构造函数默认第一行有一条隐式的语句 super();
super()：会访问父类中空参数的构造函数，而且子类中所有的构造函数默认第一行都是super();

为什么子类中一定要访问父类中的构造函数

因为父类中的数据子类可以直接获取，所以子类对象在建立时，需要先查看父类是如何对这些数据进行初始化的
所以子类在对象初始化时，要先访问一下父类中的构造函数
如果要访问子类中指定的构造函数，可以手动定义super语句来指定

注意：super语句一定定义在子类构造函数的第一行



子类的实例化过程
结论：
子类的所有的构造函数默认都会访问父类中空参数的构造函数，
因为子类每一个构造函数内的第一行都有一句隐式的super();

当父类中没有空参数的构造函数时，子类必须手动通过super语句形式来指定要访问父类的构造函数

当然：子类中的构造函数第一行也可以手动指定this语句来访问本类中的构造函数
子类中至少有一个构造函数会访问父类中的构造函数
*/
class Fu4 //extends Object
{
	int num = 10;
	Fu4()
	{
		// super();
		num = 60;
		System.out.println("Fu run");
	}
	Fu4(int x)
	{
		System.out.println("Fu run"+"..."+x);
	}
}

class Zi4 extends Fu4
{
	Zi4()
	{
		super();
		System.out.println("Zi run");
	}
	Zi4(int x)
	{
		super(x);//this();只能有一个
		System.out.println("Zi run"+"..."+x);
	}
}


class ExtendsDemo4
{
	public static void main(String[] args) 
	{
		Zi4 z = new Zi4();
		System.out.println(z.num);
		System.out.println("Hello World!");
		Zi4 z2 = new Zi4(2);
	}
}

// class Person
// {
	// private String name;
	// Person(String name)
	// {
		// this.name = name;
	// }
	// void show()
	// {
		
	// }
// }
// class Student extends Person
// {
	// Student(String name)
	// {
		// super(name);
	// }
	// void method()
	// {
		// super.show();
	// }
// }



