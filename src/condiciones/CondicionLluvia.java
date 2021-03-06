package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import clima.Lluvia;
import com.Alertador;
import com.FiguraPoligono;
import com.SistemaSolar;

public class CondicionLluvia extends Condicion {
    FiguraPoligono figuraPoligono;

    /*Es sabido que en el momento en el que el sol se encuentra dentro del triángulo, el sistema solar
    experimenta unperíodo de lluvia, teniendo éste, un pico de intensidad cuando el perímetro del
    triángulo está en su máximo*/

    @Override
    public Clima evaluar(SistemaSolar sistemaSolar) {
        // Se crea el Poligono para obtener la figura del Sistema
        this.figuraPoligono = new FiguraPoligono(sistemaSolar.getPlanetas(), sistemaSolar.getSol());

        if (figuraPoligono.contiene(sistemaSolar.getSol())){
            //System.out.println("Hoy tenemos condicion de lluvia");
            //Se notifica al usuario de la lluvia
            notificar();
            return new Lluvia(figuraPoligono.getPerimetro());
        } else {
            //System.out.println("Clima desconocido");
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


    @Override
    //Subscriptor
    public void suscribir(Alertador alertador){
        this.alertados.add (alertador);
    }
}
