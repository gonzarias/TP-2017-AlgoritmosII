package com;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class FiguraPoligono{
    public Polygon poligono;
    private ArrayList<Point2D.Double> points;
    private double area;
    private double areaConSol;
    private double perimetro;

    public FiguraPoligono(ArrayList<Planeta> planetas, Sol sol){

        int i = planetas.size();
        int j = 0;
        int[] xPoints = new int[i];
        int[] yPoints = new int[i];
        this.points = new ArrayList<Point2D.Double>();

        for (Planeta planeta : planetas) {
            int x = (int)planeta.posicion.getX();
            int y = (int)planeta.posicion.getY();

            xPoints[j] = x;
            yPoints[j] = y;

            // Agregado para calcular perimetro
            Point2D.Double point = new Point2D.Double(x,y);
            points.add(point);
            j++;
        }


        this.poligono = new Polygon(xPoints, yPoints, j);
        this.area = this.area(xPoints, yPoints, j);
        this.areaConSol = this.area(xPoints, yPoints, j, sol);
    };

    public boolean contiene(Sol sol) {
        Posicion posicionSol = sol.getPosicion();

        return this.poligono.contains(posicionSol.getX(),posicionSol.getY());
    }

    private void perimetro() {


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
        this.perimetro = total;

    }

    private double area(int[] X, int[] Y, int numPoints)
    {
        int j,i;
        double area = 0.;

        j = numPoints-1;

        for (i=0; i<numPoints; i++)
        { area = area +  (X[j]+X[i]) * (Y[j]-Y[i]);
            j = i;
        }
        return area/2;
    }

    private double area(int[] X, int[] Y, int numPoints, Sol sol)
    {
        int i;
        int[] xPoints = new int[numPoints+1];
        int[] yPoints = new int[numPoints+1];

        for (i=0;i<numPoints;i++){
            xPoints[i] = X[i];
            yPoints[i] = Y[i];
        }
        xPoints[i] = (int)sol.getPosicion().getX();
        yPoints[i] = (int)sol.getPosicion().getY();

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



}
