package javastudy25days.Day02;

class OperateDemo3
{
	public static void main(String []args)
	{
		System.out.println(Integer.toBinaryString(60));
		
		int num=60;
		//获取60的最低四位，通过&15；
		//num & 15=12;
		int n1=num&15;
		System.out.println((char)(n1-10+'A'));
		//要获取下一组四位，将60右移四位。
		int temp =60>>4;//只能双右移，三位负数会循环
		//对temp的值进行最低四位的获取。
		//temp&15=3;
		int n2=temp &15;
		System.out.println(n2);
		/*
		0-9 'A' 'B' 'C' 'D' 'E' 'F'
		     65  66  67
			 10  11  12  13  14  15
		12-10=2+'A'=(char)67
		*/
		
		int x=3,y;
		y=(x>1)?100:200;
		System.out.println(y);
	}
}