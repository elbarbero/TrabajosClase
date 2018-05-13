package ejercicio.dias.semana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class EjercicioDiasSemana {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int dia;
        System.out.println("INTRODUCE DEL 1 AL 7: ");
        dia = Integer.parseInt(teclado.readLine());

        if (dia >= 1 && dia <= 7) {
            switch (dia) {
                case 1:
                    System.out.println("LUNES");
                    break;
                case 2:
                    System.out.println("MARTES");
                    break;
                case 3:
                    System.out.println("MIERCOLES");
                    break;
                case 4:
                    System.out.println("JUEVES");
                    break;
                case 5:
                    System.out.println("VIERNES");
                    break;
                case 6:
                    System.out.println("SABADO");
                    break;
                case 7:
                    System.out.println("DOMINGO");
                    break;
            }

        } else {

            System.out.println("DATO ERRONEO");
        }

    }
}
