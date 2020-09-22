package javastudy25days.Day03;

class ForTest
{
	public static void main(String []args)
	{
		int x = 1;
		for(System.out.println("a");x<3;System.out.println("c"),x++)//多表达式逗号分隔
		{
			System.out.println("d");
			//x++;
		}
		//adcdc
		
		for(int y = 0;y<3;y++)
		{
			
		}
		
		/*
		无限循环的最简单表现形式。
		对于for循环语句   for(;;){}默认为真
		
		while(true){}
		*/
	}
}