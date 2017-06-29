package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import clima.OptimaPresionYTemperatura;
import clima.Sequia;
import com.Alertador;
import com.FiguraPoligono;
import com.SistemaSolar;

public class CondicionSequia extends Condicion {
    FiguraPoligono figuraPoligono;

    /*Cuando los tres planetas están alineados entre sí y a su vez alineados con respecto al sol, el
    sistema solar experimenta un período de sequía*/
    @Override
    public Clima evaluar(SistemaSolar sistemaSolar) {
        this.figuraPoligono = new FiguraPoligono(sistemaSolar.getPlanetas(), sistemaSolar.getSol());

        if (figuraPoligono.esRecta()
                && figuraPoligono.getAreaConSol() == 0) {
            //System.out.println("Hoy tenemos condiciones de Sequia");

            notificar();
            return new Sequia();
        } else {
            //System.out.println("Clima Desconocido");
            return new ClimaDesconocido();
        }

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
    public void suscribir(Alertador alertador){
        this.alertados.add (alertador);

    }
}
