/*
1.Escribe un programa que pida un número y visualice en pantalla
dicho número indicando si positivo, negativo o nulo.
 */
package ejercicio.positivo.negativo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class EjercicioPositivoNegativo {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero1;
        int resultado;
        System.out.print("Introduce Número: ");
        numero1 = Integer.parseInt(teclado.readLine());

        if (numero1 > 0) {
            System.out.println("ES POSITIVO");
        } else if (numero1 < 0) {
            System.out.println("ES NEGATIVO");
        } else {
            System.out.println("ES NULO");
        }
    }
}
