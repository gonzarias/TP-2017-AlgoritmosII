package com;

import java.awt.*;
import java.util.ArrayList;

import static com.sun.jmx.mbeanserver.Util.cast;


public class FiguraPoligono{
    private Polygon poligono;

    public FiguraPoligono(ArrayList<Planeta> planetas){
        int i = planetas.size();
        int j = 0;
        int[] xPoints = new int[i];
        int[] yPoints = new int[i];

        for (Planeta planeta : planetas) {
            int x = (int)planeta.posicion.getX();
            int y = (int)planeta.posicion.getY();


            xPoints[j] = x;
            yPoints[j] = y;
            j++;
        }
        this.poligono = new Polygon(xPoints, yPoints, j);
    };

    public boolean contiene(Sol sol) {
        Posicion posicionSol = sol.getPosicion();

        return this.poligono.contains(posicionSol.getX(),posicionSol.getY());
    }

}
