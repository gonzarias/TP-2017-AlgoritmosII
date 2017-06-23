package clima;

import com.Dia;

public class Lluvia extends Clima {
    private double perimetro;

    @Override
    public void agregarEnDia(Dia dia)  {
        dia.getClimas().add(this);
    }
}

