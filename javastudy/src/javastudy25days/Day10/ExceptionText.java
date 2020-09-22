package javastudy25days.Day10;/*
有一个圆形和长方形。
都可以获取面积，对于面积如果出现非法的数值，视为是获取面积出现问题
问题通过异常来表示
现有对这个程序的基本设计

*/
// import java.awt.Point;//自己玩

class NoValueException extends RuntimeException
{
	NoValueException(String msg)
	{
		super(msg);
	}
}

interface Shape
{
	void getArea();
}

class Rec implements Shape
{
	private int len,wid;
	
	Rec(int len,int wid)//throws NoValueException
	{
		if(len<=0 || wid<=0)
			throw new NoValueException("出现非法值");
		else
		{
			this.len = len;
			this.wid = wid;
		}
	}
	
	public void getArea()
	{
		System.out.println(len*wid);
	}
}

class Circle implements Shape
{
	private int radius;
	public static final double PI = 3.14;
	Circle(int radius)
	{
		if(radius<=0)
			throw new NoValueException("非法");
		this.radius = radius;
	}
	
	public void getArea()
	{
		System.out.println(radius*radius*PI);
	}
}

class ExceptionText
{
	public static void main(String[] args)
	{
		// Rec r = new Rec(-3,4);
		// r.getArea();
		// try
		// {
			// Rec r = new Rec(-3,4);
			// r.getArea();
		// }
		// catch(NoValueException e)
		// {
			// System.out.println(e.toString());
		// }
		// System.out.println("Over");
		
		Circle c = new Circle(8);
		c.getArea();
		
		
		
		
		
		//自己玩
		// Point p = new Point(10,20);
		// p.setLocation(3.1415,3.6514);
		// System.out.println(p.toString());自己玩
	}
}