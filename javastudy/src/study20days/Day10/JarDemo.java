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
META-INF/MANIFEST.MF		//�����嵥�ļ�
pack/
pack/JarDemo.class
pack/PackageDemo.class
packa/
packa/DemoA.class
packa/Demoaa.class


set classpath=C:\Users\xff07\OneDrive\����\Java\Day10\haha.jar
java pack.JarDemo


eclipse Ctel+Shift+O


C:\Users\xff07\OneDrive\����\Java\Day10>jar -cfv a.jar pack packa
������嵥
�������: pack/(���� = 0) (��� = 0)(�洢�� 0%)
�������: pack/JarDemo.class(���� = 488) (��� = 333)(ѹ���� 31%)
�������: pack/PackageDemo.class(���� = 331) (��� = 250)(ѹ���� 24%)
�������: packa/(���� = 0) (��� = 0)(�洢�� 0%)
�������: packa/DemoA.class(���� = 421) (��� = 302)(ѹ���� 28%)
�������: packa/Demoaa.class(���� = 401) (��� = 286)(ѹ���� 28%)


C:\Users\xff07\OneDrive\����\Java\Day10>jar -tvf a.jar
     0 Sat Mar 21 20:41:32 CST 2020 META-INF/
    66 Sat Mar 21 20:41:32 CST 2020 META-INF/MANIFEST.MF
     0 Sat Mar 21 18:56:18 CST 2020 pack/
   488 Sat Mar 21 18:58:38 CST 2020 pack/JarDemo.class
   331 Fri Mar 20 23:09:02 CST 2020 pack/PackageDemo.class
     0 Sat Mar 21 18:57:22 CST 2020 packa/
   421 Fri Mar 20 23:08:56 CST 2020 packa/DemoA.class
   401 Sat Mar 21 18:58:34 CST 2020 packa/Demoaa.class
   
   
C:\Users\xff07\OneDrive\����\Java\Day10>jar -tf a.jar >C:\Users\xff07\OneDrive\����\Java\Day10\1.txt
�����ض���
*/