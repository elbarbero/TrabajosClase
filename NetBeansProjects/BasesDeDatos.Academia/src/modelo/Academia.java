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
public class Academia {

    String nombre, cif, direccion, poblacion, telefono, email;
    private ArrayList<Curso> cursos;

    public Academia(String nombre, String cif, String direccion, String poblacion, String telefono, String email) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telefono = telefono;
        this.email = email;
    }

    public Academia(String cif,String telefono, String email) {
        this.telefono = telefono;
        this.email = email;
        this.cif=cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
        de la memoria donde se guarda*/
        return nombre;
    }
}
