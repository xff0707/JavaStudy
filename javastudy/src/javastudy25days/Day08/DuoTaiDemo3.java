package javastudy25days.Day08;

/*
基础班的学生：
	学习，睡觉
高级版的学生：
	学习，睡觉
	
可以将这两类事物进行抽取。

*/
abstract class Student
{
	abstract public void study();
	public void sleep()
	{
		System.out.println("躺着睡");
	}
}
class BaseStudent extends Student
{
	public void study()
	{
		System.out.println("base study");
	}
	public void sleep()
	{
		System.out.println("zuo着睡");
	}
}
class AdvStudent extends Student
{
	public void study()
	{
		System.out.println("adv study");
	}
	
}

class DoStudent
{
	public void doSth(Student stu)
	{
		stu.study();
		stu.sleep();
	}
}

class DuoTaiDemo3
{
	public static void main(String[] args)
	{
		DoStudent ds = new DoStudent();
		ds.doSth(new BaseStudent());
		ds.doSth(new AdvStudent());
		
		// BaseStudent bs = new BaseStudent();
		// bs.study();
		// bs.sleep();
		// AdvStudent as = new AdvStudent();
		// as.study();
		// as.sleep();
		
		
	}
	

}