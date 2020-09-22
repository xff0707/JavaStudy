package javastudy25days.Day04;

class  ArrDemo3
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		//数组的操作
		//获取数组中的元素，通常会用到遍历
		//数组中有一个属性可以直接获取数组元素的个数，length
		//使用方式，数组名称.length
		int[] arr = new int[3];
		for(int i = 0;i<arr.length;i++)
		System.out.println("arr["+i+"]="+arr[i]+";");
		int sum = 0;
		for(int i = 0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
		printArray(arr);
		
		
	}
	
	//定义功能，用于打印数组中的元素，元素间用逗号隔开
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
