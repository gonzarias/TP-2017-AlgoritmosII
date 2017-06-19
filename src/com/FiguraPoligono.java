package com;

import java.awt.*;
import java.util.ArrayList;

import static com.sun.jmx.mbeanserver.Util.cast;


public class FiguraPoligono extends Polygon {

    public FiguraPoligono(ArrayList<Planeta> planetas){

        int j = 0;
        int[] xPoints = new int[0], yPoints = new int[0];

        for (Planeta planeta : planetas) {

            xPoints[j] = cast(planeta.posicion.getX());
            xPoints[j] = cast(planeta.posicion.getY());
            j++;
        }
        new Polygon(xPoints, yPoints, j);
    };

    public boolean contiene(Sol sol) {
        Posicion posicionSol = sol.getPosicion();

        return this.contains(posicionSol.getX(),posicionSol.getY());
    }

}
