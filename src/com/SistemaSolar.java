package com;

import clima.Clima;
import com.sun.org.apache.xpath.internal.SourceTree;
import condiciones.*;

import java.util.ArrayList;

public class SistemaSolar {

    public boolean debug = false;

    public static SistemaSolar sistemaSolar;
    private Sol sol;
    private ArrayList<Planeta> planetas;
    private ArrayList<Condicion> condiciones;
    private ArrayList<Clima> climas;
    private ObservatorioClimatologico observatorioClimatologico;


    public static SistemaSolar crearSistemaSolar(){
        if(sistemaSolar == null){
            sistemaSolar = new SistemaSolar();
        }
        return sistemaSolar;
    }


    private SistemaSolar() {
        // Constructor utilizado para la carga inicial.

        this.sol = new Sol();
        this.planetas = new ArrayList<Planeta>();
        this.condiciones = new ArrayList<Condicion>();
        this.observatorioClimatologico = ObservatorioClimatologico.crearObservatorioClimatologico();

        Planeta alderaan = new Planeta(500,1);
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
        Alertador i1 = new Interesado ("RepresentanteA");
        Alertador i2 = new Interesado ("EstacionA");

        condicionLluvia.subscribir (i1);
        condicionLluvia.subscribir (i2);
    }

    public void addPlaneta(ArrayList<Planeta> planetas) {
        this.planetas = planetas;
    }

    public ArrayList<Planeta> getPlanetas() {
        return this.planetas;
    }

    public Sol getSol() {
        return this.sol;
    }

    public void addCondicion(ArrayList<Condicion> condiciones) {
        this.condiciones = condiciones;
    }


    public void transcurrirDias(double dias){
        int diaActual;
        int p;
        Clima clima;
        Dia dia;

        for (diaActual=1;diaActual<=dias;diaActual++) {
            //Crear dia a agregar en el Observatorio
            dia = new Dia(diaActual);

            p = 1;
            for (Planeta planeta : this.planetas) {
                System.out.print("Posicion planeta " + p + ": ");
                planeta.transcurrirDia(diaActual);
                p++;
            }

            if (debug)  System.out.println(" Transcurrido el dia " + diaActual);
            // Se verifican las condiciones
            for (Condicion condicion : this.condiciones){
                clima = condicion.evaluar(this);
                dia.addClima(clima);
            }

            this.observatorioClimatologico.addDia(dia);
        }

        this.observatorioClimatologico.obetenerEstadistica(dias);

    }


}
