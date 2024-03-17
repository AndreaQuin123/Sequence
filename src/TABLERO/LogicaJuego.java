package TABLERO;

import SWING.Configuracion;
import SWING.ElegirOponente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LogicaJuego {

    //JUGADORES
    ArrayList<String> players = ElegirOponente.players;

    //INDICADOR TURNO
    public int turnoActual = 1;
    //MISC
    private Casilla[][] casillas;
    private String[] colors = {"AMARILLO", "VERDE", "ROJO", "AZUL"};
    String ColorEquipo2 = "";
    String ColorEquipo3 = "";
    List<String> coloresDisponibles = new ArrayList<>();

    public Icon fichaActual = null;
    public ArrayList<String> Equipo1 = ElegirOponente.Equipo1;
    public ArrayList<String> Equipo2 = ElegirOponente.Equipo2;
    public ArrayList<String> Equipo3 = ElegirOponente.Equipo3;
    public String equipoActualTexto = "EQUIPO 1";
    public ArrayList<String> equipoActual = new ArrayList<>();

    private int filas = 10;
    private int columnas = 10;

    //Relevantes a los movimientos especiales
    private boolean ME_cambiarCarta = false;
    public boolean ME_bloqueo = false;

    //GENERALES
    public int secuenciaVertical = 0, secuenciaHorizontal = 0, secuenciaDiagonal = 0;
    int sequenceCountEquipo1 = 0;
    int sequenceCountEquipo2 = 0;
    int sequenceCountEquipo3 = 0;

    // Constructor
    public LogicaJuego(ArrayList<String> players, Casilla[][] casillas) {
        this.casillas = TableroMain.casillas;
        this.players = players;
        this.casillas = casillas;
        this.filas = 10;
        this.columnas = 10;
        this.turnoActual = 0;

        for (String color : colors) {
            if (!color.equalsIgnoreCase(Configuracion.colorFicha)) {
                coloresDisponibles.add(color);
            }
        }

        Random random = new Random();

        int index = random.nextInt(coloresDisponibles.size());
        ColorEquipo2 = coloresDisponibles.get(index);
        coloresDisponibles.remove(index);

        int index2 = random.nextInt(coloresDisponibles.size());
        ColorEquipo3 = coloresDisponibles.get(index2);

    }

    public void cambiarTurno() {
        switch (Configuracion.cantidadJugador) {
            case "2 Jugadores":
                if (turnoActual == 1) {
                    equipoActualTexto = "EQUIPO 2";
                    equipoActual = Equipo2;
                    turnoActual = 2;
                    fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));

                } else {
                    equipoActualTexto = "EQUIPO 2";
                    equipoActual = Equipo2;
                    turnoActual = 1;
                    fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                }
                break;

            case "3 Jugadores":
                switch (turnoActual) {
                    case 1:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 2;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        System.out.println(fichaActual);
                        break;
                    case 2:
                        equipoActualTexto = "EQUIPO 3";
                        equipoActual = Equipo3;
                        turnoActual = 3;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 3:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 1;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo3 + ".png"));
                        break;
                    default:
                        break;
                }
                break;

            case "4 Jugadores":
                switch (turnoActual) {
                    case 1:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 2;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 2:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 1;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        break;
                    case 3:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 4;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 4:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 1;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        break;
                    default:
                        break;
                }
                break;

            case "6 Jugadores":
                switch (turnoActual) {
                    case 1:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 2;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 2:
                        equipoActualTexto = "EQUIPO 3";
                        equipoActual = Equipo3;
                        turnoActual = 3;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo3 + ".png"));
                        break;
                    case 3:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 4;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        break;
                    case 4:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 5;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 5:
                        equipoActualTexto = "EQUIPO 3";
                        equipoActual = Equipo3;
                        turnoActual = 6;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo3 + ".png"));
                        break;
                    case 6:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 1;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        break;
                    default:
                        break;
                }
                break;

            case "8 Jugadores":
                switch (turnoActual) {
                    case 1:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 2;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 2:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 3;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        break;
                    case 3:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 4;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 4:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 5;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        break;
                    case 5:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 6;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 6:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 7;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        break;
                    case 7:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 8;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + ".png"));
                        break;
                    case 8:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 4;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + ".png"));
                        break;
                    default:
                        break;
                }
                break;

            default:
                break;
        }
    }

    public String getPlayerActual() {
        return players.get(turnoActual-1);
    }
    
        public String getEquipoActual() {
        return equipoActualTexto;
    }

    public boolean checkForWin() {

        switch (equipoActualTexto) {
            case "EQUIPO 1":
                if (checkHorizontalSequence()) {
                    sequenceCountEquipo1++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");
                }

                if (checkVerticalSequence()) {
                    sequenceCountEquipo1++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");

                }

                if (checkDiagonalSequence()) {
                    sequenceCountEquipo1++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");

                }

            case "EQUIPO 2":
                if (checkHorizontalSequence()) {
                    sequenceCountEquipo2++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");
                }

                if (checkVerticalSequence()) {
                    sequenceCountEquipo2++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");

                }

                if (checkDiagonalSequence()) {
                    sequenceCountEquipo2++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");

                }

            case "EQUIPO 3":
                if (checkHorizontalSequence()) {
                    sequenceCountEquipo3++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");
                }

                if (checkVerticalSequence()) {
                    sequenceCountEquipo3++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");

                }

                if (checkDiagonalSequence()) {
                    sequenceCountEquipo3++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActual + " completo una secuencia.");

                }
        }

        if (sequenceCountEquipo1 >= 2) {
            return true;
        }

        if (sequenceCountEquipo2 >= 2) {
            return true;
        }

        if (sequenceCountEquipo3 >= 2) {
            return true;
        }

        return false;
    }

    private boolean checkHorizontalSequence() {
        for (int row = 0; row < filas; row++) {
            for (int col = 0; col <= columnas - 5; col++) {
                boolean sequenceFound = true;
                for (int i = 0; i < 5; i++) {
                    if (!casillas[row][col + i].getFicha()) {
                        sequenceFound = false;
                        break;
                    }
                }
                if (sequenceFound) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalSequence() {
        for (int col = 0; col < columnas; col++) {
            for (int row = 0; row <= filas - 5; row++) {
                boolean sequenceFound = true;
                for (int i = 0; i < 5; i++) {
                    if (!casillas[row + i][col].getFicha()) {
                        sequenceFound = false;
                        break;
                    }
                }
                if (sequenceFound) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalSequence() {
        for (int row = 0; row <= filas - 5; row++) {
            for (int col = 0; col <= columnas - 5; col++) {
                boolean sequenceFound = true;
                for (int i = 0; i < 5; i++) {
                    if (!casillas[row + i][col + i].getFicha()) {
                        sequenceFound = false;
                        break;
                    }
                }
                if (sequenceFound) {
                    return true;
                }

                sequenceFound = true;
                for (int i = 0; i < 5; i++) {
                    if (!casillas[row + i][col + 4 - i].getFicha()) {
                        sequenceFound = false;
                        break;
                    }
                }
                if (sequenceFound) {
                    return true;
                }
            }
        }
        return false;
    }

}
