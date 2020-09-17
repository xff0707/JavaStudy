package Day15;
//泛型定义在接口上

interface inter<T>
{
    void show(T t);
}

/*
class InterImpl implements inter<String>
{
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}

 */

class InterImpl<T> implements inter<T>
{

    @Override
    public void show(T t) {
        System.out.println("show:"+t);
    }
}



public class GenericDemo5 {
    public static void main(String[] args) {
        //InterImpl i = new InterImpl();
        //i.show("hahahah");

        InterImpl<Integer> i = new InterImpl<Integer>();
        i.show(555);

    }
}
