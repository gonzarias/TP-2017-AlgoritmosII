package com;

import java.awt.*;
import java.util.ArrayList;

import static com.sun.jmx.mbeanserver.Util.cast;

/**
 * Created by Gonzalo Arias on 10/6/2017.
 */
public class FiguraSistema extends Polygon {

    public FiguraSistema(ArrayList<Planeta> planetas){

        int j = 0;
        int[] xPoints = new int[0], yPoints = new int[0];

        for (Planeta planeta : planetas) {

            xPoints[j] = cast(planeta.posicion.getX());
            xPoints[j] = cast(planeta.posicion.getY());
            j++;
        }
        new Polygon(xPoints, yPoints, j);
    };

}
