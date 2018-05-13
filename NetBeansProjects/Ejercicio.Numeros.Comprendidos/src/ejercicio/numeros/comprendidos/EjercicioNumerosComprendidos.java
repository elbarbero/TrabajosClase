/*Realiza un programa que introduzca los números comprendidos en el 1 y 10000.
El proceso consiste que nos diga cual es el número mayor y elmenor o bien si
ambos números son iguales. Además deberá visualizar el número de digitos que
tiene cada númer.*/

package ejercicio.numeros.comprendidos;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EjercicioNumerosComprendidos {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        EjercicioNumerosComprendidos objeto = new EjercicioNumerosComprendidos();
        int numA = 0, numB = 0;
        int digitA = 0, digitB = 0;
        /*En el numA no se pone el objeto delante del método poque el método
        está dentro de la misma clase y es "public static int...".
        Para pedir el numB si ponemos el objeto porque el método no es estatico.
        Solo se puede hacer con métodos que estén en la misma clase.*/
        numA = pedirNumeroA("Introduce número A: ", 1, 9999);
        numB = objeto.pedirNumeroB("Introduce número B: ", 1, 9999);
        if (numA > numB) {
            System.out.println("El número mayor es " + numA);
            System.out.println("El número menor " + numB);
        }else if(numB > numA){
            System.out.println("El número mayor es " + numB);
            System.out.println("El número menor " + numA);
        }
        if (numA == numB) {
            System.out.println("Los números son iguales");
        }
        while (numA > 0) {//para saber cuantas cifras tiene el numero.
            numA = numA / 10;
            digitA = digitA + 1;
        }
        while (numB > 0) {
            numB = numB / 10;
            digitB = digitB + 1;
        }
        System.out.println("El número A tiene " + digitA + " cifras");
        System.out.println("El número B tiene " + digitB + " cifras");
    }

    public static int pedirNumeroA(String mensaje, int limiteInferior, int limiteSuperior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(teclado.readLine());
                if (numero < limiteInferior || numero > limiteSuperior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR. NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return numero;
    }

    public int pedirNumeroB(String mensaje, int limiteInferior, int limiteSuperior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(teclado.readLine());
                if (numero < limiteInferior || numero > limiteSuperior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR. NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return numero;
    }
}

