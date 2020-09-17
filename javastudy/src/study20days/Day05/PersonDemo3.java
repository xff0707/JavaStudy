package Day05;

/*
this关键字看上去是用于区分局部变量和成员变量重名的情况
this为什么可以解决这个问题
this到底代表是什么呢？

this:就代表本类的对象，到底代表哪一个呢？
	this代表它所在函数所属对象的引用
	简单说：哪个对象在调用this所在的函数，this就代表哪个对象

*/
class Person3
{
	private String name;
	private int age;
	Person3()
	{
		System.out.println("A:name="+name+",age="+age);
		// cry();
	}
	Person3(String name)
	{
		this.name = name;
		System.out.println("B:name="+name+",age="+age);
		// cry();
	}
	Person3(String name,int a)
	{
		this.name = name;
		age = a;
		System.out.println("C:name="+name+",age="+age);
		// cry();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	
		public void setAge(int a)
	{
		age = a;
	}
	public int getAge()
	{
		return age;
	}

	public void speak()
	{
		System.out.println("B:name="+name+",age="+age);
	}
	/*
	需求：给人定义一个比较年龄是否相同的功能，也就是是否是同龄人
	*/
	public boolean compare(Person3 p)
	{
		return p.getAge()==this.getAge();
	}
}
 
class PersonDemo3
{
	public static void main(String[] args)
	{
		Person3 p1 = new Person3("liza",15);
		// p1.cry();
		// p1.setName("libusi");
		// System.out.println(p1.getName());
		
		// Person p2 = new Person("lisi");
		
		Person3 p3 = new Person3("wangwu",10);
		boolean b = p1.compare(p3);
		System.out.println(b);
		
	}
}