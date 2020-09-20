package line;

import Jama.Matrix;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.*;

/**
 * ���ڼ���ռ�󷽽�����
 */
public class SpaceRear {
    private ArrayList<Point> coorsPic = new ArrayList<>();
    private ArrayList<Point3d> coorsSpa = new ArrayList<>();
    private Point coorPic;
    private Point3d coorSpa;
    private double f, m, toa,ptNum;

    /**
     * ����һ���ռ�󷽽�����
     * @param coorPic ��Ƭ��
     * @param coorSpa �ռ��
     * @param f ���������
     * @param m �����߷�ĸ
     * @param toa �޲�
     */
    public SpaceRear(Point coorPic, Point3d coorSpa, double f, double m, double toa) {
        this.coorPic = coorPic;
        this.coorSpa = coorSpa;
        coorsPic.add(coorPic);
        coorsSpa.add(coorSpa);
        this.f = f/1000;
        this.m = m;
        this.toa = toa;
    }

    /**
     * ��ô��������һ������
     * @param coorPic ��Ƭ��
     * @param coorSpa �ռ��
     */
    public void add(Point coorPic, Point3d coorSpa)
    {
        coorsPic.add(coorPic);
        coorsSpa.add(coorSpa);
    }


    /**
     * �������е�������޲�����ݽ��м���
     * @return
     */
    public HashMap<String,Double> calculate()
    {
        HashMap<String,Double> calu = new HashMap<>();
        Matrix m1;
        Matrix m2;
        Matrix m3;
        Matrix R;
        Matrix L = null;
        Matrix A = null;
        Matrix mi;
        double m0;
        Matrix DX = null;

        ptNum = (int) coorsPic.size();
        double Xso,Yso,Zso;//��Ԫ��
        double sum = 0;
        for (Point3d p:coorsSpa) {
            sum += p.getX();
        }
        Xso = sum/ptNum;

        sum = 0;
        for (Point3d p:coorsSpa) {
            sum += p.getY();
        }
        Yso = sum/ptNum;
        Zso = f*m;

        //�����
        double[][] allCoors = new double[(int) ptNum][5];
        for (int i = 0; i < ptNum; i++) {
            allCoors[i][0] = coorsPic.get(i).getX()/1000;
            allCoors[i][1] = coorsPic.get(i).getY()/1000;
            allCoors[i][2] = coorsSpa.get(i).getX();
            allCoors[i][3] = coorsSpa.get(i).getY();
            allCoors[i][4] = coorsSpa.get(i).getZ();
        }
        Matrix Coors = new Matrix(allCoors);

        Matrix d = new Matrix(6,1);
        d.set(0,0,Xso);
        d.set(1,0,Xso);
        d.set(2,0,Xso);

        double d�� = 1;
        double d�� = 1;
        double d�� = 1;
        double �� = 0;
        double �� = 0;
        double �� = 0;
        //int n = 0;
        toa = 0.01;
        while (abs(d��)>toa || abs(d��)>toa || abs(d��)>toa)
        {
            double[][] d1 = {{cos(��), 0, -sin(��)},{0, 1, 0}, {sin(��), 0, cos(��)}};
            double[][] d2 = {{1, 0, 0}, {0, cos(��), -sin(��)}, {0, sin(��), cos(��)}};
            double[][] d3 = {{cos(��), -sin(��), 0}, {sin(��), cos(��), 0}, {0, 0, 1}};
            m1 = new Matrix(d1);
            m2 = new Matrix(d2);
            m3 = new Matrix(d3);
            R = m1.solve(m2).solve(m3);//��ת����R

            L = new Matrix((int) (2*ptNum),1);
            for (int i = 0; i < ptNum; i++) {
                double x = Coors.get(i,0);
                double y = Coors.get(i,1);
                double X = Coors.get(i,2);
                double Y = Coors.get(i,3);
                double Z = Coors.get(i,4);
                double s1 = x-(0-f*((R.get(0,0)*(X-Xso)+(R.get(1,0)*(Y-Yso)+(R.get(2,0)*(Z-Zso))))/
                        ((R.get(0,2)*(X-Xso)+(R.get(1,2)*(Y-Yso)+(R.get(2,2)*(Z-Zso)))))));
                double s2 = y-(0-f*((R.get(0,1)*(X-Xso)+(R.get(1,1)*(Y-Yso)+(R.get(2,1)*(Z-Zso))))/((R.get(0,2)*(X-Xso)+(R.get(1,2)*(Y-Yso)+(R.get(2,2)*(Z-Zso)))))));
                L.set(2*i,0, s1);
                L.set(2*i+1,0, s2);
            }

            A = new Matrix((int) (2*ptNum),6);
            for (int i = 0; i < ptNum; i++) {
                double x = Coors.get(i,0);
                double y = Coors.get(i,1);
                double X = Coors.get(i,2);
                double Y = Coors.get(i,3);
                double Z = Coors.get(i,4);
                double Zb = R.get(0,2)*(X-Xso)+R.get(1,2)*(Y-Yso)+R.get(2,2)*(Z-Zso);
                A.set(2*i,0, (R.get(0,0)*f+R.get(0,2)*x)/Zb);
                A.set(2*i,1, (R.get(1,0)*f+R.get(1,2)*x)/Zb);
                A.set(2*i,2, (R.get(2,0)*f+R.get(2,2)*x)/Zb);
                A.set(2*i+1,0, (R.get(0,1)*f+R.get(0,2)*y)/Zb);
                A.set(2*i+1,1, (R.get(1,1)*f+R.get(1,2)*y)/Zb);
                A.set(2*i+1,2, (R.get(2,1)*f+R.get(2,2)*y)/Zb);
                A.set(2*i,3, y*sin(��)-(x*(x*cos(��)-y*sin(��))/f+f*cos(��))*cos(��));
                A.set(2*i,4, -f*sin(��)-x*(x*sin(��)+y*cos(��))/f);
                A.set(2*i,5, y);
                A.set(2*i+1,3, -x*sin(��)-(y*(x*cos(��)-y*sin(��))/f-f*sin(��))*cos(��));
                A.set(2*i+1,4, -f*cos(��)-y*(x*sin(��)+y*cos(��))/f);
                A.set(2*i+1,5, -x);
            }


            DX = A.transpose().times(A).inverse().times(A.transpose()).times(L);
            Xso += DX.get(0, 0);
            Yso += DX.get(1, 0);
            Zso += DX.get(2, 0);
            �� += DX.get(3, 0);
            �� += DX.get(4, 0);
            �� += DX.get(5, 0);
            d�� = DX.get(3, 0);
            d�� = DX.get(4, 0);
            d�� = DX.get(5, 0);

        }

        double VV = 0;
        Matrix DV = A.times(DX).minus(L);
        for (int i = 0; i < 2*ptNum; i++) {
            VV += pow(DV.get(i,0),2);
        }
        m0 = sqrt(VV/(2*ptNum-6));
        mi = new Matrix(6,1);
        Matrix Qx = A.transpose().times(A).inverse();

        for (int i = 0; i < 6; i++) {
            mi.set(i,0, m0*sqrt(Qx.get(i,i)));
        }

        calu.put("Xs",Xso);
        calu.put("Ys",Yso);
        calu.put("Zs",Zso);
        calu.put("��",��);
        calu.put("��",��);
        calu.put("��",��);

        calu.put("m0",m0);
        calu.put("mXs",mi.get(0,0));
        calu.put("mYs",mi.get(1,0));
        calu.put("mZs",mi.get(2,0));
        calu.put("m��",mi.get(3,0));
        calu.put("m��",mi.get(4,0));
        calu.put("m��",mi.get(5,0));

        return calu;
    }

}
