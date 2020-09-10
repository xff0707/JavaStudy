package Day05;

/*
this语句用于构造函数之间的互相调用

this语句只能定义在构造函数的第一行，因为初始化要先执行
*/
class Person4
{
	private String name;
	private int age;
	
	
	Person4()
	{
		// cry();
		speak();
	}
	Person4(String name)
	{
		this();
		this.name = name;
		// cry();
	}
	Person4(String name,int age)
	{
		this(name);
		this.age = age;
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
	public boolean compare(Person4 p)
	{
		return p.getAge()==this.getAge();
	}
}
 
class PersonDemo4
{
	public static void main(String[] args)
	{
		Person4 p1 = new Person4("liza",15);
		// p1.cry();
		// p1.setName("libusi");
		// System.out.println(p1.getName());
		
		// Person p2 = new Person("lisi");
		
		Person4 p3 = new Person4("wangwu",10);
		// boolean b = p1.compare(p3);
		// System.out.println(b);
		
	}
}