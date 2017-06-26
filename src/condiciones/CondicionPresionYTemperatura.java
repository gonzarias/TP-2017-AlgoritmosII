package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import clima.OptimaPresionYTemperatura;
import com.Alertador;
import com.FiguraPoligono;
import com.SistemaSolar;

public class CondicionPresionYTemperatura extends Condicion {
    FiguraPoligono figuraPoligono;

    /*Las condiciones óptimas de presión y temperatura se dan cuando los tres planetas están
    alineados entre sí pero no están alineados con el sol*/

    @Override
    public Clima evaluar(SistemaSolar sistemaSolar) {

        this.figuraPoligono = new FiguraPoligono(sistemaSolar.getPlanetas(), sistemaSolar.getSol());

        if (figuraPoligono.getArea() == 0
                    && figuraPoligono.getAreaConSol() != 0) {
            //System.out.println("Hoy tenemos Optimas Condiciones de Presiòn y Temperatura");

            notificar();
            return new OptimaPresionYTemperatura();
        } else {
            //System.out.println("Clima Desconocido");
            return new ClimaDesconocido();
        }
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
