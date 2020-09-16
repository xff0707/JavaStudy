package supplementary.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class test6 {
    public static void main(String[] args) throws NoSuchMethodException {
        //通过反射获取泛型

        Method method = test6.class.getMethod("test01", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type gen: genericParameterTypes
             ) {
            System.out.println("#"+gen);
            if (gen instanceof ParameterizedType)
            {
                Type[] actualTypeArguments = ((ParameterizedType) gen).getActualTypeArguments();
                Arrays.stream(actualTypeArguments).forEach(System.out::println);
            }
        }


        Method method2 = test6.class.getMethod("test02", null);

        Type gen = method2.getGenericReturnType();

        /*
        System.out.println("#"+gen);
        if (gen instanceof ParameterizedType)
        {
            Type[] actualTypeArguments = ((ParameterizedType) gen).getActualTypeArguments();
            Arrays.stream(actualTypeArguments).forEach(System.out::println);
        }
        */

    }

    public void test01(Map<String,User> map, List<User> list)
    {
        System.out.println("test01");
    }

    public Map<String,User> test01()
    {
        System.out.println("test02");
        return null;
    }


}
