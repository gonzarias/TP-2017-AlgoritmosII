package clima;

import com.Dia;

public abstract class Clima {
    public void agregarEnDia(Dia dia) {
        dia.getClimas().add(this);
    }
}

