package com;

import clima.Clima;

import java.util.ArrayList;
import java.util.HashMap;

public class ObservatorioClimatologico {
    public static ObservatorioClimatologico observatorioClimatologico;
    private HashMap<Integer, Dia> calendarioClimatologico;
    private double diasLluvia = 0;
    private double diasSequia = 0;
    private double diasOptimaPresionYtemperatura = 0;

    public static ObservatorioClimatologico crearObservatorioClimatologico() {
        if (observatorioClimatologico == null) {
            observatorioClimatologico = new ObservatorioClimatologico();
        }
        return observatorioClimatologico;
    }

    public ObservatorioClimatologico() {
        this.calendarioClimatologico = new HashMap<Integer, Dia>();
    }

    public void addDia(Dia dia) {
        if (calendarioClimatologico.containsKey(dia.getDia())) {
            //Tirar exception
        } else {
            calendarioClimatologico.put(dia.getDia(), dia);
        }
    }


    public void obetenerEstadistica(double dias) {
        int diaActual;
        Dia dia;
        ArrayList<Clima> climas;

        for (diaActual=1; diaActual<dias; diaActual++){
            dia = this.calendarioClimatologico.get(diaActual);
            climas = dia.getClimas();
            for (Clima clima : climas){

                clima.addEstadistica(this);

            }
        }
    }

    public void addDiasLluvia (){
        this.diasLluvia ++;
    }

    public void addOptimaPresionYTemperatura (){
        this.diasOptimaPresionYtemperatura ++;
    }

    public void addDiasSequia (){
        this.diasSequia ++;
    }

    public double getDiasLluvia() {
        return diasLluvia;
    }

    public double getDiasSequia() {
        return diasSequia;
    }

    public double getDiasOptimaPresionYtemperatura() {
        return diasOptimaPresionYtemperatura;
    }
}




