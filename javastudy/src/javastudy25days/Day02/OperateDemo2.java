package javastudy25days.Day02;

class OperateDemo2
{
	public static void main(String []args)
	{
		int x = 7;
		//逻辑运算符用于连接boolean类型的表达式
		
		//x>3 & x<6 =true & true =true
		
		/*
		& 和    一假即假 全部运算
		| 或    一真即真
		^ 亦或  两边相同为假，不同为真
		! 非    反
		&& 与   左边为假时右边不运算
		|| 或   左边为真时右边不运算
		*/
		
		
		
		
		int m,n;
		m=3;
		n=8;
		System.out.println("m="+m+",n="+n);
		//1.通过第三方变量 开发时使用
		int temp;
		temp=m;
		m=n;
		n=temp;
		System.out.println("m="+m+",n="+n);
		
		//2.不用第三方变量
		n = n + m;//如果m和n的值非常大，容易超出范围
		m = n - m;
		n = n - m;
		System.out.println("m="+m+",n="+n);
		//3.技巧型方式
		n = n ^ m;
		m = n ^ m;//(n^m)^m
		n = n ^ m;//n^(n^m)
		System.out.println("m="+m+",n="+n);
		
	}
}