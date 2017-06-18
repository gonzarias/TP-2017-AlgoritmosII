/**
 * Created by marti on 6/6/2017.
 */
public class Sol extends CuerpoEstelar{
    public Sol() {
        this.posicion = new Posicion(0,0);
    }

    public Posicion obtenerPosicion() {
        return this.posicion;
    }
}
