/*
9.Realiza un programa que devuelva el máximo común divisor de
dos números utilizando el algoritmo de Euclides.(mcd(a,b)=mcd(b,a%b))
 */
package maximo.comun.divisor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximoComunDivisor {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int a, b, cociente;
        int resto = 1;

        System.out.print("Introduce numero: ");
        a = Integer.parseInt(teclado.readLine());
        System.out.print("Introduce numero: ");
        b = Integer.parseInt(teclado.readLine());

        while (resto != 0) {
            resto = a % b;//para saber el resto de la division de a entre b
            a = b;
            b = resto;
        }
        System.out.println("El m.c.d. es " + a);
    }
}
