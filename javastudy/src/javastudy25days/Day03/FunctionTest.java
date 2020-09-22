package javastudy25days.Day03;

class FunctionTest
{
	public static void main(String []args)
	{
		getJuxing(5,9);
		printRu();
		getNineNine();
		printRu();
	}
	
	
	static void getNineNine()
	{
		for (int i = 1; i <=9; i++) 
		{

			for (int j = 1; j <= i; j++) 
			{

				System.out.print(j+"*"+i+"="+(i*j)+"\t");

			}
			System.out.println( );
		}
	}
	static void getJuxing(int x,int y)
	{
		for(int i = 0;i<x;i++)
		{
			for(int j = 0;j<y;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static public void printRu()
	{
		System.out.println("--------------------");
	}
	
	
}