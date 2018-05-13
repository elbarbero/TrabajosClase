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

    private String nombre, login, password;
    private int tipo;//Para saber si es admin o es un usuario
    private ArrayList<Linea> lineas;

    public Usuario(String nombre, String login, String password, int tipo) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.tipo = tipo;
        this.lineas = new ArrayList<>();
    }

    public Usuario(String nombre, String login, String password) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.lineas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<Linea> lineas) {
        this.lineas = lineas;
    }

    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
         de la memoria donde se guarda*/
        return nombre;
    }
}
