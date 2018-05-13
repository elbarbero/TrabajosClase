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
public class Empresa {

    Curso[] cursos;

    public Empresa() {
        cursos = new Curso[3];
        cursos[0] = new Curso("Java", 200);
        cursos[1] = new Curso("Visual NET", 300);
        cursos[2] = new Curso("Abap", 400);
    }

    public Curso[] getCursos() {//PARA ACCEDER AL ARRAY
        return cursos;
    }
    
}
