package Day07;/*
�Ӹ�����ֺ����г�Ա���ص�

���г�Ա
1.����
2.����
3.���캯��

1.����
��������г��ַ�˽�е�ͬ����Ա����ʱ
����Ҫ���ʱ����еı�������this
����Ҫ���ʸ����еı�������super

super��ʹ�ú�this��ʹ�ü���һ��
this������Ǳ�����������
super������Ǹ�����������
*/

class Fu2
{
	int num = 4;
}

class Zi2 extends Fu2
{
	int num = 5;
	void show()
	{
		System.out.println(super.num);
	}
}

class ExtendsDemo2
{
	public static void main(String[] args) 
	{
		Zi2 z = new Zi2();
		z.show();
		System.out.println(z.num+"......"+z.num);
	}
}