package javastudy25days.Day09;
/*
�쳣�����ǳ���������ʱ���ֲ����������
�쳣����������Ҳ����ʾ�����о�������Ҳ����ͨ��java�����ʽ��������������װ�ɶ���
		��ʵ����java�Բ������������������Ķ������֡�

��������Ļ��֣�һ�������ص����⣬һ���Ƿ����ص�����

�������صģ�javaͨ��Error���������
	����Error��һ�㲻��д����Դ��������д���
	
���ڷ����صģ�Javaͨ��Exception���������
	����Exception����ʹ������ԵĴ���ʽ���д���

����Error����Exception������һЩ�������ݡ�
���磬�������������Ϣ������ԭ��ȡ�

Throwable	
	|--Error
	|--Exception
	
	
	
	
2.�쳣�Ĵ���

java �ṩ�����е������д���
try
{
	��Ҫ�����Ĵ���;
}
catch(�쳣�� ����)
{
	�����쳣�Ĵ���;(����ʽ)
}
finally
{
	һ����ִ�����;
}


3.�Բ��񵽵��쳣������г�����������
	String getMessage();��ȡ�쳣��Ϣ
	
	
	

*/

class Demo
{
	int div(int a,int b)
	{
		return a/b;
	}
}


class ExceptionDemo
{
	public static void main(String[] args)
	{
		Demo d = new Demo();
		try
		{
			int x = d.div(4,1);
			System.out.println("X="+x);
		}
		catch(Exception e)//Exception e = new ArithmeticException();
		{
			System.out.println("������");
			System.out.println(e.getMessage());//   / by zero
			System.out.println(e.toString());//		�쳣���ƣ��쳣��Ϣ
			
			e.printStackTrace();//�쳣���ƣ��쳣��Ϣ���쳣���ֵ�λ��
								//��ʵjvmĬ�ϵ��쳣������ƣ������ڵ���printStackTrace����
								//��ӡ�쳣�Ķ�ջ��Ϣ
		}
		
		
		System.out.println("Over");
		
		// byte[] arr = new byte[1024*1024*600];�ڴ治���쳣
	}
}