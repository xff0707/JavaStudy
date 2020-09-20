package line;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * 支导线类
 * @version V1.0
 * @author xff07
 */
public class Traverse {
    //支导线
    private int n = 1;//点的个数,默认0和1为起点
    private ArrayList<Point> points = new ArrayList<>();
    private double azimuth;
    private ArrayList<Double> azimuths = new ArrayList<>();

    /**
     *创造一条支导线，已知起点为p1何p2
     * @param p1 支导线第一个已知点
     * @param p2 支导线第二个已知点
     */
    public Traverse(Point p1, Point p2) {
        points.add(p1);
        points.add(p2);
        //azimuths.add(0.0);//默认第一个为0
        azimuths.add(Math.atan2(p2.getY()-p1.getY(),p2.getX()-p1.getX()));
    }

    /**
     * 返回该支导线上所有点的集合
     * @return 返回该支导线上所有点的集合
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * 向该支导线中添加一个点，输入角度和距离，自动计算出下一点
     * @param azi 观测角左角角度，格式DD.mmss
     * @param s 距离
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
