package Day06.ALL;

/*
��̬��static
�÷�����һ�����η����������γ�Ա����Ա��������Ա������
����Ա����̬���κ󣬾Ͷ���һ�����÷�ʽ�����˿��Ա���������⣬
������ֱ�ӱ��������ã�����.��̬��Ա

����������������������


static�ص�
1.��̬������ļ��ض�����
2.�����ڶ������
3.�����ж�����
4.����ֱ�ӱ���������

��̬��ע������
1.��̬����ֻ�ܷ��ʾ�̬��Ա
   �Ǿ�̬�����ȿ��Է��ʾ�̬Ҳ���Է��ʷǾ�̬
2.��̬�����в����Զ���this��super�ؼ���
    ��Ϊ��̬�����ڶ�����ڣ����Ծ�̬�����в����Գ���this
3.�������Ǿ�̬��

��̬�����б�
�������Զ���Ĺ������ݵ����ռ�Ĵ洢
     ����ֱ�ӱ���������
�׶ˣ��������ڹ���
      ���ʳ��־����ԣ���̬��ã�ֻ�ܷ��ʾ�̬��	 
*/
class Person1
{
	String name;
	static String country = "CN";
	public static void show()
	{
		System.out.println("country="+country);
	}
}
class  StaticDemo
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		Person1 p = new Person1();
		p.name="�ྮ��";
		p.show();
		Person1.show();
	}
}
