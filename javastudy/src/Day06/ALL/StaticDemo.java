package Day06.ALL;

/*
静态：static
用法：是一个修饰符，用于修饰成员（成员变量，成员函数）
当成员被静态修饰后，就多了一个调用方式，除了可以被对象调用外，
还可以直接被类名调用，类名.静态成员

方法区，共享区，数据区


static特点
1.静态随着类的加载而加载
2.优先于对象存在
3.被所有对象共享
4.可以直接被类名调用

静态的注意事项
1.静态方法只能访问静态成员
   非静态方法既可以访问静态也可以访问非静态
2.静态方法中不可以定义this、super关键字
    因为静态优先于对象存在，所以静态方法中不可以出现this
3.主函数是静态的

静态有利有弊
利处：对对象的共享数据单独空间的存储
     可以直接被类名调用
弊端：生命周期过长
      访问出现局限性（静态虽好，只能访问静态）	 
*/
class Person1
{
	String name;
	static String country = "CN";
	public static void show()
	{
		System.out.println("country="+country);
	}
}
class  StaticDemo
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		Person1 p = new Person1();
		p.name="赤井心";
		p.show();
		Person1.show();
	}
}
