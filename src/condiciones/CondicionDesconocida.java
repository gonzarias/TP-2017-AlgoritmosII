package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import com.FiguraSistema;

public class CondicionDesconocida extends Condicion {

    @Override
    public Clima verificarCondicion(int dia, FiguraSistema figuraSistema) {
        return new ClimaDesconocido(dia);
    }

}
