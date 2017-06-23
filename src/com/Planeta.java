package com; /**
 * Created by marti on 6/6/2017.
 */

import java.lang.Math;

/**
 * Abstracción de un planeta del sistema solar.Se le puede pedir la posición (x, y) en base a el tiempo, la distancia
 * respecto al sol y la velocidad angular.
 */
public class Planeta extends CuerpoEstelar{

    private double distanciaAlSol;
    private double velocidadAngular;

    public Planeta(double distanciaAlSol, double velocidadAngular) {
        this.distanciaAlSol = distanciaAlSol;
        this.velocidadAngular = Math.toRadians(velocidadAngular); //La velocidad angular está dada en grados por día
        this.posicion = new Posicion(distanciaAlSol, 0);
    }

    public Posicion obtenerPosicion() {
        return this.posicion;
    }

    public void transcurrirDia(double diaTranscurrido) {

        double x = Math.round(Math.cos(velocidadAngular * diaTranscurrido) * distanciaAlSol);
        double y = Math.round(Math.sin(velocidadAngular * diaTranscurrido) * distanciaAlSol);
        System.out.println("x: " + x + ". y: " + y);
        this.posicion = new Posicion(x,y);
    }

    public double getDistanciaAlSol() {
        return distanciaAlSol;
    }

    public void setDistanciaAlSol(double distanciaAlSol) {
        this.distanciaAlSol = distanciaAlSol;
    }

    public double getVelocidadAngular() {
        return velocidadAngular;
    }

    public void setVelocidadAngular(double velocidadAngular) {
        this.velocidadAngular = velocidadAngular;
    }

}
