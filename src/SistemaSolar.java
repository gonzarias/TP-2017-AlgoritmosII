import java.util.ArrayList;

/**
 * Created by marti on 6/6/2017.
 */
public class SistemaSolar {
    private Sol sol;
    private ArrayList<Planeta> planetas;
    private ArrayList<Condicion> condiciones;

    public SistemaSolar() {
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
        Condicion condicionPresionYTemperatura = new CondicionPresionYTemperatura();

        this.condiciones.add(condicionSequia);
        this.condiciones.add(condicionLluvia);
        this.condiciones.add(condicionPresionYTemperatura);
    }
}
