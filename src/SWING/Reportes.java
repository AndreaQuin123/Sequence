/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SWING;

import TABLERO.Log;
import TABLERO.Log.Game;
import USUARIOS.UsuariosMetodos;
import java.util.List;


public class Reportes extends javax.swing.JFrame {

    private UsuariosMetodos funcion;
    String usuarioLoggedIn = Login.usuarioLoggedIn;
    private Log.GameLog gameLog;

    public Reportes() {
        funcion = funcion != null ? funcion : new UsuariosMetodos();
        gameLog = gameLog != null ? gameLog : new Log.GameLog();

        initComponents();

        List<Game> juegosUsuario = gameLog.getJuegosUsuario(usuarioLoggedIn);
        StringBuilder contenido = null;
        
        for (Game item : juegosUsuario) {
            contenido.append(item).append("\n");
        }
        
        if (contenido != null) {
        Reportes.setText(contenido.toString());
        } else {
            Reportes.setText("El usuario no ha participado en ningun juego.");
        }
        
        setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SalirBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Reportes = new javax.swing.JTextArea();
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

        Reportes.setEditable(false);
        Reportes.setBackground(new java.awt.Color(255, 249, 235));
        Reportes.setColumns(20);
        Reportes.setForeground(new java.awt.Color(0, 0, 0));
        Reportes.setRows(5);
        jScrollPane1.setViewportView(Reportes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 610, 280));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/BG_Reportes.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBTNActionPerformed

        MenuPrincipal pasar = new MenuPrincipal(funcion);
        pasar.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_SalirBTNActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Reportes;
    private javax.swing.JButton SalirBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
