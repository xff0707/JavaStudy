package Day13;

/*
3. ��ȡһ���ַ�������һ���ַ����г��ֵĴ�����
    "abkkcdkkefkkskk"
    ˼·��
    1. ����һ����������
    2. ��ȡkk��һ�γ��ֵ�λ�á�
    3. �ӵ�һ�γ���λ�ú�ʣ����ַ����м�����ȡkk���ֵ�λ�á�
        ÿ��ȡһ�ξͼ���һ�Ρ�
    4. ����ȡ����ʱ��������ɡ�


4.��ȡ�����ַ����������ͬ�ִ�����һ�����������̵��Ǹ������г���һ�εݼ����Ӵ���ӡ��
    "abcwerthelloyuiodef"
    "cvhellobnm"
    ˼·��
        1. ���̵��Ǹ��Ӵ����ճ��ȵݼ��ķ�ʽ��ȡ����
        2. ����ȡ�����Ӵ�ȥ�������ж��Ƿ������
            ����������Ѿ��ҵ�����
*/
public class StringTest2 {
    /*
    ��ϰ����
    */
    public static int getSubCount(String str,String key)
    {
        int count = 0;
        int index = 0;

        while((index=str.indexOf(key))!=-1)//�Ӵ���һ�γ��ֵ�λ��
        {
            System.out.println("str="+str);
            str = str.substring(index+key.length());//�Ӵ���һ�γ��ֵ�λ��+�Ӵ����ȣ��´β��ҵĴ�

            count++;
        }
        return count;
    }

    /*
    ��ϰ������ʽ����
     */
    public static int getSubCount_2(String str,String key)
    {
        int count = 0;
        int index = 0;

        while((index=str.indexOf(key,index))!=-1)//�Ӵ���һ�γ��ֵ�λ��
        {
            System.out.println("index="+index);
           index += key.length();

            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abkkcdkkefkkskk";

        //System.out.println("count======"+str.split("kk").length);//������ʹ��

        //System.out.println("count="+getSubCount(str,"kk"));
        System.out.println("count="+getSubCount_2(str,"kk"));
    }
}
