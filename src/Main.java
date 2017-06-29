
import com.Alertador;
import com.Interesado;
import com.Planeta;
import com.SistemaSolar;
import condiciones.Condicion;
import condiciones.CondicionTsunami;


public class Main {
    public static void main(String[] args) {

        // Creamos una sola instancia del Sistema, se crea con la carga incial.
        Boolean alertas = false;

        SistemaSolar sistemaSolar =  new SistemaSolar(alertas);

        sistemaSolar.transcurrirDias(360);
        sistemaSolar.obtenerEstadisticas();


        /* Agregar planetas ,condiciones e interesados */
        Planeta banfield = new Planeta(4000,-8);
        sistemaSolar.addPlaneta(banfield);

        Condicion condicionTsunami = CondicionTsunami.crearCondicion();
        //Agrego interesado
        Alertador i1 = new Interesado("Pepe de Alderan", alertas);
        Alertador i2 = new Interesado ("Dario de Banfield", alertas);
        condicionTsunami.suscribir(i1);
        condicionTsunami.suscribir(i2);
        sistemaSolar.addCondicion(condicionTsunami);

        sistemaSolar.transcurrirDias(360);
        sistemaSolar.obtenerEstadisticas();

    }
}
