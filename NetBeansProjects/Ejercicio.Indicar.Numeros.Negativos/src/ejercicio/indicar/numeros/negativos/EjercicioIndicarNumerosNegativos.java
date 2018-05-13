/*
3.Escribe un programa que pida diez números. Al finalizar
indicará si se ha introducido algún número negativo.
 */
package ejercicio.indicar.numeros.negativos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class EjercicioIndicarNumerosNegativos {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero1;
        int contador = 0;//para que cuente los numeros positivos
        int contador2 = 0;//para que cuente los numeros negativos
        System.out.print("Introduce Número: ");
        numero1 = Integer.parseInt(teclado.readLine());
        contador = contador + 1;

        while (contador != 10) {//mientras sea diferente de 10
            if (numero1 >= 0) {//mayor que cero
                contador = contador + 1;
            } else {
                contador2 = contador2 + 1;
                contador = contador + 1;
            }
            System.out.print("Introduce Número: ");
            numero1 = Integer.parseInt(teclado.readLine());
        }
        if(contador2>0){
            System.out.println("Si que hay números negativos");
            System.out.println("Total De Numeros Negativos: " + contador2);
        }
    }

}
