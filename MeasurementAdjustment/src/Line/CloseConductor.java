package line;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;
import static tools.DMSChange.dmsToRad;

/**
 * 闭合导线类
 * @version V1.0
 * @author xff07
 */
public class CloseConductor {
    private Point p1;
    protected ArrayList<Double> azimuths = new ArrayList<>();
    private ArrayList<Double> longs = new ArrayList<>();
    private int n = 0;//未知点的个数+1,未知点加起点终点
    private HashMap<String,Double> f = new HashMap<>();
    double da;//角度改正数
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Double> azimuth = new ArrayList<>();

    /**
     * 返回辅助计算结果
     * @return 辅助计算的变量名和其值的集合
     */
    public HashMap<String, Double> getF() {
        return f;
    }

    public CloseConductor(Point p1, double azi) {
        this.p1 = p1;
        points.add(p1);
        azimuths.add(dmsToRad(azi));
    }

    /**
     * 向导线中添加观测角值
     * @param azi 观测左角值，格式DD.mmss
     */
    public void addAzi(double azi) {
        azi = dmsToRad(azi);
        azimuth.add(azi);
        double a = ((azi + azimuths.get(n)-PI)+2*PI)%(2*PI);
        azimuths.add(a);
        points.add(null);
        n++;
    }

    /**
     * 向导线中添加观测距离值
     * @param l 观测的距离
     */
    public void addLong(double l)
    {
        longs.add(l);
    }

    /**
     * 进行闭合导线平差计算
     * @return 平差后所有点组成的集合
     */
    public ArrayList<Point> adjustment()
    {
        double dts;
        ArrayList<Double> dx = new ArrayList<>();
        ArrayList<Double> dy = new ArrayList<>();
        double dtx,dty;
        double sumL = 0;
        double sumDx = 0;
        double sumDy = 0;
        da = 0;
        for (double d : azimuth) {
            da += d;
        }
        da = da-(n-2)*PI;
        dts = - da / (n);
        for (int i = 0; i < n; i++) {
            azimuths.set(i+1,azimuths.get(i+1)+dts);
        }


        for (int i = 0; i < n; i++) {
            dx.add(longs.get(i) * cos(azimuths.get(i)));
            dy.add(longs.get(i) * sin(azimuths.get(i)));
        }


        for (double l: longs) {
            sumL += l;
        }
        for (double x : dx) {
            sumDx += x;
        }
        for (double y : dy) {
            sumDy += y;
        }
        dtx = sumDx;
        dty = sumDy;

        for (int i = 0; i < n; i++) {
            double x1 = points.get(i).getX();
            double y1 = points.get(i).getY();
            dx.set(i,dx.get(i)-dtx*longs.get(i)/sumL);
            dy.set(i,dy.get(i)-dty*longs.get(i)/sumL);
            double x2 = x1 + dx.get(i);
            double y2 = y1 + dy.get(i);
            points.set(i+1,new Point(x2,y2));
        }


        f.put("fβ",da);
        f.put("fβ容",40*sqrt(n));
        f.put("fx", dtx);
        f.put("fy", dty);
        f.put("f",sqrt(dtx*dtx+dty*dty));
        f.put("K",sqrt(dtx*dtx+dty*dty)/sumL);

        return points;
    }
}
