package javastudy25days.Day07;/*
abstract calss Student
{
	abstract void study();
	void sleep()
	{
		System.out.println("sleep");
	}
}

interface Smoking
{
	abstract void smoke();//扩展功能
}

class Zhang extends Student implements Smoking
{
	void study(){}
	public void smoke(){}
}
*/

abstract class Sporter
{
	abstract void play();//基本功能
}
interface Study
{
}

class Wang extends Sporter implements Study
{
	 public void play(){};
}

class InterfaceTest
{
	public static void main(String[] args)
	{
		System.out.println("规划");
	}
}