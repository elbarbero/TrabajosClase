package ejercicio.notas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class EjercicioNotas {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        double nota;
        System.out.print("INTRODUCE NOTA: ");
        nota = Double.parseDouble(teclado.readLine());
        if (nota < 0 || nota > 10) {
            System.out.println("DATO INCORRECTO");
        } else {
            if ( nota < 5) {
                System.out.println("SUSPENSO");
            } else if ( nota <6) {
                System.out.println("SUFICIENTE");
            } else if (nota < 9) {
                System.out.println("NOTABLE");
            } else {
                
                    System.out.println("SOBRESALIENTE");
                

            }

        }
    }
}
