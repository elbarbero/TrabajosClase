/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.junit;



/**
 *
 * @author Mario Barbero
 */
public class Ejercicio3JUnit {

    String nombre;
    float nota1;
    float nota2;
    float nota3;
/**
 * Constructor que recoge las variables correspondientes al alumno
 * @param nombre Valor de tipo String
 * @param nota1 Valor de tipo float de la primera nota
 * @param nota2 Valor de tipo float de la segunda nota
 * @param nota3 Valor de tipo float de la tercera nota
 */
   public Ejercicio3JUnit(String nombre, float nota1, float nota2, float nota3) {
       /*Creamos este método para usarlo en el test*/
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
/**
 * Método que calcula la nota media del alumno
 * @return delvuelve el valor de la media
 */
    public float calculoMedia() {
        float media;
        media = (nota1 + nota2 + nota3) / 3;
        return media;
    }
/**
 * Método que calcula si te conceden la beca o no
 * @return devuelve un valor de tipo boolean
 */
    public boolean derechoBeca() {
        boolean beca = false;
        if (calculoMedia() > 5 && (nota1 >= 5 && nota2 >= 5 && nota3 >= 5)) {
            beca = true;
        }
        return beca;
    }
}
