package javastudy25days.Day05;/*
面向对象是一种思想
能让复杂问题简单化
执行者转变为指挥者
*/

//三大特征：封装 继承 多态

//以后开发：其实就是找对象用 没有对象，就创建一个对象

//找对象 建立对象 使用对象 维护对象的关系

/*
类和对象的关系

现实生活中的对象：张三 李四。
想要描述：提取对象的共性内容，对具体的一个抽象。

描述时这些对象的共性：姓名、性别、年龄、学习的功能；

映射到java中就是class定义的类
具体对象就是对应java在堆内存中用new建立的实体



类就是对现实生活中事务的描述
对象就是这类事务实实在在存在的个体

*/

/*
需求：描述汽车（颜色、轮胎数）.描述事物的属性和行为
                                        变量  函数(方法)
其实定义类，就是在描述事物，就是在定义属性和行为，属性和行为共同成为类中的成员(成员变量和成员方法)									
*/


/*
              成员变量           和            局部变量
           作用于整个类中                作用于函数中或者语句中
在内存中的位置 堆内存中（因为对象的存在）     存在栈内存中
*/
class Car
{
	//描述颜色
	String color = "红色";//显式初始化值 默认null
	//描述轮胎数
	int num = 4;
	
	//运行行为
	void run()
	{
		System.out.println(color+".."+num);
	}
	//在本类中创建本类对象
	//public static void main(String[] args) 
	//run();
}

class  CarDemo
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		//生产汽车在Java通过呢哇操作符完成
		//其实就是在堆内存中产生一个实体
		Car c = new Car();//c:引用型变量 也称句柄 就是一个类类型变量
		//需求：将已有车的颜色改成蓝色，只会该对象做使用，java中的指挥方式是：对象.对象成员
		c.run();
		c.color="blue";
		c.run();
		
		//匿名对象
		//使用方式1：当对象的方法只调用一次时，可以用匿名对象来完成，这样写比较简化
		//如果对一个对象进行多个成员调用，必须给这个对象起个名字
		new Car().num = 5;
		new Car().color = "blue";
		new Car().run();
		//使用方式2：可以将匿名对象作为实际参数进行传递
		show(c);
		show(new Car());
		c=null;//内存释放
	}
	//需求汽车修配厂，对汽车进行改装，将来的车都改成黑色，三个轮胎
	public static void show(Car c)
	{
		c.num=3;
		c.color="black";
		c.run();
	}
}