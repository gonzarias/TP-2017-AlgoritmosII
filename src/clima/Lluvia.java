package clima;

import com.Dia;
import com.ObservatorioClimatologico;

public class Lluvia extends Clima {


    private double perimetro;

    public Lluvia(double perimetro) {
        this.perimetro = perimetro;
    }

    @Override
    public void agregarEnDia(Dia dia)  {
        dia.getClimas().add(this);
    }

    public void addEstadistica(ObservatorioClimatologico observatorioClimatologico, Dia diaActual){
        observatorioClimatologico.addDiasLluvia();
        observatorioClimatologico.verDiaMaxLluvia(this, diaActual);
    }

    public double getPerimetro() {
        return perimetro;
    }



}

