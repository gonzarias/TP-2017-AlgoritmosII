package com;

import java.awt.*;
import java.util.ArrayList;

import static com.sun.jmx.mbeanserver.Util.cast;


public class FiguraPoligono extends Polygon {

    public FiguraPoligono(ArrayList<Planeta> planetas){
        int i = planetas.size();
        int j = 0;
        int[] xPoints = new int[i];
        int[] yPoints = new int[i];

        for (Planeta planeta : planetas) {
            int x = (int)planeta.posicion.getX();
            int y = (int)planeta.posicion.getY();


            xPoints[j] = x;
            xPoints[j] = y;
            j++;
        }
        new Polygon(xPoints, yPoints, j);
    };

    public boolean contiene(Sol sol) {
        Posicion posicionSol = sol.getPosicion();

        return this.contains(posicionSol.getX(),posicionSol.getY());
    }

}
