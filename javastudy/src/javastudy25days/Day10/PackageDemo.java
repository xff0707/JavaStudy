package javastudy25days.Day10;
//package pack;//������ĸСд
/*
��:������з������,�����ṩ��������ռ�
javac -d . PackageDemo.java  || javac -d d:\myclass PackageDemo.java ||set classpath=c:\myclass ||java pack.PackageDemo
Ϊ�˼���������д��ʹ��һ���ؼ��֣�import
������ǰ��е���
���飺��Ҫдͨ���*����Ҫ�õ����е��ĸ��࣬�͵����ĸ���
��ͬ����ͬ����ʹ��ʱ����Ӱ���
���鶨�������Ҫ����������ʹ��url����ɶ��壬url��Ψһ�ġ�
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
C:\Users\xff07\OneDrive\����\Java\javastudy20days.Day10>javac -d . PackageDemo.java
PackageDemo.java:20: ����: �Ҳ�������
                DemoA d = new DemoA();
                ^
  ����:   �� DemoA
  λ��: �� PackageDemo
PackageDemo.java:20: ����: �Ҳ�������
                DemoA d = new DemoA();
                              ^
  ����:   �� DemoA
  λ��: �� PackageDemo
2 ������

����ԭ������д��

��Ϊ������ȫ���ǣ�����.����



PackageDemo.java:20: ����: �����packa������
                packa.DemoA d = new packa.DemoA();
                     ^
PackageDemo.java:20: ����: �����packa������
                packa.DemoA d = new packa.DemoA();
                                         ^
2 ������

����ԭ��packa�����ڵ�ǰĿ¼��

��Ҫ����classpath������jvmȥ������ָ����packa��



C:\Users\xff07\OneDrive\����\Java\javastudy20days.Day10>javac -d . PackageDemo.java
PackageDemo.java:20: ����: DemoA��packa�в��ǹ�����; �޷����ⲿ������ж�����з���
                packa.DemoA d = new packa.DemoA();
                     ^
PackageDemo.java:20: ����: DemoA��packa�в��ǹ�����; �޷����ⲿ������ж�����з���
                packa.DemoA d = new packa.DemoA();
                                         ^
2 ������

����ԭ�����˰�����Χ���һ�����е���Ҫ�����ʣ�����Ҫ���㹻���Ȩ��



PackageDemo.java:21: ����: show()��DemoA�в��ǹ�����; �޷����ⲿ������ж�����з���
                d.show();
                 ^
1 ������

����ԭ���๲�к󣬱����ʵĳ�ԱҲҪ���вſ��Ա�����







�ܽ᣺
	�����֮����з��ʣ������ʵİ��е����Լ����еĳ�Ա����Ҫpublic����

	��ͬ���е��������ֱ�ӷ��ʸ����б�protectedȨ�����εĳ�Ա

�����֮�����ʹ�õ�Ȩ��ֻ�����֣�public protected


			public	  protected  	   default  	private
ͬһ������    ok         ok              ok           ok
ͬһ������    ok         ok              ok           no
����          ok         ok              no           no
��ͬ����      ok         no              no           no


�������˹����Ժ����������java������һ��
һ��.java�ļ����治�ܳ����������ϵĹ�������߽ӿ�



*/