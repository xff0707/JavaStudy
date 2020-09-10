package Day04;

/*
数组的查找工作

练习：
有一个有序地数组，想要将一个元素插入到该数组中，还要保证该数组是有序的
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
	折半查找，提高效率，必须要保证该数组是有序的数组
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
	折半的第二种方法
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
	//练习
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
		return min;//仅仅修改返回值
	}
	
	
	//定义获取key第一次出现在出现在数组中的位置，如果返回-1，则其不存在
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