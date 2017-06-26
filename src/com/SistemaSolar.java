package com;

import clima.Clima;
import com.sun.org.apache.xpath.internal.SourceTree;
import condiciones.*;

import java.util.ArrayList;

public class SistemaSolar {

    private Sol sol;
    private ArrayList<Planeta> planetas;
    private ArrayList<Condicion> condiciones;
    private ArrayList<Clima> climas;
    private ObservatorioClimatologico observatorioClimatologico;
    private double diasTranscurridos;


    public SistemaSolar(Boolean alertas) {
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
        Alertador i1 = new Interesado ("Representante Alderan", alertas);
        Alertador i2 = new Interesado ("Representante Felucia", alertas);

        condicionLluvia.subscribir (i1);
        condicionPresionYTemperatura.subscribir(i1);
        condicionSequia.subscribir(i1);

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
                //if (debug) System.out.print("Posicion planeta " + p + ": ");
                planeta.transcurrirDia(diaActual);
                p++;
            }

            //if (debug)  System.out.println(" Transcurrido el dia " + diaActual);
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

        System.out.println("--------------Informe Climatologico-----------------");
        System.out.format( "-Dias transcurridos ------             %1$8.0f ----%n",this.diasTranscurridos );
        System.out.format( "---LLuvia                              %1$8.0f ----%n",observatorioClimatologico.getDiasLluvia() );
        System.out.format( "------Dia Pico                         %1$8.0f ----%n",observatorioClimatologico.getDiaMaxLluvia().getDia());
        System.out.format( "---Sequia                              %1$8.0f ----%n",observatorioClimatologico.getDiasSequia() );
        System.out.format( "---Optima Presion y Temperatura        %1$8.0f ----%n",observatorioClimatologico.getDiasOptimaPresionYtemperatura() );
        System.out.println("----------------------------------------------------");
    }


}
