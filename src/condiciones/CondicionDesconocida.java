package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import com.SistemaSolar;

public class CondicionDesconocida extends Condicion {

    @Override
    public Clima verificarCondicion(SistemaSolar sistemaSolar) {
        return new ClimaDesconocido(sistemaSolar.getDiaTranscurrido());
    }

}
