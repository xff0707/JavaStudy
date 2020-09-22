package javastudy25days.Day10;
/*
	finally代码块，定义一定执行的代码。
	通常用于关闭资源
	
	

*/

class FuShuException extends Exception
{
	FuShuException(String msg)
	{
		super(msg);
	}
}

class Demo
{
	int div(int a,int b)throws FuShuException
	{
		if(b<0)
			throw new FuShuException("出现了除数为负数啦");
		return a/b;
	}
}

class ExceptionDemo5
{
	public static void main(String[] args)//throws Exception
	{
		Demo d = new Demo();
		
		try
		{
		int x = d.div(4,-3);
		System.out.println("x="+x);
		}
		catch(FuShuException e)
		{
			System.out.println(e.toString());
			return;
			// System.exit(0);//系统，退出，jvm结束
		}
		finally
		{
			System.out.println("Finally");//finally中存放的是一定会被执行的代码
		}
		
		System.out.println("Over");
	}
}
/*
class NoException
{
	NoException(String msg)
	{
		super(msg);
	}
}

public void method()throws NoException
{
	连接数据库;
	
	数据操作;//throw new SQLException();
	
	关闭数据库;//该动作无论数据操作是否成功，一定要关闭资源
	
	
	try
	{
		连接数据库;
		数据操作;//throw new SQLException();
	}
	catch(SQLException e)
	{
		会对数据库进行异常处理;
		throw new NoException();
	}
	finally
	{
		关闭数据库;
	}
	
	
}

*/
















