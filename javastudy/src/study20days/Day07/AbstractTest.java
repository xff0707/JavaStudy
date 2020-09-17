package Day07;

/*
假如我们在开发一个系统时需要对员工进行建模，员工包含3个属性：
姓名、工号及工资。经理也是员工，除了含有员工的属性外，另外还有一个
奖金属性，请使用继承的思想设计处员工类和经理类。要求类中提供必要的
方法进行属性访问。

员工类：name id pay

经理类：继承了员工，并有自己特有的bonus


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
		System.out.println("经理的Work");
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
		System.out.println("员工的Work");
	} 
}

class AbstractTest
{
	public static void main(String[] args)
	{
		Manager jl = new Manager("王呜","201701415",20000.0,20);
		jl.work();
		Por yg = new Por("王呜","201701415",4396.0);
		yg.work();
	}
}