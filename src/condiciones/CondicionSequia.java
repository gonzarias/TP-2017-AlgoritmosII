package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import clima.Sequia;
import com.SistemaSolar;

public class CondicionSequia extends Condicion {

    /*Cuando los tres planetas están alineados entre sí y a su vez alineados con respecto al sol, el
    sistema solar experimenta un período de sequía*/
    @Override
    public Clima evaluar(SistemaSolar sistemaSolar) {
        return new Sequia();
    }
}
