
import com.SistemaSolar;


public class Main {
    public static void main(String[] args) {

        // Creamos una sola instancia del Sistema, se crea con la carga incial.
        SistemaSolar sistemaSolar =  SistemaSolar.crearSistemaSolar();


        sistemaSolar.debug = false;
        sistemaSolar.transcurrirDias(365);
        sistemaSolar.obtenerEstadisticas();


        /* Agregar planetas y condiciones */

    }
}
