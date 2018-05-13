/*
 7.Programa que lea números y acepte únicamente aquellos
 números que sean mayores que el último dado correctamente.
 El programa terminará cuando se introduzca cero.
 Al final se dirá cuántos errores se han cometido.
 */
package ejercicio.mayor.kanterior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioMayorKanterior {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero;
        int contador = 0;
        int min = Integer.MIN_VALUE;//previamente hay que asignar un valor al minimo
        System.out.print("INSERTE NUMERO: ");
        numero = Integer.parseInt(teclado.readLine());
        min = -1;//previamente hay que asignar un valor al minimo

        while (numero != 0) {//Mientras sea distinto de cero

            if (numero > min) {//mayor que el minimo
                min = numero;
                System.out.println("CORRECTO");
            } else if (numero <= min && numero != 0) {//Menor que el minimo valor 
                //contador = contador + 1;
                contador++;//Es igual que un contador
                System.out.println("ERROR");
            }
            System.out.print("INSERTE NUMERO: ");
            numero = Integer.parseInt(teclado.readLine());
        }//FIN DEL WHILE
        System.out.println("ERRORES TOTALES: " + contador);
    }

}
