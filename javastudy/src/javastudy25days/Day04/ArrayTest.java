package javastudy25days.Day04;/*
����һ������
��ȡ�����е����ֵ���Լ���Сֵ
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
	��ȡ�����е����ֵ
	˼·��
	��ȡ��ֵ��Ҫ���бȽϣ�ÿһ�αȽ϶�����һ���ϴ��ֵ����Ϊ��ֵ��ȷ��
	ͨ��һ���������д洢
	�������е�ÿһ��Ԫ�ض�����������е�ֵ�Ƚ�
	��¼�Ƚϴ��ֵ
	�����е�Ԫ�ض��Ƚ���ɣ����ռ������ֵ
	*/
	static int getMax(int[] arr)//��¼ֵ
	{
		int a = arr[0];
		for(int i = 1;i<arr.length;i++)
		{
			if(a<arr[i])
				a=arr[i];
		}
		return a;
	}
	static int getMax_2(int[] arr)//��¼�Ǳ�
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