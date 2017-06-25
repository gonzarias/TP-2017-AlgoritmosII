import com.FiguraPoligono;
import com.SistemaSolar;


public class Main {
    public static void main(String[] args) {

        // Creamos una sola instancia del Sistema, se crea con la carga incial.
        //SistemaSolar sistemaSolar =  SistemaSolar.crearSistemaSolar();


        //sistemaSolar.debug = true;
        //sistemaSolar.transcurrirDias(360);


        /* Agregar planetas y condiciones */

        /* Prueba del poligono */


        int[] xPts , yPts;

        xPts = new int[4];
        yPts = new int[4];

        xPts[0] = 0;
        yPts[0] = 0;

        xPts[1] = 1;
        yPts[1] = 4;

        xPts[2] = 5;
        yPts[2] = 4;

        xPts[3] = 4;
        yPts[3] = 0;
/*
        xPts[4] = -4;
        yPts[4] = -8;

        xPts[5] = -4;
        yPts[5] = 6;*/

        FiguraPoligono figuraPoligono = new FiguraPoligono(xPts, yPts, 4);

        System.out.println("El àrea del poligono es: " + figuraPoligono.getArea());
        System.out.println("El perimetro del poligono es: " + figuraPoligono.getPerimetro());

    }
}
