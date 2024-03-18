package TABLERO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public final class ManojoCartas {

    private Carta cartas[];
    private int posicionCarta = 0;
    private int numCartas = 0;
    public static int tipoEspecial = 0;
    public static int rangoEspecial= 10;
    private boolean cartaEspecial;


    /*
    Tipo y Rango Enum para clasificar cada carta 
     */
    public enum Tipo {
        DIAMANTE,
        CORAZÓN,
        TRÉBOL,
        PICA,
        COMODIN;
    }

    public enum Rango {
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
        AS,
        COMODIN;

    }

    public ManojoCartas() {

        inicializarBaraja();
        Barajear();

    }

    /*
    Inicializa la baraja y se asegura de poner cada tarjeta dos veces en la baraja y los ochos comodines / cartas de jack.
     */
    public void inicializarBaraja() {
        numCartas = (4 * 13)*2;
        cartas = new Carta[numCartas];
        int index = 0;

        for (Tipo tipo : Tipo.values()) {
            for (Rango rango : Rango.values()) {
                if (!(tipo == Tipo.COMODIN || rango == Rango.COMODIN)) {
                    cartas[index++] = new Carta(tipo, rango);
                }
                if(tipo.ordinal()==tipoEspecial && rango.ordinal()==rangoEspecial){
                    cartas[index].setEspecial();
                }
            }
        }

        for (Tipo tipo : Tipo.values()) {
            for (Rango rango : Rango.values()) {
                if (!(tipo == Tipo.COMODIN || rango == Rango.COMODIN)) {
                    cartas[index++] = new Carta(tipo, rango);
                }
            }
        }
    }

    /*
    Agarra la baraja creada y la randomiza
     */
    public void Barajear() {
        List<Carta> cartaList = Arrays.asList(cartas);
        Collections.shuffle(cartaList, new Random(System.nanoTime()));
        cartas = cartaList.toArray(Carta[]::new);
    }

    /*
    Agarra la siguiente carta en la baraja para cuando los usuarios estan agarrando cartas de la baraja
     */
    public Carta siguienteCarta() {

        Carta cartas = null;

        if (posicionCarta == numCartas) {
            JOptionPane.showMessageDialog(null, "Ya no hay mas cartas, por favor barajear otra vez!");
            return null;

        } else {
            cartas = this.cartas[posicionCarta++];
        }

        return cartas;
    }

    /*
    Entrega las cartas a cada jugador
    NumeroCartas cambiando dependiendo de la configuracion del usuario (CantidadJugador)
     */
    public Carta[] entregarCartas(int NumeroCartas) {

        if (NumeroCartas > numCartas) {
            System.out.println("No existe en la baraja esa cantidad de cartas.");
        } else {
            int cartasDisponibles = numCartas - posicionCarta;
            if (cartasDisponibles < NumeroCartas) {
                System.out.println("No hay suficientes cartas que mostrar");
            } else {
                Carta[] cartaEntregada = new Carta[NumeroCartas];
                for (int i = 0; i < cartaEntregada.length; i++) {
                    cartaEntregada[i] = siguienteCarta();
                }
                return cartaEntregada;
            }
        }
        return null;
    }

    /*
    Revisa si se necesita volver a barajear las cartas, y si es verdadero lo hace
     */
    public void revisarBaraja() {
        int cartasDisponibles = numCartas - posicionCarta;

        if (cartasDisponibles == 0) {
            System.out.println("Ya no quedan más cartas.");
            reiniciarMazo();
        } else {
            for (int i = posicionCarta; i < cartas.length; i++) {
                System.out.println(i + "" + cartas[i]);
            }
        }
    }

    /*
    Vuelve a iniciar la baraja y las barajea de un solo
     */
    public void reiniciarMazo() {
        posicionCarta = 0;
        inicializarBaraja();
        Barajear();
        
        System.out.println(numCartas);
    }

    ImageIcon getCardIcon(ManojoCartas.Tipo tipo, ManojoCartas.Rango rango) {
        String rangoNumero = "";
        String tipoTexto = "";

        if (rango.toString().equals("DOS")) {
            rangoNumero = "2";
        }

        if (rango.toString().equals("TRES")) {
            rangoNumero = "3";
        }

        if (rango.toString().equals("CUATRO")) {
            rangoNumero = "4";
        }

        if (rango.toString().equals("CINCO")) {
            rangoNumero = "5";
        }

        if (rango.toString().equals("SEIS")) {
            rangoNumero = "6";
        }

        if (rango.toString().equals("SIETE")) {
            rangoNumero = "7";
        }

        if (rango.toString().equals("OCHO")) {
            rangoNumero = "8";
        }

        if (rango.toString().equals("NUEVE")) {
            rangoNumero = "9";
        }

        if (rango.toString().equals("DIEZ")) {
            rangoNumero = "10";
        }

        if (rango.toString().equals("JOTA")) {
            rangoNumero = "jack";
        }

        if (rango.toString().equals("REINA")) {
            rangoNumero = "queen";
        }

        if (rango.toString().equals("REY")) {
            rangoNumero = "king";
        }

        if (rango.toString().equals("AS")) {
            rangoNumero = "ace";
        }
        
        if (rango.toString().equals("COMODIN")) {
            rangoNumero = "red";
        }

        if (tipo.toString().equals("DIAMANTE")) {
            tipoTexto = "diamonds";
        }

        if (tipo.toString().equals("CORAZÓN")) {
            tipoTexto = "hearts";
        }

        if (tipo.toString().equals("TRÉBOL")) {
            tipoTexto = "clubs";
        }

        if (tipo.toString().equals("PICA")) {
            tipoTexto = "spades";
        }

        if (tipo.toString().equals("COMODIN")) {
            tipoTexto = "joker";
        }

        String fileName = "";
        if (!"COMODIN".equals(tipo.toString()) || !"COMODIN".equals(rango.toString())) {
            fileName = String.format("/IMAGES/CARDS/%s_of_%s.png", rangoNumero.toLowerCase(), tipoTexto.toLowerCase());
            
        } else if ("COMODIN".equals(rango.toString())) {
            fileName = String.format("/IMAGES/CARDS/%s_%s.png", rangoNumero.toLowerCase(), tipoTexto.toLowerCase());
        }
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
            return icon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
