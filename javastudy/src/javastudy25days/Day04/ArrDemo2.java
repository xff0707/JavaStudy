package javastudy25days.Day04;

class  ArrDemo2
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		
		//int[] arr = new int[2];
		//int arr[] = new int[2];
		
		//int[] arr = new int[]{3,1,6,5,4};��������ʵ�岢��Ӿ���Ԫ��
		//int[] arr = new int[]{3,1,6,5,4};
		
		// int[] arr = new int[5];
		// arr[0] = 59;
		// System.out.println(arr[2]);

		int[] arr = new int[3];
		arr = null;//NullPointerException��ָ���쳣
		//������û���κ�ָ��ֵΪnull������������û������ڲ���ʵ��
		System.out.println(arr[1]);
		//ArrayIndexOutOfBoundsException���ݽǱ�Խ���쳣
		//��������ʱ�����������в����ڵĽǱ�
		
	}
}
