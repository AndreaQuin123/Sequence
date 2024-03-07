package TABLERO;

import TABLERO.ManojoCartas.Rango;
import TABLERO.ManojoCartas.Tipo;

public class Carta {

    private Tipo tipo;
    private Rango rango;

    public Carta(Tipo tipo, Rango rango) {
        this.tipo = tipo;
        this.rango = rango;

    }

    static Casilla setTipoRango(ManojoCartas.Tipo tipo, ManojoCartas.Rango rango) {
        return new Casilla(tipo, rango);

    }

    public ManojoCartas.Tipo getTipo() {
        return tipo;

    }

    public ManojoCartas.Rango getRango() {
        return rango;
    }

}
