package javastudy25days.Day03;

//循环嵌套形式，其实就是语句中还有语句
//循环嵌套。
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
		打印
		*****
		****
		***
		**
		*
		发现图形有很多行，每一行有很多列
		要使用嵌套循环 
		原理：形象说法，大圈套小圈
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
		打印
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
		打印
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
			break w;//跳出循环W
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
		记住：
		break和continue语句的作用范围
		单独存在时下边不可以有任何语句，因为执行不到
		*/
		
		
	}
}