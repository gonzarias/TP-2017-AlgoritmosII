import com.SistemaSolar;


public class Main {
    public static void main(String[] args) {

        // Creamos una sola instancia del Sistema, se crea con la carga incial.
        SistemaSolar sistemaSolar =  SistemaSolar.crearSistemaSolar();

        sistemaSolar.debug = true;
        sistemaSolar.transcurrirDias(360);


        /* Agregar planetas y condiciones */




    }
}
