package javastudy25days.Day10;/*
��һ��Բ�κͳ����Ρ�
�����Ի�ȡ������������������ַǷ�����ֵ����Ϊ�ǻ�ȡ�����������
����ͨ���쳣����ʾ
���ж��������Ļ������

*/
// import java.awt.Point;//�Լ���

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
			throw new NoValueException("���ַǷ�ֵ");
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
			throw new NoValueException("�Ƿ�");
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
		
		
		
		
		
		//�Լ���
		// Point p = new Point(10,20);
		// p.setLocation(3.1415,3.6514);
		// System.out.println(p.toString());�Լ���
	}
}