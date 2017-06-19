package condiciones;

import clima.Clima;
import clima.ClimaDesconocido;
import clima.Lluvia;
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
        this.figuraPoligono = new FiguraPoligono(sistemaSolar.getPlanetas());
        if (figuraPoligono.contiene(sistemaSolar.getSol())){
            return new Lluvia();
        } else {
            return new ClimaDesconocido();
        }
    }
}
