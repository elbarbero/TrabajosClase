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
public class Usuario {

    private String nombre, login, password;
    private int tipo;//Para saber si es admin o es un nempleado
    private ArrayList<Agenda> bEntrada;

    public Usuario(String nombre, String login, String password) {// es constructor lo creamos para dar de alta a los empleados
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.bEntrada = new ArrayList<>(); // AL CREAR EL USUARIO NO TENDREMOS MAILS PERO CREAREMOS EL ESPACIO PARA GUARDARLOS
        // PERO bENTRADA NO ESTARA EN EL METODO DEL CONSTRUCTOR
    }

    public Usuario(String nombre, String login, String password, int tipo) {// es constructor lo creamos el admin
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.tipo = tipo;
        this.bEntrada = new ArrayList<>(); // AL CREAR EL USUARIO NO TENDREMOS MAILS PERO CREAREMOS EL ESPACIO PARA GUARDARLOS
        // PERO bENTRADA NO ESTARA EN EL METODO DEL CONSTRUCTOR
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Agenda> getbEntrada() {
        return bEntrada;//me devuelve una coleccion de correos
    }

    public void setbEntrada(ArrayList<Agenda> bEntrada) {
        this.bEntrada = bEntrada;
    }

    public int getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
        de la memoria donde se guarda*/
        return nombre;
    }

    /**
     * Busca evento por evento si hay alguno con el mismo día y/o hora y lo
     * compara con el que estamos introduciendo
     *
     * @param hora la hora introducida en el evento que estamos introduciendo
     * @param fecha la fecha completa introducida en el evento que estamos
     * introduciendo
     * @return devuelve un boolean (verdadero o falso)
     */
    public boolean buscarFechaEvento(String hora, String fecha) {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < bEntrada.size()) {
            if (fecha.compareToIgnoreCase(bEntrada.get(i).getFecha()) == 0) {
                if (hora.compareToIgnoreCase(bEntrada.get(i).getHora()) == 0) {
                    encontrado = true;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return encontrado;
    }

    /**
     * Busca evento por evento si hay alguno con el mismo nombre y lo compara
     * con el que estamos introduciendo
     *
     * @param nombre el nombre introducida en el evento que estamos
     * introduciendo
     * @return devuelve un boolean (verdadero o falso)
     */
    public boolean buscarNombreEvento(String nombre) {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < bEntrada.size()) {
            if (nombre.compareToIgnoreCase(bEntrada.get(i).getNombre()) == 0) {
                encontrado = true;
            } else {
                i++;
            }
        }
        return encontrado;
    }

}
