package com;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class FiguraPoligono{
    public Path2D poligono;
    private ArrayList<Point2D.Double> points;
    private double area;
    private double areaConSol;
    private double perimetro;
    private boolean esRecta;

    public boolean esRecta() {
        return esRecta;
    }

    public FiguraPoligono(ArrayList<Planeta> planetas, Sol sol){

        int i = planetas.size();
        int j = 0;
        int k;

        double[] xPoints = new double[i];
        double[] yPoints = new double[i];
        this.points = new ArrayList<Point2D.Double>();
        this.poligono = new Path2D.Double();


        for (Planeta planeta : planetas) {
            double x = planeta.posicion.getX();
            double y = planeta.posicion.getY();
            xPoints[j] = x;
            yPoints[j] = y;
            Point2D.Double point = new Point2D.Double(x,y);
            points.add(point);
            j++;
        }

        poligono.moveTo(xPoints[0], yPoints[0]);

        for(k = 1; k < xPoints.length; ++k) {
            poligono.lineTo(xPoints[k], yPoints[k]);
        }
        poligono.closePath();

        this.perimetro = this.perimetro();
        this.area = this.area(xPoints, yPoints, j);
        this.areaConSol = this.area(xPoints, yPoints, j, sol);
        this.esRecta = this.esRecta(xPoints, yPoints, j);


    };

    public boolean contiene(Sol sol) {
        Posicion posicionSol = sol.getPosicion();


        return this.poligono.contains(posicionSol.getX(),posicionSol.getY());
    }

    private double perimetro() {


        if (points.size() < 2){
            this.perimetro = 0.0;
        }

        int i = 0;
        double d = 0;
        double total = 0;

        // Guarda la distancia entre el primer y ultimo punto.
        total =  points.get(0).distance(points.get(points.size() - 1));

        //System.out.println(total);

        while (i < points.size()-1)
        {
            Point2D.Double point1 = points.get(i);
            double x = point1.x;
            double y = point1.y;

            Point2D.Double point2 = points.get(i+1);
            double x1 = point2.x;
            double y1 = point2.y;

            d = point1.distance(point2);
//            System.out.println(d);

            total = total + d;
            i++;

        }
        return  total;

    }

    private double area(double[] X, double[] Y, int numPoints)
    {
        int j,i;
        double area = 0.;

        j = numPoints-1;

        for (i=0; i<numPoints; i++)
        { area = area +  Math.abs((X[j]+X[i]) * (Y[j]-Y[i]));
            j = i;
        }
        return area/2;
    }

    private double area(double[] X, double[] Y, int numPoints, Sol sol)
    {
        int i;
        double[] xPoints = new double[numPoints+1];
        double[] yPoints = new double[numPoints+1];

        for (i=0;i<numPoints;i++){
            xPoints[i] = X[i];
            yPoints[i] = Y[i];
        }

        xPoints[i] = sol.getPosicion().getX();
        yPoints[i] = sol.getPosicion().getY();


        return this.area(xPoints, yPoints, numPoints+1);

    }


    public double getArea() {
        return area;
    }

    public double getAreaConSol() {
        return areaConSol;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public boolean esRecta(double[] X, double[] Y, int numPoints){
        int j,i;
        double[] pendientes = new double[numPoints-1];
        double pendiente;
        double promedioPendiente;
        double minPendiente = 999999;
        double maxPendiente = -999999;

        j = 1;

        for (i=0; i<numPoints-1; i++) {
            pendiente = getPendiente(X[i],Y[i],X[j],Y[j]);
            pendientes[i] = pendiente;
            j++;
        }

        for (double pend : pendientes) {
            if (pend < minPendiente) {
                minPendiente = pend;
            }
            if (pend > maxPendiente) {
                maxPendiente = pend;
            }
        }

        if (maxPendiente != 0) {
            promedioPendiente = Math.round(1000d * minPendiente / maxPendiente) / 1000d;
        } else {
            if (minPendiente == 0) {
                promedioPendiente = 1;
            } else {
                promedioPendiente = 0;
            }
        }

        if (promedioPendiente ==1 && promedioPendiente >= 0.999) {
            return true;
        } else {
            return false;
        }
    }

    public double getPendiente(double x0, double y0, double x1, double y1) {
        double dx = x1 - x0;
        double dy = y1 - y0;
        double m = 0;

        if (Math.abs(dx) > Math.abs(dy)) {
            m = Math.round(100d * dy / dx) / 100d;
        } else {
            if (dy != 0) {
                m = Math.round(100d * dx / dy) / 100d;
            }
        }
        return m;
    }






}
