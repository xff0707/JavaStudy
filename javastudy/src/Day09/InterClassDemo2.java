package Day09;/*
�ڲ�����ʹ���
1.�ڲ������ֱ�ӷ����ⲿ���еĳ�Ա������˽��.
	֮���Կ���ֱ�ӷ����ⲿ���еĳ�Ա������Ϊ�ڲ����г�����һ���ⲿ������� ��ʽ���ⲿ����.this
2.�ⲿ��Ҫ�����ڲ�����뽨���ڲ������

���ʸ�ʽ��
���ڲ��ඨ�����ⲿ��ĳ�Աλ���ϣ����ҷ�˽�У��������ⲿ��������
����ֱ�ӽ����ڲ������
��ʽ��
	�ⲿ����.�ڲ����� ������ = �ⲿ�����.�ڲ������
	Outer.Inter in = new Outer().new Inter();
	
2.���ڲ����ڳ�Աλ���ϣ��Ϳ��Ա���Ա���η�����
	���磺private�����ڲ������ⲿ���н��з�װ
		static���ڲ���;߱�static������
		���ڲ��౻static���κ�ֻ��ֱ�ӷ����ⲿ���е�static��Ա�������˷��ʾ���
		
		���ⲿ�������У����ֱ�ӷ���static�ڲ���ķǾ�̬��Ա�أ�
		new Outer.Inter().function();
		
		���ⲿ�������У����ֱ�ӷ���static�ڲ���ľ�̬��Ա�أ�
		Outer.Inter.function();
	
	ע�⣺���ڲ����ж����˾�̬��Ա�����ڲ��������static��
			���ⲿ���еľ�̬���������ڲ���ʱ���ڲ���Ҳ������static��

			
			

����������ʱ��������ڲ�����������������ڲ�����������
��Ϊ�ڲ�������ʹ���ⲿ�����������

class Body
{
	
	private class Xinzang
	{
			
	}
	
	public void show()
	{
		new Xinzang();
	}
}



*/

class Outer
{
	private static int x = 3;
	
	
	static class Inter//�ڲ��࣬��̬
	{
		// int x = 5;
		static void function()
		{
			// int x = 6;
			System.out.println("Inter :"+x);
			// System.out.println("Inter :"+this.x);
			// System.out.println("Inter :"+Outer.this.x);
		}		
	}
	
	static class Inter2
	{
		void show()
		{
			System.out.println("2Show");
		}
	}
	
	
	public static void method()
	{
		// Inter in = new Inter();
		// in.function();
		// System.out.println("");
		// Inter.function();
		new Inter2().show();//��Ҫ��Inter2��̬
	}
}

class InterClassDemo2
{
	public static void main(String[] args)
	{
		// Outer out = new Outer();
		// out.method();
		
		//ֱ�ӷ����ڲ����еĳ�Ա
		// Outer.Inter in = new Outer().new Inter();
		// in.function();
		
		//Outer.Inter.function();
		
		Outer.method();
	}
}