package Day09;/*
��Ϊ��Ŀ�л�������е�����
����Щ���Ⲣδ��java��������װ����
���Զ�һ��Щ���е�������԰���java�Ķ������װ��˼��
�����е����⣬�����Զ�����쳣��װ

�Զ����쳣

�����ڱ������У����ڳ���ʱ������Ҳ��Ϊʱ����ģ��޷����������
��ô����Ҫ�������������Զ��������

���ں����ڲ�������throw�׳��쳣������ô�ͱ���Ҫ������Ӧ�Ĵ�����
Ҫô���ڲ�try catch ����
Ҫô�ں����������õ����ߴ���

һ������ڣ������ڳ����쳣����������Ҫ����


���ִ�ӡ�Ľ����ֻ���쳣�����ƣ�ȴû���쳣����Ϣ
��Ϊ�Զ�����쳣��δ������Ϣ

��ζ����쳣��Ϣ�
��Ϊ�������Ѿ����쳣��Ϣ�Ĳ����������
��������ֻҪ�ڹ���ʱ�����쳣��Ϣ���ݸ�����ͨ��super���
��ô�Ϳ���ֱ��ͨ��getMessage������ȡ�Զ�����쳣��Ϣ



�Զ����쳣
�������Զ�����̳�Exception


�̳�Exceptionԭ��
�쳣��ϵ��һ���ص㣬��Ϊ�쳣����쳣������Ҫ�׳�
���Ƕ��߱������ԡ������������throwable�����ϵ�еĶ����ص�

ֻ�������ϵ�е���Ͷ���ſ��Ա�throws��throw����



throws��throw������
throwsʹ���ں�����
throwʹ���ں�����

throws����������쳣�࣬���Ը�������ö��Ÿ���
throw��������쳣����
*/

class FuShuException extends Exception//getMessage();
{
	private int val;
	
	FuShuException(String msg,int val)
	{
		super(msg);
		this.val = val;
	}
	int getVal()
	{
		return val;
	}
	/*
	private String msg;
	FuShuException(String msg)
	{
		this.msg = msg;
	}
	public String getMessage()
	{
		return msg;
	}
	*/
}

class Demo2
{
	int div(int a,int b)throws FuShuException
	{
		if(b<0)
			throw new FuShuException("�����˳���ʱ���������",b);//�ֶ�ͨ��throw�ؼ����׳�һ���Զ����쳣����
		
		
		return a/b;
	}
}


class ExceptionDemo2
{
	public static void main(String[] args)//throws Exception
	{
		Demo2 d = new Demo2();
		
		try
		{
			int x = d.div(4,-1);
			System.out.println("X="+x);
		}
		catch(FuShuException e)
		{
			System.out.println(e.toString());
			System.out.println("�������ָ�����");
			System.out.println("�����ֵΪ��"+e.getVal());
			// e.printStackTrace();
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