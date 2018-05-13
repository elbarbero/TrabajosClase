/**
 * Calcúlese la suma de n números dados por teclado, de manera que los pares lo
 * suma y los impares los reste. Si el número dado es cero, terminará el
 * programa sacando por pantalla el resultado.
 */
package ejercicio.suma.pkgwhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class EjercicioSumaWhile {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero;
        int resultado=0;
        System.out.print("INSERTE NÚMERO: ");
        numero = Integer.parseInt(teclado.readLine());

        while (numero != 0)//mientras sea distinto de cero
        {//INICIO WHILE
            if (numero % 2 == 0) {//si es par...
                resultado = numero + resultado;
            } else {//pero si es impar...
                resultado = resultado - numero;
            }
                System.out.print("INSERTE NÚMERO: ");
                numero = Integer.parseInt(teclado.readLine());
        }//FIN WHILE
        System.out.println("RESULTADO= " + resultado);
    }
}
