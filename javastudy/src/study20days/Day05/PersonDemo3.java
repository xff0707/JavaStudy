package Day05;

/*
this�ؼ��ֿ���ȥ���������־ֲ������ͳ�Ա�������������
thisΪʲô���Խ���������
this���״�����ʲô�أ�

this:�ʹ�����Ķ��󣬵��״�����һ���أ�
	this���������ں����������������
	��˵���ĸ������ڵ���this���ڵĺ�����this�ʹ����ĸ�����

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
	���󣺸��˶���һ���Ƚ������Ƿ���ͬ�Ĺ��ܣ�Ҳ�����Ƿ���ͬ����
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