package javastudy25days.Day07;

/*
3.�Ӹ����еĹ��캯��

�ڶ����������г�ʼ��ʱ������Ĺ��캯��Ҳ������
������Ϊ����Ĺ��캯��Ĭ�ϵ�һ����һ����ʽ����� super();
super()������ʸ����пղ����Ĺ��캯�����������������еĹ��캯��Ĭ�ϵ�һ�ж���super();

Ϊʲô������һ��Ҫ���ʸ����еĹ��캯��

��Ϊ�����е������������ֱ�ӻ�ȡ��������������ڽ���ʱ����Ҫ�Ȳ鿴��������ζ���Щ���ݽ��г�ʼ����
���������ڶ����ʼ��ʱ��Ҫ�ȷ���һ�¸����еĹ��캯��
���Ҫ����������ָ���Ĺ��캯���������ֶ�����super�����ָ��

ע�⣺super���һ�����������๹�캯���ĵ�һ��



�����ʵ��������
���ۣ�
��������еĹ��캯��Ĭ�϶�����ʸ����пղ����Ĺ��캯����
��Ϊ����ÿһ�����캯���ڵĵ�һ�ж���һ����ʽ��super();

��������û�пղ����Ĺ��캯��ʱ����������ֶ�ͨ��super�����ʽ��ָ��Ҫ���ʸ���Ĺ��캯��

��Ȼ�������еĹ��캯����һ��Ҳ�����ֶ�ָ��this��������ʱ����еĹ��캯��
������������һ�����캯������ʸ����еĹ��캯��
*/
class Fu4 //extends Object
{
	int num = 10;
	Fu4()
	{
		// super();
		num = 60;
		System.out.println("Fu run");
	}
	Fu4(int x)
	{
		System.out.println("Fu run"+"..."+x);
	}
}

class Zi4 extends Fu4
{
	Zi4()
	{
		super();
		System.out.println("Zi run");
	}
	Zi4(int x)
	{
		super(x);//this();ֻ����һ��
		System.out.println("Zi run"+"..."+x);
	}
}


class ExtendsDemo4
{
	public static void main(String[] args) 
	{
		Zi4 z = new Zi4();
		System.out.println(z.num);
		System.out.println("Hello World!");
		Zi4 z2 = new Zi4(2);
	}
}

// class Person
// {
	// private String name;
	// Person(String name)
	// {
		// this.name = name;
	// }
	// void show()
	// {
		
	// }
// }
// class Student extends Person
// {
	// Student(String name)
	// {
		// super(name);
	// }
	// void method()
	// {
		// super.show();
	// }
// }



