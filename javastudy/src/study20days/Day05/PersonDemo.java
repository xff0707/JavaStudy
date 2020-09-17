package Day05;

/*
封装是指隐藏对象的属性和实现细节，仅对外提供公共访问方式
好处：
将变化隔离
便于使用
提高重用性
提高安全性
封装原则
将不需要对外提供的内容隐藏起来
把属性都隐藏，提供公共方法对其访问

函数本身是最小的封装体
类也是封装体
*/
/*
private
私有，权限修饰符，用于修饰类中的成员（成员变量，成员函数）
私有只在本类中有效

将age私有化后，类以外即使建立了对象也不能直接访问
但是人应给有年龄，就需要在Person类中提供对应访问age的方式

注意：私有仅仅是封装的一种表现形式


之所以对外提供访问方式，是因为可以在访问方式中加入逻辑判断等语句
对方问的数据进行操作，提高代码的健壮性
*/
class Person
{
	private int age;
	void speak()
	{
		System.out.println("age="+age);
	}
	public void setAge(int a)//设置年龄
	{
		if(a>0 && a<130)
		age = a;
		else
			System.out.println("feifa ang");
	}
	public int getAge()
	{
		return age;
	}
}

class PersonDemo
{
	public static void main(String[] args)
	{
		Person p = new Person();
		//p.age= 150;
		p.setAge(-10);
		p.speak();
	}
}