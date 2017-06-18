package condiciones;

import clima.Clima;
import clima.ClimaOptimo;
import com.FiguraSistema;

public class CondicionOptima extends Condicion {
    public static CondicionOptima instance;
    Condicion siguiente = new CondicionDesconocida();

    public static CondicionOptima getInstance(){
        if(instance == null){
            instance = new CondicionOptima();
        }
        return instance;
    }

    @Override
    public Clima verificarCondicion(int dia, FiguraSistema figuraSistema) {
        return new ClimaOptimo(dia);
    }




}
