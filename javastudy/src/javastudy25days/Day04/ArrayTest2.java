package javastudy25days.Day04;

class ArrayTest2
{
	public static void main(String []args)
	{
		int[] a=new int[] {15,50,62,13,25};
		printArray(a);
		//selectSort(a);
		bubbleSort(a);
		System.out.println();
		printArray(a);
		//Arrays.sort(a);//调用函数
		System.out.println();
		printArray(a);

	}
	//选择排序
	/*
	内循环结束一次，最值出现在头角标位置
	*/
	public static void selectSort(int[] a)//从小到大(升序)
	{
		for(int i = 0;i<a.length-1;i++)
		{
			for(int j = i+1;j<a.length;j++)
			{
				if(a[j]<a[i])
				{
					int k = a[j];
					a[j] = a[i];
					a[i] = k;
				}
			}
		}
	}
	/*
	冒泡排序
	*/
	public static void bubbleSort(int[] a)
	{
		for(int i = 0;i<a.length-1;i++)
		{
			for(int j = 0;j<a.length-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					//int k = a[j];
					//a[j] = a[j+1];
					//a[j+1] = k;
					swap(a,j,j+1);
				}
			}
		}
	}
	/*希尔排序三个循环速度最快效率最高*/
	//交换位置函数
	public static void swap(int[] a,int i,int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	
	//打印数组
	public static void printArray(int[] arr)
	{
		System.out.print("[");
		for(int i = 0;i<arr.length;i++)
		{
			if(i!=arr.length-1)
				System.out.print(arr[i]+",");
			else
				System.out.print(arr[i]+"]");
		}
	}
}