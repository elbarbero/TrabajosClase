/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio23.alumnos.calificaciones3;

/**
 *
 * @author Mario
 */
public class Alumnos {

    private String nombreAlumno;
    private int notaAlumno;

    public void DatosAlumnos(String nombre, int nota) {
        nombreAlumno = nombre;
        this.notaAlumno = nota;
        /*Se pone this. para que coga el dato de fuera del metodo.
         el this. trabaja con una propiedad de esa clase.*/
    }

    /*public void visualizar() {
        System.out.println(nombreAlumno +" ha sacado un "+ notaAlumno);
    }*/
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int getNotaAlumno() {
        return notaAlumno;
    }

    public void setNotaAlumno(int notaAlumno) {
        this.notaAlumno = notaAlumno;
    }

}
