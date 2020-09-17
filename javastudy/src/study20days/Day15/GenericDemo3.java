package Day15;
/*
泛型类
什么时候定义泛型类？
当类中要操作的引用数据类型不确定的时候，
早期定义Object来完成扩展。
现在定义泛型类来完成扩展。
*/

/*
class Tool
{
    private Worker w;
    public void setWorker(Worker w)
    {
        this.w = w;
    }

    public Worker getWorker() {
        return w;
    }
}
*/

class Worker
{

}

class Studentt
{

}

//泛型前做法
class Tool
{
    private Object obj;
    public void setObject(Object obj)
    {
        this.obj = obj;
    }

    public Object getObject() {
        return obj;
    }
}

class Utils<QQ>
{
    private QQ q;
    public void setObject(QQ q)
    {
        this.q = q;
    }

    public QQ getObject() {
        return q;
    }
}



public class GenericDemo3 {
    public static void main(String[] args) {

        Utils<Worker> u = new Utils<Worker>();

        u.setObject(new Worker());
        //Worker w = (Worker) u.getObject();
        Worker w =  u.getObject();


        /*
        Tool t = new Tool();
        //t.setObject(new Worker());

        t.setObject(new Studentt());
        Worker w = (Worker) t.getObject();
        */
    }
}
