package Day09;/*
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
	
	
�ں����������쳣
������߰�ȫ�ԣ��õ��ô����д������������ʧ��



�Զ��쳣�Ĵ���

1.�����쳣ʱ������������Ϊ������쳣����������Ŀ��Ը�����
2.�Է������м����쳣���Ͷ�Ӧ�м���catch�飬��Ҫ��������catch��
	������catch���е��쳣���ּ̳й�ϵ�������쳣catch�����������

	
�����ڽ���catch����ʱ��catch��һ��Ҫ������崦��ʽ��
��Ҫ�򵥶�������e.printStackTrace()
Ҳ��Ҫ�򵥵ľ���дһ��������

�쳣��־
*/

class Demo1
{
	int div(int a,int b)throws ArithmeticException,ArrayIndexOutOfBoundsException//�ڹ�����ͨ��throws�����˸ù����п��ܻ��������
	{
		
		int[] arr = new int[a];
		
		System.out.println(arr[4]);
		return a/b;
	}
}


class ExceptionDemo1
{
	public static void main(String[] args)//throws Exception
	{
		Demo1 d = new Demo1();
		
		try
		{
			int x = d.div(4,1);
			System.out.println("X="+x);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		/*
		catch(ArithmeticException e)//Exception e = new ArithmeticException();
		{
			System.out.println("������");
			//System.out.println(e.getMessage());//   / by zero
			System.out.println(e.toString());//		�쳣���ƣ��쳣��Ϣ
			
			//e.printStackTrace();//�쳣���ƣ��쳣��Ϣ���쳣���ֵ�λ��
								//��ʵjvmĬ�ϵ��쳣������ƣ������ڵ���printStackTrace����
								//��ӡ�쳣�Ķ�ջ��Ϣ
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("�Ǳ�Խ����");
			System.out.println(e.toString());
		}
		*/
		System.out.println("Over");
		
	}
}