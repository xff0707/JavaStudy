package javastudy25days.Day09;/*
�����ڲ��ࣺ
1.�����ڲ�����ʵ�����ڲ���ļ�д��ʽ
2.���������ڲ����ǰ��
	�ڲ������̳�һ�������ʵ�ֽӿ�
3.�����ڲ���ĸ�ʽ��new ������߽ӿ�() {�������������}
4.��ʵ�����ڲ������һ������������󡣶�����������е��֣��������Ϊ�����ݵĶ���
5.�����ڲ����ж���ķ�����ò�Ҫ����3��(1����2��)
*/

abstract class AbsDemo
{
	abstract void show();
}

class Outer4
{
	int x = 3;
	
	// class Inter extends AbsDemo
	// {
		// void show()
		// {
			// System.out.println("Show:"+x);
		// }
	// }
	
	public void function()
	{
		// new Inter().show();
		
		// new AbsDemo()
		// {
			// void show()
			// {
				// System.out.println("Show:"+x);
			// }
			// void abc()
			// {
				// System.out.println("ABC");
			// }
		// }.show();
		
		AbsDemo a = new AbsDemo()
		{
			int num = 9;
			void show()
			{
				System.out.println("Show:"+x+num);
			}
			void abc()
			{
				System.out.println("ABC");
			}
		};
		a.show();
		// a.abc();//�����ԣ��̳�(ʵ��)ֻ��ʹ�ø��෽��������ʧ��
		
	}
	
}

class InterClassDemo4
{
	public static void main(String[] args)
	{
		
		new Outer4().function();
		
		// Outer out = new Outer();
		// out.method(7);
		// out.method(8);
	}
}