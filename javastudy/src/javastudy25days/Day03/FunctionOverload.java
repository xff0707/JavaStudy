package javastudy25days.Day03;

/*

ʲôʱ��������
������Ĺ�����ͬ�������������λ�����ݲ�ͬ
��ô����ʱ��Ͷ���һ������������ʾ�书�ܣ������Ķ�����ͨ�������б�Ĳ�ͬ�����ֶ��ͬ��������
\

���غͷ���ֵ����û��ϵ

*/
class  FunctionOverload
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		System.out.println(add(4,5));
		System.out.println(add(4,5,6));
		getNineNine(5);
	}
	
	public static int add(int x,int y)
	{
		return x+y;
	}
	public static int add(int x,int y,int z)
	{
		return x+y+z;
	}
	
	
	static void getNineNine(int num)
	{
		for (int i = 1; i <=num; i++) 
		{
			for (int j = 1; j <= i; j++) 
			{

				System.out.print(j+"*"+i+"="+(i*j)+"\t");

			}
			System.out.println( );
		}
	}
	static void getNineNine()
	{
		getNineNine(9);
	}
}
