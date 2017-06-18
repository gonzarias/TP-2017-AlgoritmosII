package condiciones;

import clima.Clima;
import clima.ClimaLluviaIntensa;
import com.FiguraSistema;

public class CondicionLluviaIntensa extends Condicion {

    public static CondicionLluviaIntensa instance;
    Condicion siguiente = new CondicionOptima();

    public static CondicionLluviaIntensa getInstance(){
        if(instance == null){
            instance = new CondicionLluviaIntensa();
        }
        return instance;
    }

    @Override
    public Clima verificarCondicion(int dia, FiguraSistema figuraSistema) {
        return new ClimaLluviaIntensa(dia);
    }


}
