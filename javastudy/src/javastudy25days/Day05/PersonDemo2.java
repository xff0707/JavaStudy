package javastudy25days.Day05;/*
�������ͻ������֮��Ӧ�Ĺ��캯��

���캯�������ã��������ڸ�������г�ʼ��

���캯����Сϸ��
��һ������û�й��캯��ʱ����ôϵͳ��Ĭ�ϸ��������һ���ղ����Ĺ��캯��

���������Զ����˹��캯����Ĭ�ϵĹ��캯����û��

���캯����һ�㺯����д���ϲ�ͬ

��������Ҳ�в�ͬ
���캯�����ڶ���һ����������
��һ�㷽���ǵ��ò����У��Ǹ�������Ӷ���߱��Ĺ���

һ�����������캯��ֻ����һ�Σ���һ�㷽�����Ա����ö��

ʲôʱ���幹�캯��
����������ʱ����������ھ߱�һЩ���Ի�����Ϊ����ô����Щ���ݶ����ڹ��캯����
*/

class Person2
{
	// Person()
	// {
	// }
	private String name;
	private int age;
	
	/*
	��������
	���ã���������г�ʼ��
	����һ���������У����������ڹ��캯��ִ��
	�͹��캯��������
	���������Ǹ����ж������ͳһ��ʼ��
	�����캯���Ǹ���Ӧ�Ķ����ʼ��
	
	���������ж�����ǲ�ͬ�����Եĳ�ʼ������
	*/
	{
		// System.out.println("person code run");
		cry();
	}
	
	
	Person2()
	{
		System.out.println("A:name="+name+",age="+age);
		// cry();
	}
	Person2(String n)
	{
		name = n;
		System.out.println("B:name="+name+",age="+age);
		// cry();
	}
	Person2(String n,int a)
	{
		name = n;
		age = a;
		System.out.println("C:name="+name+",age="+age);
		// cry();
	}
	public void setName(String n)
	{
		name = n;
	}
	public String getName()
	{
		return name;
	}
	public void cry()
	{
		System.out.println("Cry");
	}
}
 
class PersonDemo2
{
	public static void main(String[] args)
	{
		Person2 p1 = new Person2();
		// p1.cry();
		// p1.setName("libusi");
		// System.out.println(p1.getName());
		
		// Person p2 = new Person("lisi");
		
		// Person p3 = new Person("wangwu",10);
	}
}