package javastudy25days.Day07;/*
2.�Ӹ����еĺ�����

��������ֺ͸���һģһ���ĺ���ʱ��
�����������øú��������������ຯ�������ݡ�
��ͬ����ĺ���������һ��

�������ʱ��������һ�����ԣ���д(����)


������̳и��࣬��Ϯ�˸���Ĺ��ܣ��������У�
����������߱��ù��ܣ���ʮ���ܵ����ݺ͸��಻һ�£�
��ʱ��û�б�Ҫ�����¹��ܣ�����ʹ�ø������ԣ���������Ĺ��ܶ��壬����д��������


���ǣ�
1.���า�Ǹ��࣬���뱣֤����Ȩ�޴��ڵ��ڸ���Ȩ�ޣ��ſ��Ը��ǣ��������ʧ��

2.��ֻ̬�ܸ��Ǿ�̬


��ס��ң�
���أ�ֻ��ͬ�������Ĳ����б�
��д���Ӹ���ķ���Ҫһģһ��

*/


class Fu3
{
	void show1()
	{
		System.out.println("Fu show");
	}
	void speak()
	{
		System.out.println("VB");
	}
}

class Zi3 extends Fu3
{
	void show2()
	{
		System.out.println("Zi show");
	}
	void speak()
	{
		System.out.println("JAVA");
	}
}


class ExtendsDemo3
{
	public static void main(String[] args) 
	{
		Zi3 z = new Zi3();
		z.show2();
		z.show1();
		System.out.println("Hello World!");
		z.speak();
	}
}


class Tel
{
	void show()
	{
		System.out.println("number");
	}
}

class NewTel extends Tel
{
	void show()
	{
		super.show();
		System.out.println("music");
		System.out.println("name");
		System.out.println("pic");
	}
}