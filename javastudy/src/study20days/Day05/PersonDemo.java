package Day05;

/*
��װ��ָ���ض�������Ժ�ʵ��ϸ�ڣ��������ṩ�������ʷ�ʽ
�ô���
���仯����
����ʹ��
���������
��߰�ȫ��
��װԭ��
������Ҫ�����ṩ��������������
�����Զ����أ��ṩ���������������

������������С�ķ�װ��
��Ҳ�Ƿ�װ��
*/
/*
private
˽�У�Ȩ�����η��������������еĳ�Ա����Ա��������Ա������
˽��ֻ�ڱ�������Ч

��age˽�л��������⼴ʹ�����˶���Ҳ����ֱ�ӷ���
������Ӧ�������䣬����Ҫ��Person�����ṩ��Ӧ����age�ķ�ʽ

ע�⣺˽�н����Ƿ�װ��һ�ֱ�����ʽ


֮���Զ����ṩ���ʷ�ʽ������Ϊ�����ڷ��ʷ�ʽ�м����߼��жϵ����
�Է��ʵ����ݽ��в�������ߴ���Ľ�׳��
*/
class Person
{
	private int age;
	void speak()
	{
		System.out.println("age="+age);
	}
	public void setAge(int a)//��������
	{
		if(a>0 && a<130)
		age = a;
		else
			System.out.println("feifa ang");
	}
	public int getAge()
	{
		return age;
	}
}

class PersonDemo
{
	public static void main(String[] args)
	{
		Person p = new Person();
		//p.age= 150;
		p.setAge(-10);
		p.speak();
	}
}