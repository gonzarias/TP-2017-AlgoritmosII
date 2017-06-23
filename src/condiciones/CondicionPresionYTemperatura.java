package condiciones;

import clima.Clima;
import clima.OptimaPresionYTemperatura;
import com.Alertador;
import com.SistemaSolar;

public class CondicionPresionYTemperatura extends Condicion {
    /*Las condiciones óptimas de presión y temperatura se dan cuando los tres planetas están
    alineados entre sí pero no están alineados con el sol*/
    @Override
    public Clima evaluar(SistemaSolar sistemaSolar) {
        notificar();
        return new OptimaPresionYTemperatura();
    }
    //Se implementa notificar
    @Override
    public void notificar ( ) {
        for(Alertador alertador : alertados) {
            alertador.informar(this);
        }
    }
    //Subscriptor
    public void subscribir(Alertador alertador){
        this.alertados.add (alertador);

    }
}
