package Day09;
/*
����ʦ�õ����Ͽ�

��ʼ˼���Ͽ��г��ֵ����⡣


���������ǣ�
	��������
	����ð��

Ҫ�����������������װ�ɶ���


���ǵ�ð�̷����󣬳��ֽ��ν����޷�����

�����˽�ʦ�����⣬��ʱ�ƻ��޷����
*/

class LanPingException extends Exception
{
	LanPingException(String message)
	{
		super(message);
	}
}

class MaoYanException extends Exception
{
	MaoYanException(String message)
	{
		super(message);
	}
}

class NoPlanException extends Exception
{
	NoPlanException(String message)
	{
		super(message);
	}
}


class Computer
{
	private int state = 3;
	public void run()throws LanPingException,MaoYanException
	{
		if(state==2)
			throw new LanPingException("������");
		if(state==3)
			throw new MaoYanException("ð����");
		System.out.println("��������");
	}
	public void reset()
	{
		state = 1;
		System.out.println("��������");
	}
}

class Teacher
{
	private String name;
	private Computer cmpt;
	
	Teacher(String name)
	{
		this.name = name;
		cmpt = new Computer();
	}
	
	public void prelect()throws NoPlanException
	{
		try
		{
			cmpt.run();
		}
		catch(LanPingException e)
		{
			cmpt.reset();
		}
		catch(MaoYanException e)
		{
			test();
			throw new NoPlanException("��ʱ�޷�����"+e.getMessage());
			//test();//���ʲ�����дǰ��
		}
		System.out.println("����");
	}
	public void test()
	{
		System.out.println("��ϰ");
	}
}

class ExceptionTest
{
	public static void main(String[] args)//throws Exception
	{
		Teacher t = new Teacher("����ʦ");
		try
		{
			t.prelect();
		}
		catch(NoPlanException e)
		{
			System.out.println(e.toString());
			System.out.println("����ʦ���߷ż�");
		}
		

	}
}