package com;

import clima.Clima;
import clima.Lluvia;

import java.util.ArrayList;
import java.util.HashMap;

public class ObservatorioClimatologico {
    private HashMap<Double, Dia> calendarioClimatologico;
    private double diasLluvia = 0;
    private double diasSequia = 0;
    private double diasOptimaPresionYtemperatura = 0;
    private double diasTsunami = 0;
    private double maxPerimetro;
    private Dia diaMaxLluvia;

    public ObservatorioClimatologico() {
        this.calendarioClimatologico = new HashMap<Double, Dia>();
    }

    public void addDia(Dia dia) {
        if (calendarioClimatologico.containsKey(dia.getDia())) {
            //Tirar exception
        } else {
            calendarioClimatologico.put(dia.getDia(), dia);
        }
    }


    public void obetenerEstadistica(double dias) {
        double diaActual;
        Dia dia ;
        ArrayList<Clima> climas;

        this.maxPerimetro = 0.;
        this.diaMaxLluvia = this.calendarioClimatologico.get(1);




        for (diaActual=1; diaActual<=dias; diaActual++){
            dia = this.calendarioClimatologico.get(diaActual);
            climas = dia.getClimas();
            for (Clima clima : climas){
                clima.addEstadistica(this, dia);
            }
        }
    }

    public void verDiaMaxLluvia (Lluvia lluvia, Dia dia) {

        if (lluvia.getPerimetro() > this.maxPerimetro) {
            this.diaMaxLluvia = dia;
            this.maxPerimetro = lluvia.getPerimetro();
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

    public void addDiasTsunami() {
        this.diasTsunami ++;
    }

    public double getDiasLluvia() {
        return diasLluvia;
    }

    public double getDiasSequia() {
        return diasSequia;
    }

    public double getDiasTsunami() {
        return diasTsunami;
    }

    public double getDiasOptimaPresionYtemperatura() {
        return diasOptimaPresionYtemperatura;
    }

    public Dia getDiaMaxLluvia() {
        return diaMaxLluvia;
    }

    public double getMaxPerimetro() {
        return maxPerimetro;
    }

    public void resetearEstadistica() {
        this.calendarioClimatologico = new HashMap<Double, Dia>();
        this.diasLluvia = 0;
        this.diasSequia = 0;
        this.diasOptimaPresionYtemperatura = 0;
        this.diasTsunami = 0;
    }
}




