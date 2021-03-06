package com;

import clima.Clima;
import clima.ClimaDesconocido;

import java.util.ArrayList;

public class Dia {
    double numeroDia;
    ArrayList<Clima> climas;

    public Dia(int numeroDia){
        this.numeroDia = numeroDia;
        climas = new ArrayList<Clima>();
    }

    public void addClima(Clima clima){
        clima.agregarEnDia(this);
    }

    public Double getDia() {
        return numeroDia;
    }

    public ArrayList<Clima> getClimas() {
        return climas;
    }
}
