/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.entornos.junit;

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
public class ArticuloTest {

    String codBarras;
    String denominacion;
    int existencias;
    int existenciasMinimas;
    float precioVenta;
    int cantidad;
    float precioCompra;
    boolean comprar;

    public ArticuloTest(int existencias, int existenciasMinimas, float precioVenta, int cantidad, float precioCompra, boolean comprar) {
        this.existencias = existencias;
        this.existenciasMinimas = existenciasMinimas;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.comprar = comprar;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> incializar() {
        return Arrays.asList(new Object[][]{{11, 10, 5, 15, 3, true}, {2, 4, 6, 9, 3, false}, {11, 45, 3, 4, 10, true}});
    }

    @Test
    public void testAvisoCompra() {
        System.out.println("TestAvisoCompra");
        Articulo instance = new Articulo(10, 12, 12f);
        // boolean esperado = false;
        boolean resultado = instance.avisoCompra();
        // assertEquals("ERROR", esperado, resultado);
        assertTrue("ERROR", resultado);
    }

    @Test
    public void testRecepcionMercancias() {
        System.out.println("TestrecepcionMercancias");
        Articulo instance = new Articulo(12, 10, 10f);
        int esperadoExistencias = 20;
        float espradoPrecio = 11f;
        instance.recepcionMercancias(8, 10f);
        assertEquals("ERROR EXISTENCIAS", esperadoExistencias, instance.existencias);
        assertEquals("ERROR PRECIO", espradoPrecio, instance.precioVenta, 0.0);
    }

    @Test
    public void ParamRecepcionMecanciasParam() {
        System.out.println("Parametizado");
        Articulo instance = new Articulo(existencias, existenciasMinimas, precioVenta);
        instance.recepcionMercancias(cantidad, precioCompra);
        assertEquals("Mal", precioVenta, instance.precioVenta, 0.0);
        int sumaExist = existencias + cantidad;
        assertEquals("Mal", sumaExist, instance.existencias);
    }
}
