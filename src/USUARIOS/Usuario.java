
package USUARIOS;

import java.util.Calendar;

public class Usuario {
    
    private String name;
    private String usuario;
    private int puntos;
    private Calendar fechaCreacion;
    private String password;

    public Usuario(String name, String usuario, String password) {
        this.fechaCreacion = Calendar.getInstance();
        this.puntos = 0;

        this.name = name;
        this.usuario = usuario;
        this.password = password;

    }

    public String getNombre() {
        return name;
    }

    public String getUsuario() {
        return usuario;

    }

    public int getPuntos() {
        return puntos;

    }

    public Calendar getFecha() {
        return fechaCreacion;

    }

    public String getPassword() {
        return password;

    }


}
