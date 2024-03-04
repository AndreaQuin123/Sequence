
package TABLERO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Casilla extends JButton {

    private static Casilla selectedButton = null;

    public Casilla() {
        setContentAreaFilled(true);
        setBorder(new LineBorder(Color.black, 2));
        setHorizontalAlignment(JLabel.CENTER);

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
    
}
