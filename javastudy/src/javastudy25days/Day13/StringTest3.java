package javastudy25days.Day13;

/*
4.��ȡ�����ַ����������ͬ�ִ�����һ�����������̵��Ǹ������г���һ�εݼ����Ӵ���ӡ��
"abcwerthelloyuiodef"
"cvhellobnm"
˼·��
1. ���̵��Ǹ��Ӵ����ճ��ȵݼ��ķ�ʽ��ȡ����
2. ����ȡ�����Ӵ�ȥ�������ж��Ƿ������
����������Ѿ��ҵ�����
*/
public class StringTest3 {
    /*
    ��ϰ�ġ�
    */
    public static String getMaxSubString(String s1,String s2)
    {
        String max="",min = "";

        max = (s1.length()>s2.length())?s1:s2;
        min = (max==s1)?s2:s1;
        //System.out.println("max="+max);
        //System.out.println("min="+min);
        for(int x=0;x<min.length();x++)
        {
            for(int y=0,z=min.length()-x;z!=min.length()+1;y++,z++)
            {
                String temp = min.substring(y,z);

                //System.out.println(temp);

                if (max.contains(temp))//if(s1.indexOf(temp)!=-1)
                    return temp;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s1 = "abcwerthelloyuiodef";
        String s2 = "cvhellobnm";
        System.out.println(getMaxSubString(s1,s2));
    }
}
