package javastudy25days.Day08;

/*
�������ѧ����
	ѧϰ��˯��
�߼����ѧ����
	ѧϰ��˯��
	
���Խ�������������г�ȡ��

*/
abstract class Student
{
	abstract public void study();
	public void sleep()
	{
		System.out.println("����˯");
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
		System.out.println("zuo��˯");
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