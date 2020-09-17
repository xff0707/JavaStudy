package Day06.ALL;/*
设计模式:GOF 
java中有23中设计模式
单例设计模式：解决一个类在内存中只存在一个对象


想要保证对象唯一
1.为了避免其他程序过多建立该类对象，先控制静止其他程序建立该类对象
2.还为了让其他程序可以访问到该类对象，只好在本类中自定义一个对象
3.为了方便其他程序对自定义对象的访问，可以对外提供访问方式

这三步怎么用代码体现呢？
1.将构造函数私有化
2.在类中创建一个本类对象
3.提供一个方法可以获取到该对象


对于事物该怎么描述还怎么描述，
当需要将该事物的对象保证在内存中唯一时，就将以上三步加上即可
*/

class Single
{
	private int num;
	private Single(){}
	
	private static Single s = new Single();
	
	public void setnumber(int a)
	{
		num = a;
	}
	public int getnumber()
	{
		return num;
	}
	
	public static Single getInstance()
	{
		return s;
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


class Student
{
	private int age;
	
	private Student(){}
	private static Student a = new Student();
	public static Student getStudent()
	{
		return a;
	}
	
	public void setage(int age)
	{
		this.age = age;
	}
	public int getage(int age)
	{
		return age;
	}
	
	
}