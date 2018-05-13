/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.tema3.junit;

import java.io.IOException;

/**
 *
 * @author 203pc19
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException,Exception {
        CCuenta miCuenta;
        double saldoActual;

        miCuenta = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);

        miCuenta.retirar(-2300);

        System.out.println("Ingreso en cuenta");
        miCuenta.ingresar(1695);
        saldoActual = miCuenta.estado();
        System.out.println("El saldo actual es " + saldoActual);
    }

}
