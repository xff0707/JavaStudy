package line;

import java.text.DecimalFormat;

/**
 * 代表平面上的一个点
 * @version V1.0
 * @author xff07
 */
public class Point {
    private double x = 0;
    private double y = 0;
    DecimalFormat df = new DecimalFormat();//用于规范输出格式

    /**
     *
     * @param x x坐标
     * @param y y坐标
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param x x坐标
     * @param y y坐标
     */
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 创造一个空坐标的点
     */
    public Point() {
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        df.setMaximumFractionDigits(2);//保留两位小数
        return "X="+df.format(x)+",Y="+df.format(y)+"\n";
    }
}
