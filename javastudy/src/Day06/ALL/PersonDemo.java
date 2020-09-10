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
		System.out.println(1+".静态代码块."+2);
	}
	
	{
		System.out.println(this.name+".构造代码块."+this.age);
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
		Person p = new Person("展望",50);
	}
}
/*
Person p = new Person("展望",50);

该句话都做了什么事？
1.因为new用到了Person.class，所以会找到Person.class文件并加载到内存中。
2.执行该类中的static代码块，如果有的话，给Person.class类进行初始化
3.在堆内存中开辟空间，分配内存地址
4.在堆内存中建立对象的特有属性，并进行默认初始化
5.对属性进行显式初始化
6.对对象进行构造代码块初始化
7.对对象进行与之对应的构造函数的初始化
8.将内存地址赋给占内存中的p变量



*/