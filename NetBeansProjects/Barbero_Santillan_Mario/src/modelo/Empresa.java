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

    ArrayList<Linea> lineas;
    ArrayList<Usuario> usuarios;
    ArrayList<Paradas> paradas;

    public Empresa() {
        lineas = new ArrayList<>();
        usuarios = new ArrayList<>();
        paradas = new ArrayList<>();
                lasParadas();
    }

    public Usuario getUnUsuario(int posicion) {
        return usuarios.get(posicion);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Paradas getUnaParada(int posicion) {
        return paradas.get(posicion);
    }

    public ArrayList<Paradas> getParadas() {
        return paradas;
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }

    
    /**
     * Busca usuario por usuario si hay alguno con el mismo login y lo compara
     * con que estamos introduciendo
     *
     * @param login es login del usuario que estamos introduciendo en este
     * momento
     * @return devuelve un boolean (verdadero o falso)
     */
    public boolean buscarLinea(String codigo) {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < lineas.size()) {
            if (codigo.equalsIgnoreCase(lineas.get(i).getCodigo())) {
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
    
        private void lasParadas() {

        paradas.add(new Paradas("1", "Gamonal"));
        paradas.add(new Paradas("2", "Vitoria,198"));
        paradas.add(new Paradas("3", "Vitoria,165"));
        paradas.add(new Paradas("4", "Hacienda"));
        paradas.add(new Paradas("5", "Arlanzon,10"));
        paradas.add(new Paradas("6", "El Cid"));

    }
}
