package TABLERO;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Tablero extends JPanel {

    private final int CELL_SIZE_WIDTH = 50;
    private final int CELL_SIZE_HEIGHT = 74;

    private final int N_ROWS = 10;
    private final int N_COLS = 10;

    private final int BOARD_WIDTH = N_COLS * CELL_SIZE_WIDTH + 1;
    private final int BOARD_HEIGHT = N_ROWS * CELL_SIZE_HEIGHT + 1;

    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[N_ROWS][N_COLS];

        for (int row = 0; row < N_ROWS; row++) {
            for (int col = 0; col < N_COLS; col++) {
                casillas[row][col] = new Casilla();
            }
        }

        ImageIcon icon00 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/red_joker.png"));
        casillas[0][0].setIcon(icon00);
        ImageIcon icon01 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_spades.png"));
        casillas[0][1].setIcon(icon01);
        ImageIcon icon02 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_spades.png"));
        casillas[0][2].setIcon(icon02);
        ImageIcon icon03 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_spades.png"));
        casillas[0][3].setIcon(icon03);
        ImageIcon icon04 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_spades.png"));
        casillas[0][4].setIcon(icon04);
        ImageIcon icon05 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_spades.png"));
        casillas[0][5].setIcon(icon05);
        ImageIcon icon06 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_spades.png"));
        casillas[0][6].setIcon(icon06);
        ImageIcon icon07 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_spades.png"));
        casillas[0][7].setIcon(icon07);
        ImageIcon icon08 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_spades.png"));
        casillas[0][8].setIcon(icon08);
        ImageIcon icon09 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/red_joker.png"));
        casillas[0][9].setIcon(icon09);
        ImageIcon icon10 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_clubs.png"));
        casillas[1][0].setIcon(icon10);
        ImageIcon icon11 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_clubs.png"));
        casillas[1][1].setIcon(icon11);
        ImageIcon icon12 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_clubs.png"));
        casillas[1][2].setIcon(icon12);
        ImageIcon icon13 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_clubs.png"));
        casillas[1][3].setIcon(icon13);
        ImageIcon icon14 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_clubs.png"));
        casillas[1][4].setIcon(icon14);
        ImageIcon icon15 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_clubs.png"));
        casillas[1][5].setIcon(icon15);
        ImageIcon icon16 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_hearts.png"));
        casillas[1][6].setIcon(icon16);
        ImageIcon icon17 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_hearts.png"));
        casillas[1][7].setIcon(icon17);
        ImageIcon icon18 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_hearts.png"));
        casillas[1][8].setIcon(icon18);
        ImageIcon icon19 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_spades.png"));
        casillas[1][9].setIcon(icon19);
        ImageIcon icon20 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_clubs.png"));
        casillas[2][0].setIcon(icon20);
        ImageIcon icon21 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_spades.png"));
        casillas[2][1].setIcon(icon21);
        ImageIcon icon22 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_diamonds.png"));
        casillas[2][2].setIcon(icon22);
        ImageIcon icon23 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_diamonds.png"));
        casillas[2][3].setIcon(icon23);
        ImageIcon icon24 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_diamonds.png"));
        casillas[2][4].setIcon(icon24);
        ImageIcon icon25 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_diamonds.png"));
        casillas[2][5].setIcon(icon25);
        ImageIcon icon26 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_diamonds.png"));
        casillas[2][6].setIcon(icon26);
        ImageIcon icon27 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_diamonds.png"));
        casillas[2][7].setIcon(icon27);
        ImageIcon icon28 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_hearts.png"));
        casillas[2][8].setIcon(icon28);
        ImageIcon icon29 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_spades.png"));
        casillas[2][9].setIcon(icon29);
        ImageIcon icon30 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_clubs.png"));
        casillas[3][0].setIcon(icon30);
        ImageIcon icon31 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_spades.png"));
        casillas[3][1].setIcon(icon31);
        ImageIcon icon32 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_clubs.png"));
        casillas[3][2].setIcon(icon32);
        ImageIcon icon33 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_clubs.png"));
        casillas[3][3].setIcon(icon33);
        ImageIcon icon34 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_clubs.png"));
        casillas[3][4].setIcon(icon34);
        ImageIcon icon35 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_clubs.png"));
        casillas[3][5].setIcon(icon35);
        ImageIcon icon36 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_clubs.png"));
        casillas[3][6].setIcon(icon36);
        ImageIcon icon37 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_diamonds.png"));
        casillas[3][7].setIcon(icon37);
        ImageIcon icon38 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_hearts.png"));
        casillas[3][8].setIcon(icon38);
        ImageIcon icon39 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_spades.png"));
        casillas[3][9].setIcon(icon39);
        ImageIcon icon40 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_clubs.png"));
        casillas[4][0].setIcon(icon40);
        ImageIcon icon41 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_spades.png"));
        casillas[4][1].setIcon(icon41);
        ImageIcon icon42 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_clubs.png"));
        casillas[4][2].setIcon(icon42);
        ImageIcon icon43 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_hearts.png"));
        casillas[4][3].setIcon(icon43);
        ImageIcon icon44 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_hearts.png"));
        casillas[4][4].setIcon(icon44);
        ImageIcon icon45 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_hearts.png"));
        casillas[4][5].setIcon(icon45);
        ImageIcon icon46 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_hearts.png"));
        casillas[4][6].setIcon(icon46);
        ImageIcon icon47 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_diamonds.png"));
        casillas[4][7].setIcon(icon47);
        ImageIcon icon48 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_hearts.png"));
        casillas[4][8].setIcon(icon48);
        ImageIcon icon49 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_spades.png"));
        casillas[4][9].setIcon(icon49);
        ImageIcon icon50 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"));
        casillas[5][0].setIcon(icon50);
        ImageIcon icon51 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_spades.png"));
        casillas[5][1].setIcon(icon51);        
        ImageIcon icon52 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_clubs.png"));
        casillas[5][2].setIcon(icon52);
        ImageIcon icon53 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_hearts.png"));
        casillas[5][3].setIcon(icon53);
        ImageIcon icon54 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_hearts.png"));
        casillas[5][4].setIcon(icon54);
        ImageIcon icon55 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_hearts.png"));
        casillas[5][5].setIcon(icon55);
        ImageIcon icon56 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_hearts.png"));
        casillas[5][6].setIcon(icon56);
        ImageIcon icon57 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_diamonds.png"));
        casillas[5][7].setIcon(icon57);
        ImageIcon icon58 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_hearts.png"));
        casillas[5][8].setIcon(icon58);
        ImageIcon icon59 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_diamonds.png"));
        casillas[5][9].setIcon(icon59);
        ImageIcon icon60 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_clubs.png"));
        casillas[6][0].setIcon(icon60);        
        ImageIcon icon61 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_spades.png"));
        casillas[6][1].setIcon(icon61);  
        ImageIcon icon62 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_clubs.png"));
        casillas[6][2].setIcon(icon62);  
        ImageIcon icon63 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_hearts.png"));
        casillas[6][3].setIcon(icon63);  
        ImageIcon icon64 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_hearts.png"));
        casillas[6][4].setIcon(icon64);  
        ImageIcon icon65 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_hearts.png"));
        casillas[6][5].setIcon(icon65);  
        ImageIcon icon66 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_hearts.png"));
        casillas[6][6].setIcon(icon66);  
        ImageIcon icon67 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_spades.png"));
        casillas[6][7].setIcon(icon67);  
        ImageIcon icon68 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_hearts.png"));
        casillas[6][8].setIcon(icon68);  
        ImageIcon icon69 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_diamonds.png"));
        casillas[6][9].setIcon(icon69);  
        ImageIcon icon70 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_clubs.png"));
        casillas[7][0].setIcon(icon70);  
        ImageIcon icon71 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_spades.png"));
        casillas[7][1].setIcon(icon71);  
        ImageIcon icon72 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_clubs.png"));
        casillas[7][2].setIcon(icon72);  
        ImageIcon icon73 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_clubs.png"));
        casillas[7][3].setIcon(icon73);  
        ImageIcon icon74 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_clubs.png"));
        casillas[7][4].setIcon(icon74);  
        ImageIcon icon75 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_clubs.png"));
        casillas[7][5].setIcon(icon75);  
        ImageIcon icon76 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_diamonds.png"));
        casillas[7][6].setIcon(icon76);  
        ImageIcon icon77 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_diamonds.png"));
        casillas[7][7].setIcon(icon77);  
        ImageIcon icon78 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_hearts.png"));
        casillas[7][8].setIcon(icon78);  
        ImageIcon icon79 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_diamonds.png"));
        casillas[7][9].setIcon(icon79);  
        ImageIcon icon80 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_clubs.png"));
        casillas[8][0].setIcon(icon80);  
        ImageIcon icon81 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_spades.png"));
        casillas[8][1].setIcon(icon81);          
        ImageIcon icon82 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_spades.png"));
        casillas[8][2].setIcon(icon82);   
        ImageIcon icon83 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_spades.png"));
        casillas[8][3].setIcon(icon83);   
        ImageIcon icon84 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/4_of_spades.png"));
        casillas[8][4].setIcon(icon84);   
        ImageIcon icon85 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_spades.png"));
        casillas[8][5].setIcon(icon85);   
        ImageIcon icon86 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_spades.png"));
        casillas[8][6].setIcon(icon86);   
        ImageIcon icon87 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/2_of_hearts.png"));
        casillas[8][7].setIcon(icon87);   
        ImageIcon icon88 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/3_of_hearts.png"));
        casillas[8][8].setIcon(icon88);   
        ImageIcon icon89 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/5_of_diamonds.png"));
        casillas[8][9].setIcon(icon89);   
        ImageIcon icon90 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/red_joker.png"));
        casillas[9][0].setIcon(icon90);           
        ImageIcon icon91 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/ace_of_diamonds.png"));
        casillas[9][1].setIcon(icon91);  
        ImageIcon icon92 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/king_of_diamonds.png"));
        casillas[9][2].setIcon(icon92);  
        ImageIcon icon93 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/queen_of_diamonds.png"));
        casillas[9][3].setIcon(icon93);  
        ImageIcon icon94 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/10_of_diamonds.png"));
        casillas[9][4].setIcon(icon94);  
        ImageIcon icon95 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/9_of_diamonds.png"));
        casillas[9][5].setIcon(icon95);  
        ImageIcon icon96 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/8_of_diamonds.png"));
        casillas[9][6].setIcon(icon96);  
        ImageIcon icon97 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/7_of_diamonds.png"));
        casillas[9][7].setIcon(icon97);          
        ImageIcon icon98 = new ImageIcon(getClass().getResource("/IMAGES/CARDS/6_of_diamonds.png"));
        casillas[9][8].setIcon(icon98);  
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

}