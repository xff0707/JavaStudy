package javastudy25days.Day03;

class  WhileDemo
{
	public static void main(String[] args) 
	{
		/*
		定义初始化表达式
		while(条件表达式)
		{
		循环体(执行语句)；
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
		while先判断条件，只有条件满足才执行循环体
		do while：先执行循环体，再判断条件，条件满足，再执行循环体
		无论条件是否满足，循环体至少执行一次
		*/
		
		

	}
}
