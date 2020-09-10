package Day04;

/*
����Ĳ��ҹ���

��ϰ��
��һ����������飬��Ҫ��һ��Ԫ�ز��뵽�������У���Ҫ��֤�������������
*/
import java.util.*;

class ArrayTest3
{
	public static void main(String[] args)
	{
		int[] a = {2,3,5,9,10,15,35,25};
		int index=getIndex(a,10);
		System.out.println("index="+index);
		Arrays.sort(a);
		int q=halfSearch_3(a,16);
		System.out.println("index="+q);
		
	}
	/*
	�۰���ң����Ч�ʣ�����Ҫ��֤�����������������
	*/
	public static int halfSearch(int[] a,int key)
	{
		int min,max,mid;
		min=0;
		max=a.length;
		mid=(max+min)/2;
		while(a[mid]!=key)
		{
			if(a[mid]>key)
				max=mid-1;
			else if(a[mid]<key)
				min=mid+1;
			mid=(max+min)/2;
			if(min>max)
				return -1;
		}
		return mid;
	}
	/*
	�۰�ĵڶ��ַ���
	*/
	public static int halfSearch_2(int[] a,int key)
	{
		
		int min,max,mid;
		min=0;
		max=a.length;
		while(min<=max)
		{
			mid=(max+min)>>1;
			
			if(key>a[mid])
			min=mid+1;
		else if(key<a[mid])
			max=mid-1;
		else
			return mid;
		}
		return -1;
	}
	//��ϰ
	public static int halfSearch_3(int[] a,int key)
	{
		
		int min,max,mid;
		min=0;
		max=a.length;
		while(min<=max)
		{
			mid=(max+min)>>1;
			
			if(key>a[mid])
			min=mid+1;
		else if(key<a[mid])
			max=mid-1;
		else
			return mid;
		}
		return min;//�����޸ķ���ֵ
	}
	
	
	//�����ȡkey��һ�γ����ڳ����������е�λ�ã��������-1�����䲻����
	public static int getIndex(int[] a,int key)
	{
		for(int x=0;x<a.length;x++)
		{
			if(a[x]==key)
				return x;
		}
		return -1;
	}
}