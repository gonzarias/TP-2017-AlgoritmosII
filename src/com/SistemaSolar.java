package com;

import clima.Clima;
import condiciones.*;

import java.util.ArrayList;


/**
 * Created by marti on 6/6/2017.
 */
public class SistemaSolar {

    public static SistemaSolar instance;
    private Sol sol;

    public boolean debug = false;

    private ArrayList<Planeta> planetas;
    private ArrayList<Condicion> condiciones;
    private ArrayList<Clima> climas;
    private ObservatorioClimatologico observatorioClimatologico = new ObservatorioClimatologico();


    public static SistemaSolar getInstance(){
        if(instance == null){
            instance = new SistemaSolar();
        }
        return instance;
    }


    private SistemaSolar() {
        // Constructor utilizado para la carga inicial.

        if (debug)  System.out.println(" Carga Inicial...");

        this.sol = new Sol();
        this.planetas = new ArrayList<Planeta>();
        this.condiciones = new ArrayList<Condicion>();

        Planeta alderaan = new Planeta(500,1);
        Planeta felucia = new Planeta(2000,3);
        Planeta peragus = new Planeta(1000,-5);

        this.planetas.add(alderaan);
        this.planetas.add(felucia);
        this.planetas.add(peragus);

        Condicion condicionSequia = new CondicionSequia();
        Condicion condicionLluvia = new CondicionLluvia();
        Condicion condicionLluviaIntensa = new CondicionLluviaIntensa();
        Condicion condicionOptima = new CondicionOptima();
        Condicion condicionDesconocida = new CondicionDesconocida();

        this.condiciones.add(condicionSequia);
        this.condiciones.add(condicionLluvia);
        this.condiciones.add(condicionLluviaIntensa);
        this.condiciones.add(condicionOptima);
        this.condiciones.add(condicionDesconocida);
    }

    public void addPlanetas(ArrayList<Planeta> planetas) {
        this.planetas = planetas;
    }

    public void addCondiciones(ArrayList<Condicion> condiciones) {
        this.condiciones = condiciones;
    }


    public void obtenerClima (double dias){
        int i;

        if (debug)  System.out.println(" Obtener clima.Clima Iniciado...");

        for (i=0;i<dias;i++) {


           for (Planeta planeta : planetas) {


                planeta.transcurrirDias(dias);

            }

            if (debug)  System.out.println(" Transcurrido el dia " + i);

            // Se crea el Poligono para obtener la figura del Sistema

            FiguraSistema figuraSistema = new FiguraSistema(planetas);

            // Se verifican las condiciones

            





        }

    }




}
