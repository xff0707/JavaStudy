package Day10;
//package pack;
//import packa.*;

class JarDemo
{
	public static void main(String[] args)
	{
		Day10.packa.Demoaa a = new Day10.packa.Demoaa();
		a.show();
		System.out.println("Hello Jar pack!");
	}
}

/*
jar -cf haha.jar pack packa

jar -tf haha.jar
META-INF/
META-INF/MANIFEST.MF		//配置清单文件
pack/
pack/JarDemo.class
pack/PackageDemo.class
packa/
packa/DemoA.class
packa/Demoaa.class


set classpath=C:\Users\xff07\OneDrive\桌面\Java\Day10\haha.jar
java pack.JarDemo


eclipse Ctel+Shift+O


C:\Users\xff07\OneDrive\桌面\Java\Day10>jar -cfv a.jar pack packa
已添加清单
正在添加: pack/(输入 = 0) (输出 = 0)(存储了 0%)
正在添加: pack/JarDemo.class(输入 = 488) (输出 = 333)(压缩了 31%)
正在添加: pack/PackageDemo.class(输入 = 331) (输出 = 250)(压缩了 24%)
正在添加: packa/(输入 = 0) (输出 = 0)(存储了 0%)
正在添加: packa/DemoA.class(输入 = 421) (输出 = 302)(压缩了 28%)
正在添加: packa/Demoaa.class(输入 = 401) (输出 = 286)(压缩了 28%)


C:\Users\xff07\OneDrive\桌面\Java\Day10>jar -tvf a.jar
     0 Sat Mar 21 20:41:32 CST 2020 META-INF/
    66 Sat Mar 21 20:41:32 CST 2020 META-INF/MANIFEST.MF
     0 Sat Mar 21 18:56:18 CST 2020 pack/
   488 Sat Mar 21 18:58:38 CST 2020 pack/JarDemo.class
   331 Fri Mar 20 23:09:02 CST 2020 pack/PackageDemo.class
     0 Sat Mar 21 18:57:22 CST 2020 packa/
   421 Fri Mar 20 23:08:56 CST 2020 packa/DemoA.class
   401 Sat Mar 21 18:58:34 CST 2020 packa/Demoaa.class
   
   
C:\Users\xff07\OneDrive\桌面\Java\Day10>jar -tf a.jar >C:\Users\xff07\OneDrive\桌面\Java\Day10\1.txt
数据重定向
*/