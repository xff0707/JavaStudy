package javastudy25days.Day10;

/*
��һ�ָ�ʽ
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
�ڶ��ָ�ʽ
try
{
	��Ҫ�����Ĵ���;
}
catch(�쳣�� ����)//�����ж��
{
	�����쳣�Ĵ���;(����ʽ)
}
�����ָ�ʽ
try
{
	��Ҫ�����Ĵ���;
}

finally
{
	һ����ִ�����;
}
*/
//��סһ�㣺catch�����ڴ����쳣�����û��catch�ʹ����쳣û�б��������������쳣�Ǽ��ʱ�쳣����ô��������
class Demo6
{
	public void method() throws Exception {
		try
		{
			throw new Exception();
		}
		// catch(Exception e)
		// {
			// try
			// {
				// throw e;
			// }
			// catch()
			// {
				
			// }
		// }
		finally
		{
			
		}
	}
}

class ExceptionDemo6
{
	public static void main(String[] args)
	{
		System.out.println();
	}
}