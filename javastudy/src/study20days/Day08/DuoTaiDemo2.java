package Day08;/*
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
	
4		�׶�
	�������չ�ԣ�����ֻ��ʹ�ø�������÷��ʸ����еĳ�Ա
	
5.��̬��Ӧ��

6.��̬�ĳ��ִ����е��ص�(��̬ʹ�õ�ע������)

*/

/*
����
è����

*/
abstract class Animal2
{
	abstract void eat();
}
class Cat2 extends Animal2
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
class Dog2 extends Animal2
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

class Pig2 extends Animal2
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

class DuoTaiDemo2
{
	public static void main(String[] args)
	{
		/*
		Cat a= new Cat();//����������	����ת��
		//byte b = 2; int x = b;
		a.eat();
		
		//�����Ҫ����è�����з���ʱ����β�����
		//ǿ�ƽ���������ã�ת���������͡�����ת��
		Cat c = (Cat)a;
		c.catchMouse();
		//ǧ��Ҫ���������Ĳ��������ǽ��������ת��������
		//������ת�����Ǹ���Ӧ��ָ�����Լ���������󣬸�Ӧ�ÿ��Ա�������Ҳ���Ա�ǿ��ת��
		//��̬��ʼ���ն���������������ű仯��
		// Animal a = new Animal();
		// Cat c = (Cat)a;�����ԣ�
		
		*/
		function(new Dog2());
	}

	public static void function(Animal2 a)//Animal a = new Cat();
	{
		a.eat();
		// Cat c = (Cat)a;
		// c.catchMouse();
		/*
		if(a instanceof Animal)
		{
			System.out.println("FFF");
		}
		*/
		if(a instanceof Cat2)
		{
			Cat2 c = (Cat2)a;
			c.catchMouse();
		}
		if(a instanceof Dog2)
		{
			Dog2 d = (Dog2)a;
			d.kanJia();
		}
		if(a instanceof Pig2)
		{
			Pig2 p = (Pig2)a;
			p.gongDi();
		}
		
	}
}