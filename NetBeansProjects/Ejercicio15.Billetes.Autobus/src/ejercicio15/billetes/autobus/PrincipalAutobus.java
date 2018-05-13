/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio15.billetes.autobus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class PrincipalAutobus {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numBilletes, tipoBillete;
        float importe;
        Autobus autobus1;
        //Autobus es el nombre de la segunda clase y autobus1 es el objeto
        autobus1 = new Autobus(60, 0, 0.25f, 0.5f, 1);//60 es el numero de plazas totales
        //el resto son el precio de las tarifas
        //se pone "f" detras del numero para pasar el numero a float
        while (autobus1.plazasDisponibles() > 0) {
            System.out.print("Número de billetes: ");
            numBilletes = Integer.parseInt(teclado.readLine());
            if (numBilletes > autobus1.plazasDisponibles()) {
                System.out.println("No tengo tantas plazas");
            } else {
                System.out.print("Introduce el tipo de tarifa: ");
                tipoBillete = Integer.parseInt(teclado.readLine());
                importe = autobus1.ventaBilletes(numBilletes, tipoBillete);
                System.out.println("El importe de la venta es " + importe);
            }
        }
        System.out.println("0-6 años/t"+autobus1.getPlazasOcu1()+autobus1.recaudacion1());

    }
}
