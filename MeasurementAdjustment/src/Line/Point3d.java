package line;

import java.text.DecimalFormat;

/**
 * ����ռ��ϵ�һ����
 * @version V1.0
 * @author xff07
 */
public class Point3d {
    private double x = 0;
    private double y = 0;
    private double z = 0;
    DecimalFormat df = new DecimalFormat();//���ڹ淶�����ʽ

    /**
     *
     * @param x x����
     * @param y y����
     * @param z z����
     */
    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @param x x����
     * @param y y����
     * @param z z����
     */
    public Point3d(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * ����һ��������ĵ�
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
        df.setMaximumFractionDigits(2);//������λС��
        return "X="+df.format(x)+",Y="+df.format(y)+"Z="+df.format(z)+"\n";
    }
}
