package SWING;

import TABLERO.TableroMain;
import USUARIOS.Usuario;
import USUARIOS.UsuariosMetodos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ElegirOponente extends javax.swing.JFrame {

    private UsuariosMetodos funcion;

    //players es la lista para nosotros y el comboBox es para hacer el modelo para el combobox
    public static ArrayList<String> players = new ArrayList<>();
    DefaultComboBoxModel<String> comboBoxModel;
    public static ArrayList<String> Equipo1 = new ArrayList<>();
    public static ArrayList<String> Equipo2 = new ArrayList<>();
    public static ArrayList<String> Equipo3 = new ArrayList<>();
    int contadorEquipo1;
    int contadorEquipo2;
    int contadorEquipo3;

    public ElegirOponente() throws IOException {
        funcion = funcion != null ? funcion : new UsuariosMetodos();

        Configuracion.cantidadJugador = Configuracion.cantidadJugador != null ? Configuracion.cantidadJugador : "4 Jugadores";
        initComponents();

        setLocationRelativeTo(null);

        Equipo1_2.setVisible(false);
        Equipo2_2.setVisible(false);
        Equipo1_3.setVisible(false);
        Equipo2_3.setVisible(false);
        Equipo3_3.setVisible(false);

        switch (Configuracion.cantidadJugador) {
            case "2 Jugadores":
                Equipo1_2.setVisible(true);
                Equipo2_2.setVisible(true);
                comboBoxModel = new DefaultComboBoxModel<>();
                comboBoxModel.addElement("EQUIPO 1");
                comboBoxModel.addElement("EQUIPO 2");
                Equipo.setModel(comboBoxModel);
                break;
            case "4 Jugadores":
                Equipo1_2.setVisible(true);
                Equipo2_2.setVisible(true);
                comboBoxModel = new DefaultComboBoxModel<>();

                comboBoxModel.addElement("EQUIPO 1");
                comboBoxModel.addElement("EQUIPO 2");
                Equipo.setModel(comboBoxModel);
                break;
            case "8 Jugadores":
                Equipo1_2.setVisible(true);
                Equipo2_2.setVisible(true);
                comboBoxModel = new DefaultComboBoxModel<>();
                comboBoxModel.addElement("EQUIPO 1");
                comboBoxModel.addElement("EQUIPO 2");
                Equipo.setModel(comboBoxModel);
                break;
            case "3 Jugadores":
                Equipo1_3.setVisible(true);
                Equipo2_3.setVisible(true);
                Equipo3_3.setVisible(true);
                comboBoxModel = new DefaultComboBoxModel<>();
                comboBoxModel.addElement("EQUIPO 1");
                comboBoxModel.addElement("EQUIPO 2");
                comboBoxModel.addElement("EQUIPO 3");
                Equipo.setModel(comboBoxModel);
            case "6 Jugadores":
                Equipo1_3.setVisible(true);
                Equipo2_3.setVisible(true);
                Equipo3_3.setVisible(true);
                comboBoxModel = new DefaultComboBoxModel<>();
                comboBoxModel.addElement("EQUIPO 1");
                comboBoxModel.addElement("EQUIPO 2");
                comboBoxModel.addElement("EQUIPO 3");
                Equipo.setModel(comboBoxModel);
                break;
        }

        usuariosEnComboBox();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegresarBTN = new javax.swing.JButton();
        JugarBTN = new javax.swing.JButton();
        CrearBTN = new javax.swing.JButton();
        Equipo = new javax.swing.JComboBox<>();
        Miembro = new javax.swing.JComboBox<>();
        Equipo1_3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextArea31 = new javax.swing.JTextArea();
        Equipo2_3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TextArea32 = new javax.swing.JTextArea();
        Equipo3_3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea33 = new javax.swing.JTextArea();
        Equipo2_2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TextArea22 = new javax.swing.JTextArea();
        Equipo1_2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TextArea21 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RegresarBTN.setBackground(new java.awt.Color(245, 245, 245));
        RegresarBTN.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        RegresarBTN.setForeground(new java.awt.Color(0, 0, 0));
        RegresarBTN.setText("REGRESAR");
        RegresarBTN.setBorder(null);
        RegresarBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RegresarBTN.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        RegresarBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RegresarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarBTNActionPerformed(evt);
            }
        });
        getContentPane().add(RegresarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 130, 40));

        JugarBTN.setBorder(null);
        JugarBTN.setContentAreaFilled(false);
        JugarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarBTNActionPerformed(evt);
            }
        });
        getContentPane().add(JugarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 180, 50));

        CrearBTN.setBorder(null);
        CrearBTN.setContentAreaFilled(false);
        CrearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearBTNActionPerformed(evt);
            }
        });
        getContentPane().add(CrearBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 180, 50));

        Equipo.setBackground(new java.awt.Color(255, 255, 255));
        Equipo.setForeground(new java.awt.Color(0, 0, 0));
        Equipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 260, 40));

        Miembro.setBackground(new java.awt.Color(255, 255, 255));
        Miembro.setForeground(new java.awt.Color(0, 0, 0));
        Miembro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Miembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 260, 40));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EQUIPO 1");
        Equipo1_3.add(jLabel2);

        TextArea31.setEditable(false);
        TextArea31.setBackground(new java.awt.Color(255, 255, 255));
        TextArea31.setColumns(20);
        TextArea31.setRows(5);
        TextArea31.setPreferredSize(new java.awt.Dimension(232, 50));
        jScrollPane3.setViewportView(TextArea31);

        Equipo1_3.add(jScrollPane3);

        getContentPane().add(Equipo1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 250, 120));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("EQUIPO 2");
        Equipo2_3.add(jLabel5);

        TextArea32.setEditable(false);
        TextArea32.setBackground(new java.awt.Color(255, 255, 255));
        TextArea32.setColumns(20);
        TextArea32.setRows(5);
        jScrollPane4.setViewportView(TextArea32);

        Equipo2_3.add(jScrollPane4);

        getContentPane().add(Equipo2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 250, 120));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EQUIPO 3");
        Equipo3_3.add(jLabel6);

        TextArea33.setEditable(false);
        TextArea33.setBackground(new java.awt.Color(255, 255, 255));
        TextArea33.setColumns(20);
        TextArea33.setRows(5);
        jScrollPane2.setViewportView(TextArea33);

        Equipo3_3.add(jScrollPane2);

        getContentPane().add(Equipo3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 250, 120));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("EQUIPO 2");
        Equipo2_2.add(jLabel4);

        TextArea22.setEditable(false);
        TextArea22.setBackground(new java.awt.Color(255, 255, 255));
        TextArea22.setColumns(20);
        TextArea22.setRows(5);
        jScrollPane6.setViewportView(TextArea22);

        Equipo2_2.add(jScrollPane6);

        getContentPane().add(Equipo2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 280, 150));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("EQUIPO 1");
        Equipo1_2.add(jLabel3);

        TextArea21.setEditable(false);
        TextArea21.setBackground(new java.awt.Color(255, 255, 255));
        TextArea21.setColumns(20);
        TextArea21.setRows(5);
        jScrollPane5.setViewportView(TextArea21);

        Equipo1_2.add(jScrollPane5);

        getContentPane().add(Equipo1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 280, 150));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/BG_ElegirOponente.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearBTNActionPerformed
        String miembroAgregado = (String) Miembro.getSelectedItem();
        String equipoPerteneciente = (String) Equipo.getSelectedItem();

        switch (equipoPerteneciente) {
            case "EQUIPO 1":
                if (Equipo1.contains(miembroAgregado) || Equipo2.contains(miembroAgregado) || Equipo3.contains(miembroAgregado) ) {
                    JOptionPane.showMessageDialog(null, "Este miembro ya se encuentra en otro equipo.");
                    return;
                }
                break;
            case "EQUIPO 2":
                if (Equipo1.contains(miembroAgregado) || Equipo2.contains(miembroAgregado) || Equipo3.contains(miembroAgregado) ) {
                    JOptionPane.showMessageDialog(null, "Este miembro ya se encuentra en otro equipo.");
                    return;
                }
                break;
            case "EQUIPO 3":
                if (Equipo1.contains(miembroAgregado) || Equipo2.contains(miembroAgregado) || Equipo3.contains(miembroAgregado) ) {
                    JOptionPane.showMessageDialog(null, "Este miembro ya se encuentra en otro equipo.");
                    return;
                }
                break;
        }

        if (null != Configuracion.cantidadJugador) {
            switch (Configuracion.cantidadJugador) {
                case "2 Jugadores":
                    if ((contadorEquipo1 < 1 && equipoPerteneciente.equals("EQUIPO 1"))
                            || (contadorEquipo2 < 1 && equipoPerteneciente.equals("EQUIPO 2"))) {
                        switch (equipoPerteneciente) {
                            case "EQUIPO 1":
                                TextArea21.setText(TextArea21.getText() + "\n" + miembroAgregado);
                                contadorEquipo1++;
                                Equipo1.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                            case "EQUIPO 2":
                                TextArea22.setText(TextArea22.getText() + "\n" + miembroAgregado);
                                contadorEquipo2++;
                                Equipo2.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya no puede agregar miembros a este equipo.");
                    }
                    break;
                case "4 Jugadores":
                    if ((contadorEquipo1 < 2 && equipoPerteneciente.equals("EQUIPO 1"))
                            || (contadorEquipo2 < 2 && equipoPerteneciente.equals("EQUIPO 2"))) {
                        switch (equipoPerteneciente) {
                            case "EQUIPO 1":
                                TextArea21.setText(TextArea21.getText() + "\n" + miembroAgregado);
                                contadorEquipo1++;
                                Equipo1.add(miembroAgregado);
                                players.add(miembroAgregado);

                                break;
                            case "EQUIPO 2":
                                TextArea22.setText(TextArea22.getText() + "\n" + miembroAgregado);
                                contadorEquipo2++;
                                Equipo2.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya no puede agregar miembros a este equipo.");
                    }
                    break;
                case "8 Jugadores":
                    if ((contadorEquipo1 < 4 && equipoPerteneciente.equals("EQUIPO 1"))
                            || (contadorEquipo2 < 4 && equipoPerteneciente.equals("EQUIPO 2"))) {
                        switch (equipoPerteneciente) {
                            case "EQUIPO 1":
                                TextArea21.setText(TextArea21.getText() + "\n" + miembroAgregado);
                                contadorEquipo1++;
                                Equipo1.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                            case "EQUIPO 2":
                                TextArea22.setText(TextArea22.getText() + "\n" + miembroAgregado);
                                contadorEquipo2++;
                                Equipo2.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya no puede agregar miembros a este equipo.");
                    }
                    break;
                case "3 Jugadores":
                    if ((contadorEquipo1 < 1 && equipoPerteneciente.equals("EQUIPO 1"))
                            || (contadorEquipo2 < 1 && equipoPerteneciente.equals("EQUIPO 2"))
                            || (contadorEquipo3 < 1 && equipoPerteneciente.equals("EQUIPO 3"))) {
                        switch (equipoPerteneciente) {
                            case "EQUIPO 1":
                                TextArea31.setText(TextArea31.getText() + "\n" + miembroAgregado);
                                contadorEquipo1++;
                                Equipo1.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                            case "EQUIPO 2":
                                TextArea32.setText(TextArea32.getText() + "\n" + miembroAgregado);
                                contadorEquipo2++;
                                Equipo2.add(miembroAgregado);
                                 {
                                    players.add(miembroAgregado);
                                }
                                break;
                            case "EQUIPO 3":
                                TextArea33.setText(TextArea33.getText() + "\n" + miembroAgregado);
                                contadorEquipo3++;
                                Equipo3.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya no puede agregar miembros a este equipo.");
                    }
                    break;
                case "6 Jugadores":
                    if ((contadorEquipo1 < 2 && equipoPerteneciente.equals("EQUIPO 1"))
                            || (contadorEquipo2 < 2 && equipoPerteneciente.equals("EQUIPO 2"))
                            || (contadorEquipo3 < 2 && equipoPerteneciente.equals("EQUIPO 3"))) {
                        switch (equipoPerteneciente) {
                            case "EQUIPO 1":
                                TextArea31.setText(TextArea31.getText() + "\n" + miembroAgregado);
                                contadorEquipo1++;
                                Equipo1.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                            case "EQUIPO 2":
                                TextArea32.setText(TextArea32.getText() + "\n" + miembroAgregado);
                                contadorEquipo2++;
                                Equipo2.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                            case "EQUIPO 3":
                                TextArea33.setText(TextArea33.getText() + "\n" + miembroAgregado);
                                contadorEquipo3++;
                                Equipo3.add(miembroAgregado);
                                players.add(miembroAgregado);
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya no puede agregar miembros a este equipo.");
                    }
                    break;
                default:
                    break;
            }
        }

        if (!miembroAgregado.equals(Login.usuarioLoggedIn) && (!(Equipo1.contains(Login.usuarioLoggedIn) || Equipo2.contains(Login.usuarioLoggedIn) || Equipo3.contains(Login.usuarioLoggedIn)))) {
            JOptionPane.showMessageDialog(null, "El usuario actual no está en ninguno de los equipos.");
            return;
        }


    }//GEN-LAST:event_CrearBTNActionPerformed

    private void JugarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarBTNActionPerformed

        if (Configuracion.cantidadJugador.equals("2 Jugadores")) {
            if ((contadorEquipo1 < 1 || contadorEquipo2 < 1)) {
                JOptionPane.showMessageDialog(null, "Por favor elegir los miembros de cada equipo.");
            } else {
                try {
                    TableroMain pasar = new TableroMain(funcion);
                    pasar.setVisible(true);
                    this.setVisible(false);

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (Configuracion.cantidadJugador.equals("4 Jugadores")) {
            if (contadorEquipo1 < 2 || contadorEquipo2 < 2) {
                JOptionPane.showMessageDialog(null, "Por favor elegir los miembros de cada equipo.");
            } else {
                try {
                    TableroMain pasar = new TableroMain(funcion);
                    pasar.setVisible(true);
                    this.setVisible(false);

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (Configuracion.cantidadJugador.equals("8 Jugadores")) {
            if ((contadorEquipo1 < 4 || contadorEquipo2 < 4)) {
                JOptionPane.showMessageDialog(null, "Por favor elegir los miembros de cada equipo.");
            } else {
                try {
                    TableroMain pasar = new TableroMain(funcion);
                    pasar.setVisible(true);
                    this.setVisible(false);

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (Configuracion.cantidadJugador.equals("3 Jugadores")) {
            if (contadorEquipo1 < 1 || contadorEquipo2 < 1 || contadorEquipo3 < 1) {
                JOptionPane.showMessageDialog(null, "Por favor elegir los miembros de cada equipo.");
            } else {
                try {
                    TableroMain pasar = new TableroMain(funcion);
                    pasar.setVisible(true);
                    this.setVisible(false);

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (Configuracion.cantidadJugador.equals("6 Jugadores")) {
            if (contadorEquipo1 < 2 || contadorEquipo2 < 2 || contadorEquipo3 < 2) {
                JOptionPane.showMessageDialog(null, "Por favor elegir los miembros de cada equipo.");
            } else {
                try {
                    TableroMain pasar = new TableroMain(funcion);
                    pasar.setVisible(true);
                    this.setVisible(false);

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }//GEN-LAST:event_JugarBTNActionPerformed

    private void RegresarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarBTNActionPerformed

        Equipo1.clear();
        Equipo2.clear();
        Equipo3.clear();

        TextArea21.setText("");
        TextArea22.setText("");
        
        TextArea32.setText("");
        TextArea32.setText("");
        TextArea33.setText("");

        MenuPrincipal pasar = new MenuPrincipal(funcion);
        pasar.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_RegresarBTNActionPerformed

    private void usuariosEnComboBox() {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        List<Usuario> users;
        try {
            users = funcion.getUsuarios();
            for (Usuario user : users) {
                comboBoxModel.addElement(user.getUsuario());
            }
            Miembro.setModel(comboBoxModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(ElegirOponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirOponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirOponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirOponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ElegirOponente().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ElegirOponente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearBTN;
    private javax.swing.JComboBox<String> Equipo;
    private javax.swing.JPanel Equipo1_2;
    private javax.swing.JPanel Equipo1_3;
    private javax.swing.JPanel Equipo2_2;
    private javax.swing.JPanel Equipo2_3;
    private javax.swing.JPanel Equipo3_3;
    private javax.swing.JButton JugarBTN;
    private javax.swing.JComboBox<String> Miembro;
    private javax.swing.JButton RegresarBTN;
    private javax.swing.JTextArea TextArea21;
    private javax.swing.JTextArea TextArea22;
    private javax.swing.JTextArea TextArea31;
    private javax.swing.JTextArea TextArea32;
    private javax.swing.JTextArea TextArea33;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
