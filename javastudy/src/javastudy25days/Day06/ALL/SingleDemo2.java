package javastudy25days.Day06.ALL;
/*
������ȳ�ʼ������
��Ϊ������ʽ��

Single��һ���ڴ���Ѿ��������˶���
class Single
{
	private static Single s = new Single();	
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}
*/

//�����Ƿ��������õ�ʱ��ų�ʼ����Ҳ�����������ʱ���أ���Ϊ������ʽ
//Single����ڴ����û�д��ڣ�ֻ�е�����get����ʱ�Ž�������
class Single2
{
	private static Single2 s = null;
	private Single2(){}
	public static Single2 getInstance()//���Լ�synchronized��������Ч�ʵ�
	{
		if(s==null)
		{
			synchronized(Single2.class)
			{
				if(s==null)
					s = new Single2();
			}
		}
		
		return s;
	}
}

//��¼ԭ�򣺶��嵥��������ʹ�ö���ʽ
class  SingleDemo2
{
	public static void main(String[] args) 
	{
		
		Single ss = Single.getInstance();
		Single s1 = Single.getInstance();
		s1.setnumber(50);
		System.out.println(ss.getnumber());
		
		
	}
}