package line;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.*;
import static tools.DMSChange.*;

/**
 * 附和导线类
 * @version V1.0
 * @author xff07
 */
public class CompositeConductor {
    private Point p1, p2, p3, p4;
    private ArrayList<Double> azimuths = new ArrayList<>();
    private ArrayList<Double> longs = new ArrayList<>();
    private int n = 0;//未知点的个数+2,未知点加起点终点
    private HashMap<String,Double> f = new HashMap<>();//用于存放辅助计算的值
    double da;//角度值改正数
    private ArrayList<Point> points = new ArrayList<>();//该附和导线所有点的集合

    /**
     * 返回辅助计算结果
     * @return 辅助计算的变量名和其值的集合
     */
    public HashMap<String, Double> getF() {
        return f;
    }

    /**
     * 创造一个以p1和p2为导线起点，p3和p4为导线结束的附和导线
     * @param p1 第一个点
     * @param p2 第二个点
     * @param p3 第三个点
     * @param p4 第四个点
     */
    public CompositeConductor(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        azimuths.add((atan2(p2.getY()-p1.getY(),p2.getX()-p1.getX())+2*PI)%(2*PI));
        points.add(p1);
        points.add(p2);
    }

    /**
     * 向导线中添加观测角值
     * @param azi 观测左角值，格式DD.mmss
     */
    public void addAzi(double azi) {
        azi = dmsToRad(azi);
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
     * 进行附和导线平差计算
     * @return 平差后所有点组成的集合
     */
    public ArrayList<Point> adjustment()
    {
        double dts;
        ArrayList<Double> dx = new ArrayList<>();
        ArrayList<Double> dy = new ArrayList<>();//坐标增量集合
        double dtx,dty;//改正数之和
        double sumL = 0;
        double sumDx = 0;
        double sumDy = 0;
        azimuths.add((atan2(p4.getY()-p3.getY(),p4.getX()-p3.getX())+2*PI)%(2*PI));
        da = azimuths.get(n) - azimuths.get(n+1);
        dts = - da / (n);//角度改正数
        for (int i = 0; i < n; i++) {
            azimuths.set(i+1,azimuths.get(i+1)+dts);
        }


        for (int i = 0; i < n-1; i++) {
            dx.add(longs.get(i) * cos(azimuths.get(i+1)));
            dy.add(longs.get(i) * sin(azimuths.get(i+1)));
        }

        points.set(n+1,p3);
        for (double l: longs) {
            sumL += l;
        }
        for (double x : dx) {
            sumDx += x;
        }
        for (double y : dy) {
            sumDy += y;
        }

        dtx = sumDx - (p3.getX()-p2.getX());
        dty = sumDy - (p3.getY()-p2.getY());

        //对坐标进行误差分配
        for (int i = 0; i < n-1; i++) {
            double x1 = points.get(i+1).getX();
            double y1 = points.get(i+1).getY();
            dx.set(i,dx.get(i)-dtx*longs.get(i)/sumDx);
            dy.set(i,dy.get(i)-dty*longs.get(i)/sumDy);//按照
            double x2 = x1 + dx.get(i);
            double y2 = y1 + dy.get(i);
            points.set(i+2,new Point(x2,y2));
        }

        f.put("fβ",da);
        f.put("fβ容",40*sqrt(n));
        f.put("fx", dtx);
        f.put("fy", dty);
        f.put("f",sqrt(dtx*dtx+dty*dty));
        f.put("K",sqrt(dtx*dtx+dty*dty)/sumL);//将相关辅助计算结果存入集合中

        points.set(n,p3);
        points.set(n+1,p4);//最后两个为已知点
        return points;
    }
}
