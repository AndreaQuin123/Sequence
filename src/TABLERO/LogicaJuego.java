
package TABLERO;

import java.util.ArrayList;

public class LogicaJuego {

    //JUGADORES
    public String player1, player2, player3, player4, player5, player6, player7, player8;
    
    //INDICADOR TURNO
    public int turnoActual= 1;
    
    //MISC
    public String color1, color2, color3, color4;
    public String fichaActual = "AMARILLO";
    public String Miembrosequipo1 = "";
    public String Miembrosequipo2 = "";
    public String Miembrosequipo3 = "";
    public String equipoPerteneciente = "EQUIPO 1";

    //Relevantes a los movimientos especiales
    private boolean ME_cambiarCarta = false;
    public boolean ME_bloqueo = false;

    //GENERALES
    public int secuenciaVertical = 0, secuenciaHorizontal = 0, secuenciaDiagonal = 0;
    public String elegida = "a";

    
    //METODOS QUE SE VAN A NECESITAR
    
    /*
    3 que revisen secuencias
        -Verticales
        -Diagonales
        -Horizontales
    
    1 que revise los movimientos especiales y que revise si son validos
    
    1 que haga los turnos
    
    1 
    
    
     */
   


}
