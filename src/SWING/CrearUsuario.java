package SWING;

import USUARIOS.UsuariosMetodos;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CrearUsuario extends javax.swing.JFrame {

    private UsuariosMetodos funcion;

    public CrearUsuario(UsuariosMetodos metodo) {

        funcion = metodo != null ? metodo : new UsuariosMetodos();

        initComponents();
                setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConfirmarContraseñaTextbox = new javax.swing.JPasswordField();
        ContraseñaTextbox = new javax.swing.JPasswordField();
        NombreTextbox = new javax.swing.JTextField();
        UsuarioTextbox = new javax.swing.JTextField();
        CrearBTN = new javax.swing.JButton();
        SalirBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ConfirmarContraseñaTextbox.setBackground(new java.awt.Color(255, 249, 235));
        ConfirmarContraseñaTextbox.setForeground(new java.awt.Color(0, 0, 0));
        ConfirmarContraseñaTextbox.setText("Contraseña");
        ConfirmarContraseñaTextbox.setBorder(null);
        ConfirmarContraseñaTextbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarContraseñaTextboxActionPerformed(evt);
            }
        });
        getContentPane().add(ConfirmarContraseñaTextbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 190, 30));

        ContraseñaTextbox.setBackground(new java.awt.Color(255, 249, 235));
        ContraseñaTextbox.setForeground(new java.awt.Color(0, 0, 0));
        ContraseñaTextbox.setText("Contraseña");
        ContraseñaTextbox.setBorder(null);
        ContraseñaTextbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaTextboxActionPerformed(evt);
            }
        });
        getContentPane().add(ContraseñaTextbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 190, 30));

        NombreTextbox.setBackground(new java.awt.Color(255, 249, 235));
        NombreTextbox.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 18)); // NOI18N
        NombreTextbox.setForeground(new java.awt.Color(0, 0, 0));
        NombreTextbox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NombreTextbox.setText("Nombre completo");
        NombreTextbox.setBorder(null);
        NombreTextbox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(NombreTextbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 200, 30));

        UsuarioTextbox.setBackground(new java.awt.Color(255, 249, 235));
        UsuarioTextbox.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 18)); // NOI18N
        UsuarioTextbox.setForeground(new java.awt.Color(0, 0, 0));
        UsuarioTextbox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        UsuarioTextbox.setText("Usuario");
        UsuarioTextbox.setBorder(null);
        UsuarioTextbox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(UsuarioTextbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 200, 30));

        CrearBTN.setBorder(null);
        CrearBTN.setContentAreaFilled(false);
        CrearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearBTNActionPerformed(evt);
            }
        });
        getContentPane().add(CrearBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 170, 50));

        SalirBTN.setBorder(null);
        SalirBTN.setContentAreaFilled(false);
        SalirBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBTNActionPerformed(evt);
            }
        });
        getContentPane().add(SalirBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 170, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/BG_CrearUsuario.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBTNActionPerformed

        MainInicial pasar = new MainInicial();
        pasar.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_SalirBTNActionPerformed

    private void CrearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearBTNActionPerformed

        String name = NombreTextbox.getText();
        String usuario = UsuarioTextbox.getText();
        String password = ContraseñaTextbox.getText();
        String confirmarPass = ConfirmarContraseñaTextbox.getText();
        
        if (!password.isEmpty() && !confirmarPass.isEmpty() && password.equals(confirmarPass)){
            
            try {
                funcion.agregarUsuario(name, usuario, password);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
        } else {
            JOptionPane.showMessageDialog(this, "¡Las contraseñas no concuerdan!", "ERROR EN VERIFICACIÓN", JOptionPane.OK_CANCEL_OPTION);
        }
        
        
    }//GEN-LAST:event_CrearBTNActionPerformed

    private void ContraseñaTextboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaTextboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaTextboxActionPerformed

    private void ConfirmarContraseñaTextboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarContraseñaTextboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmarContraseñaTextboxActionPerformed

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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario(new UsuariosMetodos()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmarContraseñaTextbox;
    private javax.swing.JPasswordField ContraseñaTextbox;
    private javax.swing.JButton CrearBTN;
    private javax.swing.JTextField NombreTextbox;
    private javax.swing.JButton SalirBTN;
    private javax.swing.JTextField UsuarioTextbox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
