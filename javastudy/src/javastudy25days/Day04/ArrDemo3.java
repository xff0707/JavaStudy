package javastudy25days.Day04;

class  ArrDemo3
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		//����Ĳ���
		//��ȡ�����е�Ԫ�أ�ͨ�����õ�����
		//��������һ�����Կ���ֱ�ӻ�ȡ����Ԫ�صĸ�����length
		//ʹ�÷�ʽ����������.length
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
	
	//���幦�ܣ����ڴ�ӡ�����е�Ԫ�أ�Ԫ�ؼ��ö��Ÿ���
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
