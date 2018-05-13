/*8.Realiza un programa que introduzca una serie de notas de forma
 alfabética por teclado (IN,SF,B,N,SB) de una clase de 50 alumnos.
 Finalizada la entrada de datos visualizar la nota media de esa clase. 
 */
package ejercicio.media.notas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioMediaNotas {

    public static void main(String[] args) throws IOException {

        double nota=(double)Math.random()*9.5;//genera valores decimales aleatorio del 0 al 9.5
        int contador = 0;
        double media;
        String IN = "4.0";
        String SF = "5.5";
        String B = "6.5";
        String N = "8.0";
        String SB = "9.5";
        String notas = "";
        double suma = 0;
        EjercicioMediaNotas objeto = new EjercicioMediaNotas();
       notas = objeto.pedirNota();
        while (contador < 10) {
            notas = objeto.pedirNota();
            if (notas.compareToIgnoreCase("IN") == 0) {
                System.out.println("Has sacado un " + IN);
                suma = suma + 4;
            } else if (notas.compareToIgnoreCase("SF") == 0) {
                System.out.println("Has sacado un " + SF);
                suma = suma + 5.5;
            } else if (notas.compareToIgnoreCase("B") == 0) {
                System.out.println("Has sacado un " + B);
                suma = suma + 6;
            } else if (notas.compareToIgnoreCase("N") == 0) {
                System.out.println("Has sacado un " + N);
                suma = suma + 8;
            } else {
                System.out.println("Has sacado un " + SB);
                suma = suma + 9.5;
            }

            contador++;
        }

        media = suma / contador;
        System.out.println("La nota media es "+media);
    }

    public String pedirNota() {
        String notas = "";
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        try {
            System.out.print("Introduce nota (IN, SF, B, N, SB): ");
            notas = teclado.readLine();
            while (notas.compareToIgnoreCase("In") != 0
                    && notas.compareToIgnoreCase("sf") != 0
                    && notas.compareToIgnoreCase("b") != 0
                    && notas.compareToIgnoreCase("n") != 0
                    && notas.compareToIgnoreCase("sb") != 0) {

                System.out.print("Introduce nota (IN, SF, B, N, SB): ");
                notas = teclado.readLine();
            }
        } catch (IOException ex) {
        }
        return notas;
    }
}
