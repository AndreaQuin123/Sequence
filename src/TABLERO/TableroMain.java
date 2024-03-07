package TABLERO;

import SWING.Configuracion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import TABLERO.ManojoCartas.Rango;
import TABLERO.ManojoCartas.Tipo;
import USUARIOS.UsuariosMetodos;

public class TableroMain extends javax.swing.JFrame {

    private final List<Carta> cards = new ArrayList<>();

    private UsuariosMetodos funcion;

    public TableroMain(UsuariosMetodos metodo) {
        funcion = metodo != null ? metodo : new UsuariosMetodos();
        Configuracion.cantidadJugador = Configuracion.cantidadJugador != null ? Configuracion.cantidadJugador : "4 Jugadores";
        Configuracion.colorFicha = Configuracion.colorFicha != null ? Configuracion.colorFicha : "AMARILLO";

        initComponents();

        for (ManojoCartas.Tipo s : Tipo.values()) {
            for (ManojoCartas.Rango r : Rango.values()) {
                Carta c = new Carta(s, r);
                cards.add(c);
            }
        }

        for (ManojoCartas.Tipo s : Tipo.values()) {
            for (ManojoCartas.Rango r : Rango.values()) {
                Carta c = new Carta(s, r);
                cards.add(c);
            }
        }

        System.out.println("Este SOUT se encuentra en la clase de TableroMain" + Configuracion.cantidadJugador);

        Collections.shuffle(this.cards);

        tablero1.setVisible(false);
        Player21.setVisible(false);
        Player22.setVisible(false);
        Player31.setVisible(false);
        Player32.setVisible(false);
        Player33.setVisible(false);
        Player41.setVisible(false);
        Player42.setVisible(false);
        Player43.setVisible(false);
        Player44.setVisible(false);
        Player61.setVisible(false);
        Player62.setVisible(false);
        Player63.setVisible(false);
        Player64.setVisible(false);
        Player65.setVisible(false);
        Player66.setVisible(false);
        Player81.setVisible(false);
        Player82.setVisible(false);
        Player83.setVisible(false);
        Player84.setVisible(false);
        Player85.setVisible(false);
        Player86.setVisible(false);
        Player87.setVisible(false);
        Player88.setVisible(false);

        switch (Configuracion.cantidadJugador) {
            case "2 Jugadores":
                Player21.setVisible(true);
                Player22.setVisible(true);
                tablero1.setBounds(440, 10, 500, 740);
                ManojoCartas.setBounds(610, 790, 120, 80);
                tablero1.setVisible(true);

                break;
            case "3 Jugadores":
                Player31.setVisible(true);
                Player32.setVisible(true);
                Player33.setVisible(true);
                tablero1.setBounds(780, 30, 500, 740);
                ManojoCartas.setBounds(600, 320, 120, 80);

                tablero1.setVisible(true);

                break;
            case "4 Jugadores":
                Player41.setVisible(true);
                Player42.setVisible(true);
                Player43.setVisible(true);
                Player44.setVisible(true);
                tablero1.setBounds(440, 10, 500, 740);
                ManojoCartas.setBounds(610, 790, 120, 80);

                tablero1.setVisible(true);

                break;
            case "6 Jugadores":
                Player61.setVisible(true);
                Player62.setVisible(true);
                Player63.setVisible(true);
                Player64.setVisible(true);
                Player65.setVisible(true);
                Player66.setVisible(true);
                tablero1.setBounds(780, 30, 500, 740);
                ManojoCartas.setBounds(600, 320, 120, 80);

                tablero1.setVisible(true);

                break;
            case "8 Jugadores":
                Player81.setVisible(true);
                Player82.setVisible(true);
                Player83.setVisible(true);
                Player84.setVisible(true);
                Player85.setVisible(true);
                Player86.setVisible(true);
                Player87.setVisible(true);
                Player88.setVisible(true);
                ManojoCartas.setBounds(610, 790, 120, 80);

                tablero1.setBounds(440, 10, 500, 740);
                tablero1.setVisible(true);

                break;
            default:
                break;
        }

        setExtendedState(TableroMain.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tablero1 = new TABLERO.Tablero();
        Player22 = new javax.swing.JLabel();
        Player21 = new javax.swing.JLabel();
        Player44 = new javax.swing.JLabel();
        Player43 = new javax.swing.JLabel();
        Player42 = new javax.swing.JLabel();
        Player41 = new javax.swing.JLabel();
        Player33 = new javax.swing.JLabel();
        Player32 = new javax.swing.JLabel();
        Player31 = new javax.swing.JLabel();
        Player66 = new javax.swing.JLabel();
        Player65 = new javax.swing.JLabel();
        Player64 = new javax.swing.JLabel();
        Player63 = new javax.swing.JLabel();
        Player62 = new javax.swing.JLabel();
        Player61 = new javax.swing.JLabel();
        Player81 = new javax.swing.JLabel();
        Player82 = new javax.swing.JLabel();
        Player83 = new javax.swing.JLabel();
        Player84 = new javax.swing.JLabel();
        Player85 = new javax.swing.JLabel();
        Player86 = new javax.swing.JLabel();
        Player87 = new javax.swing.JLabel();
        Player88 = new javax.swing.JLabel();
        ManojoCartas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(190, 190, 190));
        jPanel1.setLayout(null);

        javax.swing.GroupLayout tablero1Layout = new javax.swing.GroupLayout(tablero1);
        tablero1.setLayout(tablero1Layout);
        tablero1Layout.setHorizontalGroup(
            tablero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        tablero1Layout.setVerticalGroup(
            tablero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );

        jPanel1.add(tablero1);
        tablero1.setBounds(750, 10, 500, 740);

        Player22.setBackground(new java.awt.Color(150, 150, 150));
        Player22.setText("jLabel1");
        Player22.setOpaque(true);
        jPanel1.add(Player22);
        Player22.setBounds(980, 170, 380, 280);

        Player21.setBackground(new java.awt.Color(150, 150, 150));
        Player21.setText("jLabel1");
        Player21.setOpaque(true);
        jPanel1.add(Player21);
        Player21.setBounds(20, 170, 380, 280);

        Player44.setBackground(new java.awt.Color(80, 80, 80));
        Player44.setText("jLabel1");
        Player44.setOpaque(true);
        jPanel1.add(Player44);
        Player44.setBounds(980, 320, 380, 220);

        Player43.setBackground(new java.awt.Color(100, 100, 100));
        Player43.setText("jLabel1");
        Player43.setOpaque(true);
        jPanel1.add(Player43);
        Player43.setBounds(20, 80, 380, 220);

        Player42.setBackground(new java.awt.Color(100, 100, 100));
        Player42.setText("jLabel1");
        Player42.setOpaque(true);
        jPanel1.add(Player42);
        Player42.setBounds(20, 330, 380, 220);

        Player41.setBackground(new java.awt.Color(80, 80, 80));
        Player41.setText("jLabel1");
        Player41.setOpaque(true);
        jPanel1.add(Player41);
        Player41.setBounds(980, 70, 380, 220);

        Player33.setBackground(new java.awt.Color(50, 50, 50));
        Player33.setText("jLabel1");
        Player33.setOpaque(true);
        jPanel1.add(Player33);
        Player33.setBounds(200, 490, 340, 210);

        Player32.setBackground(new java.awt.Color(50, 50, 50));
        Player32.setText("jLabel1");
        Player32.setOpaque(true);
        jPanel1.add(Player32);
        Player32.setBounds(200, 260, 340, 210);

        Player31.setBackground(new java.awt.Color(50, 50, 50));
        Player31.setText("jLabel1");
        Player31.setOpaque(true);
        jPanel1.add(Player31);
        Player31.setBounds(200, 30, 340, 210);

        Player66.setBackground(new java.awt.Color(0, 0, 0));
        Player66.setText("jLabel1");
        Player66.setOpaque(true);
        jPanel1.add(Player66);
        Player66.setBounds(400, 490, 340, 210);

        Player65.setBackground(new java.awt.Color(0, 0, 0));
        Player65.setText("jLabel1");
        Player65.setOpaque(true);
        jPanel1.add(Player65);
        Player65.setBounds(400, 260, 340, 210);

        Player64.setBackground(new java.awt.Color(0, 0, 0));
        Player64.setText("jLabel1");
        Player64.setOpaque(true);
        jPanel1.add(Player64);
        Player64.setBounds(40, 260, 340, 210);

        Player63.setBackground(new java.awt.Color(0, 0, 0));
        Player63.setText("jLabel1");
        Player63.setOpaque(true);
        jPanel1.add(Player63);
        Player63.setBounds(40, 490, 340, 210);

        Player62.setBackground(new java.awt.Color(0, 0, 0));
        Player62.setText("jLabel1");
        Player62.setOpaque(true);
        jPanel1.add(Player62);
        Player62.setBounds(400, 30, 340, 210);

        Player61.setBackground(new java.awt.Color(0, 0, 0));
        Player61.setText("jLabel1");
        Player61.setOpaque(true);
        jPanel1.add(Player61);
        Player61.setBounds(40, 30, 340, 210);

        Player81.setBackground(new java.awt.Color(100, 100, 100));
        Player81.setText("jLabel1");
        Player81.setOpaque(true);
        jPanel1.add(Player81);
        Player81.setBounds(20, 10, 380, 180);

        Player82.setBackground(new java.awt.Color(100, 100, 100));
        Player82.setText("jLabel1");
        Player82.setOpaque(true);
        jPanel1.add(Player82);
        Player82.setBounds(20, 210, 380, 180);

        Player83.setBackground(new java.awt.Color(100, 100, 100));
        Player83.setText("jLabel1");
        Player83.setOpaque(true);
        jPanel1.add(Player83);
        Player83.setBounds(20, 410, 380, 180);

        Player84.setBackground(new java.awt.Color(100, 100, 100));
        Player84.setText("jLabel1");
        Player84.setOpaque(true);
        jPanel1.add(Player84);
        Player84.setBounds(20, 610, 380, 180);

        Player85.setBackground(new java.awt.Color(100, 100, 100));
        Player85.setText("jLabel1");
        Player85.setOpaque(true);
        jPanel1.add(Player85);
        Player85.setBounds(980, 10, 380, 180);

        Player86.setBackground(new java.awt.Color(100, 100, 100));
        Player86.setText("jLabel1");
        Player86.setOpaque(true);
        jPanel1.add(Player86);
        Player86.setBounds(980, 210, 380, 180);

        Player87.setBackground(new java.awt.Color(100, 100, 100));
        Player87.setText("jLabel1");
        Player87.setOpaque(true);
        jPanel1.add(Player87);
        Player87.setBounds(980, 410, 380, 180);

        Player88.setBackground(new java.awt.Color(100, 100, 100));
        Player88.setText("jLabel1");
        Player88.setOpaque(true);
        jPanel1.add(Player88);
        Player88.setBounds(980, 610, 380, 180);

        ManojoCartas.setBackground(new java.awt.Color(100, 100, 100));
        ManojoCartas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/back.png"))); // NOI18N
        ManojoCartas.setOpaque(true);
        ManojoCartas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManojoCartasMouseClicked(evt);
            }
        });
        jPanel1.add(ManojoCartas);
        ManojoCartas.setBounds(610, 790, 120, 80);

        switch (Configuracion.cantidadJugador) {
            case "2 Jugadores":
            tablero1.setBounds(440, 10, 500, 740);

            break;
            case "3 Jugadores":
            tablero1.setBounds(780, 30, 500, 740);

            break;
            case "4 Jugadores":
            tablero1.setBounds(440, 10, 500, 740);

            break;
            case "6 Jugadores":
            tablero1.setBounds(780, 30, 500, 740);

            break;
            case "8 Jugadores":
            tablero1.setBounds(440, 10, 500, 740);
            break;
            default:
            break;
        }

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1464, 944));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManojoCartasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManojoCartasMouseClicked

        for (Carta c : cards) {

        }

    }//GEN-LAST:event_ManojoCartasMouseClicked

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
            java.util.logging.Logger.getLogger(TableroMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableroMain(new UsuariosMetodos()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ManojoCartas;
    private javax.swing.JLabel Player21;
    private javax.swing.JLabel Player22;
    private javax.swing.JLabel Player31;
    private javax.swing.JLabel Player32;
    private javax.swing.JLabel Player33;
    private javax.swing.JLabel Player41;
    private javax.swing.JLabel Player42;
    private javax.swing.JLabel Player43;
    private javax.swing.JLabel Player44;
    private javax.swing.JLabel Player61;
    private javax.swing.JLabel Player62;
    private javax.swing.JLabel Player63;
    private javax.swing.JLabel Player64;
    private javax.swing.JLabel Player65;
    private javax.swing.JLabel Player66;
    private javax.swing.JLabel Player81;
    private javax.swing.JLabel Player82;
    private javax.swing.JLabel Player83;
    private javax.swing.JLabel Player84;
    private javax.swing.JLabel Player85;
    private javax.swing.JLabel Player86;
    private javax.swing.JLabel Player87;
    private javax.swing.JLabel Player88;
    private javax.swing.JPanel jPanel1;
    private TABLERO.Tablero tablero1;
    // End of variables declaration//GEN-END:variables
}
