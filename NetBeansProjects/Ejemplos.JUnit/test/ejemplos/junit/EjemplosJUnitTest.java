/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.junit;

import ejemplos.junit.EjemplosJUnit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mario
 */
public class EjemplosJUnitTest {

    public EjemplosJUnitTest() {
    }

    @Test
    public void testSumar() {
        int resultado = EjemplosJUnit.sumar(2, 3);
        int esperado = 5;//2+3=5
        assertEquals("NO ES CORRECTO",esperado, resultado);
    }

    @Test
    public void testRestar() {
        int resultado = EjemplosJUnit.restar(3, 2);//3-2=1
        int esperado = 1;
        assertEquals("NO ES CORRECTO",esperado, resultado);;
        /*el orden da igual, se puede poner al revés:
        assertEquals("NO ES CORRECTO",resultado,esperado); y dar bien*/
    }

}
