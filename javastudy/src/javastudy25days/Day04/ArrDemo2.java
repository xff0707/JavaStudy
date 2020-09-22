package javastudy25days.Day04;

class  ArrDemo2
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		
		//int[] arr = new int[2];
		//int arr[] = new int[2];
		
		//int[] arr = new int[]{3,1,6,5,4};创建数组实体并添加具体元素
		//int[] arr = new int[]{3,1,6,5,4};
		
		// int[] arr = new int[5];
		// arr[0] = 59;
		// System.out.println(arr[2]);

		int[] arr = new int[3];
		arr = null;//NullPointerException空指针异常
		//当引用没有任何指向值为null的情况，该引用还在用于操作实体
		System.out.println(arr[1]);
		//ArrayIndexOutOfBoundsException数据角标越界异常
		//操作数组时访问了数组中不存在的角标
		
	}
}
