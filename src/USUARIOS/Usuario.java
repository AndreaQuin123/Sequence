
package USUARIOS;

import java.util.Calendar;
import java.io.*;

public class Usuario {
    
    private int code;
    private String name;
    private String usuario;
    private int puntos;
    private Calendar fechaCreacion;
    private String password;

    public Usuario(int codigo, String name, String usuario, String password) {
        code = codigo;
        this.name = name;
        this.usuario = usuario;
        this.password = password;

        this.puntos = 0;
        this.fechaCreacion = Calendar.getInstance();

    }

    public int getCodigo() {
        return code;
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

    public void setPassword(String nuevaContraseña) {
        this.password = nuevaContraseña;

    }


}
