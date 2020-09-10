package Day04;

class ArrayTest5
{
	public static void main(String[] args)
	{
		toHex(60);
		toBin(6);
	}
	/*
	 0  1  2  3  4  5  6  7  8  9   A   B   C   D   E   F   十六进制中的元素
	 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15   十
	查表法
	将所有的元素临时存储起来，建立对应关系
	每一次&15后的值作为索引去查建立好的类，就可以找对应的关系
	这样比-10+'a'简单的多
	这个表怎么建立呢？
	可以通过数据的形式来定义
	
	发现终于出了结果，但是是反着的，想要正过来呢？可以通过StringBuffer reverse功能来完成
	但是这个工具还没有学习
	
	所以可以使用已经学习过的容器，数组来完成存储
	*/
	//十进制-->二进制。
	public static void toBin(int num)
	{
		//定义二进制表
		char[] chs = {'0','1'};
		//定义一个临时容器
		char[] arr = new char[32];
		//定义一个操作数组的指针
		int pos = arr.length;
		while(num!=0)
		{
			int temp = num & 1;
			arr[--pos]=chs[temp];
			num=num>>>1;
		}
		for(int i = pos;i<arr.length;i++)
		System.out.print(arr[i]);
	}
	

	//十进制-->十六进制。
	public static void toHex(int num)
	{
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		//定义一个临时容器
		char[] arr = new char[8];//'\u0000'空位，相当于空格
		// int pos = 0;
		int pos = arr.length;
		//for(int x=0;x<8;x++)
		while(num!=0)
		{
			int temp = num&15;
			arr[--pos]=chs[temp];
			num=num>>>4;
		}
		// int n1 = num & 15;
		// n1-10+'a';
		// int temp = num>>>4;
		//System.out.println(sb.reverse());
		for(int i = pos;i<arr.length;i++)
		System.out.print(arr[i]+",");
	}
}