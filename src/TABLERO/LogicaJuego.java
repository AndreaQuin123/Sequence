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

    public Icon fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
    ;
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
        this.turnoActual = 1;

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
                    String file = "/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png";
                    fichaActual = new ImageIcon(getClass().getResource(file));

                } else {
                    equipoActualTexto = "EQUIPO 1";
                    equipoActual = Equipo1;
                    turnoActual = 1;
                    fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
                }
                break;

            case "3 Jugadores":
                switch (turnoActual) {
                    case 1:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 2;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 2:
                        equipoActualTexto = "EQUIPO 3";
                        equipoActual = Equipo3;
                        turnoActual = 3;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/Ficha_" + ColorEquipo3 + "_1.png"));
                        break;
                    case 3:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 1;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
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
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 2:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 1;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
                        break;
                    case 3:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 4;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 4:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 1;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
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
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 2:
                        equipoActualTexto = "EQUIPO 3";
                        equipoActual = Equipo3;
                        turnoActual = 3;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo3 + "_1.png"));
                        break;
                    case 3:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 4;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
                        break;
                    case 4:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 5;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 5:
                        equipoActualTexto = "EQUIPO 3";
                        equipoActual = Equipo3;
                        turnoActual = 6;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo3 + "_1.png"));
                        break;
                    case 6:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 1;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
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
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 2:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 3;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
                        break;
                    case 3:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 4;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 4:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 5;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
                        break;
                    case 5:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 6;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 6:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 7;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
                        break;
                    case 7:
                        equipoActualTexto = "EQUIPO 2";
                        equipoActual = Equipo2;
                        turnoActual = 8;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + ColorEquipo2 + "_1.png"));
                        break;
                    case 8:
                        equipoActualTexto = "EQUIPO 1";
                        equipoActual = Equipo1;
                        turnoActual = 4;
                        fichaActual = new ImageIcon(getClass().getResource("/IMAGES/FICHAS/ICON_Ficha_" + Configuracion.colorFicha + "_1.png"));
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
        return players.get(turnoActual - 1);
    }

    public String getEquipoActual() {
        return equipoActualTexto;
    }

    public boolean checkForWin() {
        switch (equipoActualTexto) {
            case "EQUIPO 1":
                if (checkHorizontalSequence() || checkVerticalSequence() || checkDiagonalSequence()) {
                    sequenceCountEquipo1++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActualTexto + " completó una secuencia.");
                }
                break;

            case "EQUIPO 2":
                if (checkHorizontalSequence() || checkVerticalSequence() || checkDiagonalSequence()) {
                    sequenceCountEquipo2++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActualTexto + " completó una secuencia.");
                }
                break;

            case "EQUIPO 3":
                if (checkHorizontalSequence() || checkVerticalSequence() || checkDiagonalSequence()) {
                    sequenceCountEquipo3++;
                    JOptionPane.showMessageDialog(null, "El " + equipoActualTexto + " completó una secuencia.");
                }
                break;
        }

        return sequenceCountEquipo1 >= 2 || sequenceCountEquipo2 >= 2 || sequenceCountEquipo3 >= 2;
    }

    private boolean checkHorizontalSequence() {
        for (int row = 0; row < filas; row++) {
            for (int col = 0; col <= columnas - 5; col++) {
                boolean sequenceFound = false;
                String team = casillas[row][col].getEquipo();
                if (team == null) {
                    continue; // Skip if no team owns the cell
                }
                for (int i = 0; i < 5; i++) {
                    if (!casillas[row][col + i].getEquipo().equals(team)) {
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
                boolean sequenceFound = false;
                String team = casillas[row][col].getEquipo();
                System.out.println(team);
                if (team == null) {
                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    if (!casillas[row + i][col].getEquipo().equals(team)) {
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
                boolean sequenceFound = false;
                String team = casillas[row][col].getEquipo();
                
                if (team == null) {
                    continue;
                }
                
                for (int i = 0; i < 5; i++) {
                    if (!casillas[row + i][col + i].getFicha() || !casillas[row + i][col + i].getEquipo().equals(team)) {
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
