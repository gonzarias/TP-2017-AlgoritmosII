/**
 * Created by marti on 6/6/2017.
 */
<<<<<<< HEAD


public abstract class Condicion {

    public abstract Clima verificarCondicion(int dia);


=======
public abstract class Condicion {
    abstract public Clima evaluar(SistemaSolar sistemaSolar);
>>>>>>> 385aabcfee546eca6e3c45d3773d810c848f64f2
}

class Lluvia extends Condicion {

    public static Lluvia instance;
    Condicion siguiente = new Sequia();

    public static Lluvia getInstance(){
        if(instance == null){
            instance = new Lluvia();
        }
        return instance;
    }


    @Override
    public Clima verificarCondicion(int dia) {
        return new ClimaLluvioso(dia);
    }
}

class Sequia extends Condicion {

    public static Sequia instance;
    Condicion siguiente = new LluviaIntensa();

    public static Sequia getInstance(){
        if(instance == null){
            instance = new Sequia();
        }
        return instance;
    }

    @Override
    public Clima verificarCondicion(int dia) {
        return new ClimaSeco(dia);
    }


}



class LluviaIntensa extends Condicion {

    public static LluviaIntensa instance;
    Condicion siguiente = new Optima();

    public static LluviaIntensa getInstance(){
        if(instance == null){
            instance = new LluviaIntensa();
        }
        return instance;
    }

    @Override
    public Clima verificarCondicion(int dia) {
        return new ClimaLluviaIntensa(dia);
    }


}

class Optima extends Condicion {
    public static Optima instance;
    Condicion siguiente = new Desconocido();

    public static Optima getInstance(){
        if(instance == null){
            instance = new Optima();
        }
        return instance;
    }

    @Override
    public Clima verificarCondicion(int dia) {
        return new ClimaOptimo(dia);
    }




}

class Desconocido extends Condicion {

    @Override
    public Clima verificarCondicion(int dia) {
        return new ClimaDesconocido(dia);
    }

}

