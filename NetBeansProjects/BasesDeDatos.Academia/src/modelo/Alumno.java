/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mario
 */
public class Alumno {

    int codAlumno;
    String nombre, dni, codCurso;
    String direccion, poblacion;
    int telefono;
    double importeGastos;

    public Alumno(int codAlumno, String nombre, String dni, String codCurso, String direccion, String poblacion, int telefono, double importeGastos) {
        this.codAlumno = codAlumno;
        this.nombre = nombre;
        this.dni = dni;
        this.codCurso = codCurso;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telefono = telefono;
        this.importeGastos = importeGastos;
    }

    public Alumno(int codAlumno, String codCurso) {
        this.codAlumno = codAlumno;
        this.codCurso = codCurso;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public double getImporteGastos() {
        return importeGastos;
    }

    public void setImporteGastos(double importeGastos) {
        this.importeGastos = importeGastos;
    }

    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
        de la memoria donde se guarda*/
        return nombre;
    }

}
