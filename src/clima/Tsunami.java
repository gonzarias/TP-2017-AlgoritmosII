package clima;

import com.Dia;
import com.ObservatorioClimatologico;
import condiciones.Condicion;

public class Tsunami extends Clima {

    @Override
    public void agregarEnDia(Dia dia)  {
        dia.getClimas().add(this);
    }

    public void addEstadistica(ObservatorioClimatologico observatorioClimatologico, Dia diaActual){
        observatorioClimatologico.addDiasTsunami();
    }

}
