package condiciones;

import clima.Clima;
import clima.ClimaLluvioso;
import com.FiguraSistema;

public class CondicionLluvia extends Condicion {

    public static CondicionLluvia instance;
    Condicion siguiente = new CondicionSequia();

    public static CondicionLluvia getInstance(){
        if(instance == null){
            instance = new CondicionLluvia();
        }

        return instance;
    }


    @Override
    public Clima verificarCondicion(int dia, FiguraSistema figuraSistema) {
        return new ClimaLluvioso(dia);
    }
}
