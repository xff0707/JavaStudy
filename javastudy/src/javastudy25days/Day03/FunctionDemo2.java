package javastudy25days.Day03;

class FunctionDemo2
{
	public static void main(String[] args)
	{
		int sum=getSum();
		System.out.println("sum="+sum);
		int sum2=getSum2(5,10);
		System.out.println("sum2="+sum2);
		System.out.println(isSame(10,12));
	}
	/*
	��ζ���һ�������أ�
	��Ȼ������һ�������Ĺ��ܣ���ô�ù��ܵ���������ʲô����ȷ��
	   ��ȷ��������ֵ����
	����ȷ�ڶ���ù��ܵĹ������Ƿ���Ҫδ֪�����ݲ������㡣
	   ��ȷ��������
	*/
	
	//����һ���������3+4�����㲢��������ظ�������
	/*
	1.��ȷ���ܵĽ������һ�������ĺ�
	2.��ʵ�ָù��ܵĹ������Ƿ���δ֪���ݲ������㣺û��
	��ʵ���������ܾ�������ȷ�����Ķ��壺
	1.ʵ����ȷ�����ķ���ֵ����
	2.��ȷ�����Ĳ����б�(���������ͺ͸���)
	*/
	public static int getSum()
	{
		return 3+4;
	}
	//����̶���������չ��
	//Ϊ�˷����û��������û�ָ�������ͱ����������ܲ�������
		public static int getSum2(int x,int y)
	{
		return x+y;
	}
	
	/*
	�ж��������Ƿ����
	*/
	public static boolean isSame(int x,int y)
	{
		if(x==y)
			return true;
		else//��ע�͵�
			return false;
			
		//return x==y?true:false;
		
		//return x==y;
	}
	
	
	/*
	���幦�ܶ����������бȽϣ���ȡ�ϴ����
	*/
		public static int getMax(int x,int y)
	{
		if(x==y)
			return x;
		else//��ע�͵�
			return y;
			
		//return x==y?x:y;
	}
	
}