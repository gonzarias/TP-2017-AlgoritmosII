package com;

import clima.Clima;
import clima.ClimaDesconocido;

import java.util.ArrayList;

public class Dia {
    int numeroDia;
    ArrayList<Clima> climas;

    public Dia(int numeroDia){
        this.numeroDia = numeroDia;
        climas = new ArrayList<Clima>();
    }

    public void addClima(Clima clima){
        this.climas.add(clima);
    }

    public void addClima(ClimaDesconocido climaDesconocido){
        //No se agrega
    }

    public Integer getDia() {
        return numeroDia;
    }
}
