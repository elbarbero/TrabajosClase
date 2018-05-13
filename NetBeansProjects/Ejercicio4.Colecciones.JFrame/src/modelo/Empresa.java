/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class Empresa {

    private ArrayList<Usuario> usuarios;

    public Empresa(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Empresa() {
        usuarios = new ArrayList<>(); // CREAMOS UN ELEMENTO USUARIOS PARA CREAR UNA COLECCION DE DATOS. SINO NOS SALDRÍA JNullPointerException
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUnUsuarios(int posicion) {
        return usuarios.get(posicion);
    }

    /**
     * Busca usuario por usuario si hay alguno con el mismo login y lo compara
     * con que estamos introduciendo
     *
     * @param login es login del usuario que estamos introduciendo en este
     * momento
     * @return devuelve un boolean (verdadero o falso)
     */
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

    /**
     * Busca usuario por usuario si hay alguno con el mismo login y contraseña
     * para iniciar sesion o no
     *
     * @param login es login del usuario que queremos acceder en este momento
     * @param password es la contraseña del usuario que queremos acceder en este
     * momento
     * @return devuelve un boolean (verdadero o falso)
     */
    public int buscarUsuario(String login, String password) {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < usuarios.size()) {
            if (login.equalsIgnoreCase(usuarios.get(i).getLogin()) && password.equals(usuarios.get(i).getPassword())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            i = -1;
        }
        return i;
    }

}
