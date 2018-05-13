/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.tema3.junit;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author 203pc19
 */
@RunWith(Parameterized.class)
public class CCuentaTest {

    String nomCuenta;
    String cuenta;
    int saldo;
    int ingresar;
    int quitar;
    int result1;//resultado despues de ingresar
    int result2;//resultado despues de retirar
    int interes;
    float cantidad;

    public CCuentaTest(String nomCuenta, String cuenta, int saldo, int ingresar, int result1, int quitar, int result2, int interes) {
        this.nomCuenta = nomCuenta;
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.ingresar = ingresar;
        this.result1 = result1;
        this.quitar = quitar;
        this.result2 = result2;
        this.interes = interes;
    }

    @Parameterized.Parameters
    /*Le estoy diciendo todo el conjunto de datos que tengo que tener en cuenta para poder funcionar*/
    public static Collection<Object[]> numeros() {
        /*Lo que va entre los parentesis son los datos de nombre de la cuenta, numero de la cuenta, saldo y el tipo de interes, en ese orden.
         Entre los parentesis tiene que haber tantos datos como variables declaradas,*/
        return Arrays.asList(new Object[][]{{"Juan López", "1000-2365-85-123456789", 2000, 125, 2125,23,2102, 0}, {"mi cuenta 2", "2156456", 2000, 321, 2250,123,1877, 0}, {"Juan López", "1000-2365-85-123456789", 2500, 54, 2554,169,2389, 0}});
        /*Dentro del Arrays.list tengo que poner todos los datos con los que tengo que realizar la prueba.
         Se tienen que poner en el mismo orden en el que han sido declaradas.*/
    }

    /**
     * Test of ingresar method, of class CCuenta.
     */
    @Test
    public void testIngresarParametizado() throws Exception {
        System.out.println("ingresar");

        CCuenta instance = new CCuenta(nomCuenta, cuenta, saldo, interes);
        assertTrue("No se puede ingresar ", ingresar > 0);
        instance.ingresar(ingresar);
        /*El último 3 indica el némero de decimales que queremos que compare.
         Si no sepone, el assertEquals se tacha automaticamente.
         Esto pasa con los datos double.*/
        assertEquals("Operación de ingresar incorrecta", result1, instance.estado(), 3);
    }

    /**
     * Test of retirar method, of class CCuenta.
     */
    @Test
    public void testRetirarParametizado() throws Exception {
        System.out.println("retirar");
        CCuenta instance = new CCuenta(nomCuenta, cuenta, saldo, interes);
        instance.retirar(quitar);
        assertEquals("Fallo en el calculo",result2,instance.estado(),2);
        if(nomCuenta!="Juan lópez"){
      
        fail("Ese no es el nombre de la cuenta");
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testRetirarPrueba() throws Exception {
        System.out.println("retirarPrueba");
        CCuenta instance = new CCuenta("mi cuenta", "235677", 500, 0);
        float esperado=851;
        int resultado= instance.retirar(125);
        assertEquals("MAL",esperado,instance.estado(),0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
