/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.junit;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Mario Barbero
 */
@RunWith(Parameterized.class)
public class Ejercicio3JUnitTest {

    Ejercicio3JUnit alumno;
    boolean beca;

    /*String nombre;
    float nota1;
    float nota2;
    float nota3;*/

 /*public Ejercicio3JUnitTest(String nombre, float nota1, float nota2, float nota3, boolean beca) {

        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.beca = beca;
    }*/
    public Ejercicio3JUnitTest(String nombre, float nota1, float nota2, float nota3, boolean beca) {
        /*La siguiente línea es igual que si se declara cada variable por separado.
         En este constructor del Test utilizamos las variables que hemos puesto en el
         constructor de la clase "Ejercicio3JUnit" y usarlo con el método parametizado*/
        alumno = new Ejercicio3JUnit(nombre, nota1, nota2, nota3);
        /*El objeto, en la línea de arriba,ponemos las variable que se
         han puesto en el constructor de la clase "Ejercicio3JUnit"*/
        this.beca = beca;
    }

    @Parameterized.Parameters
    /*Es una colección de datos que van a ser un conjuntos de objetos.
     Inicializar es un nombre cualquiera que queremaos poner.*/
    public static Collection<Object[]> inicializar() {
        return Arrays.asList(new Object[][]{{"Ana", 6, 8, 5, true},
        {"Luis", 7, 8, 10, false}, {"José", 3, 9, 4, false}, {"Marta", 2, 6, 6, false}});
    }

    /**
     * Test of calculoMedia method, of class Ejercicio3JUnit.
     */
    @Test
    public void testCalculoMedia() {
        System.out.println("calculoMedia");
        Ejercicio3JUnit instance = new Ejercicio3JUnit("pepe", 5, 6, 7);
        float expResult = 6F;
        float resultado = instance.calculoMedia();
        assertEquals("Fallo en el calculo de la media", expResult, resultado, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of derechoBeca method, of class Ejercicio3JUnit.
     */
    @Test
    public void testDerechoBeca() {
        System.out.println("derechoBeca");
        Ejercicio3JUnit instance = new Ejercicio3JUnit("jose", 8, 4, 6);
        boolean resultado = instance.derechoBeca();
        /*assertFalse te comprueba si el resultado es falso, es decir,
         si el resultado es correcto, no me muestra el mensaje*/
 /*assertTrue te comprueba si el resultado es verdadero, es decir,
         si el resultado no es correcto, me muestra el mensaje*/
        assertFalse("BECA NO CONCEDIDA", resultado);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testDerechoBecaParametizado() {
        System.out.println("DerechoBecaParametizado");
        /*Ejercicio3JUnit instance = new Ejercicio3JUnit(nombre, nota1, nota2, nota3);
        /*en la siguiente línea llamamos al objeto "alumno" de tipo "Ejercicio3JUnit"*/
        //boolean resultado = instance.derechoBeca();
        boolean resultado = alumno.derechoBeca();
        assertEquals("ERROR EN LA CONCESIÓN DE LA BECA", resultado, beca);
    }

}
