package Day06.ALL;

class Person
{
	private String name = "zhangli";
	private int age;
	private static String country = "cn";
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	static
	{
		System.out.println(1+".��̬�����."+2);
	}
	
	{
		System.out.println(this.name+".��������."+this.age);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void speak()
	{
		System.out.println(this.name+"..."+this.age);
	}
	
	public static void showCountry()
	{
		System.out.println("Country="+country);
	}
}


class  PersonDemo
{
	public static void main(String[] args) 
	{
		Person p = new Person("չ��",50);
	}
}
/*
Person p = new Person("չ��",50);

�þ仰������ʲô�£�
1.��Ϊnew�õ���Person.class�����Ի��ҵ�Person.class�ļ������ص��ڴ��С�
2.ִ�и����е�static����飬����еĻ�����Person.class����г�ʼ��
3.�ڶ��ڴ��п��ٿռ䣬�����ڴ��ַ
4.�ڶ��ڴ��н���������������ԣ�������Ĭ�ϳ�ʼ��
5.�����Խ�����ʽ��ʼ��
6.�Զ�����й��������ʼ��
7.�Զ��������֮��Ӧ�Ĺ��캯���ĳ�ʼ��
8.���ڴ��ַ����ռ�ڴ��е�p����



*/