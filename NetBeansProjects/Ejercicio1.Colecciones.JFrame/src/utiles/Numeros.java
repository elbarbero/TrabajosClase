/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Admin
 */
public class Numeros {

    public int pedirNumeroEntero(String mensaje) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(teclado.readLine());
                mal = false;

            } catch (NumberFormatException ex) {
                System.out.println("debe ser un numero");
            } catch (IOException ex) {
            }
        }
        return numero;
    }

    public int pedirnumeroEntero(String mensaje, int limiteInferior) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(teclado.readLine());
                if (numero < limiteInferior) {
                    System.out.println("debe ser un numero");
                } else {
                    mal = false;
                }

            } catch (NumberFormatException ex) {
                System.out.println("debe ser un numero");
            } catch (IOException ex) {
            }
        }
        return numero;
    }

    public int pedirnumeroEntero(String mensaje, int limiteInferior, int limiteSuperior) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(teclado.readLine());
                if (numero < limiteInferior || numero > limiteSuperior) {
                    System.out.println("el valor debe estar comprendido entre " + limiteInferior + " y " + limiteSuperior);
                } else {
                    mal = false;
                }

            } catch (NumberFormatException ex) {
                System.out.println("debe ser un numero");
            } catch (IOException ex) {
            }
        }
        return numero;
    }
}