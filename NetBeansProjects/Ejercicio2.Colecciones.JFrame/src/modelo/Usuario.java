/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 203pc19
 */
public class Usuario {

    String nombre, apellidos, login, contrasena;
    private ArrayList<Libros> lNuevos;

    public Usuario(String nombre, String apellidos, String login, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.login = login;
        this.contrasena = contrasena;
        this.lNuevos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<Libros> getlNuevos() {
        return lNuevos;
    }

    public void setbNuevos(ArrayList<Libros> lNuevos) {
        this.lNuevos = lNuevos;
    }

    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
         de la memoria donde se guarda*/
        return nombre;
    }

}
