package TABLERO;

import java.util.ArrayList;
import java.util.List;

public class Log {

    public static class GameLog {

        private List<Game> juegos;

        public GameLog() {
            this.juegos = new ArrayList<>();
        }

        public void agregarJuego(Game game) {
            juegos.add(game);
        }

        public List<Game> getJuegosUsuario(String username) {
            List<Game> juegosUsuario = new ArrayList<>();

            for (Game game : juegosUsuario) {
                if (game.contieneParticipante(username)) {
                    juegosUsuario.add(game);
                }
            }

            return juegosUsuario;
        }

    }

    public static class Game {

        private List<String> participantes;
        private String estadoJuego;

        public Game(List<String> participantes, String estadoJuego) {
            this.participantes = participantes;
            this.estadoJuego = estadoJuego;
        }

        public boolean contieneParticipante(String username) {
            return participantes.contains(username);
        }
    }

}
