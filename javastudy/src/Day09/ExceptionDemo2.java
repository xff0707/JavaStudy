package Day09;/*
因为项目中会出现特有的问题
而这些问题并未被java描述并封装对象
所以对一这些特有的问题可以按照java的对问题封装的思想
将特有的问题，进行自定义的异常封装

自定义异常

需求：在本程序中，对于除数时负数，也视为时错误的，无法进行运算的
那么就需要对这个问题进行自定义的描述

当在函数内部出现了throw抛出异常对象，那么就必须要给出对应的处理动作
要么在内部try catch 处理
要么在函数上声明让调用者处理

一般情况在，函数内出现异常，函数上需要声明


发现打印的结果中只有异常的名称，却没有异常的信息
因为自定义的异常并未定义信息

如何定义异常信息嘛？
因为父类中已经把异常信息的操作都完成了
所以子类只要在构造时，将异常信息传递给父类通过super语句
那么就可以直接通过getMessage方法获取自定义的异常信息



自定义异常
必须是自定义类继承Exception


继承Exception原因：
异常体系由一个特点，因为异常类和异常对象都与要抛出
他们都具备可抛性。这个可抛性事throwable这个体系中的独有特点

只有这个体系中的类和对象才可以被throws和throw操作



throws和throw的区别
throws使用在函数上
throw使用在函数内

throws后面跟的是异常类，可以跟多个，用逗号隔开
throw后跟的是异常对象
*/

class FuShuException extends Exception//getMessage();
{
	private int val;
	
	FuShuException(String msg,int val)
	{
		super(msg);
		this.val = val;
	}
	int getVal()
	{
		return val;
	}
	/*
	private String msg;
	FuShuException(String msg)
	{
		this.msg = msg;
	}
	public String getMessage()
	{
		return msg;
	}
	*/
}

class Demo2
{
	int div(int a,int b)throws FuShuException
	{
		if(b<0)
			throw new FuShuException("出现了除数时负数的情况",b);//手动通过throw关键字抛出一个自定义异常对象
		
		
		return a/b;
	}
}


class ExceptionDemo2
{
	public static void main(String[] args)//throws Exception
	{
		Demo2 d = new Demo2();
		
		try
		{
			int x = d.div(4,-1);
			System.out.println("X="+x);
		}
		catch(FuShuException e)
		{
			System.out.println(e.toString());
			System.out.println("除数出现负数啦");
			System.out.println("错误的值为："+e.getVal());
			// e.printStackTrace();
		}
		
		/*
		catch(ArithmeticException e)//Exception e = new ArithmeticException();
		{
			System.out.println("除零啦");
			//System.out.println(e.getMessage());//   / by zero
			System.out.println(e.toString());//		异常名称：异常信息
			
			//e.printStackTrace();//异常名称，异常信息，异常出现的位置
								//其实jvm默认的异常处理机制，就是在调用printStackTrace方法
								//打印异常的堆栈信息
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("角标越界了");
			System.out.println(e.toString());
		}
		*/
		System.out.println("Over");
		
	}
}