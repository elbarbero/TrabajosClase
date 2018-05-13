/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author 203pc19
 */
@RunWith(Parameterized.class)
public class CalculadoraTest {

    Calculadora objeto;

    public CalculadoraTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //Para abrir la clase
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        //Para cerrar la clase
    }

    @Before
    //Este se ejecuta primero
    public void setUp() throws Exception {
        /*Aqui no hace falta volver a declararla
        Ya se declara en el public class test*/
        objeto = new Calculadora(20, 10);
    }

    @After
    //Esto se ejecuta despues, el segundo si solo hay dos.
    public void tearDown() throws Exception {
        objeto = null;//con esto destruyes la claculadora de este método
        /*Se pone null porque se se ejecuta despues del setUp.
         Por eso en tearDown no hace falta volver a declarar el objeto.
         Si el primero falla (el setUp) este (el tearDown) tambien falla.*/
    }

    /**
     * Test of suma method, of class Calculadora.
     */
    @Test
    public void testSuma() {
        System.out.println("suma");
        //Calculadora objeto = new Calculadora(10,20);//pone null porque está vacio
        int expResult = 30;
        int result = objeto.suma();
        assertEquals("Si el resultado no es le esperado",expResult, result);
        //Aquí se pone lo que quieres comprobar
        //si es igual(....)
    }

    /**
     * Test of dividir method, of class Calculadora.
     */
    @Test
    public void testDividir() {
        System.out.println("dividir");
        try {
            //Calculadora objeto = new Calculadora(20, 5);//pone null porque está vacio
            int esperado = 2;
            int resultado = objeto.dividir();
            assertEquals("División mal hecha", esperado, resultado);
        } catch (ArithmeticException e) {
            fail("Excepción aritmetica");
        }
        /*Se pone un mensaje en assertEquals que se quiere
         mostrar si el resultado no es correcto*/
        //fail("TEsto es un prototipo.");
    }
    /*si el fail está puesto obligas al metodo al fallo aunque
     el resultado sea el correcto. Siempre te dará fallo*/

    /**
     * Test of resta method, of class Calculadora.
     */
    @Test
    public void testResta() {
        System.out.println("resta");
        Calculadora instance = null;
        int expResult = 0;
        int result = instance.resta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resta2 method, of class Calculadora.
     */
    @Test
    public void testResta2() {
        System.out.println("resta2");
        /*En la siguiente instruccion: Para usar los objeto de la clase CalculadoraTest,
        que tambien los hemos llamado objeto.*/
        boolean result = objeto.resta2();
        assertTrue("El resultado es false ",result);
    }
    
    
}
