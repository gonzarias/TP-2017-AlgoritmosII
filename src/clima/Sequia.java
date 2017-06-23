package clima;

import com.Dia;

public class Sequia extends Clima {
    @Override
    public void agregarEnDia(Dia dia)  {
        dia.getClimas().add(this);
    }
}
