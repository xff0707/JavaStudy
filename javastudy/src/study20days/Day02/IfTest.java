package Day02;

class IfTest
{
	public static void main(String []args)
	{
		//345春季
		/*
		如果判断的具体数值不多，而是符合byte short int char这四种类型
		使用Switch 效率精度高
		其他情况：对区间判断，对结果为Boolean类型判断：使用if适用范围更广
		*/
		int x=5;
		
		switch(x)
		{
			case 3:
			case 4:
			case 5:
			System.out.println(x+"春季");
			break;
			case 6:
			case 7:
			case 8:
			System.out.println(x+"夏季");
			case 9:
			case 10:
			case 11:
			System.out.println(x+"秋季");
			case 12:
			case 1:
			case 2:
			System.out.println(x+"冬季");
			default:
			System.out.println("nono");
		}
	}
}