package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import clima.OptimaPresionYTemperatura;
import com.SistemaSolar;

public class CondicionPresionYTemperatura extends Condicion {
    /*Las condiciones óptimas de presión y temperatura se dan cuando los tres planetas están
    alineados entre sí pero no están alineados con el sol*/
    @Override
    public Clima evaluar(SistemaSolar sistemaSolar) {
        return new OptimaPresionYTemperatura();
    }
}
