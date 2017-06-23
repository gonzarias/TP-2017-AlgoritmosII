package clima;

import com.Dia;

public class OptimaPresionYTemperatura extends Clima {

    @Override
    public void agregarEnDia(Dia dia)  {
        dia.getClimas().add(this);
    }
}
