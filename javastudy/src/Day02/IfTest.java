package Day02;

class IfTest
{
	public static void main(String []args)
	{
		//345����
		/*
		����жϵľ�����ֵ���࣬���Ƿ���byte short int char����������
		ʹ��Switch Ч�ʾ��ȸ�
		����������������жϣ��Խ��ΪBoolean�����жϣ�ʹ��if���÷�Χ����
		*/
		int x=5;
		
		switch(x)
		{
			case 3:
			case 4:
			case 5:
			System.out.println(x+"����");
			break;
			case 6:
			case 7:
			case 8:
			System.out.println(x+"�ļ�");
			case 9:
			case 10:
			case 11:
			System.out.println(x+"�＾");
			case 12:
			case 1:
			case 2:
			System.out.println(x+"����");
			default:
			System.out.println("nono");
		}
	}
}