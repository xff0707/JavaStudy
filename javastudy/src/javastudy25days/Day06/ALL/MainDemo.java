package javastudy25days.Day06.ALL;

/*
public static void main(String[] args) 
����������һ������ĺ�������Ϊ�������ڣ����Ա�jvm���á�

�������Ķ��壺
public�������Ÿú�������Ȩ��������
static������������������ļ��ؾ��Ѿ�������
void��������û�о���ķ���ֵ
main�����ǹؼ��֣�������һ������ĵ��ʣ����Ա�jvmʶ��
(String[] args)�������Ĳ���������������һ�����飬�������е�Ԫ�����ַ������ַ������͵�����
        arguments�����Ը�

�������ǹ̶���ʽ�ģ�jvmʶ��

jvm�ڵ���������ʱ�������ʱnew String[0];
*/
class  MainDemo
{
	public static void main(String[] args)//new String[]
	{
		String[] arr={"haha","hehe","hiehie"};
		MainTest.main(arr);
	}
}
// String[] args = new String[3];
// String[] args = null;
class MainTest
{
	public static void main(String[] args)
	{
		for(int a = 0; a<args.length;a++)
		System.out.println(args[a]);
	}
}