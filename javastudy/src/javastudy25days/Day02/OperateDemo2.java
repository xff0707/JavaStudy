package javastudy25days.Day02;

class OperateDemo2
{
	public static void main(String []args)
	{
		int x = 7;
		//�߼��������������boolean���͵ı��ʽ
		
		//x>3 & x<6 =true & true =true
		
		/*
		& ��    һ�ټ��� ȫ������
		| ��    һ�漴��
		^ ���  ������ͬΪ�٣���ͬΪ��
		! ��    ��
		&& ��   ���Ϊ��ʱ�ұ߲�����
		|| ��   ���Ϊ��ʱ�ұ߲�����
		*/
		
		
		
		
		int m,n;
		m=3;
		n=8;
		System.out.println("m="+m+",n="+n);
		//1.ͨ������������ ����ʱʹ��
		int temp;
		temp=m;
		m=n;
		n=temp;
		System.out.println("m="+m+",n="+n);
		
		//2.���õ���������
		n = n + m;//���m��n��ֵ�ǳ������׳�����Χ
		m = n - m;
		n = n - m;
		System.out.println("m="+m+",n="+n);
		//3.�����ͷ�ʽ
		n = n ^ m;
		m = n ^ m;//(n^m)^m
		n = n ^ m;//n^(n^m)
		System.out.println("m="+m+",n="+n);
		
	}
}