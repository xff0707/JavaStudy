package javastudy25days.Day07;

/*
���󣺻�ȡһ�γ���
ԭ����ȡ����ʼ�ͽ�����ʱ�䲢�������

��ȡʱ�䣺System.currentTimeMillis();

����������Ż��󣬾Ϳ��Խ���������⡣

���ַ�����ģ�巽�����ģʽ

ʲô��ģ�巽���أ�
�ڶ��幦��ʱ�����ܵ�һ������ȷ���ģ�������һ�����ǲ�ȷ���ģ���ȷ���Ĳ�����ʹ�ò�ȷ���Ĳ���
��ô��ʱ�ͽ���ȷ���Ĳ��ֱ�¶��ȥ���ɸ��������ȥ���
*/
abstract class GetTime
{
	public final void getTime()//���⸲��
	{
		long start = System.currentTimeMillis();
		
		runcode();
		
		long end = System.currentTimeMillis();
		
		System.out.println("���룺"+(end-start));
	}
	public abstract void runcode();
}


class SubTime extends GetTime
{
	public void runcode()
	{
		for(int x = 0;x<50;x++)
		{
			System.out.print(x);
		}
	}
}


class TemoplateDemo
{
	public static void main(String[] args)
	{
		// GetTime gt = new GetTime();
		SubTime gt = new SubTime();
		gt.getTime();
	}
}

