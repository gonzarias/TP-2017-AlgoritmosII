/**
 * Created by marti on 6/6/2017.
 */

import java.lang.Math;

/**
 * Abstracción de un planeta del sistema solar.Se le puede pedir la posición (x, y) en base a el tiempo, la distancia respecto al sol y la velocidad angular.
 *
 */
public class Planeta extends CuerpoEstelar{

    private double distanciaAlSol;
    private double velocidadAngular;

    public Planeta(double distanciaAlSol, double velocidadAngular) {
        this.distanciaAlSol = distanciaAlSol;
        this.velocidadAngular = Math.toRadians(velocidadAngular); // se debe multiplicar el valor que viene en nudos/dia a km/dia
        this.posicion = new Posicion(0, distanciaAlSol);
    }

    public Posicion obtenerPosicion() {
        return this.posicion;
    }

    public void transcurrirDias(double diasTranscurridos) {

        System.out.println(" Transcurriendo el dia..." + diasTranscurridos);
        double x = Math.cos(velocidadAngular * diasTranscurridos) * distanciaAlSol;
        double y = Math.sin(velocidadAngular * diasTranscurridos) * distanciaAlSol;

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
