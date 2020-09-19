package line;

import java.text.DecimalFormat;

public class Point {
    private double x = 0;
    private double y = 0;
    DecimalFormat df = new DecimalFormat("");

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

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
        df.setMaximumFractionDigits(2);//������λС��
        return "X="+df.format(x)+",Y="+df.format(y)+"\n";
    }
}
