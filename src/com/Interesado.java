package com;

import condiciones.CondicionLluvia;
import condiciones.CondicionPresionYTemperatura;
import condiciones.CondicionSequia;

/**
 * Created by polino on 2017-06-23.
 */
public class Interesado implements Alertador{
    private String interesado;

      private Boolean printAlarm = false;

    public Interesado (String interesado, Boolean printAlarm) {
        this.interesado = interesado;
        this.printAlarm = printAlarm;
    }

    @Override
    public void informar (CondicionLluvia condicionLluvia) {

        if (printAlarm) System.out.println ("Estimado: " +interesado + ". El clima está con Lluvia");
    }

    @Override
    public void informar (CondicionPresionYTemperatura condicionPresionYTemperatura) {
        if (printAlarm) System.out.println ("Estimado: " +interesado + ". El clima está con Optimas condiciones de Presion y Temperatura");

    }

    @Override
    public void informar (CondicionSequia condicionSequia) {
        if (printAlarm) System.out.println ("Estimado: " +interesado + ". El clima presenta una condición de Sequía");

    }


}
