package Line;

import javax.swing.plaf.basic.BasicToolBarSeparatorUI;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Traverse {
    //支导线
    protected int n = 1;//点的个数,默认0和1为起点
    protected ArrayList<Point> points = new ArrayList<>();
    protected double azimuth;

    /*
    public Line.Traverse(Line.Line line) {
        //this.lines.add(lStart);
        points.add(line.getStartP());
        points.add(line.getEndP());
        azimuth = Math.atan2(line.getEndP().getY()-line.getStartP().getY(),line.getEndP().getX()-line.getStartP().getX());
    }

     */

    /*
    public Line.Traverse(Line.Point p, double azimuth) {
        points.add(new Line.Point(0,0));
        points.add(p);
        this.azimuth = azimuth;

    }

     */

    public Traverse(Point p1, Point p2) {
        points.add(p1);
        points.add(p2);
        azimuth = Math.atan2(p2.getY()-p1.getY(),p2.getX()-p1.getX());
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void add(double azi, double s)
    {
        azi = Tools.DMSChange.DMSToRad(azi);
        double a = ((azi + azimuth-Math.PI)+2*Math.PI)%(2*Math.PI);
        double x1 = points.get(n).getX();
        double y1 = points.get(n).getY();
        double x2 = x1 + s * Math.cos(a);
        double y2 = y1 + s * Math.sin(a);
        Point p1 = new Point(x2,y2);
        points.add(p1);
        n++;
    }

    public void addAll(double[] azis, double[] s)
    {
        for (int i=0;i<azis.length;i++)
        {
            double a = ((azis[i] + azimuth-Math.PI)+2*Math.PI)%(2*Math.PI);
            double x1 = points.get(n).getX();
            double y1 = points.get(n).getY();
            double x2 = x1 + s[i] * Math.cos(a);
            double y2 = y1 + s[i] * Math.sin(a);
            Point p1 = new Point(x2,y2);
            points.add(p1);
            n++;
        }
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
