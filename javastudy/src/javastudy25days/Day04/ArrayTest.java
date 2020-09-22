package javastudy25days.Day04;/*
定义一个数组
获取数组中的最大值，以及最小值
*/

class ArrayTest
{
	public static void main(String[] args)
	{
		int[] a=new int[] {15,50,62,13,25};
		int c = getMax(a);
		int d = getMax_2(a);
		System.out.println("Max="+c);
		System.out.println("Max="+d);
	}
	/*
	获取数组中的最大值
	思路：
	获取最值需要进行比较，每一次比较都会有一个较大的值，因为该值不确定
	通过一个变量进行存储
	让数组中的每一个元素都和这个变量中的值比较
	记录比较大的值
	当所有的元素都比较完成，最终即是最大值
	*/
	static int getMax(int[] arr)//记录值
	{
		int a = arr[0];
		for(int i = 1;i<arr.length;i++)
		{
			if(a<arr[i])
				a=arr[i];
		}
		return a;
	}
	static int getMax_2(int[] arr)//记录角标
	{
		int max = 0;
		for(int i = 1;i<arr.length;i++)
		{
			if(arr[max]<arr[i])
				max=i;
		}
		return arr[max];
	}
	
	
}