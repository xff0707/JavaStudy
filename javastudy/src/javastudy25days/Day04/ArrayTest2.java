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
		//Arrays.sort(a);//���ú���
		System.out.println();
		printArray(a);

	}
	//ѡ������
	/*
	��ѭ������һ�Σ���ֵ������ͷ�Ǳ�λ��
	*/
	public static void selectSort(int[] a)//��С����(����)
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
	ð������
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
	/*ϣ����������ѭ���ٶ����Ч�����*/
	//����λ�ú���
	public static void swap(int[] a,int i,int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	
	//��ӡ����
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