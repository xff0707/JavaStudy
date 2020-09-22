package javastudy25days.Day08;/*
Object：是所有对象的直接后者间接父类，传说中的上帝
该类中定义了所有对象中都具有的功能



Object类中已经提供了对对象是否相同的比较方法

如果自定义类中也有比较相同的功能，没有必要重新定义
只要演习父类中的功能，建立自己特有的比较内容即可，这就是覆盖
*/


class Demo2 //extends Object
{
	// Demo()
	// {
		// super();
	// }
	private int num;
	Demo2(int num)
	{
		this.num = num;
	}
	// public boolean compare(Demo d)
	// {
		// return this.num==d.num;
	// }
	public boolean equals(Object obj)//Object obj = new Demo();
	{
		if(!(obj instanceof Demo2))
			return false;//抛出异常
		Demo2 d = (Demo2)obj;
		return this.num==d.num;
	}
	// public String toString()
	// {
		// return "demo:"+num;
	// }
}
class Person2
{
	
}

class ObjectDemo //extends  Object
{
	public static void main(String[] args)
	{
		// Demo d1 = new Demo();
		// Demo d2 = new Demo();
		// Demo d3 = d1;
		
		// System.out.println(d1.equals(d3));
		// System.out.println(d1==d2);
		// System.out.println(d1==d3);
		
		// Person p1 = new Person();
		// Person p2 = new Person();
		
		// System.out.println("Person:"+p1.equals(p2));
		
		Demo2 d1 = new Demo2(4);
		// Demo d2 = new Demo(54);
		// Person p1 = new Person();
		// System.out.println(d1.compare(d2));
		// System.out.println(d1.equals(p1));
		
		
		
		//Class c = d1.getClass();
		//////c.getMethods();
		// System.out.println(c.getName());
		// System.out.println(c.getName()+"@@"+Integer.toHexString(d1.hashCode()));
		System.out.println(d1.toString());
		// System.out.println(Integer.toHexString(d1.hashCode()));
	}
}