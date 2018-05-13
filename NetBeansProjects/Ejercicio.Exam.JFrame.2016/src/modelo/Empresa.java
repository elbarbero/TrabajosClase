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
public class Empresa {

    ArrayList<Usuario> usuarios;
    ArrayList<Alumno> alumnos;
    ArrayList<Curso> cursos;
    ArrayList<Asignatura> asignaturas;

    public Empresa(ArrayList<Usuario> usuarios, ArrayList<Alumno> alumnos, ArrayList<Curso> cursos, ArrayList<Asignatura> asignaturas) {
        this.usuarios = usuarios;
        this.alumnos = alumnos;
        this.cursos = cursos;
        this.asignaturas = asignaturas;
    }

    public Empresa() {
        usuarios = new ArrayList<>(); // CREAMOS UN ELEMENTO USUARIOS PARA CREAR UNA COLECCION DE DATOS. SINO NOS SALDRÍA JNullPointerException
        alumnos = new ArrayList<>();
        cursos = new ArrayList<>();
        this.asignaturas = new ArrayList<>();
        lasAsignaturas();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public Curso getUnCurso(int posicion) {
        return cursos.get(posicion);
    }

    public Usuario getUnUsuario(int posicion) {
        return usuarios.get(posicion);
    }

    public Alumno getUnAlumno(int posicion) {
        return alumnos.get(posicion);
    }

    public Asignatura getUnaAsignatura(int posicion) {
        return asignaturas.get(posicion);
    }

    public boolean buscarAlumno(String codigo) {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < alumnos.size()) {
            if (codigo.equalsIgnoreCase(alumnos.get(i).getCodigo())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        return encontrado;
    }

    /**
     * Busca usuario por usuario si hay alguno con el mismo login y contraseña
     * para iniciar sesion o no
     *
     * @param login es login del usuario que queremos acceder en este momento
     * @param password es la contraseña del usuario que queremos acceder en este
     * momento
     * @return devuelve un boolean (verdadero o falso)
     */
    public int buscarUsuario(String login, String password) {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < usuarios.size()) {
            if (login.equalsIgnoreCase(usuarios.get(i).getLogin()) && password.equals(usuarios.get(i).getPass())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            i = -1;
        }
        return i;
    }

    /*public boolean buscarCurso(String curso){
         
     }*/
    private void lasAsignaturas() {

        asignaturas.add(new Asignatura("1", "Programación"));
        asignaturas.add(new Asignatura("2", "Bases de Datos"));
        asignaturas.add(new Asignatura("3", "Lenguaje de Marcas"));

    }
}
