package modelo;

import java.util.ArrayList;

/**
 *
 * @author 203pc19
 */
public class Empresa {

    private ArrayList<Usuario> usuarios;//para acceder a todos los usuarios
    private ArrayList<Libros> libro;//para acceder a todos los libros

    public Empresa() {
        usuarios = new ArrayList<>(); // CREAMOS UN ELEMENTO USUARIOS PARA CREAR UNA COLECCION DE DATOS. SINO NOS SALDRÍA JNullPointerException
        this.libro = new ArrayList<>();
        losLibros();
    }

    public ArrayList<Libros> getLibro() {
        return libro;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUnUsuario(int posicion) {
        return usuarios.get(posicion);
    }

    public Libros getUnLibro(int posicion) {
        return libro.get(posicion);
    }

    public boolean buscarUsuario(String login) {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < usuarios.size()) {
            if (login.equalsIgnoreCase(usuarios.get(i).getLogin())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        return encontrado;
    }

    /*public boolean buscarUnlibro(String isbn) {
     int i = 0;
     boolean encontrado = false;
     while (!encontrado && i < miLibro.length) {
     if (isbn.equalsIgnoreCase(miLibro.) {
     encontrado = true;
     } else {
     i++;
     }
     }
     return encontrado;
     }*/
    private void losLibros() {

        libro.add(new Libros("978-84-08-11959-3", "Historia del tiempo", "Stephen Hawking", "Crítica"));
        libro.add(new Libros("978-84-15239-85-7", "Ícaro", "Alberto Vázquez Figueroa", "Singular"));
        libro.add(new Libros("978-84-92431-98-4", "La Respuesta", "Robert Doherty", "VíaMagna"));

    }
}
