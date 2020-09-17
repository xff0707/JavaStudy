package Day06.ALL;/*
���ģʽ:GOF 
java����23�����ģʽ
�������ģʽ�����һ�������ڴ���ֻ����һ������


��Ҫ��֤����Ψһ
1.Ϊ�˱�������������ཨ����������ȿ��ƾ�ֹ�����������������
2.��Ϊ��������������Է��ʵ��������ֻ���ڱ������Զ���һ������
3.Ϊ�˷�������������Զ������ķ��ʣ����Զ����ṩ���ʷ�ʽ

��������ô�ô��������أ�
1.�����캯��˽�л�
2.�����д���һ���������
3.�ṩһ���������Ի�ȡ���ö���


�����������ô��������ô������
����Ҫ��������Ķ���֤���ڴ���Ψһʱ���ͽ������������ϼ���
*/

class Single
{
	private int num;
	private Single(){}
	
	private static Single s = new Single();
	
	public void setnumber(int a)
	{
		num = a;
	}
	public int getnumber()
	{
		return num;
	}
	
	public static Single getInstance()
	{
		return s;
	}
}

class  SingleDemo
{
	public static void main(String[] args) 
	{
		
		Single ss = Single.getInstance();
		Single s1 = Single.getInstance();
		s1.setnumber(50);
		System.out.println(ss.getnumber());
		
		
	}
}


class Student
{
	private int age;
	
	private Student(){}
	private static Student a = new Student();
	public static Student getStudent()
	{
		return a;
	}
	
	public void setage(int age)
	{
		this.age = age;
	}
	public int getage(int age)
	{
		return age;
	}
	
	
}