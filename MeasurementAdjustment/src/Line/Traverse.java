package line;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Traverse {
    //支导线
    private int n = 1;//点的个数,默认0和1为起点
    private ArrayList<Point> points = new ArrayList<>();
    private double azimuth;
    private ArrayList<Double> azimuths = new ArrayList<>();


    public Traverse(Point p1, Point p2) {
        points.add(p1);
        points.add(p2);
        //azimuths.add(0.0);//默认第一个为0
        azimuths.add(Math.atan2(p2.getY()-p1.getY(),p2.getX()-p1.getX()));
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

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


    public void addAll(Map<Double,Double> mp1)
    {
        Set<Map.Entry<Double,Double>> set = mp1.entrySet();
        for (Map.Entry<Double,Double> entry : set)
        {
            double azi = entry.getKey();
            double s = entry.getValue();
            double a = ((azi + azimuth-Math.PI)+2*Math.PI)%(2*Math.PI);
            double x1 = points.get(n).getX();
            double y1 = points.get(n).getY();
            double x2 = x1 + s * Math.cos(a);
            double y2 = y1 + s * Math.sin(a);
            Point p1 = new Point(x2,y2);
            points.add(p1);
            n++;
        }
    }

}
