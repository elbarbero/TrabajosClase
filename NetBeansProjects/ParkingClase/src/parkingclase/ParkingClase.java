package parkingclase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import numeros.Numeros;

/**
 * Clase principal
 */
public class ParkingClase {

    /**
     * Metodo Principal
     *
     * @param args argumrentos de entrada
     * @throws IOException excepcion de E/S
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);

        System.out.println("Numero de plazas: ");
        int numeroPlazas = Integer.parseInt(teclado.readLine());
        Parking parkingDam = new Parking(numeroPlazas);
        ParkingClase objeto = new ParkingClase();
        int opcion;
        /*Numeros es el nombre de una clase importada de un archivo.jar*/
        Numeros objeto2 = new Numeros();
        objeto.menu();
        opcion = objeto2.pedirNumeroEntero("PULSE OPCION: ", 1, 4);
        while (opcion != 4) {
            switch (opcion) {

                case 1:
                    parkingDam.entrada();
                    break;
                case 2:
                    parkingDam.salidaAutomoviles();
                    break;
                case 3:
                    parkingDam.verSituacion();
                    break;
            }
        }
    }

    public void menu() {
        System.out.println("Menu de opciones");
        System.out.println("1. ENTRADA");
        System.out.println("2. SALIDA");
        System.out.println("3. INFORME");
        System.out.println("4. FIN");
    }

}
