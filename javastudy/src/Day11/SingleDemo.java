package Day11;
/*
�������ģʽ

��Ϊ������ʽ��

Single��һ���ڴ���Ѿ��������˶���
class Single
{
	private static final Single s = new Single();	
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}
*/

//����ʽ
//ʵ�����ӳټ���
class Single
{
	private static Single s = null;
	private Single(){}
	public static Single getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class)
			{
				if(s==null)
				{
					s = new Single();
				}
			}
		}
		return s;
		
	}

	public void setnumber(int i) {
	}

	public boolean getnumber() {
		return false;
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