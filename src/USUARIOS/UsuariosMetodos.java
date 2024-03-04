package USUARIOS;

import java.io.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuariosMetodos {

    private RandomAccessFile usuarios, codigos;

    /*
    La carpeta principal se llamara "Usuarios" y cada carpeta de cada usuario sera nombrada con su usuario
     */
    public static final String DIRECTORY_FINAL = "Usuarios";
    public static final String PATH_FINAL = DIRECTORY_FINAL + "/usuarios.txt";
    public static final String PATH_FINAL_CODIGOS = DIRECTORY_FINAL + "/codigos.txt";

    public UsuariosMetodos() {

        try {

            File usersDir = new File(DIRECTORY_FINAL);
            usersDir.mkdir();

            usuarios = new RandomAccessFile(PATH_FINAL, "rw");
            codigos = new RandomAccessFile(PATH_FINAL_CODIGOS, "rw");

            initCodes();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /*
    Inicializar el folder de usuarios.
     */
    private void initCodes() throws IOException {
        if (codigos.length() == 0) {
            codigos.writeInt(1);
        }
    }

    /*
    Busca el siguiente codigo para el usuario
     */
    private int getCode() throws IOException {
        codigos.seek(0);
        int code = codigos.readInt();
        
        codigos.seek(0);
        codigos.writeInt(code + 1);

        return code;
    }


    /*
    Revisar si el usuario existe en el archivo.
     */
    public boolean revisarUsuario(String usuario) throws IOException {
        usuarios.seek(0);

        try {
            while (usuarios.getFilePointer() < usuarios.length()) {
                int code = usuarios.readInt();
                String name = usuarios.readUTF();
                String user = usuarios.readUTF();
                String password = usuarios.readUTF();
                int puntos = usuarios.readInt();
                long fechaCreacion = usuarios.readLong();

                if (user.equals(usuario)) {
                    return true;
                }
            }
        } catch (EOFException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean revisarContraseña(String usuario, String contraseña) throws IOException {
        usuarios.seek(0);

        while (usuarios.getFilePointer() < usuarios.length()) {
                int code = usuarios.readInt();
                String name = usuarios.readUTF();
                String user = usuarios.readUTF();
                String password = usuarios.readUTF();
                int puntos = usuarios.readInt();
                long fechaCreacion = usuarios.readLong();

                if (user.equals(usuario)) {
                    return true;
                }

            if (user.equals(usuario) && (password.equals(contraseña))) {
                return true;
            }
        }
        return false;
    }

    /*
                    FORMATO
    int code
    String name
    String usuario
    String password
    int puntos
    Long fechaCreacion
    
     */
    
    public void agregarUsuario(String name, String usuario, String password) throws IOException {
        
        if (!revisarUsuario(usuario)) {
            try {
                usuarios.seek(usuarios.length());

                int code = getCode();

                Usuario newUser = new Usuario(code, name, usuario, password);

                usuarios.writeInt(newUser.getCodigo());
                usuarios.writeUTF(newUser.getNombre());
                usuarios.writeUTF(newUser.getUsuario());
                usuarios.writeUTF(newUser.getPassword());
                usuarios.writeInt(newUser.getPuntos());
                usuarios.writeLong(newUser.getFecha().getTimeInMillis());
                
            } catch (IOException e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "¡Usuario creado con éxito!", "CREANDO USUARIO", JOptionPane.OK_CANCEL_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "¡Usuario ya existe!", "ERROR EN VERIFICACIÓN", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    public void closeFile() {
        try {
            if (usuarios != null) {
                usuarios.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
