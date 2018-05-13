/*
 2.Escribe un programa que visualice la suma de los 50 primeros números impares
 */
package ejercicio.pkg50primeros.numeros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class Ejercicio50PrimerosNumeros {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero1 = 1;
        int contador = 0;
        int suma = 0;
        int incremento = +2;

        while (contador < 50) {
            suma = suma + numero1;
            numero1 = numero1 + incremento;
            contador++;
        }
        System.out.println("Resultado= " + suma);

    }

}
