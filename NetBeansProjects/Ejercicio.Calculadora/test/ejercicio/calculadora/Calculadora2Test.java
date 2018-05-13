/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.calculadora;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author 203pc19
 */
@RunWith(Parameterized.class)
public class Calculadora2Test {

    int numero1;
    int numero2;
    int result;
    int resultResta;

    public Calculadora2Test(int numero1, int numero2, int result,int resultResta) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.result = result;
        this.resultResta=resultResta;
    }

    @Parameters
    /*Le estoy diciendo todo el conjunto de datos que tengo que tener en cuenta para poder funcionar*/
    public static Collection<Object[]> numeros() {
        /*Lo que va entre los parentesis son los datos de numero1,numero2 y resultado,resultado2, en ese orden.
         Entre los parentesis tiene que haber tantos datos(numeros)como variables declaradas,*/
        return Arrays.asList(new Object[][]{{20, 10, 30,10},{30,-2,-15,28},{5,2,3,3}});
        /*Dentro del Arrays.list tengo que poner todos los datos con los que tengo que realizar la prueba.
        Se tienen que poner en el mismo orden en el que han sido declaradas.*/
}         

    /**
     * Test of suma method, of class Calculadora.
     */
    @Test
        public void testSuma() {
        Calculadora objeto = new Calculadora(numero1, numero2);
        int resultado = objeto.suma();
        assertEquals("Fallo en la suma", resultado, result);
    }
            /**
     * Test of suma method, of class Calculadora.
     */
    @Test
        public void testResta() {
        Calculadora objeto = new Calculadora(numero1, numero2);
        int resultado = objeto.resta();
        assertEquals("Fallo en la resta", resultado, resultResta);
    }

}
