package Day09;/*


*/

interface Inter1
{
	void method();
}

class Test1
{
	//������룬ͨ�������ڲ���
	
	// static class Inner implements Inter
	// {
		// public void method()
		// {
			// System.out.println("Fuc");
		// }
	// }
	
	static Inter1 function()
	{
		return new Inter1()
		{
			public void method()
			{
				System.out.println("Fuc");
			}
		};
	}
}

class InterClassTest
{
	public static void main(String[] args)
	{
		//Test.function()��Test������һ����̬����function
		//.method()��function������������Ľ��ʱһ�����󣬶�����һ��Inter���͵Ķ���
		//��Ϊֻ����Inter���͵Ķ���ſ��Ե���method����
		Test1.function().method();
		
		//�൱��
		// Inter in = new Test.function();
		// in.method();
		
		show(new Inter1()
		{
			public void method()
			{
				System.out.println("FucK");
			}
		});
	}
	
	public static void show(Inter1 in)
	{
		in.method();
	}
}

class InterTest
{
	public static void main(String[] args)
	{
		new Object()
		{
			public void function()
			{
				System.out.println("��װ��");
			}
		}.function();
	}
}