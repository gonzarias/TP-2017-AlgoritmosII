package condiciones;

import clima.*;
import com.*;

import java.util.ArrayList;


public abstract class Condicion {
    //Array para los alertados
    protected  ArrayList<Alertador> alertados = new ArrayList <> ();

    public abstract Clima evaluar(SistemaSolar sistemaSolar);

    //Se crea el metodo para poder suscribir a los alertados
    abstract public void notificar();

    //Se crea el metodo para poder suscribir a los alertados
    abstract public void suscribir(Alertador alertador);

}



