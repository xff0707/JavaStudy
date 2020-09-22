package javastudy25days.Day10;

/*
第一种格式
try
{
	需要被检测的代码;
}
catch(异常类 变量)
{
	处理异常的代码;(处理方式)
}
finally
{
	一定会执行语句;
}
第二种格式
try
{
	需要被检测的代码;
}
catch(异常类 变量)//可以有多个
{
	处理异常的代码;(处理方式)
}
第三种格式
try
{
	需要被检测的代码;
}

finally
{
	一定会执行语句;
}
*/
//记住一点：catch是用于处理异常，如果没有catch就代表异常没有被处理过，如果该异常是检测时异常，那么必须声明
class Demo6
{
	public void method() throws Exception {
		try
		{
			throw new Exception();
		}
		// catch(Exception e)
		// {
			// try
			// {
				// throw e;
			// }
			// catch()
			// {
				
			// }
		// }
		finally
		{
			
		}
	}
}

class ExceptionDemo6
{
	public static void main(String[] args)
	{
		System.out.println();
	}
}