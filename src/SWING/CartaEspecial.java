
package SWING;

import TABLERO.ManojoCartas;
import USUARIOS.UsuariosMetodos;
import javax.swing.JOptionPane;

/**
 *
 * @author Tommy Lee Pon
 */

public class CartaEspecial extends javax.swing.JFrame {

    private UsuariosMetodos funcion;
    private String selectedRango;
    private String selectedTipo;

    public CartaEspecial(UsuariosMetodos metodo) {
        funcion = metodo != null ? metodo : new UsuariosMetodos();
        initComponents();
        selectedRango=ManojoCartas.rangoEspecial;
        selectedTipo=ManojoCartas.tipoEspecial;
        RangoComboBox.setSelectedItem(selectedRango);
        TipoComboBox.setSelectedItem(selectedTipo);
        
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        RangoComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TipoComboBox = new javax.swing.JComboBox<>();
        HabilidadComboBox = new javax.swing.JComboBox<>();
        SalirBTN = new javax.swing.JButton();
        GuardarBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Rango:");

        RangoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REY", "REINA" }));

        jLabel2.setText("Tipo:");

        jLabel3.setText("Habilidad:");

        TipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DIAMANTE", "CORAZÓN", "TRÉBOL", "PICA" }));

        HabilidadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intercambiar Fichas", "Robar Carta" }));

        SalirBTN.setText("Salir");
        SalirBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBTNActionPerformed(evt);
            }
        });

        GuardarBTN.setText("Guardar");
        GuardarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RangoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TipoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HabilidadComboBox, 0, 241, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SalirBTN)
                .addGap(26, 26, 26)
                .addComponent(GuardarBTN)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(RangoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(HabilidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalirBTN)
                    .addComponent(GuardarBTN))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBTNActionPerformed
        new Configuracion(funcion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SalirBTNActionPerformed

    private void GuardarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarBTNActionPerformed
        ManojoCartas.rangoEspecial = RangoComboBox.getSelectedItem().toString();
        ManojoCartas.tipoEspecial = TipoComboBox.getSelectedItem().toString();
        ManojoCartas.accionEspecial = HabilidadComboBox.getSelectedItem().toString();
        
        if (ManojoCartas.accionEspecial.equals("Intercambiar Ficha") && ((Configuracion.cantidadJugador.equals ("2 Jugadores")) || (Configuracion.cantidadJugador.equals("3 Jugadores"))))
            JOptionPane.showMessageDialog(null, "Si elije jugar con dos o tres jugadores, esta habilidad es nula.");
        
        
        new Configuracion(funcion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_GuardarBTNActionPerformed

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
            java.util.logging.Logger.getLogger(CartaEspecial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartaEspecial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartaEspecial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartaEspecial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartaEspecial(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuardarBTN;
    private javax.swing.JComboBox<String> HabilidadComboBox;
    private javax.swing.JComboBox<String> RangoComboBox;
    private javax.swing.JButton SalirBTN;
    private javax.swing.JComboBox<String> TipoComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
