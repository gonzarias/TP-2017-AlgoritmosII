package condiciones;

import clima.Clima;
import clima.ClimaLluviaIntensa;
import com.SistemaSolar;

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
    public Clima verificarCondicion(SistemaSolar sistemaSolar) {
        return new ClimaLluviaIntensa(sistemaSolar.getDiaTranscurrido());
    }


}
