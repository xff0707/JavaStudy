package javastudy25days.Day06.ALL;
class ArrayToolDemo
{
	public static <ArrayTool> void main(String[] args)
	{
		int[] arr = {3,4,1,8};
		//ArrayTool tool = new ArrayTool();
		int max = javastudy25days.Day06.ALL.ArrayTool.getMax(arr);
		System.out.println(max);
	}
}