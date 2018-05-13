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
public class Alumno {

    String codigo;
    String nombre;
    //Curso miCurso;
    private ArrayList<Curso> misCursos;

    public Alumno(String codigo, String nombre/*, Curso miCurso*/) {
        this.codigo = codigo;
        this.nombre = nombre;
        //this.miCurso = miCurso;
        this.misCursos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    /*public Curso getMiCurso() {
     return miCurso;
     }*/
    public Curso getUnCurso(int posicion) {
        return misCursos.get(posicion);
    }

    public ArrayList<Curso> getMisCursos() {
        return misCursos;
    }

    public void setMisCursos(ArrayList<Curso> misCursos) {
        this.misCursos = misCursos;
    }

    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
         de la memoria donde se guarda*/
        return nombre;
    }
}
