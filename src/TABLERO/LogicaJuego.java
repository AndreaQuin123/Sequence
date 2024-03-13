package TABLERO;

import SWING.Configuracion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicaJuego {

    //JUGADORES
    private String[] players;

    //INDICADOR TURNO
    public int turnoActual = 1;
    //MISC
    private Casilla[][] casillas;
    private String[] colors = {"AMARILLO", "VERDE", "ROJO", "AZUL"};
    String ColorEquipo2 = "";
    String ColorEquipo3 = "";
    List<String> coloresDisponibles = new ArrayList<>();

    public String fichaActual = "";
    public String Miembrosequipo1 = "";
    public String Miembrosequipo2 = "";
    public String Miembrosequipo3 = "";
    public String equipoActual = "";

    private int filas = 10;
    private int columnas = 10;

    //Relevantes a los movimientos especiales
    private boolean ME_cambiarCarta = false;
    public boolean ME_bloqueo = false;

    //GENERALES
    public int secuenciaVertical = 0, secuenciaHorizontal = 0, secuenciaDiagonal = 0;
    public String elegida = "a";

    // Constructor
    public LogicaJuego(String[] players, Casilla[][] casillas) {
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
                    equipoActual = "EQUIPO 1";
                    turnoActual = 2;
                    fichaActual = Configuracion.colorFicha;

                } else {
                    equipoActual = "EQUIPO 2";
                    turnoActual = 1;
                    fichaActual = ColorEquipo2;
                }
                break;

            case "3 Jugadores":
                switch (turnoActual) {
                    case 1:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 1;
                        fichaActual = Configuracion.colorFicha;
                        break;
                    case 2:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 2;
                        fichaActual = ColorEquipo2;
                        break;
                    case 3:
                        equipoActual = "EQUIPO 3";
                        turnoActual = 4;
                        fichaActual = ColorEquipo3;
                        break;
                    default:
                        break;
                }
                break;

            case "4 Jugadores":
                switch (turnoActual) {
                    case 2:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 2;
                        fichaActual = ColorEquipo2;
                        break;
                    case 1:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 3;
                        fichaActual = Configuracion.colorFicha;
                        break;
                    case 3:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 4;
                        fichaActual = ColorEquipo2;
                        break;
                    case 4:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 1;
                        fichaActual = Configuracion.colorFicha;
                        break;
                    default:
                        break;
                }
                break;

            case "6 Jugadores":
                switch (turnoActual) {
                    case 1:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 2;
                        fichaActual = ColorEquipo2;
                        break;
                    case 2:
                        equipoActual = "EQUIPO 3";
                        turnoActual = 3;
                        fichaActual = ColorEquipo3;
                        break;
                    case 3:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 4;
                        fichaActual = Configuracion.colorFicha;
                        break;
                    case 4:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 5;
                        fichaActual = ColorEquipo2;
                        break;
                    case 5:
                        equipoActual = "EQUIPO 3";
                        turnoActual = 6;
                        fichaActual = ColorEquipo3;
                        break;
                    case 6:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 1;
                        fichaActual = Configuracion.colorFicha;
                        break;
                    default:
                        break;
                }
                break;

            case "8 Jugadores":
                switch (turnoActual) {
                    case 1:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 2;
                        fichaActual = ColorEquipo2;
                        break;
                    case 2:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 3;
                        fichaActual = Configuracion.colorFicha;
                        break;
                    case 3:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 4;
                        fichaActual = ColorEquipo2;
                        break;
                    case 4:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 5;
                        fichaActual = Configuracion.colorFicha;
                        break;
                    case 5:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 6;
                        fichaActual = ColorEquipo2;
                        break;
                    case 6:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 7;
                        fichaActual = Configuracion.colorFicha;
                        break;
                    case 7:
                        equipoActual = "EQUIPO 2";
                        turnoActual = 8;
                        fichaActual = ColorEquipo2;
                        break;
                    case 8:
                        equipoActual = "EQUIPO 1";
                        turnoActual = 1;
                        fichaActual = Configuracion.colorFicha;
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
        return players[turnoActual];
    }

    public boolean checkForWin() {
        int sequenceCount = 0;

        if (checkHorizontalSequence()) {
            sequenceCount++;
        }

        if (checkVerticalSequence()) {
            sequenceCount++;
        }

        if (checkDiagonalSequence()) {
            sequenceCount++;
        }

        return sequenceCount >= 2;
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
