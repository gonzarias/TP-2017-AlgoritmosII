package condiciones;

import clima.Clima;
import clima.ClimaSeco;
import com.FiguraSistema;

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
    public Clima verificarCondicion(int dia, FiguraSistema figuraSistema) {
        return new ClimaSeco(dia);
    }


}
