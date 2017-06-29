package com;

import clima.Clima;
import condiciones.*;

import java.util.ArrayList;

public class SistemaSolar {

    private Sol sol;
    private ArrayList<Planeta> planetas;
    private ArrayList<Condicion> condiciones;
    private ObservatorioClimatologico observatorioClimatologico;
    private double diasTranscurridos;
    private boolean alertas;


    public SistemaSolar(Boolean alertas) {
        // Constructor utilizado para la carga inicial.

        this.sol = new Sol();
        this.planetas = new ArrayList<Planeta>();
        this.condiciones = new ArrayList<Condicion>();
        this.observatorioClimatologico = new ObservatorioClimatologico();
        this.alertas = alertas;

        Planeta alderaan = new Planeta(500,-1);
        Planeta felucia = new Planeta(2000,3);
        Planeta peragus = new Planeta(1000,-5);

        this.planetas.add(alderaan);
        this.planetas.add(felucia);
        this.planetas.add(peragus);

        Condicion condicionSequia = new CondicionSequia();
        Condicion condicionLluvia = new CondicionLluvia();
        Condicion condicionPresionYTemperatura = new CondicionPresionYTemperatura();

        this.condiciones.add(condicionSequia);
        this.condiciones.add(condicionLluvia);
        this.condiciones.add(condicionPresionYTemperatura);

        //Agrego interesado
        Alertador i1 = new Interesado ("Representante Alderan", alertas);
        Alertador i2 = new Interesado ("Representante Felucia", alertas);
        Alertador i3 = new Interesado ("Estacion Met. Peragus", alertas);

        condicionLluvia.suscribir(i1);
        condicionLluvia.suscribir(i2);
        condicionPresionYTemperatura.suscribir(i3);
        condicionSequia.suscribir(i2);
        condicionSequia.suscribir(i3);

    }

    public void addPlaneta(Planeta planeta) {
        this.planetas.add(planeta) ;
    }

    public ArrayList<Planeta> getPlanetas() {
        return this.planetas;
    }

    public Sol getSol() {
        return this.sol;
    }

    public void addCondiciones(ArrayList<Condicion> condiciones) {
        this.condiciones = condiciones;
    }


    public void transcurrirDias(double dias){
        int diaActual;
        int p;
        Clima clima;
        Dia dia;

        this.observatorioClimatologico.resetearEstadistica();
        for (diaActual=1;diaActual<=dias;diaActual++) {
            //Crear dia a agregar en el Observatorio
            dia = new Dia(diaActual);

            p = 1;

            if (alertas){
                System.out.println(" Transcurrido el dia " + diaActual);
            }
            for (Planeta planeta : this.planetas) {
                //System.out.print("Posicion planeta " + p + ": ");
                planeta.transcurrirDia(diaActual);
                p++;
            }
            // Se verifican las condiciones
            for (Condicion condicion : this.condiciones){
                clima = condicion.evaluar(this);
                dia.addClima(clima);
            }

            this.observatorioClimatologico.addDia(dia);
        }
        this.diasTranscurridos = dias;

    }

    public void obtenerEstadisticas() {

        this.observatorioClimatologico.obetenerEstadistica(this.diasTranscurridos);

        System.out.println("--------------Informe Climatologico----------------------");
        System.out.format( "-Dias transcurridos ------             %1$8.0f dias ----%n",this.diasTranscurridos );
        System.out.format("---LLuvia                              %1$8.0f dias ----%n", observatorioClimatologico.getDiasLluvia());
        if (observatorioClimatologico.getDiasLluvia() != 0) {
            System.out.format("------Dia Pico                         %1$8.0f dia  ----%n", observatorioClimatologico.getDiaMaxLluvia().getDia());
            System.out.format("---------Intensidad                    %1$8.0f int. ----%n", observatorioClimatologico.getMaxPerimetro());
        }
        System.out.format( "---Sequia                              %1$8.0f dias ----%n",observatorioClimatologico.getDiasSequia() );
        System.out.format( "---Optima Presion y Temperatura        %1$8.0f dias ----%n",observatorioClimatologico.getDiasOptimaPresionYtemperatura() );
        if (this.condiciones.contains(CondicionTsunami.crearCondicion())) {
            System.out.format( "---Tsunami                             %1$8.0f dias ----%n",observatorioClimatologico.getDiasTsunami() );
        }
        System.out.println("---------------------------------------------------------");
    }


    public void addCondicion(Condicion condicion) {
        this.condiciones.add(condicion);
    }
}
