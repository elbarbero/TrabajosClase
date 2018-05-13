/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio15.billetes.autobus2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Autobus {

    public int pedirPlazas(String mensaje, int limiteInferior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numPlazas = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                numPlazas = Integer.parseInt(teclado.readLine());
                if (numPlazas < limiteInferior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return numPlazas;
    }

    public int pedirBilletes(String mensaje, int limiteInferior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numBilletes = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                numBilletes = Integer.parseInt(teclado.readLine());
                if (numBilletes < limiteInferior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return numBilletes;
    }

    public int pedirEdad(String mensaje, int limiteInferior, int limiteSuperior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int edad = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                edad = Integer.parseInt(teclado.readLine());
                if (edad < limiteInferior || edad > limiteSuperior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return edad;
    }
}
