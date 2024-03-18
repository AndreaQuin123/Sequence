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

        sequenceCountEquipo1 = 0;
        sequenceCountEquipo2 = 0;
        sequenceCountEquipo3 = 0;

        boolean gano = false;

        for (int row = 0; row < filas; row++) {
            for (int col = 0; col <= columnas - 5; col++) {
                secuenciaHorizontal(row, col, "EQUIPO 1");
                secuenciaHorizontal(row, col, "EQUIPO 2");
                secuenciaHorizontal(row, col, "EQUIPO 3");
            }
        }

        for (int col = 0; col < columnas; col++) {
            for (int row = 0; row <= filas - 5; row++) {
                secuenciaVertical(col, "EQUIPO 1");
                secuenciaVertical(col, "EQUIPO 2");
                secuenciaVertical(col, "EQUIPO 3");
            }
        }

        for (int row = 0; row <= filas - 5; row++) {
            for (int col = 0; col <= columnas - 5; col++) {
                obtenerDiagonalIzquierdaDerecha(row, col, "EQUIPO 1");
                obtenerDiagonalIzquierdaDerecha(row, col, "EQUIPO 2");
                obtenerDiagonalIzquierdaDerecha(row, col, "EQUIPO 3");
            }
        }

        for (int row = 0; row <= filas - 5; row++) {
            for (int col = columnas - 1; col >= 4; col--) {
                obtenerDiagonalDerechaIzquierda(row, col, "EQUIPO 1");
                obtenerDiagonalDerechaIzquierda(row, col, "EQUIPO 2");
                obtenerDiagonalDerechaIzquierda(row, col, "EQUIPO 3");
            }
        }
        return (sequenceCountEquipo1 >= 2 || sequenceCountEquipo2 >= 2 || sequenceCountEquipo3 >= 2);

    }

    private void secuenciaHorizontal(int fila, int columna, String equipo) {
    if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
        System.out.println("Invalid position.");
        return;
    }

    String[] horizontal = new String[columnas];

    for (int i = 0; i < columnas; i++) {
        horizontal[i] = casillas[fila][i].getEquipo();

    }

    int consecutiveCount = 0;
    for (int i = 0; i < horizontal.length; i++) {
        String team = horizontal[i];
        if (team != null && team.equals(equipo)) {
            consecutiveCount++;
        } else {
            consecutiveCount = 0; 
        }

        if (consecutiveCount == 5) {
            String message = "El equipo " + equipo + " ha hecho una secuencia horizontal.";
            JOptionPane.showMessageDialog(null, message);

            // Update counters or visuals if needed
            if (equipo.equals("EQUIPO 1")) {
                sequenceCountEquipo1++;
            } else if (equipo.equals("EQUIPO 2")) {
                sequenceCountEquipo2++;
            } else if (equipo.equals("EQUIPO 3")) {
                sequenceCountEquipo3++;
            }


            for (int j = i - 4; j <= i; j++) {
                casillas[fila][j].setEquipo(equipo);
            }

            break;
        }
    }
}

    private void secuenciaVertical(int columna, String equipo) {
        int consecutiveCount = 0;
        for (int i = 0; i < filas; i++) {
            String team = casillas[i][columna].getEquipo();

            if (team != null && team.equals(equipo)) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }

            if (consecutiveCount == 5) {
                String message = "El equipo " + equipo + " ha hecho una secuencia vertical.";
                JOptionPane.showMessageDialog(null, message);

                // Update counters or visuals if needed
                if (equipo.equals("EQUIPO 1")) {
                    sequenceCountEquipo1++;
                } else if (equipo.equals("EQUIPO 2")) {
                    sequenceCountEquipo2++;
                } else if (equipo.equals("EQUIPO 3")) {
                    sequenceCountEquipo3++;
                }

                break;
            }
        }
    }

    private void obtenerDiagonalIzquierdaDerecha(int fila, int columna, String equipo) {
        int apiadate = Math.min(fila, columna);
        fila -= apiadate;
        columna -= apiadate;
        int consecutiveCount = 0;
        for (int i = 0; i < filas && fila + i < filas && columna + i < columnas; i++) {
            String team = casillas[fila + i][columna + i].getEquipo();
            
            if (team != null && team.equals(equipo)) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }

            if (consecutiveCount == 5) {
                String message = "El equipo " + equipo + " ha hecho una secuencia diagonal.";
                JOptionPane.showMessageDialog(null, message);

                if (equipo.equals("EQUIPO 1")) {
                    sequenceCountEquipo1++;
                } else if (equipo.equals("EQUIPO 2")) {
                    sequenceCountEquipo2++;
                } else if (equipo.equals("EQUIPO 3")) {
                    sequenceCountEquipo3++;
                }

                break;
            }
        }
    }

    private void obtenerDiagonalDerechaIzquierda(int fila, int columna, String equipo) {
        int apiadate = Math.min(fila, columnas - 1 - columna);
        fila -= apiadate;
        columna += apiadate;
        int consecutiveCount = 0;
        for (int i = 0; i < filas && fila + i < filas && columna - i >= 0; i++) {
            String team = casillas[fila + i][columna - i].getEquipo();
            
            System.out.println("D D-I : Columna: [" + (columna - i) + "] fila [" + (fila + i) + " ] Equipo: " + casillas[fila + i][columna - i].getEquipo());

            if (team != null && team.equals(equipo)) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }

            if (consecutiveCount == 5) {
                String message = "El equipo " + equipo + " ha hecho una secuencia diagonal.";
                JOptionPane.showMessageDialog(null, message);

                // Update counters or visuals if needed
                if (equipo.equals("EQUIPO 1")) {
                    sequenceCountEquipo1++;
                } else if (equipo.equals("EQUIPO 2")) {
                    sequenceCountEquipo2++;
                } else if (equipo.equals("EQUIPO 3")) {
                    sequenceCountEquipo3++;
                }

                break;
            }
        }
    }
}

