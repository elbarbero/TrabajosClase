/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.get.set.conclases;

/**
 *
 * @author Mario
 */
public class Alumnos {

    private float nota,SumaNota;
    private String nombre, nombreMayor, nombreMenor;
    private int edad;
    private int conMenos5;
    private int conMenos8;
    private int conMas8;

    public Alumnos(String nombre, float nota, int edad) {
        this.nombre = nombre;
        this.nota = nota;
        this.edad = edad;
    }

    public float getNota() {
        return nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getConMenos5() {
        return conMenos5;
    }

    public int getConMenos8() {
        return conMenos8;
    }

    public int getConMas8() {
        return conMas8;
    }

    public String getNombreMayor() {
        return nombreMayor;
    }

    public void setNombreMayor(String nombreMayor) {
        this.nombreMayor = nombreMayor;
    }

    public String getNombreMenor() {
        return nombreMenor;
    }

    public void setNombreMenor(String nombreMenor) {
        this.nombreMenor = nombreMenor;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void actualizarConMenos5() {
        conMenos5++;
    }

    public void actualizarConMenos8() {
        conMenos8++;
    }

    public void actualizarConMas8() {
        conMas8++;
    }

    public float totalNotas() {
        float totalNotas=0;
        totalNotas = SumaNota;
        return totalNotas;
    }

    public float SumarNota() {
        SumaNota = SumaNota + nota;
        return SumaNota;
    }
}
