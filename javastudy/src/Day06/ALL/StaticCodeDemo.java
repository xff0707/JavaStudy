package Day06.ALL;

/*
��̬�����
��ʽ
static
{
	��̬�����ִ�����
}
�ص㣺������ļ��ض�ִ�У�ִֻ��һ�Σ���������mainִ��
���ڸ�����г�ʼ��

*/
class StaticCode
{
	StaticCode()
	{
		System.out.println("b");
	}
	
	static
	{
		System.out.println("a");
	}
	{
		System.out.println("c");//��������
	}
	
	StaticCode(int x)
	{
		System.out.println("s");
	}

	public static void show()
	{
		System.out.println("show run");
	}
}


class  StaticCodeDemo
{
	// static
	// {
		// System.out.println("b");
	// }
	public static void main(String[] args) 
	{
		new StaticCode(4);
		// new StaticCode();
		// new StaticCode();
		// System.out.println("Over!");
		// StaticCode.show();
		// StaticCode a = null;
		// a = new StaticCode();
	}
	// static
	// {
		// System.out.println("c");
	// }
}
// d:\>java StaticCodeDemo