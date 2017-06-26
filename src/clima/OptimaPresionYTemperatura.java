package clima;

import com.Dia;
import com.ObservatorioClimatologico;

public class OptimaPresionYTemperatura extends Clima {

    @Override
    public void agregarEnDia(Dia dia)  {
        dia.getClimas().add(this);
    }

    public void addEstadistica(ObservatorioClimatologico observatorioClimatologico, Dia diaActual){
        observatorioClimatologico.addOptimaPresionYTemperatura();
    }
}
