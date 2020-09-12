package Tools;

public class DMSChange {
    /**
     * 度.分秒转弧度
     * @param dms 输入度.分秒
     * @return rad对应弧度[0,2*PI)
     */
    public static double DMSToRad(double dms)
    {
        int deg = (int)dms;
        double m = (int)(dms*100-deg*100);
        double s = (dms*10000-deg*10000-m*100);
        double d = deg+m/60+s/3600;
        //double rad = Math.toRadians(dms);
        double rad = d*Math.PI/180;
        return rad;
    }
}
