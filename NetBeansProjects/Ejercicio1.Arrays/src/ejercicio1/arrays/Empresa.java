/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.arrays;

import Utilidades.Numeros;
import Utilidades.Caracteres;
import Utilidades.Fechas;

/**
 *
 * @author 203pc19
 */
public class Empresa {

    Vendedor[] empleados;
    Comision[] tablaComisiones;
    Fechas f;

    public Empresa(int numEmple) {
        empleados = new Vendedor[numEmple];
        crearVendedores();
        tablaComisiones = new Comision[5];
        crearComisiones();
    }

    /*En el siguiente constructor ponemos un numero en array empleados, eso quiere decir que introduciremos 5 empleados.
     Si creamos este constructor no es necesario ponemos el numero de empleados en la clase Main.
     Si no le creamo, estamos obligados a poner el numero de empleados en la clase Main*/
 /* public Empresa() {
     empleados = new Vendedor[7];
     crearVendedores();
     tablaComisiones = new Comision[5];
     crearComisiones();
     }*/
    private void crearVendedores() {
        for (int nEmple = 0; nEmple < empleados.length; nEmple++) {
            empleados[nEmple] = new Vendedor();
        }
    }

    private void crearComisiones() {
        tablaComisiones[0] = new Comision(10000, 0.05f);
        tablaComisiones[1] = new Comision(15000, 0.10f);
        tablaComisiones[2] = new Comision(20000, 0.15f);
        tablaComisiones[3] = new Comision(25000, 0.20f);
        tablaComisiones[4] = new Comision(Float.MAX_VALUE, 0.25f);
        /*El "Float.MAX_VALUE" indica que el máximo valor, es decir, en este caso, 
         que el límite va des el máximo de la comision anterior hasta el maximo valor que 
         le queramos meter (sin limite establecido)*/
    }

    public void ventasVendedores() {
        Numeros numero = new Numeros();
        Caracteres caracter = new Caracteres();
        float importe;
        /*Habrá tantos códigos de empleado como tan largo sea el array, es decir,
         si el aray tiene 3 valores, los codigos del empleado van desde el 0 hasta el 2.*/
        int numVendedor = numero.pedirNumeroEntero("Introducir código del Vendedor: ", 0, empleados.length-1);
        while (numVendedor != -1) {
            importe = numero.pedirNumeroEntero("Introducir importe: ", 0);
            //busquedaComision(importe);
            empleados[numVendedor].acumularVentas(importe);
            numVendedor = numero.pedirNumeroEntero("Introducir código del Vendedor: ", -1, empleados.length-1);
            //numVendedor = numero.pedirNumeroEntero("Introducir código del Vendedor: ", -1);
        }
        // informe();
    }

    public void pedirDatos() {
        Numeros numero = new Numeros();
        Caracteres caracter = new Caracteres();
        for (int nEmple = 0; nEmple < empleados.length; nEmple++) {
            // while (empleados[nEmple].getCodigoVendedor() != -1) {
            empleados[nEmple].setNombre(caracter.pedirString("Introduce nombre: "));
        }
    }

    /**
     * Compra las ventas para averiguar cual es la menor comisión
     */
    public void menorComisiones() {
        String nombreMenor = "";
        int posMenor = 0;//PARTIMOS DESDE LA POSICION CERO DEL ARRAY
        for (int nEmple = 1; nEmple < empleados.length; nEmple++) {
            if (empleados[nEmple].getVentas() < empleados[posMenor].getVentas()) {
                //SI LAS VENTAS EL EMPLEADO ES MENOR QUE LA POSICION CERO DEL ARRAY
                posMenor = nEmple;//ME PODIFICA LA POSICION DE PARTIDA POR LA POSICION DEL EMLEADO CON MENOS VENTAS
            }
        }
        nombreMenor = empleados[posMenor].getNombre();
        System.out.println("Con menos comisión: " + nombreMenor);
    }

    /**
     * Compra las ventas para averiguar cual es la mayor comisión
     */
    public void mayorComisiones() {
        String nombreMayor = "";
        int posMayor = 0;
        for (int nEmple = 1; nEmple < empleados.length; nEmple++) {
            if (empleados[nEmple].getVentas() > empleados[posMayor].getVentas()) {
                posMayor = nEmple;
            }
        }
        nombreMayor = empleados[posMayor].getNombre();
        System.out.println("Con más comisión: " + nombreMayor);
    }

    /**
     * Método que busca la posición de la comisión dependiendo del valor de las
     * ventas
     * @param ventas el valor de las ventas de cada vendedor
     * @return devuelve la posicón que ocupa en el array
     */
    private int busquedaComision(float ventas) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < tablaComisiones.length) {
            if (ventas <= tablaComisiones[pos].getImporteHasta()) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return pos;
    }

    public void informe() {
        f=new Fechas();
        System.out.println("------------------"+f.visualizar()+"--------------------");//TE DA LA FECHA ACTUAL
        System.out.println("NOMBRE" + "\t" + "\t" + "IMPORTE VENTAS" + "\t" + "\t" + "IMPORTE COMISIÓN");
        System.out.println("---------------------------------------------------------");
        for (int numEmple = 0; numEmple < empleados.length; numEmple++) {
            int posicion = busquedaComision(empleados[numEmple].getVentas());//RECOGE LA POSICIÓN DE LAS VENTAS DE CADA VENDEDOR
            System.out.println(empleados[numEmple].getNombre() + "\t" + "\t"
                    + empleados[numEmple].getVentas() + "\t" + "\t" + "\t"
                    + empleados[numEmple].CalcularComision(tablaComisiones[posicion].porcentaje));
            /*Ponemos la variable "posicion" entre los corchetes porque dicha variable ya recoge las ventas de cada vendedor*/
        }
        menorComisiones();
        mayorComisiones();
    }
}
