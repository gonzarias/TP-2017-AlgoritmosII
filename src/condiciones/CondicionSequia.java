package condiciones;

import clima.Clima;
import clima.ClimaSeco;
import com.SistemaSolar;

public class CondicionSequia extends Condicion {

    public static CondicionSequia instance;
    Condicion siguiente = new CondicionLluviaIntensa();

    public static CondicionSequia getInstance(){
        if(instance == null){
            instance = new CondicionSequia();
        }
        return instance;
    }

    @Override
    public Clima verificarCondicion(SistemaSolar sistemaSolar) {
        return new ClimaSeco(sistemaSolar.getDiaTranscurrido());
    }


}
