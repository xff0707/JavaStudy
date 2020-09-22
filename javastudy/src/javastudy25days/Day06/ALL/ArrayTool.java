package javastudy25days.Day06.ALL;/*
静态的应用

（一个工具类的产生）
每一个应用程序中有共性的功能，
可以将这些功能进行抽取，独立封装
以便复用

虽然可以通过建立对象使用这些工具方法，对数组进行操作
发现了问题
1.对象是用于封装数据的，可是ArrayTool对象未封装特有数据
2.操作数组的每一个方法都没有用到对象中的特有数据

这是就考虑，让程序更严谨，是不需要对象的
可以将类中的方法都定义乘static的，直接通过类名调用即可

将方法都静态后可以方便与使用，但是该类还是可以被其他程序建立对象的
为了更为严谨，强制让该类不能建立对象。

可以通过将构造函数私有化完成


接下来将Array Tool文件发送给其他人，其他人只要将该文件设置到classPath下，就可以使用该工具类

但是，很遗憾，该类中到底定义了多少个方法，对方却不清楚，因为该类并没有使用说明书

开始制作程序的说明书。java的说明书通过文档注释完成
javadoc -d myhelp -author -version ArrayTool.java
*/

/**
这是一个可以对数组操作的工具类，该类中提供了获取最值、排序等功能。
@author 张三
@version V1.1


*/
public class ArrayTool
{
	/**
	空参数构造函数
	*/
	private ArrayTool(){}
	
	/**
	获取一个整形数组中的最大值
	@param arr 接收一个int类型的数组
	@return 会返回一个该数组中的最大值
	*/
	public static int getMax(int[] arr)
	{
		int max = 0;
		for(int x = 0;x<arr.length;x++)
		{
			if(arr[x]>arr[max])
				max=x;
		}
		return arr[max];
	}
	/**
	获取一个整形数组中的最小值
	@param arr 接收一个int类型的数组
	@return 会返回一个该数组中的最小值
	*/
	public static int getMin(int[] arr)
	{
		int max = 0;
		for(int x = 0;x>arr.length;x++)
		{
			if(arr[x]>arr[max])
				max=x;
		}
		return arr[max];
	}
	/**
	int数组进行选择排序
	@param arr 接收一个int类型的数组
	*/
	public static void selectSort(int[] arr)
	{
		for(int i = 0;i<arr.length-1;i++)
		{
			for(int j = i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
					swap(arr,i,j);
			}
		}
	}
	/**
	int数组进行冒泡排序
	@param arr 接收一个int类型的数组
	*/
	public static void bubbleSort(int[] arr)
	{
		for(int i = 0;i<arr.length;i++)
		{
			for(int j = 0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}
	/**
	给数组中元素进行位置的置换
	@param arr 接收一个int类型的数组
	@param a 要置换的位置
	@param b 要置换的位置
	*/
	private static void swap(int[] arr, int a, int b)
	{
		int c = arr[a];
		arr[a]=arr[b];
		arr[b]=c;
	}
}


/*

一个类中默认会有一个空参数的构造函数
这个默认的构造函数的权限的所属类一致
如果类被public修饰，那么默认的构造函数也带public修饰
如果类没有被public修饰，那么默认的构造函数，也没有public修饰

默认构造构造函数的权限是随着类的变化而变化的
*/

// class Demo
// {
	// public static void main(String[] args)
	// {
		// int[] arr = {3,4,1,8};
		
		// int max = getMax(arr);
		// System.out.println("max="+max);
	// }
	
	// public static int getMax(int[] arr)
	// {
		// int max = 0;
		// for(int x = 0;x<arr.length;x++)
		// {
			// if(arr[x]>arr[max])
				// max=x;
		// }
		// return arr[max];
	// }
// }