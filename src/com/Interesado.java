package com;

import condiciones.CondicionLluvia;
import condiciones.CondicionPresionYTemperatura;
import condiciones.CondicionSequia;

/**
 * Created by polino on 2017-06-23.
 */
public class Interesado implements Alertador{
    String interesado;

    public Interesado (String interesado) {
        this.interesado = interesado;
    }

    @Override
    public void informar (CondicionLluvia condicionLluvia) {
        System.out.println ("Estimado: " +interesado + ". El clima está con Lluvia");
    }

    @Override
    public void informar (CondicionPresionYTemperatura condicionPresionYTemperatura) {
        System.out.println ("Estimado: " +interesado + ". El clima está con Optimas condiciones de Presion y Temperatura");

    }

    @Override
    public void informar (CondicionSequia condicionSequia) {
        System.out.println ("Estimado: " +interesado + ". El clima presenta una condición de Sequía");

    }


}
