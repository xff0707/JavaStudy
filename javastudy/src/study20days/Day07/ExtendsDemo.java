package Day07;

/*
��ѧ���͹��˵Ĺ���������ȡ��������������������
ֻҪ��ѧ���͹����뵥��������������й�ϵ���Ϳ����ˡ�

�̳У�
1.����˴���ĸ����ԡ�
2.��������֮������˹�ϵ�����������ϵ�������˶�̬�����ԡ�


ע�⣺ǧ��ҪΪ�˻�ȡ������Ĺ��ܣ��򻯴�����̳�
������������֮����������ϵ�ſ��Լ̳У�������ϵ is a


class A extends C
{
	// void demo1(){}
	void demo2(){}
}
class B extends C
{
	// void demo1(){}
	void demo3(){}
}
class C
{
	void demo1(){}
}


java�����У�javaֻ֧�ֵ��̳У���֧�ֶ�̳�

��Ϊ��̳����״�����ȫ����������������ж�������ͬ���ܣ�
���������ݲ�ͬʱ���������ȷ��Ҫ������һ��
����java�������ֻ��ƣ�������һ��������ʽ����ɱ�ʾ����ʵ��


java֧�ֶ��̳У�Ҳ����һ���̳���ϵ

���ʹ��һ���̳���ϵ�еĹ����أ�

��Ҫʹ����ϵ���Ȳ�����ϵ�и������������Ϊ�����ж�����Ǹ���ϵ�еĹ��Թ���
ͨ���˽⹲�Թ��ܣ��Ϳ���֪������ϵ�Ļ�������
��ô�����ϵ�Ѿ����Ի���ʹ����
��ô�ھ������ʱ��Ҫ����������Ķ���Ϊʲô�أ�
һ����Ϊ�п��ܸ��಻�ܴ�������
���Ǵ�������������ʹ�ø���Ĺ��ܣ�����������Ҳ�������е�

��һ�仰�����ĸ��๦�ܣ������������ʹ�ù���


class A
{
	void show()
	{
		System.println("a");
	}
}
class B
{
	void show()
	{
		System.println("b");
	}
}
class C extends A,B
{}

C c = new C;
c.show;


�ۼ���has a

�ۺϣ�
�༶��ѧ��
��ϣ�
�ֻ�����
��������
*/
class Person
{
	String name;
	int age;
}

class Student1 extends Person
{
	void study()
	{
		System.out.println("Good Study");
	}
}

class Worker extends Person
{
	void work()
	{
		System.out.println("Good Work");
	}
}


class ExtendsDemo
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
