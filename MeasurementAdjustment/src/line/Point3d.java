package line;

import java.text.DecimalFormat;

/**
 * 代表空间上的一个点
 * @version V1.0
 * @author xff07
 */
public class Point3d {
    private double x = 0;
    private double y = 0;
    private double z = 0;
    DecimalFormat df = new DecimalFormat();//用于规范输出格式

    /**
     *
     * @param x x坐标
     * @param y y坐标
     * @param z z坐标
     */
    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @param x x坐标
     * @param y y坐标
     * @param z z坐标
     */
    public Point3d(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 创造一个空坐标的点
     */
    public Point3d() {
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        df.setMaximumFractionDigits(2);//保留两位小数
        return "X="+df.format(x)+",Y="+df.format(y)+"Z="+df.format(z)+"\n";
    }
}
