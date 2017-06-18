/**
 * Created by Gonzalo Arias on 10/6/2017.
 */
public class Main {
    public static void main(String[] args) {

        // Creamos una sola instancia del Sistema, se crea con la carga incial.
        SistemaSolar sistemaSolar =  SistemaSolar.getInstance();

        sistemaSolar.debug = true;
        sistemaSolar.obtenerClima(360);


        /* Agregar planetas y condiciones */
        //sistemaSolar.addPlanetas();
        //sistemaSolar.addPlanetas();




    }
}
