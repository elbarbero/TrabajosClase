/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 203pc19
 */
public class Categoria {

    private String denominacion;
    private Curso[] cursos;

    public Categoria(String denominacion, Curso[] cursos) {
        this.denominacion = denominacion;
        this.cursos = cursos;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public Curso getUnCurso(int pos) {//ESTE MÉTODO DEVUELVE UN CURSO CONCRETO
        //Nos devuelve un curso dependiendo de la posicion en la que este
        return cursos[pos];
    }

    public int buscarCurso(String nombreCurso) {
        /*Con este método buscamos un curso dentro de una categoria*/
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < cursos.length) {
            if (nombreCurso.equalsIgnoreCase(cursos[pos].getNombre())) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        if (!encontrado) {
            pos = -1;
        }
        return pos;
    }

}
