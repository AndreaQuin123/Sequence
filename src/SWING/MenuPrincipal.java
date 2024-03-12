
package SWING;

import TABLERO.TableroMain;
import USUARIOS.UsuariosMetodos;


public class MenuPrincipal extends javax.swing.JFrame {

    private UsuariosMetodos funcion;

    public MenuPrincipal(UsuariosMetodos metodo) {

        funcion = metodo != null ? metodo : new UsuariosMetodos();
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CerrarSesionBTN = new javax.swing.JButton();
        ReportesBTN = new javax.swing.JButton();
        ConfigBTN = new javax.swing.JButton();
        JugarBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CerrarSesionBTN.setBorder(null);
        CerrarSesionBTN.setContentAreaFilled(false);
        CerrarSesionBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionBTNActionPerformed(evt);
            }
        });
        getContentPane().add(CerrarSesionBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 300, 60));

        ReportesBTN.setBorder(null);
        ReportesBTN.setContentAreaFilled(false);
        ReportesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesBTNActionPerformed(evt);
            }
        });
        getContentPane().add(ReportesBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 300, 50));

        ConfigBTN.setBorder(null);
        ConfigBTN.setContentAreaFilled(false);
        ConfigBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigBTNActionPerformed(evt);
            }
        });
        getContentPane().add(ConfigBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 300, 50));

        JugarBTN.setBorder(null);
        JugarBTN.setContentAreaFilled(false);
        JugarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarBTNActionPerformed(evt);
            }
        });
        getContentPane().add(JugarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 111, 300, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/BG_MenuPrincipal.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JugarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarBTNActionPerformed
        try {
            TableroMain pasar = new TableroMain(funcion);
            pasar.setVisible(true);
            this.setVisible(false);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_JugarBTNActionPerformed

    private void ConfigBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigBTNActionPerformed
        Configuracion pasar = new Configuracion(funcion);
        pasar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ConfigBTNActionPerformed

    private void CerrarSesionBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionBTNActionPerformed
        Login pasar = new Login(funcion);
        pasar.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_CerrarSesionBTNActionPerformed

    private void ReportesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesBTNActionPerformed
        Reportes pasar = new Reportes();
        pasar.setVisible(true);
        this.setVisible(false);    }//GEN-LAST:event_ReportesBTNActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(new UsuariosMetodos()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesionBTN;
    private javax.swing.JButton ConfigBTN;
    private javax.swing.JButton JugarBTN;
    private javax.swing.JButton ReportesBTN;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
