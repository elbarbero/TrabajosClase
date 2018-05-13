package ejercicio24.compañia.telefonica3;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Compañia {

    private int nContrato;
    private int nTarjeta;
    private String nombre;
    /*Toda clase tiene que tener al menos un constructor.
     Si no se pone nada, java pone uno por defecto*/

    public Compañia(String nombre) {
        /*Este public se llama como la clase.
         Este public es un constructor. de la clase Compañia*/
        this.nombre = nombre;
        /*Se pone this. para que coga el dato de fuera del metodo.
         el this. trabaja con una propiedad de esa clase.*/
    }

    public void actualizarContrato() {
        nContrato++;
    }

    public void actualizarTarjeta() {
        nTarjeta++;
    }

    public int totalTelefonos() {
        int total;
        total = nContrato + nTarjeta;
        return total;
    }

    public String Visualizar() {
        return nombre + "\t" + nContrato + "\t" + nTarjeta + "\t" + totalTelefonos();
    }

    /*Los set sirven para modificar un dato de la clase*/
    public void setContrato(int contrato) {
        this.nContrato = contrato;
    }

    public void setTarjeta(int tarjeta) {
        this.nTarjeta = tarjeta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*Encapsular los getter es ponerles un acceso private.
     Si las variables no las tienes puestas como private y,
     das a encapsular campos, java te pone private automaticamente*/
    public int getContrato() {
        return nContrato;
    }

    public int getTarjeta() {
        return nTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

}//FIN CLASE COMPAÑIA
