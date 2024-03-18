package SWING;

import USUARIOS.UsuariosMetodos;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Configuracion extends javax.swing.JFrame {

    private UsuariosMetodos funcion;
    public static String colorFicha = "AMARILLO";
    public static String cantidadJugador;

    public Configuracion(UsuariosMetodos metodo) {
        funcion = metodo != null ? metodo : new UsuariosMetodos();
        initComponents();

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SalirBTN = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new JButton();
        ;
        Equipos = new javax.swing.JLabel();
        CantidadJugadores = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SalirBTN.setBorder(null);
        SalirBTN.setContentAreaFilled(false);
        SalirBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBTNActionPerformed(evt);
            }
        });
        getContentPane().add(SalirBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 230, 50));

        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 255, 98, 97));

        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 254, 97, 98));

        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 123, 96, 97));

        jButton2.setContentAreaFilled(false);
        jButton2.setBorder(new RoundedBorder(2));
        jButton2.setForeground(Color.CYAN);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 122, 96, 98));

        Equipos.setBackground(new java.awt.Color(240, 240, 240));
        Equipos.setFont(new java.awt.Font("UD Digi Kyokasho NK-B", 1, 18)); // NOI18N
        Equipos.setForeground(new java.awt.Color(255, 60, 60));
        Equipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Equipos.setText("2 EQUIPOS");
        Equipos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Equipos.setOpaque(true);
        getContentPane().add(Equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 190, 40));

        CantidadJugadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Jugadores", "3 Jugadores", "4 Jugadores", "6 Jugadores", "8 Jugadores" }));
        CantidadJugadores.setSelectedItem("4 Jugadores");
        CantidadJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadJugadoresActionPerformed(evt);
            }
        });
        getContentPane().add(CantidadJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 260, 30));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 51, 0));
        jButton6.setText("CARTAS ESPECIALES");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/BG_Configuracion.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CantidadJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadJugadoresActionPerformed
        cantidadJugador = (String) CantidadJugadores.getSelectedItem();

        if ("2 Jugadores".equals(cantidadJugador) || "4 Jugadores".equals(cantidadJugador) || "8 Jugadores".equals(cantidadJugador)) {
            Equipos.setText("2 EQUIPOS");
        } else if ("3 Jugadores".equals(cantidadJugador) || "6 Jugadores".equals(cantidadJugador)) {
            Equipos.setText("3 EQUIPOS");
         }    }//GEN-LAST:event_CantidadJugadoresActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        jButton3.setBorder(null);
        jButton4.setBorder(null);
        jButton5.setBorder(null);

        jButton2.setBorder(new RoundedBorder(2));
        jButton2.setForeground(Color.CYAN);
        colorFicha = "AMARILLO";

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        jButton2.setBorder(null);
        jButton4.setBorder(null);
        jButton5.setBorder(null);

        jButton3.setBorder(new RoundedBorder(2));
        jButton3.setForeground(Color.CYAN);

        colorFicha = "ROJO";

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        jButton2.setBorder(null);
        jButton3.setBorder(null);
        jButton5.setBorder(null);

        jButton4.setBorder(new RoundedBorder(2));
        jButton4.setForeground(Color.CYAN);
        colorFicha = "VERDE";


    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        jButton2.setBorder(null);
        jButton3.setBorder(null);
        jButton4.setBorder(null);

        jButton5.setBorder(new RoundedBorder(2));
        jButton5.setForeground(Color.CYAN);

        colorFicha = "AZUL";

    }//GEN-LAST:event_jButton5MouseClicked

    private void SalirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBTNActionPerformed

        cantidadJugador = (String) CantidadJugadores.getSelectedItem();

        JOptionPane.showMessageDialog(null, "Eligio jugar con " + cantidadJugador + " y con la ficha de color " + colorFicha+"!");


        MenuPrincipal pasar = new MenuPrincipal(funcion);
        pasar.setVisible(true);
        this.setVisible(false);
        
        
        
    }//GEN-LAST:event_SalirBTNActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new CartaEspecial(funcion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion(new UsuariosMetodos()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CantidadJugadores;
    private javax.swing.JLabel Equipos;
    private javax.swing.JButton SalirBTN;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
