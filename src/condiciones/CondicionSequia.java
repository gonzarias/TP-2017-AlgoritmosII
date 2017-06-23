package condiciones;

import clima.Clima;
import clima.Sequia;
import com.Alertador;
import com.SistemaSolar;

public class CondicionSequia extends Condicion {

    /*Cuando los tres planetas están alineados entre sí y a su vez alineados con respecto al sol, el
    sistema solar experimenta un período de sequía*/
    @Override
    public Clima evaluar(SistemaSolar sistemaSolar) {
        //Notifica a interesados con el alertador
        notificar();
        return new Sequia();

        //Falta if para retornar clima desconocido
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
