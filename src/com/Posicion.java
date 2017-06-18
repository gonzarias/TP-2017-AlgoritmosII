package com;

/**
 * Created by marti on 6/6/2017.
 */
public class Posicion {
    private double x;
    private double y;

    Posicion(double x, double y) {
        this.setLocation(x,y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
