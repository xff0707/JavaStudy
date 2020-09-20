package line;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * ֧������
 * @version V1.0
 * @author xff07
 */
public class Traverse {
    //֧����
    private int n = 1;//��ĸ���,Ĭ��0��1Ϊ���
    private ArrayList<Point> points = new ArrayList<>();
    private double azimuth;
    private ArrayList<Double> azimuths = new ArrayList<>();

    /**
     *����һ��֧���ߣ���֪���Ϊp1��p2
     * @param p1 ֧���ߵ�һ����֪��
     * @param p2 ֧���ߵڶ�����֪��
     */
    public Traverse(Point p1, Point p2) {
        points.add(p1);
        points.add(p2);
        //azimuths.add(0.0);//Ĭ�ϵ�һ��Ϊ0
        azimuths.add(Math.atan2(p2.getY()-p1.getY(),p2.getX()-p1.getX()));
    }

    /**
     * ���ظ�֧���������е�ļ���
     * @return ���ظ�֧���������е�ļ���
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * ���֧���������һ���㣬����ǶȺ;��룬�Զ��������һ��
     * @param azi �۲����ǽǶȣ���ʽDD.mmss
     * @param s ����
     */
    public void add(double azi, double s)
    {
        azi = tools.DMSChange.dmsToRad(azi);
        double a = ((azi + azimuths.get(n-1)-Math.PI)+2*Math.PI)%(2*Math.PI);
        azimuths.add(a);
        double x1 = points.get(n).getX();
        double y1 = points.get(n).getY();
        double x2 = x1 + s * Math.cos(a);
        double y2 = y1 + s * Math.sin(a);
        Point p = new Point(x2,y2);

        points.add(p);
        n++;
    }

}
