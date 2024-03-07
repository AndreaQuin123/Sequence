package TABLERO;

import java.util.ArrayList;
import java.util.List;

public class ManojoCartas {

    private final List<Carta> cards = new ArrayList<>();

    public enum Tipo {
        DIAMANTE,
        CORAZÓN,
        TRÉBOL,
        PICA,
        COMODIN;
    }

    public enum Rango {
        UNO,
        DOS,
        TRES,
        CUATRO,
        CINCO,
        SEIS,
        SIETE,
        OCHO,
        NUEVE,
        DIEZ,
        JOTA,
        REINA,
        REY,
        COMODIN,
        AS;
    }

}
