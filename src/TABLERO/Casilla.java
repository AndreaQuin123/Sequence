
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
    private boolean tieneFicha; 

    public Casilla(ManojoCartas.Tipo tipo, ManojoCartas.Rango rango) {
        setContentAreaFilled(true);
        setBorder(new LineBorder(Color.black, 2));
        setHorizontalAlignment(JLabel.CENTER);

        this.tipo = tipo;
        this.rango=rango;
        this.tieneFicha=false;
        
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton != null) {
                    selectedButton.setBorder(new LineBorder(Color.black, 1));
                }

                setBorder(new LineBorder(Color.YELLOW, 3));

                selectedButton = Casilla.this;
                
                System.out.println("Este SOUT se encuentra en la clase de Casilla:"+selectedButton.getTipo() + " " + selectedButton.getRango());

                
                
            }
        });
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

    public boolean getFicha() {
        return tieneFicha;

    }

    public void setFicha() {
        this.tieneFicha = true;

    }

}
