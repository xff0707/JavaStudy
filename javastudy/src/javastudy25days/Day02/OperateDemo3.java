package javastudy25days.Day02;

class OperateDemo3
{
	public static void main(String []args)
	{
		System.out.println(Integer.toBinaryString(60));
		
		int num=60;
		//��ȡ60�������λ��ͨ��&15��
		//num & 15=12;
		int n1=num&15;
		System.out.println((char)(n1-10+'A'));
		//Ҫ��ȡ��һ����λ����60������λ��
		int temp =60>>4;//ֻ��˫���ƣ���λ������ѭ��
		//��temp��ֵ���������λ�Ļ�ȡ��
		//temp&15=3;
		int n2=temp &15;
		System.out.println(n2);
		/*
		0-9 'A' 'B' 'C' 'D' 'E' 'F'
		     65  66  67
			 10  11  12  13  14  15
		12-10=2+'A'=(char)67
		*/
		
		int x=3,y;
		y=(x>1)?100:200;
		System.out.println(y);
	}
}