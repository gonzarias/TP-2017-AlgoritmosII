package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import clima.Tsunami;
import com.Alertador;
import com.FiguraPoligono;
import com.SistemaSolar;

public class CondicionTsunami extends Condicion {
    FiguraPoligono figuraPoligono;
    public static CondicionTsunami condicionTsunami;

    /*Es sabido que en el momento en el que el sol se encuentra dentro del triángulo, el sistema solar
    experimenta unperíodo de lluvia, teniendo éste, un pico de intensidad cuando el perímetro del
    triángulo está en su máximo*/




    public static CondicionTsunami crearCondicion() {
        if (condicionTsunami == null) {
            condicionTsunami = new CondicionTsunami();
        }
        return condicionTsunami;
    }

    @Override
    public Clima evaluar(SistemaSolar sistemaSolar) {
        // Se crea el Poligono para obtener la figura del Sistema
        this.figuraPoligono = new FiguraPoligono(sistemaSolar.getPlanetas(), sistemaSolar.getSol());

        if (figuraPoligono.contiene(sistemaSolar.getSol())
                && figuraPoligono.getPerimetro() > 12000){
            //System.out.println("Hoy tenemos condicion de tsunami");
            //Se notifica al usuario del tsunami
            notificar();
            return new Tsunami();
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
