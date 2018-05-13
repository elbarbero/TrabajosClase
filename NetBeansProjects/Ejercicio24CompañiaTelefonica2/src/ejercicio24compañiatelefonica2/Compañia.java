/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio24compañiatelefonica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class Compañia {
    
    public String pedirOperador()throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String operador = "";
        boolean correcto = false;
        try {
            System.out.println("MOVISTAR(m), VODAFONE(v), OTRAS(o)");
            System.out.print("Introduce operador: ");
            operador = teclado.readLine();
            if (operador.compareToIgnoreCase("m") != 0 && operador.compareToIgnoreCase("v") != 0
                    && operador.compareToIgnoreCase("o") != 0 && operador.compareTo("*") != 0) {
                System.out.print("ERROR");
            } else {
                correcto = true;
            }
        } catch (IOException ex) {
        }
        return operador;
    }
    
      public String pedirContrato() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String contrato = "";
        try {
            System.out.print("Contrato o tarjeta (T o C): ");
            contrato = teclado.readLine();
            while (contrato.compareToIgnoreCase("T") != 0 && contrato.compareToIgnoreCase("C") != 0) {
                System.out.print("Vuelve a introducir tipo de contrato: ");
                contrato = teclado.readLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR I/O");

        }
        return contrato;
    }
}
