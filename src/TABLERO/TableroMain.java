package TABLERO;

import SWING.Configuracion;
import SWING.ElegirOponente;
import TABLERO.Log.Game;
import java.util.ArrayList;
import java.util.List;
import USUARIOS.UsuariosMetodos;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class TableroMain extends javax.swing.JFrame {

    private final List<Carta> cards = new ArrayList<>();
    ManojoCartas manojo = new ManojoCartas();
    private Log.GameLog gameLog;

    private TimerListener reloj = new TimerListener();
    private Timer timer = new Timer(1000, reloj);
    private Carta[] cartaEntregada;
    private int jugadores;
    private int turnoActual = 1;
    private final Map<JLabel, Carta> labelCartaMap = new HashMap<>();
    static Casilla[][] casillas;

    String firstPlayer, secondPlayer, thirdPlayer, fourthPlayer, fifthPlayer, sixthPlayer, seventhPlayer, eighthPlayer;

    private UsuariosMetodos funcion;
    private Tablero tablero;
    private LogicaJuego Logica;
    private ElegirOponente oponente;

    public TableroMain(UsuariosMetodos metodo) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        funcion = metodo != null ? metodo : new UsuariosMetodos();
        Configuracion.cantidadJugador = Configuracion.cantidadJugador != null ? Configuracion.cantidadJugador : "3 Jugadores";
        Configuracion.colorFicha = Configuracion.colorFicha != null ? Configuracion.colorFicha : "AMARILLO";
        tablero = tablero != null ? tablero : new Tablero();
        gameLog = gameLog != null ? gameLog : new Log.GameLog();
        manojo = manojo != null ? manojo : new ManojoCartas();

        try {
            oponente = oponente != null ? oponente : new ElegirOponente();
        } catch (IOException ex) {
            Logger.getLogger(TableroMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        casillas = tablero.casillas;

        ArrayList<String> players = ElegirOponente.players;

        Logica = Logica != null ? Logica : new LogicaJuego(players, casillas);

        switch (Configuracion.cantidadJugador) {
            case "2 Jugadores":
                jugadores = 2;
            case "3 Jugadores":
                jugadores = 3;
            case "4 Jugadores":
                jugadores = 4;
            case "6 Jugadores":
                jugadores = 6;
            case "8 Jugadores":
                jugadores = 8;
        }

        manojo.reiniciarMazo();

        initComponents();

        TurnoJugador.setVisible(true);
        EquipoActual.setVisible(true);

        String jugadorActual = Logica.getPlayerActual();
        TurnoJugador.setText(jugadorActual);

        String equipoActual = Logica.getEquipoActual();
        EquipoActual.setText(equipoActual);

        tablero1.setVisible(false);
        Divider_Placeholder.setVisible(false);

        Player21.setVisible(false);
        Player22.setVisible(false);

        // 3 JUGADORES ---------------------
        Player31.setVisible(false);
        Player32.setVisible(false);
        Player33.setVisible(false);

        // 4 JUGADORES ---------------------
        Player41.setVisible(false);
        Player42.setVisible(false);
        Player43.setVisible(false);
        Player44.setVisible(false);

        // 6 JUGADORES ---------------------
        Player61.setVisible(false);
        Player62.setVisible(false);
        Player63.setVisible(false);
        Player64.setVisible(false);
        Player65.setVisible(false);
        Player66.setVisible(false);

        // 8 JUGADORES ---------------------
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

                cartaEntregada = manojo.entregarCartas(14);

                Player21.setVisible(true);
                Player22.setVisible(true);

                firstPlayer = players.get(0);
                secondPlayer = players.get(1);

                for (int i = 0; i < cartaEntregada.length; i++) {
                    int cardIndex = (i % 7) + 11 + (i / 7) * 10;
                    String labelName = String.format("CartaJugador2_" + cardIndex);

                    try {
                        JLabel cartaLabel = (JLabel) this.getClass().getDeclaredField(labelName).get(this);
                        cartaLabel.setVisible(true);
                        cartaLabel.setIcon(manojo.getCardIcon(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango()));

                        String owner;
                        if (i < 7) {
                            owner = firstPlayer;
                        } else {
                            owner = secondPlayer;
                        }

                        Carta carta = cartaCreada(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango());
                        carta.setDueño(owner);
                        labelCartaMap.put(cartaLabel, carta);

                        MouseListener boardMouseListener = new BoardMouseListener();
                        cartaLabel.addMouseListener(boardMouseListener);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.err.println("no existe el label papu");
                    }
                }

                tablero1.setBounds(450, 10, 500, 740);
                Deck.setBounds(520, 760, 120, 80);
                Timer.setBounds(720, 790, 180, 80);
                UltimaCarta.setBounds(180, 620, 110, 150);
                UltimaCartaTexto.setBounds(10, 780, 550, 40);
                EquipoActual.setBounds(1060, 800, 190, 40);
                TurnoJugador.setBounds(990, 760, 460, 40);
                tablero1.setVisible(true);

                break;

            case "3 Jugadores":
                cartaEntregada = manojo.entregarCartas(18);

                firstPlayer = players.get(0);
                secondPlayer = players.get(1);
                thirdPlayer = players.get(2);

                Player31.setVisible(true);
                Player32.setVisible(true);
                Player33.setVisible(true);

                for (int i = 0; i < cartaEntregada.length; i++) {
                    int cardIndex = (i % 6) + 11 + (i / 6) * 10;

                    String labelName = String.format("CartaJugador3_", cardIndex);

                    try {
                        JLabel cartaLabel = (JLabel) this.getClass().getDeclaredField(labelName).get(this);
                        cartaLabel.setVisible(true);
                        cartaLabel.setIcon(manojo.getCardIcon(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango()));

                        String owner;
                        if (i < 6) {
                            owner = firstPlayer;
                        } else if (i < 12) {
                            owner = secondPlayer;
                        } else {
                            owner = thirdPlayer;
                        }

                        Carta carta = cartaCreada(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango());
                        carta.setDueño(owner);
                        labelCartaMap.put(cartaLabel, carta);

                        MouseListener boardMouseListener = new BoardMouseListener();
                        cartaLabel.addMouseListener(boardMouseListener);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.err.println("no existe el label papu");
                    }
                }

                tablero1.setBounds(780, 30, 500, 740);
                Deck.setBounds(450, 760, 120, 80);
                Timer.setBounds(1080, 780, 200, 130);
                UltimaCarta.setBounds(20, 710, 110, 150);
                UltimaCartaTexto.setBounds(140, 770, 550, 40);
                EquipoActual.setBounds(600, 770, 190, 40);
                TurnoJugador.setBounds(600, 810, 460, 40);

                tablero1.setVisible(true);

                break;
            case "4 Jugadores":

                cartaEntregada = manojo.entregarCartas(28);

                firstPlayer = players.get(0);
                secondPlayer = players.get(1);
                thirdPlayer = players.get(2);
                fourthPlayer = players.get(3);

                Player41.setVisible(true);
                Player42.setVisible(true);
                Player43.setVisible(true);
                Player44.setVisible(true);

                for (int i = 0; i < cartaEntregada.length; i++) {
                    int cardIndex = (i % 7) + 11 + (i / 7) * 10;

                    String labelName = String.format("CartaJugador4_", cardIndex);
                    try {
                        JLabel cartaLabel = (JLabel) this.getClass().getDeclaredField(labelName).get(this);
                        cartaLabel.setVisible(true);
                        cartaLabel.setIcon(manojo.getCardIcon(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango()));

                        String owner;
                        if (i < 7) {
                            owner = firstPlayer;
                        } else if (i < 14) {
                            owner = secondPlayer;
                        } else if (i < 21) {
                            owner = thirdPlayer;
                        } else {
                            owner = fourthPlayer;
                        }

                        Carta carta = cartaCreada(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango());
                        carta.setDueño(owner);
                        labelCartaMap.put(cartaLabel, carta);

                        MouseListener boardMouseListener = new BoardMouseListener();
                        cartaLabel.addMouseListener(boardMouseListener);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.err.println("no existe el label papu");
                    }
                }

                tablero1.setBounds(450, 10, 500, 740);
                Deck.setBounds(520, 760, 120, 80);
                Timer.setBounds(720, 790, 180, 80);
                UltimaCarta.setBounds(180, 620, 110, 150);
                UltimaCartaTexto.setBounds(10, 780, 550, 40);
                EquipoActual.setBounds(1060, 800, 190, 40);
                TurnoJugador.setBounds(990, 760, 460, 40);

                tablero1.setVisible(true);

                break;
            case "6 Jugadores":

                cartaEntregada = manojo.entregarCartas(30);

                firstPlayer = players.get(0);
                secondPlayer = players.get(1);
                thirdPlayer = players.get(2);
                fourthPlayer = players.get(3);
                fifthPlayer = players.get(4);
                sixthPlayer = players.get(5);

                Player61.setVisible(true);
                Player62.setVisible(true);
                Player63.setVisible(true);
                Player64.setVisible(true);
                Player65.setVisible(true);
                Player66.setVisible(true);

                for (int i = 0; i < cartaEntregada.length; i++) {
                    int cardIndex = (i % 5) + 11 + (i / 5) * 10;
                    String labelName = String.format("CartaJugador6_" + cardIndex);

                    try {
                        JLabel cartaLabel = (JLabel) this.getClass().getDeclaredField(labelName).get(this);
                        cartaLabel.setVisible(true);
                        cartaLabel.setIcon(manojo.getCardIcon(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango()));

                        String owner;
                        if (i < 5) {
                            owner = firstPlayer;
                        } else if (i < 10) {
                            owner = secondPlayer;
                        } else if (i < 15) {
                            owner = thirdPlayer;
                        } else if (i < 20) {
                            owner = fourthPlayer;
                        } else if (i < 25) {
                            owner = fifthPlayer;
                        } else {
                            owner = sixthPlayer;
                        }

                        Carta carta = cartaCreada(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango());
                        carta.setDueño(owner);
                        labelCartaMap.put(cartaLabel, carta);

                        MouseListener boardMouseListener = new BoardMouseListener();
                        cartaLabel.addMouseListener(boardMouseListener);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.err.println("no existe el label papu");
                    }
                }

                tablero1.setBounds(780, 30, 500, 740);
                Deck.setBounds(500, 760, 120, 80);
                Timer.setBounds(1080, 780, 200, 130);
                UltimaCarta.setBounds(20, 710, 110, 150);
                UltimaCartaTexto.setBounds(140, 770, 550, 40);
                EquipoActual.setBounds(600, 790, 190, 40);
                TurnoJugador.setBounds(600, 830, 460, 40);

                tablero1.setVisible(true);

                break;
            case "8 Jugadores":

                cartaEntregada = manojo.entregarCartas(32);

                firstPlayer = players.get(0);
                secondPlayer = players.get(1);
                thirdPlayer = players.get(2);
                fourthPlayer = players.get(3);
                fifthPlayer = players.get(4);
                sixthPlayer = players.get(5);
                seventhPlayer = players.get(6);
                eighthPlayer = players.get(7);

                Player81.setVisible(true);
                Player82.setVisible(true);
                Player83.setVisible(true);
                Player84.setVisible(true);
                Player85.setVisible(true);
                Player86.setVisible(true);
                Player87.setVisible(true);
                Player88.setVisible(true);

                for (int i = 0; i < cartaEntregada.length; i++) {
                    int cardIndex = (i % 4) + 11 + (i / 4) * 10;
                    String labelName = String.format("CartaJugador8_" + cardIndex);

                    try {
                        JLabel cartaLabel = (JLabel) this.getClass().getDeclaredField(labelName).get(this);
                        cartaLabel.setVisible(true);
                        cartaLabel.setIcon(manojo.getCardIcon(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango()));

                        String owner;
                        if (i < 4) {
                            owner = firstPlayer;
                        } else if (i < 8) {
                            owner = secondPlayer;
                        } else if (i < 12) {
                            owner = thirdPlayer;
                        } else if (i < 16) {
                            owner = fourthPlayer;
                        } else if (i < 20) {
                            owner = fifthPlayer;
                        } else if (i < 24) {
                            owner = sixthPlayer;
                        } else if (i < 28) {
                            owner = seventhPlayer;
                        } else {
                            owner = eighthPlayer;
                        }

                        Carta carta = cartaCreada(cartaEntregada[i].getTipo(), cartaEntregada[i].getRango());
                        carta.setDueño(owner);
                        labelCartaMap.put(cartaLabel, carta);

                        MouseListener boardMouseListener = new BoardMouseListener();
                        cartaLabel.addMouseListener(boardMouseListener);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.err.println("no existe el label papu");
                    }
                }

                tablero1.setBounds(450, 10, 500, 740);
                Deck.setBounds(520, 760, 120, 80);
                Timer.setBounds(720, 790, 180, 80);
                UltimaCarta.setBounds(180, 620, 110, 150);
                UltimaCartaTexto.setBounds(10, 780, 550, 40);
                EquipoActual.setBounds(1060, 800, 190, 40);
                TurnoJugador.setBounds(990, 760, 460, 40);

                tablero1.setVisible(true);

                break;
            default:
                break;
        }

        mostrarCartas1();

        timer.start();

        setExtendedState(TableroMain.MAXIMIZED_BOTH);

    }

    /*
    Configuracion del timer, 120 segundos (2 minutos) 
     */
    private class TimerListener implements ActionListener {

        int segundosRestantes;

        public TimerListener() {
            segundosRestantes = 120;
        }

        public void actionPerformed(ActionEvent evt) {
            segundosRestantes--;
            Timer.setText(String.format("%02d:%02d", segundosRestantes / 60, segundosRestantes % 60));
            if (segundosRestantes <= 0) {
                ((Timer) evt.getSource()).stop();
                timerAcabado();
            }
        }

        /*
    Lo que hace al terminarse el timer, el jugador actual pierde su turno
         */
        private void timerAcabado() {
            JOptionPane.showMessageDialog(null, "¡Se acabo el tiempo, pierde su turno!");
            Logica.cambiarTurno();

            switch (Logica.turnoActual) {
                case 1:
                    mostrarCartas1();
                    break;
                case 2:
                    mostrarCartas2();
                    break;
                case 3:
                    mostrarCartas3();
                    break;
                case 4:
                    mostrarCartas4();
                    break;
                case 5:
                    mostrarCartas5();
                    break;
                case 6:
                    mostrarCartas6();
                    break;
                case 7:
                    mostrarCartas7();
                    break;
                case 8:
                    mostrarCartas8();
                    break;
                default:
                    System.err.println("Error inesperado: " + Logica.turnoActual);
                    break;
            }

            String jugadorActual = "Jugador actual: " + Logica.getPlayerActual();
            TurnoJugador.setText(jugadorActual);

            String equipoActual = Logica.getEquipoActual();
            EquipoActual.setText(equipoActual);

            resetTimer();

            jPanel1.revalidate();
            jPanel1.repaint();

        }

        public void resetTimer() {
            if (timer != null) {
                timer.stop();
                segundosRestantes = 120;
                SwingUtilities.invokeLater(() -> {
                    Timer.setText(String.format("%02d:%02d", segundosRestantes / 60, segundosRestantes % 60));
                });
                timer.start();
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tablero1 = new TABLERO.Tablero();
        TurnoJugador = new javax.swing.JLabel();
        EquipoActual = new javax.swing.JLabel();
        UltimaCarta = new javax.swing.JLabel();
        UltimaCartaTexto = new javax.swing.JLabel();
        CartaJugador4_47 = new javax.swing.JLabel();
        CartaJugador4_46 = new javax.swing.JLabel();
        CartaJugador4_45 = new javax.swing.JLabel();
        CartaJugador4_44 = new javax.swing.JLabel();
        CartaJugador4_43 = new javax.swing.JLabel();
        CartaJugador4_42 = new javax.swing.JLabel();
        CartaJugador4_41 = new javax.swing.JLabel();
        Player44 = new javax.swing.JLabel();
        CartaJugador4_37 = new javax.swing.JLabel();
        CartaJugador4_36 = new javax.swing.JLabel();
        CartaJugador4_35 = new javax.swing.JLabel();
        CartaJugador4_34 = new javax.swing.JLabel();
        CartaJugador4_33 = new javax.swing.JLabel();
        CartaJugador4_32 = new javax.swing.JLabel();
        CartaJugador4_31 = new javax.swing.JLabel();
        Player43 = new javax.swing.JLabel();
        CartaJugador4_27 = new javax.swing.JLabel();
        CartaJugador4_26 = new javax.swing.JLabel();
        CartaJugador4_25 = new javax.swing.JLabel();
        CartaJugador4_24 = new javax.swing.JLabel();
        CartaJugador4_23 = new javax.swing.JLabel();
        CartaJugador4_22 = new javax.swing.JLabel();
        CartaJugador4_21 = new javax.swing.JLabel();
        Player42 = new javax.swing.JLabel();
        CartaJugador4_17 = new javax.swing.JLabel();
        CartaJugador4_16 = new javax.swing.JLabel();
        CartaJugador4_15 = new javax.swing.JLabel();
        CartaJugador4_14 = new javax.swing.JLabel();
        CartaJugador4_13 = new javax.swing.JLabel();
        CartaJugador4_12 = new javax.swing.JLabel();
        CartaJugador4_11 = new javax.swing.JLabel();
        Player41 = new javax.swing.JLabel();
        CartaJugador6_11 = new javax.swing.JLabel();
        CartaJugador6_12 = new javax.swing.JLabel();
        CartaJugador6_13 = new javax.swing.JLabel();
        CartaJugador6_14 = new javax.swing.JLabel();
        CartaJugador6_15 = new javax.swing.JLabel();
        Player61 = new javax.swing.JLabel();
        CartaJugador6_21 = new javax.swing.JLabel();
        CartaJugador6_22 = new javax.swing.JLabel();
        CartaJugador6_23 = new javax.swing.JLabel();
        CartaJugador6_24 = new javax.swing.JLabel();
        CartaJugador6_25 = new javax.swing.JLabel();
        Player62 = new javax.swing.JLabel();
        CartaJugador6_31 = new javax.swing.JLabel();
        CartaJugador6_32 = new javax.swing.JLabel();
        CartaJugador6_33 = new javax.swing.JLabel();
        CartaJugador6_34 = new javax.swing.JLabel();
        CartaJugador6_35 = new javax.swing.JLabel();
        Player64 = new javax.swing.JLabel();
        CartaJugador6_51 = new javax.swing.JLabel();
        CartaJugador6_52 = new javax.swing.JLabel();
        CartaJugador6_53 = new javax.swing.JLabel();
        CartaJugador6_54 = new javax.swing.JLabel();
        CartaJugador6_55 = new javax.swing.JLabel();
        Player63 = new javax.swing.JLabel();
        CartaJugador6_41 = new javax.swing.JLabel();
        CartaJugador6_42 = new javax.swing.JLabel();
        CartaJugador6_43 = new javax.swing.JLabel();
        CartaJugador6_44 = new javax.swing.JLabel();
        CartaJugador6_45 = new javax.swing.JLabel();
        Player65 = new javax.swing.JLabel();
        CartaJugador6_61 = new javax.swing.JLabel();
        CartaJugador6_62 = new javax.swing.JLabel();
        CartaJugador6_63 = new javax.swing.JLabel();
        CartaJugador6_64 = new javax.swing.JLabel();
        CartaJugador6_65 = new javax.swing.JLabel();
        Player66 = new javax.swing.JLabel();
        CartaJugador3_16 = new javax.swing.JLabel();
        CartaJugador3_15 = new javax.swing.JLabel();
        CartaJugador3_14 = new javax.swing.JLabel();
        CartaJugador3_13 = new javax.swing.JLabel();
        CartaJugador3_12 = new javax.swing.JLabel();
        CartaJugador3_11 = new javax.swing.JLabel();
        Player31 = new javax.swing.JLabel();
        CartaJugador3_26 = new javax.swing.JLabel();
        CartaJugador3_25 = new javax.swing.JLabel();
        CartaJugador3_24 = new javax.swing.JLabel();
        CartaJugador3_23 = new javax.swing.JLabel();
        CartaJugador3_22 = new javax.swing.JLabel();
        CartaJugador3_21 = new javax.swing.JLabel();
        Player32 = new javax.swing.JLabel();
        CartaJugador3_36 = new javax.swing.JLabel();
        CartaJugador3_35 = new javax.swing.JLabel();
        CartaJugador3_34 = new javax.swing.JLabel();
        CartaJugador3_33 = new javax.swing.JLabel();
        CartaJugador3_32 = new javax.swing.JLabel();
        CartaJugador3_31 = new javax.swing.JLabel();
        Player33 = new javax.swing.JLabel();
        CartaJugador8_11 = new javax.swing.JLabel();
        CartaJugador8_12 = new javax.swing.JLabel();
        CartaJugador8_13 = new javax.swing.JLabel();
        CartaJugador8_14 = new javax.swing.JLabel();
        Player81 = new javax.swing.JLabel();
        CartaJugador8_21 = new javax.swing.JLabel();
        CartaJugador8_22 = new javax.swing.JLabel();
        CartaJugador8_23 = new javax.swing.JLabel();
        CartaJugador8_24 = new javax.swing.JLabel();
        Player82 = new javax.swing.JLabel();
        CartaJugador8_31 = new javax.swing.JLabel();
        CartaJugador8_32 = new javax.swing.JLabel();
        CartaJugador8_33 = new javax.swing.JLabel();
        CartaJugador8_34 = new javax.swing.JLabel();
        Player83 = new javax.swing.JLabel();
        CartaJugador8_41 = new javax.swing.JLabel();
        CartaJugador8_42 = new javax.swing.JLabel();
        CartaJugador8_43 = new javax.swing.JLabel();
        CartaJugador8_44 = new javax.swing.JLabel();
        Player84 = new javax.swing.JLabel();
        CartaJugador8_51 = new javax.swing.JLabel();
        CartaJugador8_52 = new javax.swing.JLabel();
        CartaJugador8_53 = new javax.swing.JLabel();
        CartaJugador8_54 = new javax.swing.JLabel();
        Player85 = new javax.swing.JLabel();
        CartaJugador8_61 = new javax.swing.JLabel();
        CartaJugador8_62 = new javax.swing.JLabel();
        CartaJugador8_63 = new javax.swing.JLabel();
        CartaJugador8_64 = new javax.swing.JLabel();
        Player86 = new javax.swing.JLabel();
        CartaJugador8_71 = new javax.swing.JLabel();
        CartaJugador8_72 = new javax.swing.JLabel();
        CartaJugador8_73 = new javax.swing.JLabel();
        CartaJugador8_74 = new javax.swing.JLabel();
        Player87 = new javax.swing.JLabel();
        CartaJugador8_81 = new javax.swing.JLabel();
        CartaJugador8_82 = new javax.swing.JLabel();
        CartaJugador8_83 = new javax.swing.JLabel();
        CartaJugador8_84 = new javax.swing.JLabel();
        Player88 = new javax.swing.JLabel();
        CartaJugador2_11 = new javax.swing.JLabel();
        CartaJugador2_12 = new javax.swing.JLabel();
        CartaJugador2_13 = new javax.swing.JLabel();
        CartaJugador2_14 = new javax.swing.JLabel();
        CartaJugador2_15 = new javax.swing.JLabel();
        CartaJugador2_16 = new javax.swing.JLabel();
        CartaJugador2_17 = new javax.swing.JLabel();
        Player22 = new javax.swing.JLabel();
        CartaJugador2_21 = new javax.swing.JLabel();
        CartaJugador2_22 = new javax.swing.JLabel();
        CartaJugador2_23 = new javax.swing.JLabel();
        CartaJugador2_24 = new javax.swing.JLabel();
        CartaJugador2_25 = new javax.swing.JLabel();
        CartaJugador2_26 = new javax.swing.JLabel();
        CartaJugador2_27 = new javax.swing.JLabel();
        Player21 = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        Deck = new javax.swing.JLabel();
        Divider_Placeholder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setLayout(null);

        tablero1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablero1MouseClicked(evt);
            }
        });

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
        tablero1.setBounds(780, 30, 500, 740);

        TurnoJugador.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        TurnoJugador.setText("JUGADOR ACTUAL:");
        jPanel1.add(TurnoJugador);
        TurnoJugador.setBounds(600, 770, 460, 40);

        EquipoActual.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        EquipoActual.setText("EQUIPO ACTUAL");
        jPanel1.add(EquipoActual);
        EquipoActual.setBounds(600, 810, 190, 40);

        UltimaCarta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(UltimaCarta);
        UltimaCarta.setBounds(20, 710, 110, 150);

        UltimaCartaTexto.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        UltimaCartaTexto.setText("ULTIMA CARTA: ");
        jPanel1.add(UltimaCartaTexto);
        UltimaCartaTexto.setBounds(140, 810, 200, 40);

        CartaJugador4_47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_47.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_47);
        CartaJugador4_47.setBounds(1250, 420, 52, 80);

        CartaJugador4_46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_46.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_46);
        CartaJugador4_46.setBounds(1180, 470, 52, 80);

        CartaJugador4_45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_45.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_45);
        CartaJugador4_45.setBounds(1180, 380, 52, 80);

        CartaJugador4_44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_44.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_44);
        CartaJugador4_44.setBounds(1110, 470, 52, 80);

        CartaJugador4_43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_43.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_43);
        CartaJugador4_43.setBounds(1110, 380, 52, 80);

        CartaJugador4_42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_42);
        CartaJugador4_42.setBounds(1040, 470, 52, 80);

        CartaJugador4_41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_41);
        CartaJugador4_41.setBounds(1040, 380, 52, 80);

        Player44.setBackground(new java.awt.Color(80, 80, 80));
        Player44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_4Player.png"))); // NOI18N
        Player44.setText("jLabel1");
        Player44.setOpaque(true);
        jPanel1.add(Player44);
        Player44.setBounds(990, 360, 360, 210);

        CartaJugador4_37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_37);
        CartaJugador4_37.setBounds(1260, 130, 52, 80);

        CartaJugador4_36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_36);
        CartaJugador4_36.setBounds(1190, 180, 52, 80);

        CartaJugador4_35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_35);
        CartaJugador4_35.setBounds(1190, 90, 52, 80);

        CartaJugador4_34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_34);
        CartaJugador4_34.setBounds(1120, 180, 52, 80);

        CartaJugador4_33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_33);
        CartaJugador4_33.setBounds(1120, 90, 52, 80);

        CartaJugador4_32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_32);
        CartaJugador4_32.setBounds(1050, 180, 52, 80);

        CartaJugador4_31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_31);
        CartaJugador4_31.setBounds(1050, 90, 52, 80);

        Player43.setBackground(new java.awt.Color(100, 100, 100));
        Player43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_4Player.png"))); // NOI18N
        Player43.setText("jLabel1");
        Player43.setOpaque(true);
        jPanel1.add(Player43);
        Player43.setBounds(990, 60, 360, 220);

        CartaJugador4_27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_27);
        CartaJugador4_27.setBounds(320, 430, 52, 80);

        CartaJugador4_26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_26);
        CartaJugador4_26.setBounds(250, 480, 52, 80);

        CartaJugador4_25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_25);
        CartaJugador4_25.setBounds(250, 390, 52, 80);

        CartaJugador4_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_24);
        CartaJugador4_24.setBounds(180, 480, 52, 80);

        CartaJugador4_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_23);
        CartaJugador4_23.setBounds(180, 390, 52, 80);

        CartaJugador4_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_22);
        CartaJugador4_22.setBounds(110, 480, 52, 80);

        CartaJugador4_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_21);
        CartaJugador4_21.setBounds(110, 390, 52, 80);

        Player42.setBackground(new java.awt.Color(100, 100, 100));
        Player42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_4Player.png"))); // NOI18N
        Player42.setText("jLabel1");
        Player42.setOpaque(true);
        jPanel1.add(Player42);
        Player42.setBounds(50, 360, 360, 220);

        CartaJugador4_17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_17);
        CartaJugador4_17.setBounds(320, 120, 52, 80);

        CartaJugador4_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_16);
        CartaJugador4_16.setBounds(250, 170, 52, 80);

        CartaJugador4_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_15);
        CartaJugador4_15.setBounds(250, 80, 52, 80);

        CartaJugador4_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_14);
        CartaJugador4_14.setBounds(180, 170, 52, 80);

        CartaJugador4_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_13);
        CartaJugador4_13.setBounds(180, 80, 52, 80);

        CartaJugador4_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_12);
        CartaJugador4_12.setBounds(110, 170, 52, 80);

        CartaJugador4_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador4_11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador4_11);
        CartaJugador4_11.setBounds(110, 80, 52, 80);

        Player41.setBackground(new java.awt.Color(80, 80, 80));
        Player41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_4Player.png"))); // NOI18N
        Player41.setText("jLabel1");
        Player41.setOpaque(true);
        jPanel1.add(Player41);
        Player41.setBounds(50, 60, 360, 220);

        CartaJugador6_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_11);
        CartaJugador6_11.setBounds(120, 50, 52, 80);

        CartaJugador6_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_12);
        CartaJugador6_12.setBounds(120, 140, 52, 80);

        CartaJugador6_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_13);
        CartaJugador6_13.setBounds(190, 140, 52, 80);

        CartaJugador6_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_14);
        CartaJugador6_14.setBounds(190, 50, 52, 80);

        CartaJugador6_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_15);
        CartaJugador6_15.setBounds(260, 90, 52, 80);

        Player61.setBackground(new java.awt.Color(0, 0, 0));
        Player61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_6Player.png"))); // NOI18N
        Player61.setText("jLabel1");
        Player61.setOpaque(true);
        jPanel1.add(Player61);
        Player61.setBounds(40, 30, 340, 210);

        CartaJugador6_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_21);
        CartaJugador6_21.setBounds(490, 50, 52, 80);

        CartaJugador6_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_22);
        CartaJugador6_22.setBounds(490, 140, 52, 80);

        CartaJugador6_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_23);
        CartaJugador6_23.setBounds(560, 50, 52, 80);

        CartaJugador6_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_24);
        CartaJugador6_24.setBounds(560, 140, 52, 80);

        CartaJugador6_25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_25);
        CartaJugador6_25.setBounds(630, 90, 52, 80);

        Player62.setBackground(new java.awt.Color(0, 0, 0));
        Player62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_6Player.png"))); // NOI18N
        Player62.setText("jLabel1");
        Player62.setOpaque(true);
        jPanel1.add(Player62);
        Player62.setBounds(400, 30, 340, 210);

        CartaJugador6_31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_31);
        CartaJugador6_31.setBounds(120, 280, 52, 80);

        CartaJugador6_32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_32);
        CartaJugador6_32.setBounds(120, 370, 52, 80);

        CartaJugador6_33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_33);
        CartaJugador6_33.setBounds(190, 280, 52, 80);

        CartaJugador6_34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_34);
        CartaJugador6_34.setBounds(190, 370, 52, 80);

        CartaJugador6_35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_35);
        CartaJugador6_35.setBounds(260, 320, 52, 80);

        Player64.setBackground(new java.awt.Color(0, 0, 0));
        Player64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_6Player.png"))); // NOI18N
        Player64.setText("jLabel1");
        Player64.setOpaque(true);
        jPanel1.add(Player64);
        Player64.setBounds(40, 260, 340, 210);

        CartaJugador6_51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_51.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_51);
        CartaJugador6_51.setBounds(120, 510, 52, 80);

        CartaJugador6_52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_52.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_52);
        CartaJugador6_52.setBounds(120, 600, 52, 80);

        CartaJugador6_53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_53.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_53);
        CartaJugador6_53.setBounds(190, 510, 52, 80);

        CartaJugador6_54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_54.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_54);
        CartaJugador6_54.setBounds(190, 600, 52, 80);

        CartaJugador6_55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_55.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_55);
        CartaJugador6_55.setBounds(260, 550, 52, 80);

        Player63.setBackground(new java.awt.Color(0, 0, 0));
        Player63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_6Player.png"))); // NOI18N
        Player63.setText("jLabel1");
        Player63.setOpaque(true);
        jPanel1.add(Player63);
        Player63.setBounds(40, 490, 340, 210);

        CartaJugador6_41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_41);
        CartaJugador6_41.setBounds(630, 320, 52, 80);

        CartaJugador6_42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_42);
        CartaJugador6_42.setBounds(490, 370, 52, 80);

        CartaJugador6_43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_43.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_43);
        CartaJugador6_43.setBounds(560, 280, 52, 80);

        CartaJugador6_44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_44.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_44);
        CartaJugador6_44.setBounds(490, 280, 52, 80);

        CartaJugador6_45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_45.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_45);
        CartaJugador6_45.setBounds(560, 370, 52, 80);

        Player65.setBackground(new java.awt.Color(0, 0, 0));
        Player65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_6Player.png"))); // NOI18N
        Player65.setText("jLabel1");
        Player65.setOpaque(true);
        jPanel1.add(Player65);
        Player65.setBounds(400, 260, 340, 210);

        CartaJugador6_61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_61.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_61);
        CartaJugador6_61.setBounds(480, 510, 52, 80);

        CartaJugador6_62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_62.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_62);
        CartaJugador6_62.setBounds(480, 600, 52, 80);

        CartaJugador6_63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_63.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_63);
        CartaJugador6_63.setBounds(550, 510, 52, 80);

        CartaJugador6_64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_64.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_64);
        CartaJugador6_64.setBounds(550, 600, 52, 80);

        CartaJugador6_65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador6_65.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador6_65);
        CartaJugador6_65.setBounds(620, 550, 52, 80);

        Player66.setBackground(new java.awt.Color(0, 0, 0));
        Player66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_6Player.png"))); // NOI18N
        Player66.setText("jLabel1");
        Player66.setOpaque(true);
        jPanel1.add(Player66);
        Player66.setBounds(400, 490, 340, 210);

        CartaJugador3_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_16);
        CartaJugador3_16.setBounds(410, 140, 52, 80);

        CartaJugador3_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_15);
        CartaJugador3_15.setBounds(410, 50, 52, 80);

        CartaJugador3_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_14);
        CartaJugador3_14.setBounds(340, 140, 52, 80);

        CartaJugador3_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_13);
        CartaJugador3_13.setBounds(340, 50, 52, 80);

        CartaJugador3_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_12);
        CartaJugador3_12.setBounds(270, 140, 52, 80);

        CartaJugador3_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_11);
        CartaJugador3_11.setBounds(270, 50, 52, 80);

        Player31.setBackground(new java.awt.Color(50, 50, 50));
        Player31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_3Player.png"))); // NOI18N
        Player31.setOpaque(true);
        jPanel1.add(Player31);
        Player31.setBounds(160, 30, 420, 210);

        CartaJugador3_26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_26);
        CartaJugador3_26.setBounds(410, 380, 52, 80);

        CartaJugador3_25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_25);
        CartaJugador3_25.setBounds(410, 290, 52, 80);

        CartaJugador3_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_24);
        CartaJugador3_24.setBounds(340, 380, 52, 80);

        CartaJugador3_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_23);
        CartaJugador3_23.setBounds(340, 290, 52, 80);

        CartaJugador3_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_22);
        CartaJugador3_22.setBounds(270, 380, 52, 80);

        CartaJugador3_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_21);
        CartaJugador3_21.setBounds(270, 290, 52, 80);

        Player32.setBackground(new java.awt.Color(50, 50, 50));
        Player32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_3Player.png"))); // NOI18N
        Player32.setOpaque(true);
        jPanel1.add(Player32);
        Player32.setBounds(160, 270, 420, 210);

        CartaJugador3_36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_36);
        CartaJugador3_36.setBounds(410, 620, 52, 80);

        CartaJugador3_35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_35);
        CartaJugador3_35.setBounds(410, 530, 52, 80);

        CartaJugador3_34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_34);
        CartaJugador3_34.setBounds(340, 620, 52, 80);

        CartaJugador3_33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_33);
        CartaJugador3_33.setBounds(340, 530, 52, 80);

        CartaJugador3_32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_32);
        CartaJugador3_32.setBounds(270, 620, 52, 80);

        CartaJugador3_31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador3_31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador3_31);
        CartaJugador3_31.setBounds(270, 530, 52, 80);

        Player33.setBackground(new java.awt.Color(50, 50, 50));
        Player33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_3Player.png"))); // NOI18N
        Player33.setOpaque(true);
        jPanel1.add(Player33);
        Player33.setBounds(160, 510, 420, 210);

        CartaJugador8_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_11);
        CartaJugador8_11.setBounds(140, 60, 52, 80);

        CartaJugador8_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_12);
        CartaJugador8_12.setBounds(60, 60, 52, 80);

        CartaJugador8_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_13);
        CartaJugador8_13.setBounds(220, 60, 52, 80);

        CartaJugador8_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_14);
        CartaJugador8_14.setBounds(300, 60, 52, 80);

        Player81.setBackground(new java.awt.Color(100, 100, 100));
        Player81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_8Player.png"))); // NOI18N
        Player81.setOpaque(true);
        jPanel1.add(Player81);
        Player81.setBounds(20, 10, 380, 180);

        CartaJugador8_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_21);
        CartaJugador8_21.setBounds(60, 260, 52, 80);

        CartaJugador8_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_22);
        CartaJugador8_22.setBounds(140, 260, 52, 80);

        CartaJugador8_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_23);
        CartaJugador8_23.setBounds(220, 260, 52, 80);

        CartaJugador8_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_24);
        CartaJugador8_24.setBounds(300, 260, 52, 80);

        Player82.setBackground(new java.awt.Color(100, 100, 100));
        Player82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_8Player.png"))); // NOI18N
        Player82.setOpaque(true);
        jPanel1.add(Player82);
        Player82.setBounds(20, 210, 380, 180);

        CartaJugador8_31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_31);
        CartaJugador8_31.setBounds(60, 460, 52, 80);

        CartaJugador8_32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_32);
        CartaJugador8_32.setBounds(140, 460, 52, 80);

        CartaJugador8_33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_33);
        CartaJugador8_33.setBounds(220, 460, 52, 80);

        CartaJugador8_34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_34);
        CartaJugador8_34.setBounds(300, 460, 52, 80);

        Player83.setBackground(new java.awt.Color(100, 100, 100));
        Player83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_8Player.png"))); // NOI18N
        Player83.setText("jLabel1");
        Player83.setOpaque(true);
        jPanel1.add(Player83);
        Player83.setBounds(20, 410, 380, 180);

        CartaJugador8_41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_41);
        CartaJugador8_41.setBounds(300, 660, 52, 80);

        CartaJugador8_42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_42);
        CartaJugador8_42.setBounds(220, 660, 52, 80);

        CartaJugador8_43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_43.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_43);
        CartaJugador8_43.setBounds(60, 660, 52, 80);

        CartaJugador8_44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_44.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_44);
        CartaJugador8_44.setBounds(140, 660, 52, 80);

        Player84.setBackground(new java.awt.Color(100, 100, 100));
        Player84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_8Player.png"))); // NOI18N
        Player84.setText("jLabel1");
        Player84.setOpaque(true);
        jPanel1.add(Player84);
        Player84.setBounds(20, 610, 380, 180);

        CartaJugador8_51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_51.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_51);
        CartaJugador8_51.setBounds(1260, 60, 52, 80);

        CartaJugador8_52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_52.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_52);
        CartaJugador8_52.setBounds(1180, 60, 52, 80);

        CartaJugador8_53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_53.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_53);
        CartaJugador8_53.setBounds(1020, 60, 52, 80);

        CartaJugador8_54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_54.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_54);
        CartaJugador8_54.setBounds(1100, 60, 52, 80);

        Player85.setBackground(new java.awt.Color(100, 100, 100));
        Player85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_8Player.png"))); // NOI18N
        Player85.setOpaque(true);
        jPanel1.add(Player85);
        Player85.setBounds(980, 10, 380, 180);

        CartaJugador8_61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_61.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_61);
        CartaJugador8_61.setBounds(1020, 260, 52, 80);

        CartaJugador8_62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_62.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_62);
        CartaJugador8_62.setBounds(1180, 260, 52, 80);

        CartaJugador8_63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_63.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_63);
        CartaJugador8_63.setBounds(1100, 260, 52, 80);

        CartaJugador8_64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_64.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_64);
        CartaJugador8_64.setBounds(1260, 260, 52, 80);

        Player86.setBackground(new java.awt.Color(100, 100, 100));
        Player86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_8Player.png"))); // NOI18N
        Player86.setText("jLabel1");
        Player86.setOpaque(true);
        jPanel1.add(Player86);
        Player86.setBounds(980, 210, 380, 180);

        CartaJugador8_71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_71.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_71);
        CartaJugador8_71.setBounds(1020, 460, 52, 80);

        CartaJugador8_72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_72.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_72);
        CartaJugador8_72.setBounds(1180, 460, 52, 80);

        CartaJugador8_73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_73.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_73);
        CartaJugador8_73.setBounds(1100, 460, 52, 80);

        CartaJugador8_74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_74.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_74);
        CartaJugador8_74.setBounds(1260, 460, 52, 80);

        Player87.setBackground(new java.awt.Color(100, 100, 100));
        Player87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_8Player.png"))); // NOI18N
        Player87.setText("jLabel1");
        Player87.setOpaque(true);
        jPanel1.add(Player87);
        Player87.setBounds(980, 410, 380, 180);

        CartaJugador8_81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_81.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_81);
        CartaJugador8_81.setBounds(1020, 660, 52, 80);

        CartaJugador8_82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_82.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_82);
        CartaJugador8_82.setBounds(1260, 660, 52, 80);

        CartaJugador8_83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_83.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_83);
        CartaJugador8_83.setBounds(1180, 660, 52, 80);

        CartaJugador8_84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador8_84.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador8_84);
        CartaJugador8_84.setBounds(1100, 660, 52, 80);

        Player88.setBackground(new java.awt.Color(100, 100, 100));
        Player88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_8Player.png"))); // NOI18N
        Player88.setText("jLabel1");
        Player88.setOpaque(true);
        jPanel1.add(Player88);
        Player88.setBounds(980, 610, 380, 180);

        CartaJugador2_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_11);
        CartaJugador2_11.setBounds(330, 280, 52, 80);

        CartaJugador2_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_12);
        CartaJugador2_12.setBounds(260, 330, 52, 80);

        CartaJugador2_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_13);
        CartaJugador2_13.setBounds(260, 240, 52, 80);

        CartaJugador2_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_14);
        CartaJugador2_14.setBounds(120, 240, 52, 80);

        CartaJugador2_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_15);
        CartaJugador2_15.setBounds(120, 330, 52, 80);

        CartaJugador2_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_16);
        CartaJugador2_16.setBounds(190, 240, 52, 80);

        CartaJugador2_17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_17);
        CartaJugador2_17.setBounds(190, 330, 52, 80);

        Player22.setBackground(new java.awt.Color(150, 150, 150));
        Player22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_4Player.png"))); // NOI18N
        Player22.setText("jLabel1");
        Player22.setOpaque(true);
        jPanel1.add(Player22);
        Player22.setBounds(60, 210, 360, 220);

        CartaJugador2_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_21);
        CartaJugador2_21.setBounds(1260, 280, 52, 80);

        CartaJugador2_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_22);
        CartaJugador2_22.setBounds(1190, 330, 52, 80);

        CartaJugador2_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_23);
        CartaJugador2_23.setBounds(1190, 240, 52, 80);

        CartaJugador2_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_24);
        CartaJugador2_24.setBounds(1050, 240, 52, 80);

        CartaJugador2_25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_25);
        CartaJugador2_25.setBounds(1050, 330, 52, 80);

        CartaJugador2_26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_26);
        CartaJugador2_26.setBounds(1120, 240, 52, 80);

        CartaJugador2_27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"))); // NOI18N
        CartaJugador2_27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(CartaJugador2_27);
        CartaJugador2_27.setBounds(1120, 330, 52, 80);

        Player21.setBackground(new java.awt.Color(150, 150, 150));
        Player21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cartas_BG_4Player.png"))); // NOI18N
        Player21.setText("jLabel1");
        Player21.setOpaque(true);
        jPanel1.add(Player21);
        Player21.setBounds(990, 210, 360, 220);

        Timer.setBackground(new java.awt.Color(255, 255, 255));
        Timer.setFont(new java.awt.Font("Yu Mincho", 1, 48)); // NOI18N
        Timer.setForeground(new java.awt.Color(0, 0, 0));
        Timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Timer.setText("  00:00");
        Timer.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Timer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 4));
        Timer.setOpaque(true);
        Timer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimerMouseClicked(evt);
            }
        });
        jPanel1.add(Timer);
        Timer.setBounds(1080, 780, 200, 130);

        Deck.setBackground(new java.awt.Color(100, 100, 100));
        Deck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/back.png"))); // NOI18N
        Deck.setOpaque(true);
        Deck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeckMouseClicked(evt);
            }
        });
        jPanel1.add(Deck);
        Deck.setBounds(450, 790, 120, 80);

        Divider_Placeholder.setBackground(new java.awt.Color(100, 100, 100));
        Divider_Placeholder.setOpaque(true);
        jPanel1.add(Divider_Placeholder);
        Divider_Placeholder.setBounds(0, 0, 1460, 890);

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

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g.dispose();
        return resizedImage;
    }

    private Carta cartaCreada(ManojoCartas.Tipo tipo, ManojoCartas.Rango rango) {
        return new Carta(tipo, rango);
    }

    public int[] getPosicion(ManojoCartas.Tipo tipo, ManojoCartas.Rango rango) {
        int[] position = new int[]{-1, -1};

        for (int row = 0; row < casillas.length; row++) {
            for (int col = 0; col < casillas[row].length; col++) {
                Casilla casilla = casillas[row][col];
                if (casilla.getTipo() == tipo && casilla.getRango() == rango
                        && casilla.getFila() == Casilla.selectedButton.getFila() && casilla.getColumna() == Casilla.selectedButton.getColumna()) {
                    position[0] = row;
                    position[1] = col;
                    return position;
                }
            }
        }

        return position;
    }

    private class BoardMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            JLabel clickedLabel = (JLabel) e.getComponent();
            Carta carta = labelCartaMap.get(clickedLabel);

            boolean turno = verificarTurno(e);

            if (Casilla.selectedButton.getBlockStatus()) {
                JOptionPane.showMessageDialog(null, "Esta celda está bloqueada y no se puede modificar.");
                return;
            }

            if (turno) {
                if (carta != null) {
                    for (JLabel label : labelCartaMap.keySet()) {
                        label.setBorder(new LineBorder(Color.black, 1));
                    }

                    ManojoCartas.Tipo tipo = carta.getTipo();
                    ManojoCartas.Rango rango = carta.getRango();
                    clickedLabel.setBorder(new LineBorder(Color.yellow, 3));

                    if (Casilla.selectedButton != null) {
                        ManojoCartas.Tipo casillaType = Casilla.selectedButton.getTipo();
                        ManojoCartas.Rango casillaRank = Casilla.selectedButton.getRango();

                        if ((tipo.equals(casillaType) && rango.equals(casillaRank))
                                || (casillaType == ManojoCartas.Tipo.COMODIN && casillaRank == ManojoCartas.Rango.COMODIN)
                                || (rango == ManojoCartas.Rango.JOTA)) {

                            //ULTIMA CARTA SETTINGS
                            ImageIcon icono = (ImageIcon) Casilla.selectedButton.getIcon();
                            Image image = icono.getImage();
                            Image resizedImage = image.getScaledInstance(110, 150, Image.SCALE_SMOOTH);
                            ImageIcon resizedIcon = new ImageIcon(resizedImage);
                            UltimaCarta.setIcon(resizedIcon);
                            UltimaCartaTexto.setText("ULTIMA CARTA: " + casillaType.toString() + " " + casillaRank.toString());

                            //ACTUALIZACION DEL TABLERO
                            Casilla.selectedButton.setBorder(new LineBorder(Color.black, 1));
                            Casilla.selectedButton.setIcon(Logica.fichaActual);
                            Casilla.selectedButton.setFicha();
                            Casilla.selectedButton.setEquipo(Logica.equipoActualTexto);

                            //Agarrando la posicion para ponerlo en el array de casillas
                            int[] posicion = getPosicion(casillaType, casillaRank);
                            int row = posicion[0];
                            int col = posicion[1];
                            casillas[row][col].setFicha();
                            casillas[row][col].setEquipo(Logica.equipoActualTexto);

                            //PARA LOS COMODINES
                            if (casillaType == ManojoCartas.Tipo.COMODIN && casillaRank == ManojoCartas.Rango.COMODIN) {
                                clickedLabel.setIcon(manojo.getCardIcon(ManojoCartas.Tipo.COMODIN, ManojoCartas.Rango.COMODIN));
                                casillas[row][col].setFicha();
                                casillas[row][col].setEquipo(Logica.equipoActualTexto);

                                //PARA LAS JOTAS
                            } else if (rango == ManojoCartas.Rango.JOTA) {
                                Carta nextCarta = manojo.siguienteCarta();
                                clickedLabel.setIcon(manojo.getCardIcon(nextCarta.getTipo(), nextCarta.getRango()));
                                nextCarta.setDueño(Logica.getPlayerActual());
                                labelCartaMap.put(clickedLabel, nextCarta);
                                casillas[row][col].setFicha();
                                casillas[row][col].setEquipo(Logica.equipoActualTexto);
                                casillas[row][col].setBlockStatus();
                                Casilla.selectedButton.setIcon(null);

                                if (Logica.fichaActual.equals("AMARILLO")) {
                                    Casilla.selectedButton.setForeground(Color.YELLOW);
                                }

                                if (Logica.fichaActual.equals("ROJO")) {
                                    Casilla.selectedButton.setForeground(Color.RED);
                                }

                                if (Logica.fichaActual.equals("AZUL")) {
                                    Casilla.selectedButton.setForeground(Color.BLUE);
                                }

                                if (Logica.fichaActual.equals("VERDE")) {
                                    Casilla.selectedButton.setForeground(Color.GREEN);
                                }

                            } else {
                                Carta nextCarta = manojo.siguienteCarta();
                                clickedLabel.setIcon(manojo.getCardIcon(nextCarta.getTipo(), nextCarta.getRango()));
                                nextCarta.setDueño(Logica.getPlayerActual());
                                labelCartaMap.put(clickedLabel, nextCarta);
                                casillas[row][col].setFicha();
                                casillas[row][col].setEquipo(Logica.equipoActualTexto);
                            }

                            //REVISANDO LAS GANADAS
                            if (Logica.checkForWin()) {
                                JOptionPane.showMessageDialog(null, "EL GANADOR ES...." + Logica.equipoActualTexto + "!!");

                                ArrayList<String> ganadores = new ArrayList<>();;

                                for (String player : Logica.equipoActual) {
                                    ganadores.add(player + "\n");
                                }

                                Game juego = new Game(Logica.players, "GANO " + Logica.equipoActualTexto + ". Los jugadores participantes fueron: " + ganadores+"pero participaron "+ElegirOponente.players);

                                for (int i = 0; i < Logica.equipoActual.size(); i++) {
                                    gameLog.agregarJuego(juego);
                                }

                            }

                            Logica.cambiarTurno();

                            reloj.resetTimer();

                            switch (Logica.turnoActual) {
                                case 1:
                                    mostrarCartas1();
                                    break;
                                case 2:
                                    mostrarCartas2();
                                    break;
                                case 3:
                                    mostrarCartas3();
                                    break;
                                case 4:
                                    mostrarCartas4();
                                    break;
                                case 5:
                                    mostrarCartas5();
                                    break;
                                case 6:
                                    mostrarCartas6();
                                    break;
                                case 7:
                                    mostrarCartas7();
                                    break;
                                case 8:
                                    mostrarCartas8();
                                    break;
                                default:
                                    System.err.println("Error inesperado: " + Logica.turnoActual);
                                    break;
                            }

                            String jugadorActual = "Jugador actual: " + Logica.getPlayerActual();
                            TurnoJugador.setText(jugadorActual);

                            String equipoActual = Logica.getEquipoActual();
                            EquipoActual.setText(equipoActual);

                            jPanel1.revalidate();
                            jPanel1.repaint();

                        } else {
                            JOptionPane.showMessageDialog(null, "No coinciden.");
                        }

                        Casilla.selectedButton.setBorder(new LineBorder(Color.black, 1));
                        Casilla.selectedButton = null;
                    }
                }
            }
        }
    }

    public void esconderCartas() {
        CartaJugador2_11.setVisible(false);
        CartaJugador2_12.setVisible(false);
        CartaJugador2_13.setVisible(false);
        CartaJugador2_14.setVisible(false);
        CartaJugador2_15.setVisible(false);
        CartaJugador2_16.setVisible(false);
        CartaJugador2_17.setVisible(false);

        CartaJugador2_21.setVisible(false);
        CartaJugador2_22.setVisible(false);
        CartaJugador2_23.setVisible(false);
        CartaJugador2_24.setVisible(false);
        CartaJugador2_25.setVisible(false);
        CartaJugador2_26.setVisible(false);
        CartaJugador2_27.setVisible(false);

        CartaJugador3_11.setVisible(false);
        CartaJugador3_12.setVisible(false);
        CartaJugador3_13.setVisible(false);
        CartaJugador3_14.setVisible(false);
        CartaJugador3_15.setVisible(false);
        CartaJugador3_16.setVisible(false);

        CartaJugador3_21.setVisible(false);
        CartaJugador3_22.setVisible(false);
        CartaJugador3_23.setVisible(false);
        CartaJugador3_24.setVisible(false);
        CartaJugador3_25.setVisible(false);
        CartaJugador3_26.setVisible(false);

        CartaJugador3_31.setVisible(false);
        CartaJugador3_32.setVisible(false);
        CartaJugador3_33.setVisible(false);
        CartaJugador3_34.setVisible(false);
        CartaJugador3_35.setVisible(false);
        CartaJugador3_36.setVisible(false);

        // 4 JUGADORES ---------------------
        CartaJugador4_11.setVisible(false);
        CartaJugador4_12.setVisible(false);
        CartaJugador4_13.setVisible(false);
        CartaJugador4_14.setVisible(false);
        CartaJugador4_15.setVisible(false);
        CartaJugador4_16.setVisible(false);
        CartaJugador4_17.setVisible(false);

        CartaJugador4_21.setVisible(false);
        CartaJugador4_22.setVisible(false);
        CartaJugador4_23.setVisible(false);
        CartaJugador4_24.setVisible(false);
        CartaJugador4_25.setVisible(false);
        CartaJugador4_26.setVisible(false);
        CartaJugador4_27.setVisible(false);

        CartaJugador4_31.setVisible(false);
        CartaJugador4_32.setVisible(false);
        CartaJugador4_33.setVisible(false);
        CartaJugador4_34.setVisible(false);
        CartaJugador4_35.setVisible(false);
        CartaJugador4_36.setVisible(false);
        CartaJugador4_37.setVisible(false);

        CartaJugador4_41.setVisible(false);
        CartaJugador4_42.setVisible(false);
        CartaJugador4_43.setVisible(false);
        CartaJugador4_44.setVisible(false);
        CartaJugador4_45.setVisible(false);
        CartaJugador4_46.setVisible(false);
        CartaJugador4_47.setVisible(false);

        // 6 JUGADORES ---------------------
        CartaJugador6_11.setVisible(false);
        CartaJugador6_12.setVisible(false);
        CartaJugador6_13.setVisible(false);
        CartaJugador6_14.setVisible(false);
        CartaJugador6_15.setVisible(false);

        CartaJugador6_21.setVisible(false);
        CartaJugador6_22.setVisible(false);
        CartaJugador6_23.setVisible(false);
        CartaJugador6_24.setVisible(false);
        CartaJugador6_25.setVisible(false);

        CartaJugador6_31.setVisible(false);
        CartaJugador6_32.setVisible(false);
        CartaJugador6_33.setVisible(false);
        CartaJugador6_34.setVisible(false);
        CartaJugador6_35.setVisible(false);

        CartaJugador6_41.setVisible(false);
        CartaJugador6_42.setVisible(false);
        CartaJugador6_43.setVisible(false);
        CartaJugador6_44.setVisible(false);
        CartaJugador6_45.setVisible(false);

        CartaJugador6_51.setVisible(false);
        CartaJugador6_52.setVisible(false);
        CartaJugador6_53.setVisible(false);
        CartaJugador6_54.setVisible(false);
        CartaJugador6_55.setVisible(false);

        CartaJugador6_61.setVisible(false);
        CartaJugador6_62.setVisible(false);
        CartaJugador6_63.setVisible(false);
        CartaJugador6_64.setVisible(false);
        CartaJugador6_65.setVisible(false);

        // 8 JUGADORES ---------------------
        CartaJugador8_11.setVisible(false);
        CartaJugador8_12.setVisible(false);
        CartaJugador8_13.setVisible(false);
        CartaJugador8_14.setVisible(false);

        CartaJugador8_21.setVisible(false);
        CartaJugador8_22.setVisible(false);
        CartaJugador8_23.setVisible(false);
        CartaJugador8_24.setVisible(false);

        CartaJugador8_31.setVisible(false);
        CartaJugador8_32.setVisible(false);
        CartaJugador8_33.setVisible(false);
        CartaJugador8_34.setVisible(false);

        CartaJugador8_41.setVisible(false);
        CartaJugador8_42.setVisible(false);
        CartaJugador8_43.setVisible(false);
        CartaJugador8_44.setVisible(false);

        CartaJugador8_51.setVisible(false);
        CartaJugador8_52.setVisible(false);
        CartaJugador8_53.setVisible(false);
        CartaJugador8_54.setVisible(false);

        CartaJugador8_61.setVisible(false);
        CartaJugador8_62.setVisible(false);
        CartaJugador8_63.setVisible(false);
        CartaJugador8_64.setVisible(false);

        CartaJugador8_71.setVisible(false);
        CartaJugador8_72.setVisible(false);
        CartaJugador8_73.setVisible(false);
        CartaJugador8_74.setVisible(false);

        CartaJugador8_81.setVisible(false);
        CartaJugador8_82.setVisible(false);
        CartaJugador8_83.setVisible(false);
        CartaJugador8_84.setVisible(false);
    }

    public void mostrarCartas1() {

        esconderCartas();

        switch (Configuracion.cantidadJugador) {
            case "2 Jugadores":
                CartaJugador2_11.setVisible(true);
                CartaJugador2_12.setVisible(true);
                CartaJugador2_13.setVisible(true);
                CartaJugador2_14.setVisible(true);
                CartaJugador2_15.setVisible(true);
                CartaJugador2_16.setVisible(true);
                CartaJugador2_17.setVisible(true);
                break;

            case "3 Jugadores":
                CartaJugador3_11.setVisible(true);
                CartaJugador3_12.setVisible(true);
                CartaJugador3_13.setVisible(true);
                CartaJugador3_14.setVisible(true);
                CartaJugador3_15.setVisible(true);
                CartaJugador3_16.setVisible(true);
                break;

            case "4 Jugadores":
                CartaJugador4_11.setVisible(true);
                CartaJugador4_12.setVisible(true);
                CartaJugador4_13.setVisible(true);
                CartaJugador4_14.setVisible(true);
                CartaJugador4_15.setVisible(true);
                CartaJugador4_16.setVisible(true);
                CartaJugador4_17.setVisible(true);
                break;

            case "6 Jugadores":
                CartaJugador6_11.setVisible(true);
                CartaJugador6_12.setVisible(true);
                CartaJugador6_13.setVisible(true);
                CartaJugador6_14.setVisible(true);
                CartaJugador6_15.setVisible(true);
                break;

            case "8 Jugadores":
                CartaJugador8_11.setVisible(true);
                CartaJugador8_12.setVisible(true);
                CartaJugador8_13.setVisible(true);
                CartaJugador8_14.setVisible(true);
                break;

        }

    }

    public void mostrarCartas2() {
        esconderCartas();

        switch (Configuracion.cantidadJugador) {
            case "2 Jugadores":
                CartaJugador2_21.setVisible(true);
                CartaJugador2_22.setVisible(true);
                CartaJugador2_23.setVisible(true);
                CartaJugador2_24.setVisible(true);
                CartaJugador2_25.setVisible(true);
                CartaJugador2_26.setVisible(true);
                CartaJugador2_27.setVisible(true);
                break;

            case "3 Jugadores":
                CartaJugador3_21.setVisible(true);
                CartaJugador3_22.setVisible(true);
                CartaJugador3_23.setVisible(true);
                CartaJugador3_24.setVisible(true);
                CartaJugador3_25.setVisible(true);
                CartaJugador3_26.setVisible(true);

            case "4 Jugadores":
                CartaJugador4_21.setVisible(true);
                CartaJugador4_22.setVisible(true);
                CartaJugador4_23.setVisible(true);
                CartaJugador4_24.setVisible(true);
                CartaJugador4_25.setVisible(true);
                CartaJugador4_26.setVisible(true);
                CartaJugador4_27.setVisible(true);
                break;

            case "6 Jugadores":
                CartaJugador6_21.setVisible(false);
                CartaJugador6_22.setVisible(false);
                CartaJugador6_23.setVisible(false);
                CartaJugador6_24.setVisible(false);
                CartaJugador6_25.setVisible(false);
                break;

            case "8 Jugadores":
                CartaJugador8_21.setVisible(false);
                CartaJugador8_22.setVisible(false);
                CartaJugador8_23.setVisible(false);
                CartaJugador8_24.setVisible(false);
                break;

        }

    }

    public void mostrarCartas3() {
        esconderCartas();

        switch (Configuracion.cantidadJugador) {
            case "3 Jugadores":
                CartaJugador3_31.setVisible(true);
                CartaJugador3_32.setVisible(true);
                CartaJugador3_33.setVisible(true);
                CartaJugador3_34.setVisible(true);
                CartaJugador3_35.setVisible(true);
                CartaJugador3_36.setVisible(true);
                break;

            case "4 Jugadores":
                CartaJugador4_31.setVisible(true);
                CartaJugador4_32.setVisible(true);
                CartaJugador4_33.setVisible(true);
                CartaJugador4_34.setVisible(true);
                CartaJugador4_35.setVisible(true);
                CartaJugador4_36.setVisible(true);
                CartaJugador4_37.setVisible(true);
                break;

            case "6 Jugadores":
                CartaJugador6_31.setVisible(true);
                CartaJugador6_32.setVisible(true);
                CartaJugador6_33.setVisible(true);
                CartaJugador6_34.setVisible(true);
                CartaJugador6_35.setVisible(true);
                break;

            case "8 Jugadores":
                CartaJugador8_31.setVisible(true);
                CartaJugador8_32.setVisible(true);
                CartaJugador8_33.setVisible(true);
                CartaJugador8_34.setVisible(true);
                break;

        }
    }

    public void mostrarCartas4() {
        esconderCartas();

        switch (Configuracion.cantidadJugador) {

            case "4 Jugadores":
                CartaJugador4_41.setVisible(true);
                CartaJugador4_42.setVisible(true);
                CartaJugador4_43.setVisible(true);
                CartaJugador4_44.setVisible(true);
                CartaJugador4_45.setVisible(true);
                CartaJugador4_46.setVisible(true);
                CartaJugador4_47.setVisible(true);
                break;

            case "6 Jugadores":
                CartaJugador6_41.setVisible(true);
                CartaJugador6_42.setVisible(true);
                CartaJugador6_43.setVisible(true);
                CartaJugador6_44.setVisible(true);
                CartaJugador6_45.setVisible(true);
                break;

            case "8 Jugadores":
                CartaJugador8_41.setVisible(true);
                CartaJugador8_42.setVisible(true);
                CartaJugador8_43.setVisible(true);
                CartaJugador8_44.setVisible(true);
                break;

        }

    }

    public void mostrarCartas5() {
        esconderCartas();

        switch (Configuracion.cantidadJugador) {

            case "6 Jugadores":
                CartaJugador6_51.setVisible(true);
                CartaJugador6_52.setVisible(true);
                CartaJugador6_53.setVisible(true);
                CartaJugador6_54.setVisible(true);
                CartaJugador6_55.setVisible(true);
                break;

            case "8 Jugadores":
                CartaJugador8_51.setVisible(true);
                CartaJugador8_52.setVisible(true);
                CartaJugador8_53.setVisible(true);
                CartaJugador8_54.setVisible(true);
                break;

        }
    }

    public void mostrarCartas6() {
        esconderCartas();

        switch (Configuracion.cantidadJugador) {

            case "6 Jugadores":
                CartaJugador6_61.setVisible(true);
                CartaJugador6_62.setVisible(true);
                CartaJugador6_63.setVisible(true);
                CartaJugador6_64.setVisible(true);
                CartaJugador6_65.setVisible(true);
                break;

            case "8 Jugadores":
                CartaJugador8_61.setVisible(true);
                CartaJugador8_62.setVisible(true);
                CartaJugador8_63.setVisible(true);
                CartaJugador8_64.setVisible(true);
                break;

        }
    }

    public void mostrarCartas7() {
        esconderCartas();

        switch (Configuracion.cantidadJugador) {

            case "8 Jugadores":
                CartaJugador8_71.setVisible(true);
                CartaJugador8_72.setVisible(true);
                CartaJugador8_73.setVisible(true);
                CartaJugador8_74.setVisible(true);
                break;

        }
    }

    public void mostrarCartas8() {
        esconderCartas();

        switch (Configuracion.cantidadJugador) {

            case "8 Jugadores":
                CartaJugador8_81.setVisible(true);
                CartaJugador8_82.setVisible(true);
                CartaJugador8_83.setVisible(true);
                CartaJugador8_84.setVisible(true);
                break;

        }
    }

    public boolean verificarTurno(MouseEvent e) {
        JLabel clickedLabel = (JLabel) e.getSource();

        Carta carta = labelCartaMap.get(clickedLabel);

        if (carta != null) {
            String owner = carta.getDueño();
            String currentPlayer = Logica.getPlayerActual();

            if (owner.equals(currentPlayer)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No es su turno!");
                return false;
            }
        }
        return false;
    }

    private void DeckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeckMouseClicked

        JLabel clickedLabel = (JLabel) evt.getComponent();
        Carta cartaSeleccionada = labelCartaMap.get(clickedLabel);

        Carta siguienteCarta = manojo.siguienteCarta();

        if (manojo.siguienteCarta() != null) {

            clickedLabel.setIcon(manojo.getCardIcon(siguienteCarta.getTipo(), siguienteCarta.getRango()));
            siguienteCarta.setDueño(Logica.getPlayerActual());
            labelCartaMap.put(clickedLabel, cartaSeleccionada);

        } else {

            JOptionPane.showMessageDialog(null, "La baraja se encuentra vacia, se reiniciara la baraja.");

            manojo.revisarBaraja();
            manojo.reiniciarMazo();
        }

    }//GEN-LAST:event_DeckMouseClicked


    private void TimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TimerMouseClicked

    private void tablero1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablero1MouseClicked


    }//GEN-LAST:event_tablero1MouseClicked

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
                try {
                    new TableroMain(new UsuariosMetodos()).setVisible(true);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(TableroMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(TableroMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(TableroMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CartaJugador2_11;
    private javax.swing.JLabel CartaJugador2_12;
    private javax.swing.JLabel CartaJugador2_13;
    private javax.swing.JLabel CartaJugador2_14;
    private javax.swing.JLabel CartaJugador2_15;
    private javax.swing.JLabel CartaJugador2_16;
    private javax.swing.JLabel CartaJugador2_17;
    private javax.swing.JLabel CartaJugador2_21;
    private javax.swing.JLabel CartaJugador2_22;
    private javax.swing.JLabel CartaJugador2_23;
    private javax.swing.JLabel CartaJugador2_24;
    private javax.swing.JLabel CartaJugador2_25;
    private javax.swing.JLabel CartaJugador2_26;
    private javax.swing.JLabel CartaJugador2_27;
    private javax.swing.JLabel CartaJugador3_11;
    private javax.swing.JLabel CartaJugador3_12;
    private javax.swing.JLabel CartaJugador3_13;
    private javax.swing.JLabel CartaJugador3_14;
    private javax.swing.JLabel CartaJugador3_15;
    private javax.swing.JLabel CartaJugador3_16;
    private javax.swing.JLabel CartaJugador3_21;
    private javax.swing.JLabel CartaJugador3_22;
    private javax.swing.JLabel CartaJugador3_23;
    private javax.swing.JLabel CartaJugador3_24;
    private javax.swing.JLabel CartaJugador3_25;
    private javax.swing.JLabel CartaJugador3_26;
    private javax.swing.JLabel CartaJugador3_31;
    private javax.swing.JLabel CartaJugador3_32;
    private javax.swing.JLabel CartaJugador3_33;
    private javax.swing.JLabel CartaJugador3_34;
    private javax.swing.JLabel CartaJugador3_35;
    private javax.swing.JLabel CartaJugador3_36;
    private javax.swing.JLabel CartaJugador4_11;
    private javax.swing.JLabel CartaJugador4_12;
    private javax.swing.JLabel CartaJugador4_13;
    private javax.swing.JLabel CartaJugador4_14;
    private javax.swing.JLabel CartaJugador4_15;
    private javax.swing.JLabel CartaJugador4_16;
    private javax.swing.JLabel CartaJugador4_17;
    private javax.swing.JLabel CartaJugador4_21;
    private javax.swing.JLabel CartaJugador4_22;
    private javax.swing.JLabel CartaJugador4_23;
    private javax.swing.JLabel CartaJugador4_24;
    private javax.swing.JLabel CartaJugador4_25;
    private javax.swing.JLabel CartaJugador4_26;
    private javax.swing.JLabel CartaJugador4_27;
    private javax.swing.JLabel CartaJugador4_31;
    private javax.swing.JLabel CartaJugador4_32;
    private javax.swing.JLabel CartaJugador4_33;
    private javax.swing.JLabel CartaJugador4_34;
    private javax.swing.JLabel CartaJugador4_35;
    private javax.swing.JLabel CartaJugador4_36;
    private javax.swing.JLabel CartaJugador4_37;
    private javax.swing.JLabel CartaJugador4_41;
    private javax.swing.JLabel CartaJugador4_42;
    private javax.swing.JLabel CartaJugador4_43;
    private javax.swing.JLabel CartaJugador4_44;
    private javax.swing.JLabel CartaJugador4_45;
    private javax.swing.JLabel CartaJugador4_46;
    private javax.swing.JLabel CartaJugador4_47;
    private javax.swing.JLabel CartaJugador6_11;
    private javax.swing.JLabel CartaJugador6_12;
    private javax.swing.JLabel CartaJugador6_13;
    private javax.swing.JLabel CartaJugador6_14;
    private javax.swing.JLabel CartaJugador6_15;
    private javax.swing.JLabel CartaJugador6_21;
    private javax.swing.JLabel CartaJugador6_22;
    private javax.swing.JLabel CartaJugador6_23;
    private javax.swing.JLabel CartaJugador6_24;
    private javax.swing.JLabel CartaJugador6_25;
    private javax.swing.JLabel CartaJugador6_31;
    private javax.swing.JLabel CartaJugador6_32;
    private javax.swing.JLabel CartaJugador6_33;
    private javax.swing.JLabel CartaJugador6_34;
    private javax.swing.JLabel CartaJugador6_35;
    private javax.swing.JLabel CartaJugador6_41;
    private javax.swing.JLabel CartaJugador6_42;
    private javax.swing.JLabel CartaJugador6_43;
    private javax.swing.JLabel CartaJugador6_44;
    private javax.swing.JLabel CartaJugador6_45;
    private javax.swing.JLabel CartaJugador6_51;
    private javax.swing.JLabel CartaJugador6_52;
    private javax.swing.JLabel CartaJugador6_53;
    private javax.swing.JLabel CartaJugador6_54;
    private javax.swing.JLabel CartaJugador6_55;
    private javax.swing.JLabel CartaJugador6_61;
    private javax.swing.JLabel CartaJugador6_62;
    private javax.swing.JLabel CartaJugador6_63;
    private javax.swing.JLabel CartaJugador6_64;
    private javax.swing.JLabel CartaJugador6_65;
    private javax.swing.JLabel CartaJugador8_11;
    private javax.swing.JLabel CartaJugador8_12;
    private javax.swing.JLabel CartaJugador8_13;
    private javax.swing.JLabel CartaJugador8_14;
    private javax.swing.JLabel CartaJugador8_21;
    private javax.swing.JLabel CartaJugador8_22;
    private javax.swing.JLabel CartaJugador8_23;
    private javax.swing.JLabel CartaJugador8_24;
    private javax.swing.JLabel CartaJugador8_31;
    private javax.swing.JLabel CartaJugador8_32;
    private javax.swing.JLabel CartaJugador8_33;
    private javax.swing.JLabel CartaJugador8_34;
    private javax.swing.JLabel CartaJugador8_41;
    private javax.swing.JLabel CartaJugador8_42;
    private javax.swing.JLabel CartaJugador8_43;
    private javax.swing.JLabel CartaJugador8_44;
    private javax.swing.JLabel CartaJugador8_51;
    private javax.swing.JLabel CartaJugador8_52;
    private javax.swing.JLabel CartaJugador8_53;
    private javax.swing.JLabel CartaJugador8_54;
    private javax.swing.JLabel CartaJugador8_61;
    private javax.swing.JLabel CartaJugador8_62;
    private javax.swing.JLabel CartaJugador8_63;
    private javax.swing.JLabel CartaJugador8_64;
    private javax.swing.JLabel CartaJugador8_71;
    private javax.swing.JLabel CartaJugador8_72;
    private javax.swing.JLabel CartaJugador8_73;
    private javax.swing.JLabel CartaJugador8_74;
    private javax.swing.JLabel CartaJugador8_81;
    private javax.swing.JLabel CartaJugador8_82;
    private javax.swing.JLabel CartaJugador8_83;
    private javax.swing.JLabel CartaJugador8_84;
    private javax.swing.JLabel Deck;
    private javax.swing.JLabel Divider_Placeholder;
    private javax.swing.JLabel EquipoActual;
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
    private javax.swing.JLabel Timer;
    private javax.swing.JLabel TurnoJugador;
    private javax.swing.JLabel UltimaCarta;
    private javax.swing.JLabel UltimaCartaTexto;
    private javax.swing.JPanel jPanel1;
    private TABLERO.Tablero tablero1;
    // End of variables declaration//GEN-END:variables
}
