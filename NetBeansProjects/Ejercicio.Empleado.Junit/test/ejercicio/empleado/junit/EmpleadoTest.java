/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.empleado.junit;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Mario
 */
@RunWith(Parameterized.class)
public class EmpleadoTest {

    float neto;
    float bruto;
    float resultado;
    float resultado2;
    String categoria;
    float totalHorasExtras;
    float ventasMes;

    public EmpleadoTest(float bruto,String categoria, float totalHorasExtras, float ventasMes, float resultado, float resultado2) {
        //this.neto = neto;
        this.bruto = bruto;
        this.categoria = categoria;
        this.totalHorasExtras = totalHorasExtras;
        this.ventasMes = ventasMes;
        this.resultado = resultado;
        this.resultado2 = resultado2;
    }

    @Parameterized.Parameters
    /*Le estoy diciendo todo el conjunto de datos que tengo que tener en cuenta para poder funcionar*/
    public static Collection<Object[]> numeros() {
        /*Lo que va entre los parentesis son los datos de bruto,categoría,horas extra,ventaMes,resultadoBruto y resultadoNeto en ese orden.
         Entre los parentesis tiene que haber tantos datos como variables declaradas,*/
        return Arrays.asList(new Object[][]{{1230,"vendedor", 3, 1300, 803f, 1033.9f}, {1336,"encatrgado", 1, 1600, 1601, 1042.3f}, {1503,"vendedor", 5, 1550, 924, 1232}});
        /*Dentro del Arrays.list tengo que poner todos los datos con los que tengo que realizar la prueba.
        Se tienen que poner en el mismo orden en el que han sido declaradas.*/
    }

    /**
     * Test of CalculaSalarioBruto method, of class Empleado.
     */
    @Test
    public void testCalculaSalarioBruto() throws Exception {
        Empleado instance = new Empleado();
        float result = instance.CalculaSalarioBruto(categoria, totalHorasExtras, ventasMes);
        assertEquals("Fallo en la operación", resultado, result, 0.0);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CalculaSalarioNeto method, of class Empleado.
     */
    @Test
    public void testCalculaSalarioNeto() throws Exception {
        Empleado instance = new Empleado();
        float result = instance.CalculaSalarioNeto(bruto);
        assertEquals("Fallo en el calculo",resultado2,result,2);
        // El 2 indica el número de cifras que queremos que compare.
        //fail("The test case is a prototype.");
    }

}
/*Poner assertTrue y pruebas parametizadas*/
/*No me compara los decimales*/
