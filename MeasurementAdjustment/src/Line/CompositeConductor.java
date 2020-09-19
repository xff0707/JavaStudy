package line;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.*;
import static tools.DMSChange.*;

public class CompositeConductor {
    private Point p1, p2, p3, p4;
    protected ArrayList<Double> azimuths = new ArrayList<>();
    //private ArrayList<Double> azimuthsChanged = new ArrayList<>();
    private ArrayList<Double> longs = new ArrayList<>();
    private int n = 0;//未知点的个数+2,未知点加起点终点

    private HashMap<String,Double> f = new HashMap<>();
    double da;
    private ArrayList<Point> points = new ArrayList<>();

    public HashMap<String, Double> getF() {
        return f;
    }

    public CompositeConductor(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        azimuths.add((atan2(p2.getY()-p1.getY(),p2.getX()-p1.getX())+2*PI)%(2*PI));
        points.add(p1);
        points.add(p2);
    }

    public void addAzi(double azi) {
        azi = dmsToRad(azi);
        double a = ((azi + azimuths.get(n)-PI)+2*PI)%(2*PI);
        azimuths.add(a);
        points.add(null);
        n++;
    }

    public void addLong(double l)
    {
        longs.add(l);
    }

    public ArrayList<Point> adjustment()
    {
        double dts;
        ArrayList<Double> dx = new ArrayList<>();
        ArrayList<Double> dy = new ArrayList<>();
        double dtx,dty;
        double sumL = 0;
        double sumDx = 0;
        double sumDy = 0;
        azimuths.add((atan2(p4.getY()-p3.getY(),p4.getX()-p3.getX())+2*PI)%(2*PI));
        da = azimuths.get(n) - azimuths.get(n+1);
        dts = - da / (n);
        for (int i = 0; i < n; i++) {
            azimuths.set(i+1,azimuths.get(i+1)+dts);
        }


        for (int i = 0; i < n-1; i++) {
            //double x1 = points.get(i+1).getX();
            //double y1 = points.get(i+1).getY();
            //double x2 = x1 + longs.get(i) * cos(azimuths.get(i+1));
            //double y2 = y1 + longs.get(i) * sin(azimuths.get(i+1));
            dx.add(longs.get(i) * cos(azimuths.get(i+1)));
            dy.add(longs.get(i) * sin(azimuths.get(i+1)));
        }

        points.set(n+1,p3);
        //points.add(p4);
        for (double l: longs) {
            sumL += l;
        }
        for (double x : dx) {
            sumDx += x;
        }
        for (double y : dy) {
            sumDy += y;
        }
        dtx = sumDx - (points.get(n+1).getX()-points.get(1).getX());
        dty = sumDy - (points.get(n+1).getY()-points.get(1).getY());

        for (int i = 0; i < n-1; i++) {
            double x1 = points.get(i+1).getX();
            double y1 = points.get(i+1).getY();
            dx.set(i,dx.get(i)-dtx*longs.get(i)/sumDx);
            dy.set(i,dy.get(i)-dty*longs.get(i)/sumDy);
            double x2 = x1 + dx.get(i);
            double y2 = y1 + dy.get(i);
            points.set(i+2,new Point(x2,y2));
        }


        f.put("fβ",da);
        f.put("fβ容",40*sqrt(n));
        f.put("fx", dtx);
        f.put("fy", dty);
        f.put("f",sqrt(dtx*dtx+dty*dty));
        f.put("K",sqrt(dtx*dtx+dty*dty)/sumL);



        points.set(n,p3);
        points.set(n+1,p4);
        return points;
    }





}
