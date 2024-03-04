
package SWING;


public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
                setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CerrarSesionBTN = new javax.swing.JButton();
        ConfigBTN = new javax.swing.JButton();
        JugarBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        CerrarSesionBTN.setBorder(null);
        CerrarSesionBTN.setContentAreaFilled(false);
        CerrarSesionBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionBTNActionPerformed(evt);
            }
        });
        getContentPane().add(CerrarSesionBTN);
        CerrarSesionBTN.setBounds(260, 280, 300, 50);

        ConfigBTN.setBorder(null);
        ConfigBTN.setContentAreaFilled(false);
        ConfigBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigBTNActionPerformed(evt);
            }
        });
        getContentPane().add(ConfigBTN);
        ConfigBTN.setBounds(260, 210, 300, 50);

        JugarBTN.setBorder(null);
        JugarBTN.setContentAreaFilled(false);
        JugarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarBTNActionPerformed(evt);
            }
        });
        getContentPane().add(JugarBTN);
        JugarBTN.setBounds(260, 131, 300, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/BG_MenuPrincipal.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 820, 462);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JugarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarBTNActionPerformed

        
    }//GEN-LAST:event_JugarBTNActionPerformed

    private void ConfigBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfigBTNActionPerformed

    private void CerrarSesionBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CerrarSesionBTNActionPerformed

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
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesionBTN;
    private javax.swing.JButton ConfigBTN;
    private javax.swing.JButton JugarBTN;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
