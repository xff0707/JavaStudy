package javastudy25days.Day09;/*
�ڲ��ඨ���ھֲ�ʱ
1.�����Ա���Ա���η�����
2.����ֱ�ӷ����ⲿ���еĳ�Ա����Ϊ�����ⲿ���е�����
	���ǲ����Է��������ڵľֲ��еı�����ֻ�ܷ��ʱ�final���εľֲ�����
*/

class Outer3
{
	int x = 3;
	
	void method(final int a)
	{
		int y = 4;//���ڲ����з��ʾֲ�����y����Ҫ������Ϊ��������
		class Inter//�ֲ��ڲ��಻���о�̬��Ա
		{
			void function()
			{
				System.out.println(a);
			}
		}
		new Inter().function();//���ܷ�ǰ��
	}
}

class InterClassDemo3
{
	public static void main(String[] args)
	{
		
		// new Outer().method();
		
		Outer3 out = new Outer3();
		out.method(7);
		out.method(8);
	}
}