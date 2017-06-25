import com.FiguraPoligono;
import com.SistemaSolar;


public class Main {
    public static void main(String[] args) {

        // Creamos una sola instancia del Sistema, se crea con la carga incial.
        SistemaSolar sistemaSolar =  SistemaSolar.crearSistemaSolar();


        sistemaSolar.debug = true;
        sistemaSolar.transcurrirDias(360);


        /* Agregar planetas y condiciones */


        /* Codigo utilizado para probar el poligono
        int[] xPts , yPts;

        xPts = new int[3];
        yPts = new int[3];

        xPts[0] = -5;
        yPts[0] = 2;

        xPts[1] = 5;
        yPts[1] = 2;

        xPts[2] = 1;
        yPts[2] = 2;

        FiguraPoligono figuraPoligono = new FiguraPoligono(xPts, yPts, 3);

        System.out.println(figuraPoligono.poligono.contains(0,1.2));
        System.out.println("El àrea del poligono es: " + figuraPoligono.getArea());
        System.out.println("El àrea del poligono con el SOL es: " + figuraPoligono.getAreaConSol());
        System.out.println("El perimetro del poligono es: " + figuraPoligono.getPerimetro());
        */
    }
}
