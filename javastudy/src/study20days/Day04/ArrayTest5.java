package Day04;

class ArrayTest5
{
	public static void main(String[] args)
	{
		toHex(60);
		toBin(6);
	}
	/*
	 0  1  2  3  4  5  6  7  8  9   A   B   C   D   E   F   ʮ�������е�Ԫ��
	 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15   ʮ
	���
	�����е�Ԫ����ʱ�洢������������Ӧ��ϵ
	ÿһ��&15���ֵ��Ϊ����ȥ�齨���õ��࣬�Ϳ����Ҷ�Ӧ�Ĺ�ϵ
	������-10+'a'�򵥵Ķ�
	�������ô�����أ�
	����ͨ�����ݵ���ʽ������
	
	�������ڳ��˽���������Ƿ��ŵģ���Ҫ�������أ�����ͨ��StringBuffer reverse���������
	����������߻�û��ѧϰ
	
	���Կ���ʹ���Ѿ�ѧϰ������������������ɴ洢
	*/
	//ʮ����-->�����ơ�
	public static void toBin(int num)
	{
		//��������Ʊ�
		char[] chs = {'0','1'};
		//����һ����ʱ����
		char[] arr = new char[32];
		//����һ�����������ָ��
		int pos = arr.length;
		while(num!=0)
		{
			int temp = num & 1;
			arr[--pos]=chs[temp];
			num=num>>>1;
		}
		for(int i = pos;i<arr.length;i++)
		System.out.print(arr[i]);
	}
	

	//ʮ����-->ʮ�����ơ�
	public static void toHex(int num)
	{
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		//����һ����ʱ����
		char[] arr = new char[8];//'\u0000'��λ���൱�ڿո�
		// int pos = 0;
		int pos = arr.length;
		//for(int x=0;x<8;x++)
		while(num!=0)
		{
			int temp = num&15;
			arr[--pos]=chs[temp];
			num=num>>>4;
		}
		// int n1 = num & 15;
		// n1-10+'a';
		// int temp = num>>>4;
		//System.out.println(sb.reverse());
		for(int i = pos;i<arr.length;i++)
		System.out.print(arr[i]+",");
	}
}