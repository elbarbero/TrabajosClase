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
public class Curso {

    String curso;
    String denominacion;
    ArrayList<Asignatura> asignaturas;

    public Curso(String curso, String denominacion) {
        this.curso = curso;
        this.denominacion = denominacion;
        this.asignaturas = new ArrayList<>();
    }

    public String getCurso() {
        return curso;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public Asignatura getUnaAsignatura(int posicion) {
        return asignaturas.get(posicion);
    }

    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
        de la memoria donde se guarda*/
        return denominacion;
    }

}
