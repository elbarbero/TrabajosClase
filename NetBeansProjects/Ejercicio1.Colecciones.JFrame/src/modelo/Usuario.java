/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Usuario {
    private String email, nombre, password;
    private int tipo;
    private ArrayList <Correo> bEntrada;

    public Usuario(String email, String nombre, String password) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.bEntrada = new ArrayList <>(); // AL CREAR EL USUARIO NO TENDREMOS MAILS PERO CREAREMOS EL ESPACIO PARA GUARDARLOS
                                            // PERO bENTRADA NO ESTARA EN EL METODO DEL CONSTRUCTOR
    }

    public Usuario(String email, String nombre, String password, int tipo) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        this.bEntrada = new ArrayList <>(); // AL CREAR EL USUARIO NO TENDREMOS MAILS PERO CREAREMOS EL ESPACIO PARA GUARDARLOS
                                            // PERO bENTRADA NO ESTARA EN EL METODO DEL CONSTRUCTOR
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList <Correo> getbEntrada() {
        return bEntrada;//me devuelve una coleccion de correos
    }

    public void setbEntrada(ArrayList <Correo> bEntrada) {
        this.bEntrada = bEntrada;
    }

    public int getTipo() {
        return tipo;
    }
    @Override
    public String toString(){
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
        de la memoria donde se guarda*/
        return email;
    } 
    
}
