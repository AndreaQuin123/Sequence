
package SWING;

import USUARIOS.UsuariosMetodos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private UsuariosMetodos funcion;
    boolean escondido = true;

    public Login(UsuariosMetodos metodo) {

        funcion = metodo != null ? metodo : new UsuariosMetodos();
        initComponents();
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContraseñaStatus = new javax.swing.JToggleButton();
        ContraseñaTextbox = new javax.swing.JPasswordField();
        UsuarioTextbox = new javax.swing.JTextField();
        LoginBTN = new javax.swing.JButton();
        SalirBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContraseñaStatus.setBackground(new java.awt.Color(255, 255, 255));
        ContraseñaStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/HidePassword_IconResize.png"))); // NOI18N
        ContraseñaStatus.setBorder(null);
        ContraseñaStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContraseñaStatusMouseClicked(evt);
            }
        });
        getContentPane().add(ContraseñaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 240, 50, 40));

        ContraseñaTextbox.setBackground(new java.awt.Color(255, 249, 235));
        ContraseñaTextbox.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 18)); // NOI18N
        ContraseñaTextbox.setForeground(new java.awt.Color(0, 0, 0));
        ContraseñaTextbox.setText("Contraseña");
        ContraseñaTextbox.setBorder(null);
        ContraseñaTextbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaTextboxActionPerformed(evt);
            }
        });
        getContentPane().add(ContraseñaTextbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 200, 40));

        UsuarioTextbox.setBackground(new java.awt.Color(255, 249, 235));
        UsuarioTextbox.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 18)); // NOI18N
        UsuarioTextbox.setForeground(new java.awt.Color(0, 0, 0));
        UsuarioTextbox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        UsuarioTextbox.setText("Usuario");
        UsuarioTextbox.setBorder(null);
        UsuarioTextbox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(UsuarioTextbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 200, 30));

        LoginBTN.setBorder(null);
        LoginBTN.setContentAreaFilled(false);
        LoginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBTNActionPerformed(evt);
            }
        });
        getContentPane().add(LoginBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 170, 40));

        SalirBTN.setBorder(null);
        SalirBTN.setContentAreaFilled(false);
        SalirBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBTNActionPerformed(evt);
            }
        });
        getContentPane().add(SalirBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 180, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/BG_Login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirBTNActionPerformed

    private void LoginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBTNActionPerformed

        String usuario = UsuarioTextbox.getText();
        String contraseña = ContraseñaTextbox.getText();

        try {
            boolean existe = funcion.revisarContraseña(usuario, contraseña);

            if (existe) {
                
                MenuPrincipal pasar = new MenuPrincipal();
                pasar.setVisible(true);
                this.setVisible(false);
                
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_LoginBTNActionPerformed

    private void ContraseñaTextboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaTextboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaTextboxActionPerformed

    private void ContraseñaStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContraseñaStatusMouseClicked

        //STACK OVERFLOW MY BELOVED, GRACIAS.

        if (escondido) {
            ContraseñaTextbox.setEchoChar((char)0);
            Icon icon = new ImageIcon(getClass().getClassLoader().getResource("IMAGES/ShowPassword_IconResize.png"));
            ContraseñaStatus.setIcon(icon);
            escondido = false;
        } else if (!escondido) {
            ContraseñaTextbox.setEchoChar('*');
            Icon icon = new ImageIcon(getClass().getClassLoader().getResource("IMAGES/HidePassword_IconResize.png"));
            ContraseñaStatus.setIcon(icon);
            escondido = true;
        }
    }//GEN-LAST:event_ContraseñaStatusMouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login(new UsuariosMetodos()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ContraseñaStatus;
    private javax.swing.JPasswordField ContraseñaTextbox;
    private javax.swing.JButton LoginBTN;
    private javax.swing.JButton SalirBTN;
    private javax.swing.JTextField UsuarioTextbox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
