/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Admin
 */
public class Categoria {
    
    private Curso [] cursos;
    private String denominacion;

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

    public Curso getUnCurso(int pos){       //DEVUELVE UN UNICO CURSO (SABIENDO LA POSICION)
        return cursos[pos];
    }
    
    //COMPARA EL NOMBRE INTRODUCIDO EN EL METODO CON EL NOMBRE DEL CURSO
    public int busquedaCursoCAT(String nombre){ 
        int pos=0;
        boolean encontrado=false;
        while (!encontrado && pos<cursos.length){
            if(nombre.equalsIgnoreCase(cursos[pos].getNombre())){
                encontrado=true;
            }else{
                pos++;
            }
        }
        if(!encontrado){
            pos = -1;
        }
        return pos;
    }

}
