package Day09;/*
Exception����һ������������쳣RuntimeException����ʱ�쳣

����ں������׳����쳣�������Ͽ��Բ�������������һ��ͨ��

����ں����������˸��쳣�������߿��Բ��ý��д�������һ��ͨ��

֮���Բ����ں���������������Ϊ����Ҫ�õ����ߴ���
�����쳣������ϣ������ֹͣ����Ϊ������ʱ���������޷���������������ϣ��ֹͣ�����
�Դ����������




�Զ����쳣ʱ��������쳣�ķ������޷��ڼ������м���
�����Զ����쳣�̳�RuntimeException


�����쳣�����֣�
1.����ʱ�������쳣
	
2.����ʱ���������쳣(����ʱ�쳣��RuntimeException�Լ�������)

*/

class FuShuException3 extends RuntimeException
{
	FuShuException3(String msg)
	{
		super(msg);
	}
}



class Demo3
{
	int div(int a,int b)//throws ArithmeticException
	{
		if(b<0)
			throw new FuShuException3("�����˳���Ϊ������");
		if(b==0)
			throw new ArithmeticException("�������");
		return a/b;
	}
}
class ExceptionDemo3
{
	public static void main(String[] args)//throws Exception
	{
		Demo3 d = new Demo3();
		
		int x = d.div(4,-9);
		System.out.println("x="+x);
		System.out.println("Over");
	}
}

/*
class Person
{
	public void checkName(String name)
	{
		// if(name.equals("sa"))//NullPointerException
		if("sa".equals(name))//if(name!=null && name.equals("sa"))
			System.out.println("Yes");
		System.out.println("No");
	}
}

main()
{
	Person p = new Person();
	p.checkName(numm);
}
*/