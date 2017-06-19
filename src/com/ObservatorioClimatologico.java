package com;

import java.util.HashMap;

public class ObservatorioClimatologico {
    public static ObservatorioClimatologico observatorioClimatologico;
    private HashMap<Integer, Dia> estadisticaClimatologica;

    public static ObservatorioClimatologico crearObservatorioClimatologico() {
        if (observatorioClimatologico == null) {
            observatorioClimatologico = new ObservatorioClimatologico();
        }
        return observatorioClimatologico;
    }

    public ObservatorioClimatologico() {
        this.estadisticaClimatologica = new HashMap<Integer, Dia>();
    }

    public void addDia(Dia dia) {
        if (estadisticaClimatologica.containsKey(dia.getDia())) {
            //Tirar exception
        } else {
            estadisticaClimatologica.put(dia.getDia(), dia);
        }
    }
}




