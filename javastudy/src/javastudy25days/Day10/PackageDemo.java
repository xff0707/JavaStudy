package javastudy25days.Day10;
//package pack;//所有字母小写
/*
包:对类进行分类管理,给类提供多层命名空间
javac -d . PackageDemo.java  || javac -d d:\myclass PackageDemo.java ||set classpath=c:\myclass ||java pack.PackageDemo
为了简化类名的书写，使用一个关键字，import
导入的是包中的类
建议：不要写通配符*，需要用到包中的哪个类，就导入哪个类
不同包中同名类使用时必须加包名
建议定义包名不要重名，可以使用url来完成定义，url是唯一的。
www.itcast.cn
package cn.itcast.demo		package cn.itcast.test
*/
//import packb.haha.hehe.heiehi.*;//import packb.haha.hehe.heiehi.DemoC;

class PackageDemo
{
	public static void main(String[] args)
	{
		// System.out.println("Hello Page");
		javastudy25days.Day10.packa.DemoA d = new javastudy25days.Day10.packa.DemoA();
		d.show();
		
		// packb.DemoB d = new packb.DemoB();
		// d.method();
		
		//packb.haha.hehe.heiehi.DemoC c = new packb.haha.hehe.heiehi.DemoC();
	}
}

/*
C:\Users\xff07\OneDrive\桌面\Java\javastudy20days.Day10>javac -d . PackageDemo.java
PackageDemo.java:20: 错误: 找不到符号
                DemoA d = new DemoA();
                ^
  符号:   类 DemoA
  位置: 类 PackageDemo
PackageDemo.java:20: 错误: 找不到符号
                DemoA d = new DemoA();
                              ^
  符号:   类 DemoA
  位置: 类 PackageDemo
2 个错误

错误原因：类名写错

因为类名的全名是：包名.类名



PackageDemo.java:20: 错误: 程序包packa不存在
                packa.DemoA d = new packa.DemoA();
                     ^
PackageDemo.java:20: 错误: 程序包packa不存在
                packa.DemoA d = new packa.DemoA();
                                         ^
2 个错误

错误原因：packa包不在当前目录下

需要设置classpath，告诉jvm去哪里找指定的packa包



C:\Users\xff07\OneDrive\桌面\Java\javastudy20days.Day10>javac -d . PackageDemo.java
PackageDemo.java:20: 错误: DemoA在packa中不是公共的; 无法从外部程序包中对其进行访问
                packa.DemoA d = new packa.DemoA();
                     ^
PackageDemo.java:20: 错误: DemoA在packa中不是公共的; 无法从外部程序包中对其进行访问
                packa.DemoA d = new packa.DemoA();
                                         ^
2 个错误

错误原因：有了包，范围变大，一个包中的类要被访问，必须要有足够大的权限



PackageDemo.java:21: 错误: show()在DemoA中不是公共的; 无法从外部程序包中对其进行访问
                d.show();
                 ^
1 个错误

错误原因：类共有后，被访问的成员也要共有才可以被访问







总结：
	包与包之间进行访问，被访问的包中的类以及类中的成员，需要public修饰

	不同包中的子类可以直接访问父类中被protected权限修饰的成员

包与包之间可以使用的权限只有两种：public protected


			public	  protected  	   default  	private
同一个类中    ok         ok              ok           ok
同一个包中    ok         ok              ok           no
子类          ok         ok              no           no
不同包中      ok         no              no           no


类名加了公有以后，类名必须和java名保持一致
一个.java文件里面不能出现两个以上的公有类或者接口



*/