/*
10.Realiza un programa para calcular el factorial de un número.
Un numero factorial es 5!=1*2*3*4*5=120
 */
package ejercicio.factorial.numero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioFactorialNumero {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero;
        double resultado;
        int contador = 0;
        System.out.print("Introduce número: ");
        numero = Integer.parseInt(teclado.readLine());

            contador++;
            resultado=1*contador;

        while (contador < numero) {
            contador++;
            resultado = resultado * contador;
        }
        System.out.println("Factorial de " + numero + "! es " + resultado);
    }

}
