package javastudy25days.Day03;

/*

什么时候用重载
当定义的功能相同，但参与运算的位置内容不同
那么，这时候就定义一个函数名称以示其功能，方便阅读，而通过参数列表的不同来区分多个同名函数。
\

重载和返回值类型没关系

*/
class  FunctionOverload
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		System.out.println(add(4,5));
		System.out.println(add(4,5,6));
		getNineNine(5);
	}
	
	public static int add(int x,int y)
	{
		return x+y;
	}
	public static int add(int x,int y,int z)
	{
		return x+y+z;
	}
	
	
	static void getNineNine(int num)
	{
		for (int i = 1; i <=num; i++) 
		{
			for (int j = 1; j <= i; j++) 
			{

				System.out.print(j+"*"+i+"="+(i*j)+"\t");

			}
			System.out.println( );
		}
	}
	static void getNineNine()
	{
		getNineNine(9);
	}
}
