package javastudy25days.Day07;

/*
final�����ա���Ϊһ�����η�
1.���������ࡢ����������
2.��final���ε��಻���Ա��̳С�Ϊ�˱��ⱻ�̳У������ิд���ܡ�
3.��final���εķ��������Ա���д
4.��final���εı�����һ������ֻ�ܸ�ֵһ�Σ��ȿ������γ�Ա�������ֿ������ξֲ�����
    ����������ʱ��һЩ���ݵĳ���ֵʱ�̶��ģ���ô��ʱΪ����ǿ�Ķ��ԣ�������Щֵ������֣��������Ķ�
	�����ֵ����Ҫ�ı䣬���Լ���final���Ρ�
	��Ϊ��������������д�淶������ĸ����д������ɶ��������ɣ�û�����ʼ�ͨ��_����
5.�ڲ��ඨ�������еľֲ�λ����ʱ��ֻ�ܷ��ʸþֲ���final���εľֲ�����
*/
class Demo
{
	public static final double MY_PI = 3.14;
	final int x = 3;
	void show1()
	{
		
	}
	void show2()
	{
		
	}
}
class SubDemo extends Demo
{
	void show1(){}
}

class FinalDemo
{
	public static void main(String[] args)
	{
		final int x = 10;
		// x = 20;
		System.out.println("����ƹ�steam�ġ������ڵĹ���/�����������������ݡ���");
	}
}