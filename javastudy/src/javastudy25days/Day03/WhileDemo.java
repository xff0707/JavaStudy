package javastudy25days.Day03;

class  WhileDemo
{
	public static void main(String[] args) 
	{
		/*
		�����ʼ�����ʽ
		while(�������ʽ)
		{
		ѭ����(ִ�����)��
		}
		*/
		int x = 1;
		while(x<3)
		{
		System.out.println("x="+x);
		x++;
		}
		
		do
		{
			System.out.println("do:x="+x);
			x++;
		}
		while(x<3);
		/*
		while���ж�������ֻ�����������ִ��ѭ����
		do while����ִ��ѭ���壬���ж��������������㣬��ִ��ѭ����
		���������Ƿ����㣬ѭ��������ִ��һ��
		*/
		
		

	}
}
