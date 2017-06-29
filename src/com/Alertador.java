package com;

import condiciones.CondicionLluvia;
import condiciones.CondicionPresionYTemperatura;
import condiciones.CondicionSequia;
import condiciones.CondicionTsunami;

public interface Alertador {

    void informar(CondicionLluvia condicionLluvia);
    void informar(CondicionPresionYTemperatura condicionPresionYTemperatura);
    void informar(CondicionSequia condicionSequia);
    void informar(CondicionTsunami condicionTsunami);
}
