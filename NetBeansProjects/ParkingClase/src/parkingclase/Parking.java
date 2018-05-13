package parkingclase;

import numeros.Numeros;

/**
 *
 * @author Mario
 */
public class Parking {

    /**
     *
     * Array que contiene la situacion de cada una de las plazas
     */
    public String[] plazas;

    public Parking() {
        plazas = new String[100];
        inicializar();
    }

    /**
     * Constructor definido por el usuario.Especifica en numero de plazas que va
     * a disponer
     *
     * @param numeroPlazas Numero de plazas que va a disponer.
     */
    public Parking(int numeroPlazas) {
        plazas = new String[numeroPlazas];
        inicializar();
    }

    /**
     * Inicializa todas las plazas al estado Libre.
     */
    private void inicializar() {
        for (int np = 0; np < plazas.length; np++) {
            plazas[np] = "LIBRE";
        }
    }

    /**
     * Visualiza el estado de todas las plazas.
     */
    public void verSituacion() {
        /*bucle que recorre
         las plazas que existen en el parking.*/
        for (int np = 0; np < plazas.length; np++) {
            System.out.println(np + "->" + plazas[np]);
        }
    }

    public void entrada() {
        int np;
        np = busquedaPlaza();//Busqueda de la plaza.
        if (np == -1) {
            System.out.println("no se le puede asignar una plaza.PARKING COMPLETO");
        } else {
            plazas[np] = "Ocupada";
            System.out.println("La plaza asignada es: " + np);
        }
    }

    public String[] getPlazas() {
        return plazas;
    }

    /**
     * Metodo que busca la primera plaza libre.
     *
     * @return la posicion donde encuentra la primera plaza libre -1 en el caso
     * de que parking este completo
     */
    private int busquedaPlaza() {
        boolean encontrado = false;
        int nPlaza = 0;
        while (!encontrado && nPlaza < plazas.length) {
            if (plazas[nPlaza].equalsIgnoreCase("libre")) {
                encontrado = true;
            } else {
                nPlaza++;
            }
        }
        if (!encontrado) {
            nPlaza = -1;
        }
        return nPlaza;
    }

    public void salidaAutomoviles() {
        int nPlaza;
        /*Numeros es el nombre de una clase importada de un archivo.jar*/
        Numeros objeto = new Numeros();
        nPlaza = objeto.pedirNumeroEntero("introduce el numero de plaza", 0, plazas.length - 1);

        if (plazas[nPlaza].equalsIgnoreCase("libre")) {
            System.out.println("esa plaza ya estaba libre");
        } else {
            plazas[nPlaza] = "libre";
            System.out.println("Plaza liberada");
        }
    }
}
