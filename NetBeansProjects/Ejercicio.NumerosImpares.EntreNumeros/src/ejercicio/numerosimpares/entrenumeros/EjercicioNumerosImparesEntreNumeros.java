/*
 2.1.Escribe un programa que visualice la suma de los números impares entre dos numeros
 */
package ejercicio.numerosimpares.entrenumeros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioNumerosImparesEntreNumeros {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero1, numero2;
        int suma = 0;
        int contador = 0;

        System.out.print("Introduce primer número: ");
        numero1 = Integer.parseInt(teclado.readLine());
        System.out.print("Introduce segundo número: ");
        numero2 = Integer.parseInt(teclado.readLine());

        if (numero2 % 2 == 0) {//Si numero2 es multiplo de 2
            numero2 = numero2 + 1;
        }
        else if (numero1 % 2 == 0) {//Si numero1 es multiplo de 2
            numero1 = numero1 + 1;
        }

        while (numero1 < numero2) {//mientras numero1 sea menor que numero2

            suma = suma + numero1;
            numero1 = numero1 + 2;
        }
        while(numero2<numero1){//mientras que numero2 sea mayor que numero1
            suma=suma+numero2;
            numero2=numero2+2;
        }

        System.out.println("La suma es " + suma);
    }

}
