package Day08;

class Fu
{
	int num = 5;
	void method1()
	{
		System.out.println("fu mothod_1");
	}
	void method2()
	{
		System.out.println("fu mothod_2");
	}
	static void method4()
	{
		System.out.println("fu mothod_4");
	}
}

class Zi extends Fu
{
	int num = 8;
	void method1()
	{
		System.out.println("Zi mothod_1");
	}
	void method3()
	{
		System.out.println("Zi mothod_3");
	}
	static void method4()
	{
		System.out.println("Zi mothod_4");
	}
}


class DuoTaiDemo4
{
	public static void main(String[] args)
	{
		// Fu f = new Zi();
		// System.out.println(f.num);
		
		// Zi z = new Zi();
		// System.out.println(z.num);
		
		
		// f.method1();
		// f.method2();
		// f.method3();
		
		Fu f = new Zi();//��̬
		f.method4();
		Zi z = new Zi();
		z.method4();
		
		Fu.method4();
		Zi.method4();
/*
�ڶ�̬��Ա�������ص㣺
�ڱ���ʱ�ڣ����������ͱ��������������Ƿ��е��õķ���������У�����ͨ�������û�б���ʧ�ܡ�
������ʱ�ڣ����Ķ��������������Ƿ��е��õķ�����
���ܽ���ǣ���Ա�����ڶ�̥����ʱ�����뿴��ߣ����п��ұ�


�ڶ�̬�У���Ա�������ص㣺
���۱�������У����ο����(�����ͱ�����������)��


�ڶ�̬�У���̬��Ա�������ص㣺
���۱�������У����ο���ߡ�
*/
		
		// Zi z = new Zi();
		// z.method1();
		// z.method2();
		// z.method3();
		
	}
}


















