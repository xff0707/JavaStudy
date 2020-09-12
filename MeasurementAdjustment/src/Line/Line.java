package Line;

public class Line {

    private Point startP;
    private Point endP;
    private double azimuth;
    private double longness;

    public Line(Point startP, Point endP) {
        this.startP = startP;
        this.endP = endP;
        CalculateAzimuth();
        CalculateLongness();
    }

    public Line() {
    }

    public Point getStartP() {
        return startP;
    }

    public void setStartP(Point startP) {
        this.startP = startP;
    }

    public Point getEndP() {
        return endP;
    }

    public void setEndP(Point endP) {
        this.endP = endP;
    }

    private void CalculateAzimuth()
    {
        azimuth = Math.atan2(endP.getY()-startP.getY(),endP.getX()-startP.getX());
    }

    private void CalculateLongness()
    {
        longness = Math.hypot(endP.getY()-startP.getY(),endP.getX()-startP.getX());//·µ»Øsqrt£¨x^2  + y^2£©
    }

}
