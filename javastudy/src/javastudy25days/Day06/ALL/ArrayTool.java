package javastudy25days.Day06.ALL;/*
��̬��Ӧ��

��һ��������Ĳ�����
ÿһ��Ӧ�ó������й��ԵĹ��ܣ�
���Խ���Щ���ܽ��г�ȡ��������װ
�Ա㸴��

��Ȼ����ͨ����������ʹ����Щ���߷�������������в���
����������
1.���������ڷ�װ���ݵģ�����ArrayTool����δ��װ��������
2.���������ÿһ��������û���õ������е���������

���ǾͿ��ǣ��ó�����Ͻ����ǲ���Ҫ�����
���Խ����еķ����������static�ģ�ֱ��ͨ���������ü���

����������̬����Է�����ʹ�ã����Ǹ��໹�ǿ��Ա����������������
Ϊ�˸�Ϊ�Ͻ���ǿ���ø��಻�ܽ�������

����ͨ�������캯��˽�л����


��������Array Tool�ļ����͸������ˣ�������ֻҪ�����ļ����õ�classPath�£��Ϳ���ʹ�øù�����

���ǣ����ź��������е��׶����˶��ٸ��������Է�ȴ���������Ϊ���ಢû��ʹ��˵����

��ʼ���������˵���顣java��˵����ͨ���ĵ�ע�����
javadoc -d myhelp -author -version ArrayTool.java
*/

/**
����һ�����Զ���������Ĺ����࣬�������ṩ�˻�ȡ��ֵ������ȹ��ܡ�
@author ����
@version V1.1


*/
public class ArrayTool
{
	/**
	�ղ������캯��
	*/
	private ArrayTool(){}
	
	/**
	��ȡһ�����������е����ֵ
	@param arr ����һ��int���͵�����
	@return �᷵��һ���������е����ֵ
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
	��ȡһ�����������е���Сֵ
	@param arr ����һ��int���͵�����
	@return �᷵��һ���������е���Сֵ
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
	int�������ѡ������
	@param arr ����һ��int���͵�����
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
	int�������ð������
	@param arr ����һ��int���͵�����
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
	��������Ԫ�ؽ���λ�õ��û�
	@param arr ����һ��int���͵�����
	@param a Ҫ�û���λ��
	@param b Ҫ�û���λ��
	*/
	private static void swap(int[] arr, int a, int b)
	{
		int c = arr[a];
		arr[a]=arr[b];
		arr[b]=c;
	}
}


/*

һ������Ĭ�ϻ���һ���ղ����Ĺ��캯��
���Ĭ�ϵĹ��캯����Ȩ�޵�������һ��
����౻public���Σ���ôĬ�ϵĹ��캯��Ҳ��public����
�����û�б�public���Σ���ôĬ�ϵĹ��캯����Ҳû��public����

Ĭ�Ϲ��칹�캯����Ȩ����������ı仯���仯��
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