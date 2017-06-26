
import com.Planeta;
import com.SistemaSolar;


public class Main {
    public static void main(String[] args) {

        // Creamos una sola instancia del Sistema, se crea con la carga incial.
        Boolean alertas = false;

        SistemaSolar sistemaSolar =  new SistemaSolar(alertas);

        //sistemaSolar.addPlaneta(new Planeta(6000,5));

        sistemaSolar.transcurrirDias(3650);
        sistemaSolar.obtenerEstadisticas();


        /* Agregar planetas y condiciones */



    }
}
