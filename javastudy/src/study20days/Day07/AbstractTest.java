package Day07;

/*
���������ڿ���һ��ϵͳʱ��Ҫ��Ա�����н�ģ��Ա������3�����ԣ�
���������ż����ʡ�����Ҳ��Ա�������˺���Ա���������⣬���⻹��һ��
�������ԣ���ʹ�ü̳е�˼����ƴ�Ա����;����ࡣҪ�������ṩ��Ҫ��
�����������Է��ʡ�

Ա���ࣺname id pay

�����ࣺ�̳���Ա���������Լ����е�bonus


*/
abstract class Employee
{
	private String name;
	private String id;
	private double pay;
	Employee(String name,String id,double pay)
	{
		this.name = name;
		this.id = id;
		this.pay = pay;
	}
	public abstract void work();
}
class Manager extends Employee
{
	private int bonus;
	Manager(String name,String id,double pay,int bonus)
	{
		super(name,id,pay);
		this.bonus = bonus;
	} 
	public void work()
	{
		System.out.println("�����Work");
	} 
}
class Por extends Employee
{
	Por(String name,String id,double pay)
	{
		super(name,id,pay);
	}
	public void work()
	{
		System.out.println("Ա����Work");
	} 
}

class AbstractTest
{
	public static void main(String[] args)
	{
		Manager jl = new Manager("����","201701415",20000.0,20);
		jl.work();
		Por yg = new Por("����","201701415",4396.0);
		yg.work();
	}
}