
package TABLERO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Casilla extends JButton {

    static Casilla selectedButton;
    private ManojoCartas.Tipo tipo;
    private ManojoCartas.Rango rango;
    private String equipo;
    private boolean hasBlock;
    private boolean isItBlocked;
    private boolean isitEspecial;
    private boolean tieneFicha;
    private int fila;
    private int columna;

    public Casilla(ManojoCartas.Tipo tipo, ManojoCartas.Rango rango, int fila, int columna) {
        setContentAreaFilled(true);
        setBorder(new LineBorder(Color.black, 2));
        setHorizontalAlignment(JLabel.CENTER);

        this.tipo = tipo;
        this.rango = rango;
        this.fila = fila;
        this.columna = columna;
        this.tieneFicha = false;
        this.equipo = "";
        this.hasBlock = rango == ManojoCartas.Rango.JOTA;
        this.isitEspecial = false;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton != null) {
                    selectedButton.setBorder(new LineBorder(Color.black, 1));
                }

                setBorder(new LineBorder(Color.YELLOW, 3));

                selectedButton = Casilla.this;
            }
        });
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

    public boolean getFicha() {
        return tieneFicha;
    }

    public void setFicha() {
        this.tieneFicha = true;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public boolean getBlockStatus() {
        return isItBlocked;
    }

    public void setBlockStatus() {
        this.isItBlocked = true;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
    public void setEspecial() {
        this.isitEspecial = true;
    }

    public boolean getEspecial() {
        return isitEspecial;
    }
    
}