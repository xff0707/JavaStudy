package javastudy25days.Day03;

class FunctionDemo2
{
	public static void main(String[] args)
	{
		int sum=getSum();
		System.out.println("sum="+sum);
		int sum2=getSum2(5,10);
		System.out.println("sum2="+sum2);
		System.out.println(isSame(10,12));
	}
	/*
	如何定义一个函数呢？
	既然函数是一个独立的功能，那么该功能的运算结果是什么先明确。
	   明确函数返回值类型
	在明确在定义该功能的过程中是否需要未知的内容参与运算。
	   明确参数类型
	*/
	
	//定义一个功能完成3+4的运算并将结果返回给调用者
	/*
	1.明确功能的结果：是一个整数的和
	2.在实现该功能的过程中是否有未知内容参与运算：没有
	其实这两个功能就是在明确函数的定义：
	1.实在明确函数的返回值类型
	2.明确函数的参数列表(参数的类型和个数)
	*/
	public static int getSum()
	{
		return 3+4;
	}
	//结果固定，毫无扩展性
	//为了方便用户需求，由用户指定加数和被加数，功能才有意义
		public static int getSum2(int x,int y)
	{
		return x+y;
	}
	
	/*
	判断两个数是否相等
	*/
	public static boolean isSame(int x,int y)
	{
		if(x==y)
			return true;
		else//可注释掉
			return false;
			
		//return x==y?true:false;
		
		//return x==y;
	}
	
	
	/*
	定义功能对两个数进行比较，获取较大的数
	*/
		public static int getMax(int x,int y)
	{
		if(x==y)
			return x;
		else//可注释掉
			return y;
			
		//return x==y?x:y;
	}
	
}