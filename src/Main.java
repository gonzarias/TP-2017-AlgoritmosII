
import com.FiguraPoligono;
import com.Planeta;
import com.SistemaSolar;


public class Main {
    public static void main(String[] args) {

        // Creamos una sola instancia del Sistema, se crea con la carga incial.
        Boolean alertas = false;

        SistemaSolar sistemaSolar =  new SistemaSolar(alertas);

        //sistemaSolar.addPlaneta(new Planeta(1,1));

        sistemaSolar.transcurrirDias(3650);
        sistemaSolar.obtenerEstadisticas();


        /* Agregar planetas y condiciones */

        //Prueba posicional del poligono
        /*
        double[] X = new double[3];
        double[] Y = new double[3];

        X[0] = 2;
        Y[0] = 1;

        X[1] = 3;
        Y[1] = 2;

        X[2] = 4;
        Y[2] = 3;

        FiguraPoligono figuraPoligono = new FiguraPoligono(X,Y, X.length);

        System.out.println("Area: " + figuraPoligono.getArea());
        System.out.println("Area con Sol: " + figuraPoligono.getAreaConSol());
        System.out.println("Perimetro: " + figuraPoligono.getArea());
        */








    }
}
