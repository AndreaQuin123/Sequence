package TABLERO;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    private final int CELL_SIZE_WIDTH = 50;
    private final int CELL_SIZE_HEIGHT = 74;

    private final int N_ROWS = 10;
    private final int N_COLS = 10;

    private final int BOARD_WIDTH = N_COLS * CELL_SIZE_WIDTH + 1;
    private final int BOARD_HEIGHT = N_ROWS * CELL_SIZE_HEIGHT + 1;

    final Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[N_ROWS][N_COLS];

        for (int row = 0; row < N_ROWS; row++) {
            for (int col = 0; col < N_COLS; col++) {
                casillas[row][col] = new Casilla(ManojoCartas.Tipo.COMODIN, ManojoCartas.Rango.COMODIN, row, col);
            }
        }

        casillas[0][0] = Casilla.setTipoRango(ManojoCartas.Tipo.COMODIN, ManojoCartas.Rango.COMODIN, 0, 0);
        ImageIcon icon00 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/red_joker.png"));
        casillas[0][0].setIcon(icon00);

        casillas[0][1] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.DOS, 0, 1);
        ImageIcon icon01 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_spades.png"));
        casillas[0][1].setIcon(icon01);

        casillas[0][2] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.TRES, 0, 2);
        ImageIcon icon02 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_spades.png"));
        casillas[0][2].setIcon(icon02);

        casillas[0][3] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.CUATRO, 0, 3);
        ImageIcon icon03 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_spades.png"));
        casillas[0][3].setIcon(icon03);

        casillas[0][4] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.CINCO, 0, 4);
        ImageIcon icon04 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_spades.png"));
        casillas[0][4].setIcon(icon04);

        casillas[0][5] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.SEIS, 0, 5);
        ImageIcon icon05 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_spades.png"));
        casillas[0][5].setIcon(icon05);

        casillas[0][6] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.SIETE, 0, 6);
        ImageIcon icon06 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_spades.png"));
        casillas[0][6].setIcon(icon06);

        casillas[0][7] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.OCHO, 0, 7);
        ImageIcon icon07 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_spades.png"));
        casillas[0][7].setIcon(icon07);

        casillas[0][8] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.NUEVE, 0, 8);
        ImageIcon icon08 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_spades.png"));
        casillas[0][8].setIcon(icon08);

        casillas[0][9] = Casilla.setTipoRango(ManojoCartas.Tipo.COMODIN, ManojoCartas.Rango.COMODIN, 0, 9);
        ImageIcon icon09 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/red_joker.png"));
        casillas[0][9].setIcon(icon09);

        casillas[1][0] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.SEIS, 1, 0);
        ImageIcon icon10 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_clubs.png"));
        casillas[1][0].setIcon(icon10);

        casillas[1][1] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.CINCO, 1, 1);
        ImageIcon icon11 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_clubs.png"));
        casillas[1][1].setIcon(icon11);

        casillas[1][2] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.CUATRO, 1, 2);
        ImageIcon icon12 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_clubs.png"));
        casillas[1][2].setIcon(icon12);

        casillas[1][3] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.TRES, 1, 3);
        ImageIcon icon13 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_clubs.png"));
        casillas[1][3].setIcon(icon13);

        casillas[1][4] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.DOS, 1, 4);
        ImageIcon icon14 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_clubs.png"));
        casillas[1][4].setIcon(icon14);

        casillas[1][5] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.AS, 1, 5);
        ImageIcon icon15 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_clubs.png"));
        casillas[1][5].setIcon(icon15);

        casillas[1][6] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.REY, 1, 6);
        ImageIcon icon16 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_hearts.png"));
        casillas[1][6].setIcon(icon16);

        casillas[1][7] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.REINA, 1, 7);
        ImageIcon icon17 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_hearts.png"));
        casillas[1][7].setIcon(icon17);

        casillas[1][8] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.DIEZ, 1, 8);
        ImageIcon icon18 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_hearts.png"));
        casillas[1][8].setIcon(icon18);

        casillas[1][9] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.DIEZ, 1, 9);
        ImageIcon icon19 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_spades.png"));
        casillas[1][9].setIcon(icon19);

        casillas[2][0] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.SIETE, 2, 0);
        ImageIcon icon20 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_clubs.png"));
        casillas[2][0].setIcon(icon20);

        casillas[2][1] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.AS, 2, 1);
        ImageIcon icon21 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_spades.png"));
        casillas[2][1].setIcon(icon21);

        casillas[2][2] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.DOS, 2, 2);
        ImageIcon icon22 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_diamonds.png"));
        casillas[2][2].setIcon(icon22);

        casillas[2][3] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.TRES, 2, 3);
        ImageIcon icon23 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_diamonds.png"));
        casillas[2][3].setIcon(icon23);

        casillas[2][4] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.CUATRO, 2, 4);
        ImageIcon icon24 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_diamonds.png"));
        casillas[2][4].setIcon(icon24);

        casillas[2][5] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.CINCO, 2, 5);
        ImageIcon icon25 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_diamonds.png"));
        casillas[2][5].setIcon(icon25);

        casillas[2][6] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.SEIS, 2, 6);
        ImageIcon icon26 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_diamonds.png"));
        casillas[2][6].setIcon(icon26);

        casillas[2][7] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.SIETE, 2, 7);
        ImageIcon icon27 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_diamonds.png"));
        casillas[2][7].setIcon(icon27);

        casillas[2][8] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.NUEVE, 2, 8);
        ImageIcon icon28 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_hearts.png"));
        casillas[2][8].setIcon(icon28);

        casillas[2][9] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.REINA, 2, 9);
        ImageIcon icon29 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_spades.png"));
        casillas[2][9].setIcon(icon29);

        casillas[3][0] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.OCHO, 3, 0);
        ImageIcon icon30 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_clubs.png"));
        casillas[3][0].setIcon(icon30);

        casillas[3][1] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.REY, 3, 1);
        ImageIcon icon31 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_spades.png"));
        casillas[3][1].setIcon(icon31);

        casillas[3][2] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.SEIS, 3, 2);
        ImageIcon icon32 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_clubs.png"));
        casillas[3][2].setIcon(icon32);

        casillas[3][3] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.CINCO, 3, 3);
        ImageIcon icon33 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_clubs.png"));
        casillas[3][3].setIcon(icon33);

        casillas[3][4] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.CUATRO, 3, 4);
        ImageIcon icon34 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_clubs.png"));
        casillas[3][4].setIcon(icon34);

        casillas[3][5] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.TRES, 3, 5);
        ImageIcon icon35 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_clubs.png"));
        casillas[3][5].setIcon(icon35);

        casillas[3][6] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.DOS, 3, 6);
        ImageIcon icon36 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_clubs.png"));
        casillas[3][6].setIcon(icon36);

        casillas[3][7] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.OCHO, 3, 7);
        ImageIcon icon37 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_diamonds.png"));
        casillas[3][7].setIcon(icon37);

        casillas[3][8] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.OCHO, 3, 8);
        ImageIcon icon38 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_hearts.png"));
        casillas[3][8].setIcon(icon38);

        casillas[3][9] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.REY, 3, 9);
        ImageIcon icon39 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_spades.png"));
        casillas[3][9].setIcon(icon39);

        casillas[4][0] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.NUEVE, 4, 0);
        ImageIcon icon40 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_clubs.png"));
        casillas[4][0].setIcon(icon40);

        casillas[4][1] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.REINA, 4, 1);
        ImageIcon icon41 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_spades.png"));
        casillas[4][1].setIcon(icon41);

        casillas[4][2] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.SIETE, 4, 2);
        ImageIcon icon42 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_clubs.png"));
        casillas[4][2].setIcon(icon42);

        casillas[4][3] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.SEIS, 4, 3);
        ImageIcon icon43 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_hearts.png"));
        casillas[4][3].setIcon(icon43);

        casillas[4][4] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.CINCO, 4, 4);
        ImageIcon icon44 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_hearts.png"));
        casillas[4][4].setIcon(icon44);

        casillas[4][5] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.CUATRO, 4, 5);
        ImageIcon icon45 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_hearts.png"));
        casillas[4][5].setIcon(icon45);

        casillas[4][6] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.AS, 4, 6);
        ImageIcon icon46 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_hearts.png"));
        casillas[4][6].setIcon(icon46);

        casillas[4][7] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.NUEVE, 4, 7);
        ImageIcon icon47 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_diamonds.png"));
        casillas[4][7].setIcon(icon47);

        casillas[4][8] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.SIETE, 4, 8);
        ImageIcon icon48 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_hearts.png"));
        casillas[4][8].setIcon(icon48);

        casillas[4][9] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.AS, 4, 9);
        ImageIcon icon49 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_spades.png"));
        casillas[4][9].setIcon(icon49);

        casillas[5][0] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.DIEZ, 5, 0);
        ImageIcon icon50 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"));
        casillas[5][0].setIcon(icon50);

        casillas[5][1] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.DIEZ, 5, 1);
        ImageIcon icon51 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_spades.png"));
        casillas[5][1].setIcon(icon51);

        casillas[5][2] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.OCHO, 5, 2);
        ImageIcon icon52 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_clubs.png"));
        casillas[5][2].setIcon(icon52);

        casillas[5][3] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.SIETE, 5, 3);
        ImageIcon icon53 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_hearts.png"));
        casillas[5][3].setIcon(icon53);

        casillas[5][4] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.DOS, 5, 4);
        ImageIcon icon54 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_hearts.png"));
        casillas[5][4].setIcon(icon54);

        casillas[5][5] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.TRES, 5, 5);
        ImageIcon icon55 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_hearts.png"));
        casillas[5][5].setIcon(icon55);

        casillas[5][6] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.REY, 5, 6);
        ImageIcon icon56 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_hearts.png"));
        casillas[5][6].setIcon(icon56);

        casillas[5][7] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.DIEZ, 5, 7);
        ImageIcon icon57 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_diamonds.png"));
        casillas[5][7].setIcon(icon57);

        casillas[5][8] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.SEIS, 5, 8);
        ImageIcon icon58 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_hearts.png"));
        casillas[5][8].setIcon(icon58);

        casillas[5][9] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.DOS, 5, 9);
        ImageIcon icon59 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_diamonds.png"));
        casillas[5][9].setIcon(icon59);

        casillas[6][0] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.REINA, 6, 0);
        ImageIcon icon60 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_clubs.png"));
        casillas[6][0].setIcon(icon60);

        casillas[6][1] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.NUEVE, 6, 1);
        ImageIcon icon61 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_spades.png"));
        casillas[6][1].setIcon(icon61);

        casillas[6][2] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.NUEVE, 6, 2);
        ImageIcon icon62 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_clubs.png"));
        casillas[6][2].setIcon(icon62);

        casillas[6][3] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.OCHO, 6, 3);
        ImageIcon icon63 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_hearts.png"));
        casillas[6][3].setIcon(icon63);

        casillas[6][4] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.NUEVE, 6, 4);
        ImageIcon icon64 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_hearts.png"));
        casillas[6][4].setIcon(icon64);

        casillas[6][5] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.DIEZ, 6, 5);
        ImageIcon icon65 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_hearts.png"));
        casillas[6][5].setIcon(icon65);

        casillas[6][6] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.REINA, 6, 6);
        ImageIcon icon66 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_hearts.png"));
        casillas[6][6].setIcon(icon66);

        casillas[6][7] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.REINA, 6, 7);
        ImageIcon icon67 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_diamonds.png"));
        casillas[6][7].setIcon(icon67);

        casillas[6][8] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.CINCO, 6, 8);
        ImageIcon icon68 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_hearts.png"));
        casillas[6][8].setIcon(icon68);

        casillas[6][9] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.TRES, 6, 9);
        ImageIcon icon69 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_diamonds.png"));
        casillas[6][9].setIcon(icon69);

        casillas[7][0] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.REY, 7, 0);
        ImageIcon icon70 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_clubs.png"));
        casillas[7][0].setIcon(icon70);

        casillas[7][1] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.OCHO, 7, 1);
        ImageIcon icon71 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_spades.png"));
        casillas[7][1].setIcon(icon71);

        casillas[7][2] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.DIEZ, 7, 2);
        ImageIcon icon72 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"));
        casillas[7][2].setIcon(icon72);

        casillas[7][3] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.REINA, 7, 3);
        ImageIcon icon73 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_clubs.png"));
        casillas[7][3].setIcon(icon73);

        casillas[7][4] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.REY, 7, 4);
        ImageIcon icon74 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_clubs.png"));
        casillas[7][4].setIcon(icon74);

        casillas[7][5] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.AS, 7, 5);
        ImageIcon icon75 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_clubs.png"));
        casillas[7][5].setIcon(icon75);

        casillas[7][6] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.AS, 7, 6);
        ImageIcon icon76 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_diamonds.png"));
        casillas[7][6].setIcon(icon76);

        casillas[7][7] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.REY, 7, 7);
        ImageIcon icon77 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_diamonds.png"));
        casillas[7][7].setIcon(icon77);

        casillas[7][8] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.CUATRO, 7, 8);
        ImageIcon icon78 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_hearts.png"));
        casillas[7][8].setIcon(icon78);

        casillas[7][9] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.CUATRO, 7, 9);
        ImageIcon icon79 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_diamonds.png"));
        casillas[7][9].setIcon(icon79);

        casillas[8][0] = Casilla.setTipoRango(ManojoCartas.Tipo.TRÉBOL, ManojoCartas.Rango.AS, 8, 0);
        ImageIcon icon80 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_clubs.png"));
        casillas[8][0].setIcon(icon80);

        casillas[8][1] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.SIETE, 8, 1);
        ImageIcon icon81 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_spades.png"));
        casillas[8][1].setIcon(icon81);

        casillas[8][2] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.SEIS, 8, 2);
        ImageIcon icon82 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_spades.png"));
        casillas[8][2].setIcon(icon82);

        casillas[8][3] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.CINCO, 8, 3);
        ImageIcon icon83 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_spades.png"));
        casillas[8][3].setIcon(icon83);

        casillas[8][4] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.CUATRO, 8, 4);
        ImageIcon icon84 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_spades.png"));
        casillas[8][4].setIcon(icon84);

        casillas[8][5] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.TRES, 8, 5);
        ImageIcon icon85 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_spades.png"));
        casillas[8][5].setIcon(icon85);

        casillas[8][6] = Casilla.setTipoRango(ManojoCartas.Tipo.PICA, ManojoCartas.Rango.DOS, 8, 6);
        ImageIcon icon86 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_spades.png"));
        casillas[8][6].setIcon(icon86);

        casillas[8][7] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.DOS, 8, 7);
        ImageIcon icon87 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_hearts.png"));
        casillas[8][7].setIcon(icon87);

        casillas[8][8] = Casilla.setTipoRango(ManojoCartas.Tipo.CORAZÓN, ManojoCartas.Rango.TRES, 8, 8);
        ImageIcon icon88 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_hearts.png"));
        casillas[8][8].setIcon(icon88);

        casillas[8][9] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.CINCO, 8, 9);
        ImageIcon icon89 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_diamonds.png"));
        casillas[8][9].setIcon(icon89);

        casillas[9][0] = Casilla.setTipoRango(ManojoCartas.Tipo.COMODIN, ManojoCartas.Rango.COMODIN, 9, 0);
        ImageIcon icon90 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/red_joker.png"));
        casillas[9][0].setIcon(icon90);

        casillas[9][1] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.AS, 9, 1);
        ImageIcon icon91 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_diamonds.png"));
        casillas[9][1].setIcon(icon91);

        casillas[9][2] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.REY, 9, 2);
        ImageIcon icon92 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_diamonds.png"));
        casillas[9][2].setIcon(icon92);

        casillas[9][3] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.REINA, 9, 3);
        ImageIcon icon93 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_diamonds.png"));
        casillas[9][3].setIcon(icon93);

        casillas[9][4] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.DIEZ, 9, 4);
        ImageIcon icon94 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_diamonds.png"));
        casillas[9][4].setIcon(icon94);

        casillas[9][5] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.NUEVE, 9, 5);
        ImageIcon icon95 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_diamonds.png"));
        casillas[9][5].setIcon(icon95);

        casillas[9][6] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.OCHO, 9, 6);
        ImageIcon icon96 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_diamonds.png"));
        casillas[9][6].setIcon(icon96);

        casillas[9][7] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.SIETE, 9, 7);
        ImageIcon icon97 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_diamonds.png"));
        casillas[9][7].setIcon(icon97);

        casillas[9][8] = Casilla.setTipoRango(ManojoCartas.Tipo.DIAMANTE, ManojoCartas.Rango.SEIS, 9, 8);
        ImageIcon icon98 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_diamonds.png"));
        casillas[9][8].setIcon(icon98);

        casillas[9][9] = Casilla.setTipoRango(ManojoCartas.Tipo.COMODIN, ManojoCartas.Rango.COMODIN, 9, 9);
        ImageIcon icon99 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/red_joker.png"));
        casillas[9][9].setIcon(icon99);

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        for (int row = 0; row < N_ROWS; row++) {
            for (int col = 0; col < N_COLS; col++) {
                int x = col * CELL_SIZE_WIDTH;
                int y = row * CELL_SIZE_HEIGHT;
                casillas[row][col].setBounds(x, y, CELL_SIZE_WIDTH, CELL_SIZE_HEIGHT);
                add(casillas[row][col]);
            }
        }
    }

    public Casilla[] getFila(int filaIndex) {
        if (filaIndex < 0 || filaIndex >= casillas.length) {
            return null;
        }

        return casillas[filaIndex];
    }

    public Casilla[] getColumna(int columnaIndex) {
        if (columnaIndex < 0 || columnaIndex >= casillas.length) {
            return null;
        }

        return casillas[columnaIndex];
    }

}
