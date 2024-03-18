package TABLERO;

import TABLERO.ManojoCartas.Rango;
import TABLERO.ManojoCartas.Tipo;

public class Carta {

    private Tipo tipo;
    private Rango rango;
    private String dueño;
    private boolean especial;

    public Carta(Tipo tipo, Rango rango) {
        this.tipo = tipo;
        this.rango = rango;
        this.dueño = dueño;
        especial = false;
    }
    
    public void setEspecial(){
        especial=true;
    }

    static Casilla setTipoRango(ManojoCartas.Tipo tipo, ManojoCartas.Rango rango, int fila, int columna) {
        return new Casilla(tipo, rango, fila, columna);

    }

    public ManojoCartas.Tipo getTipo() {
        return tipo;

    }
    
    public ManojoCartas.Rango getRango() {
        return rango;
    }
    
    public void setDueño(String dueño){
        this.dueño = dueño;
    }
    
        public String getDueño(){
        return dueño;
    }

}
