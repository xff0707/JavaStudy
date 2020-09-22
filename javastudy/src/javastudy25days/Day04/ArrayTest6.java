package javastudy25days.Day04;

class ArrayTest6
{
	public static void main(String[] args)
	{
		toBin(15);
	}
	
	
	//
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	//
	public static void toHex(int num)
	{
		trans(num,15,4);
	}
	//
	public static void to8(int num)
	{
		trans(num,7,3);
	}
	
	
	public static void trans(int num,int base,int offset)
	{
		if(num == 0)
		{
			System.out.println(0);
			return;
		}	
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		//定义一个临时容器
		char[] arr = new char[32];
		//定义一个操作数组的指针
		int pos = arr.length;
		while(num!=0)
		{
			int temp = num & base;
			arr[--pos]=chs[temp];
			num=num>>>offset;
		}
		for(int i = pos;i<arr.length;i++)
		System.out.print(arr[i]);
	}
}