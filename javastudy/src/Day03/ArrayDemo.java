package Day03;

class  ArrayDemo
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		int[] x = new int[3];
		int[] y = x;
		y[0] = 89;
		x[0] = 77;
		x=null;
		System.out.println(y[0]);
		//x=null;//��������ָ���ϵ�������洢���ݽ�������ʱ��������
	}
}
