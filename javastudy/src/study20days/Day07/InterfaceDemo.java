package Day07;/*
�ӿڣ�������⣬������Ϊ��һ������ĳ�����
	 ���������еķ������ǳ���ģ���ô�������ͨ���ӿڵ���ʽ����ʾ
class ���ڶ�����
interface ���ڶ���ӿ�

�ӿڶ���ʱ����ʽ�ص㣺
1.�ӿ��г������壺���������󷽷�
2.�ӿ��еĳ�Ա���й̶����η�������ʡ�ԣ�
	������public static final
	������public abstract
�ӿ��еĳ�Ա����public��


�ӿ��ǲ����Դ�������ģ���Ϊ�г��󷽷�
��Ҫ������ʵ�֣�����Խӿ��еĳ��󷽷�ȫ�����Ǻ�����ſ���ʵ����
����������һ��������

�ӿڿ��Ա����ʵ�֣�Ҳ�ǶԶ�̳в�֧�ֵ�ת����ʽ��java֧�ֶ�ʵ��

*/

interface Inter2//Ҳ����class�ļ�
{
	public static final int NUM = 3;
	public abstract void show();
}

interface InterA
{
	public abstract void show1();
}

class Demo2
{
	public void function(){}
}

class Test extends Demo2 implements Inter2,InterA
{
	public void show(){}
	public void show1(){}
}

interface A
{
	void methodA();
}

interface B extends A
{
	void methodB();
}

interface C extends B,A//�ӿ���ӿ�֮��֧�ֶ�̳�
{
	void methodC();
}

class D implements C
{
	public void methodA(){}
	public void methodB(){}
	public void methodC(){}
}


class InterfaceDemo
{
	public static void main(String[] args)
	{
		Test t = new Test();
		System.out.println(t.NUM);
		System.out.println(Test.NUM);
		System.out.println(Inter2.NUM);
		
		//t.NUM = 5;//�����ԣ�
	}
}