package Day07;

/*
��������г�����ͬ���ܣ����ǹ������岻ͬ
��ʱ���Խ������ϳ�ȡ����ʱ��ֻ��ȡ���ܶ��壬������ȡ��������

���󣺿�����

��������ص㣺
1.���󷽷�һ�������ڳ�������
2.���󷽷��ͳ����඼���뱻abstra�ؼ�������
3.�����಻������new����������Ϊ���ó��󷽷�û����
4.�������еķ���Ҫ��ʹ�ã����������ิд�����еĳ��󷽷�����������������
	�������ֻ�����˲��ֳ��󷽷�����ô�����໹��һ��������
	

�������һ����û��̫��Ĳ�ͬ
������������������������ֻ�����������������һЩ�������Ķ���
��Щ��ȷ���Ĳ��֣�Ҳ�Ǹ�����Ĺ��ܣ���Ҫ��ȷ���֣������ܶ���ʵ��
ͨ�����󷽷�����ʾ

�������һ������˸������������������п��Զ�����󷽷������Բ�������
�����಻����ʵ����


���⣺�������п��Բ�������󷽷��������������ǲ��ø��ཨ������
*/
abstract class Student
{
	abstract void study();
}

class BaseStudent extends Student
{
	void study()
	{
		System.out.println("base Study");
	}
}
class AdvStudent extends Student
{
	void study()
	{
		System.out.println("adv Study");
	}
}

class AbstractDemo
{
	public static void main(String[] args)
	{
		BaseStudent a = new BaseStudent();
		a.study();
	}
}