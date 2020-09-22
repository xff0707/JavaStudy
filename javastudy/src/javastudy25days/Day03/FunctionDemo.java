package javastudy25days.Day03;

class FunctionDemo
{
	public static void main(String[] args)
	{
		int x=4;
		int z=y(x);
		System.out.println(x*3+5);
		System.out.println(z);
		yy(5);
		
	}
	//发现以上的运算因为获取不同数据的运算结果代码出现了重复。
	//为了提高代码的复用性，对代码进行了抽取。
	//将这个部分定义成一个独立的功能，方便于日后使用。
	//java中对功能的定义是通过函数的形式来体现的。
	
	//需要定义功能，完成一个整数的运算
	//函数内部不能定义函数
	 /*
	格式
	修饰符 返回值类型 函数名(参数类型1 形式参数1,参数类型2 形式参数2)
	{
		执行语句;
		return 返回值;
	}
	*/
	public static int y(int x)
	{
		return 3*x+5;
	}
	//当函数运算后，没有具体的返回值时，这时返回值类型用一个特殊的关键字来标识。
	//void 表示没有具体返回值的情况
	//	   return可以省略不写
	public static void yy(int x)//功能定义思想有问题，因为只完成计算，是否打印是调用者的事
	{
		System.out.println(x*3+5);
		return;//可以省略
	}
}