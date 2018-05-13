/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.junit;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mario
 */
public class EjemplosJUnit2Test {

    EjemplosJUnit2 objeto;//OBJETO DE TIPO "EJEMPLOSJUNIT2"

    @Before
    public void Before() {//@BEFORE SIEMPRE SE EJECUTA ANTES DEL @TEST
        //TODO LOS QUE ESTE DENTRO DE @BEFORE SE EJECUTA ANTES
        System.out.println("before()");
        objeto = new EjemplosJUnit2();
    }

    @After
    public void after() {//@AFTER SIEMPRE SE EJECUTA DESPUES DEL @TEST
        //TODO LOS QUE ESTE DENTRO DE @AFTER SE EJECUTA DESPUES
        System.out.println("after()");
        objeto.borrado();
    }

    @Test
    public void testSumar() {
        System.out.println("sumar()");
        int resultado = objeto.sumando(3, 2);//NOS DEVUELVE LO QUE TENGA EL MÉTODO "SUMANDO"
        int esperado = 5;
        assertEquals("NO ES CORRECTO", esperado, resultado);
    }

    @Test
    public void testAnsSumar() {
        System.out.println("AnsSumar()");
        objeto.sumando(2, 3);
        int resultado = objeto.ans();//NOS DEVUELVE LO QUE TENGA EL MÉTODO "ANS"
        int esperado = 5;
        assertEquals("NO ES CORRECTO", esperado, resultado);
    }
    
}
