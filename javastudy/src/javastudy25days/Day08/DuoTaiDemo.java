package javastudy25days.Day08;/*
��̬���������Ϊ������ڵĶ���������̬

�ˣ����ˣ�Ů��

���è����

è x = new è();

���� x = new è();

1.��̬������
	���������ָ�����Լ����������
	���������Ҳ���Խ����Լ����������
2.��̬��ǰ��
	�������������й�ϵ��Ҫô�̳У�Ҫôʵ��
3.��̬�ĺô�
	��̬�ĳ��ִ�����߳������չ��
	ͨ������һ��ǰ�᣺���Ǵ��ڸ���
		�׶�
	�������չ�ԣ�����ֻ��ʹ�ø�������÷��ʸ����еĳ�Ա
4.��̬��Ӧ��

*/

/*
����
è����

*/
abstract class Animal
{
	abstract void eat();
}
class Cat extends Animal
{
	public void eat()
	{
		System.out.println("����");
	}
	public void catchMouse()
	{
		System.out.println("ץ����");
	}
}
class Dog extends Animal
{
	public void eat()
	{
		System.out.println("�Թ�ͷ");
	}
	public void kanJia()
	{
		System.out.println("����");
	}
}

class Pig extends Animal
{
	public void eat()
	{
		System.out.println("����");
	}
	public void gongDi()
	{
		System.out.println("����");
	}
}

class DuoTaiDemo
{
	public static void main(String[] args)
	{
		/*
		Cat c = new Cat();
		c.eat();
		
		Dog d = new Dog();
		d.eat();
		*/
		
		/*
		function(new Cat());
		function(new Dog());
		function(new Pig());
		*/
		
		//Animal c = new Cat();
		//c.eat();
		
		function(new Cat());
		function(new Dog());
		function(new Pig());

		Animal a = new Cat();
		System.out.println(a);
		Cat c = (Cat)a;//a��c����Cat���ͣ���ͬһ��������Ϊֻ��һ��new
		System.out.println(a);
		System.out.println(c);
	}
	/*
	public static void function(Cat c)
	{
		c.eat();
	}
	public static void function(Dog d)
	{
		d.eat();
	}
		public static void function(Pig p)
	{
		p.eat();
	}
	*/
	public static void function(Animal a)//Animal a = new Cat();
	{
		a.eat();
	}
	
}