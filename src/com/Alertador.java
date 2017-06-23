package com;

import condiciones.Condicion;
import condiciones.CondicionLluvia;
import condiciones.CondicionPresionYTemperatura;
import condiciones.CondicionSequia;

/**
 * Created by polino on 2017-06-23.
 */
public interface Alertador {

    public void informar(CondicionLluvia condicionLluvia);
    public void informar(CondicionPresionYTemperatura condicionPresionYTemperatura);
    public void informar(CondicionSequia condicionSequia);
}
