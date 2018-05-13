package ejercicio4.arrays.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que gestiona las plazas de un parking
 *
 * @author 203pc19
 */
public class Garaje {

    /**
     * Array que gestiona las plazas del parking
     */
    public String[] plazas;
    //int np;

    /**
     * Constructor por defecto que inicializa el parking a 100 plazas
     */
    public Garaje() {
        /*En este método no recibo nada y le meto las plazas del parking*/
        plazas = new String[100];
        inicializar();
    }

    /*En ambos casos lo incializo con ell método incializar() para cambiar
     lo queremos que nos muestre por defecto*/
    /**
     * Constructor definido por el usuario. Especifica el número de plazas que
     * va a disponer
     *
     * @param numPlazas Número de plazas de las que va a disponer el parking
     */
    public Garaje(int numPlazas) {
        /*En este método recibo las plazas del parking a traves de la variable "numPlazas"*/
        plazas = new String[numPlazas];
        inicializar();
    }

    private void inicializar() {
        /*Dentro de este método voy a modificar la propiedad plazas.
         Creamos este método para que lo valores por defecto del String sea "LIBRE" en lugar de nulo(null)*/
        for (int np = 0; np < plazas.length; np++) {
            plazas[np] = "LIBRE";
        }
    }

    public void verSituacion() {
        for (int np = 0; np < plazas.length; np++) {
            /*Bucle que recorre las plazas que existen en el parking*/
            System.out.println("PLAZA " + np + "= " + plazas[np]);
        }
    }

    public int entrada() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        //int np;
        System.out.print("¿Qué plaza quieres? ");
         int np = Integer.parseInt(teclado.readLine());

        if (np < 0 || np >= plazas.length) {
            System.out.println("No se le puede asignar una plaza");
        } else {
            plazas[np] = "OCUPADA";
        }
        return np;
    }

    public int BusquedaSecuencial() {
       int np=0;
       boolean encontrado=false;
       while(!encontrado&&np<plazas.length){
           if(plazas[np].equals("LIBRE")){
               encontrado=true;
           }else{
               np++;
           }
       }
        return -1;
    }

    /**
     * Método que devuelve la situación de cada una de las plazas
     *
     * @return array de la situación de las plazas
     */
    public String[] getPlazas() {
        return plazas;
    }

}
