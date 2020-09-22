package javastudy25days.Day04;

class Array2Demo
{
	public static void main(String[] args)
	{
		// int[][] a=new int[2][3];
		
		// int[][] arr = new int[3][];
		// arr[0]=new int[2];
		// arr[1]=new int[1];
		// arr[2]=new int[3];
		// arr.length;
		// arr[1].length;

		int[][] arr={{2,6,9},{3,5,7},{1,9,5}};
		int sum = 0;
		for(int x = 0;x<arr.length;x++)
		{
			for(int y = 0;y<arr[x].length;y++)
			{
				sum+=arr[x][y];
			}
		}
		System.out.println(sum);
		long end = System.currentTimeMillis();

	}
}