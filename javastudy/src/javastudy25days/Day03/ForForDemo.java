package javastudy25days.Day03;

//ѭ��Ƕ����ʽ����ʵ��������л������
//ѭ��Ƕ�ס�
class ForForDemo
{
	public static void main(String []args)
	{
		for (int i = 1; i <=9; i++) 
		{

			for (int j = 1; j <= i; j++) 
			{

				System.out.print(j+"*"+i+"="+(i*j)+"\t");

			}
			System.out.println( );
		}
		System.out.println("------------");
		/*
		��ӡ
		*****
		****
		***
		**
		*
		����ͼ���кܶ��У�ÿһ���кܶ���
		Ҫʹ��Ƕ��ѭ�� 
		ԭ������˵������Ȧ��СȦ
		*/
		for(int i = 5;i>0;i--)
		{
			for(int y = i;y>0;y--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------");
		
		
		/*
		��ӡ
		*
		**
		***
		****
		*****
		*/
		for(int i = 1;i<=5;i++)
		{
			for(int j = 1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------");
		/*
		��ӡ
		1
		12
		123
		1234
		12345
		*/
		for(int i = 1;i<=5;i++)
		{
			for(int j = 1;j<=i;j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println("------------");
		
				w:for(int i = 1;i<=5;i++)
		{
			q:for(int j = 1;j<=i;j++)
			{
				System.out.print(j);
			}
			System.out.println();
			break w;//����ѭ��W
		}
		System.out.println("------------");
		
		
		
		for(int i = 1;i<=10;i++)
		{
			if(i%2==1)
				continue;
			for(int j = 1;j<=i;j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println("------------");
		/*
		��ס��
		break��continue�������÷�Χ
		��������ʱ�±߲��������κ���䣬��Ϊִ�в���
		*/
		
		
	}
}