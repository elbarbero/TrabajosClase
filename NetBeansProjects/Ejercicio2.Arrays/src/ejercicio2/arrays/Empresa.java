/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.arrays;

//import Utilidades.Fechas;
import Utilidades.Numeros;
import Utilidades.Caracteres;

/**
 *
 * @author 203pc19
 */
public class Empresa {

    /*Conjunto de elementos donde cada elemento es de tipo Empleados*/
    Empleados[] empleado;
    int[] miTrienio;//Creamos el objeto array de tipo float

    /*No creamos una clase para trienios porque cada elemento
     coincide con la posición del array, entonces solo necesitamos saber el importe.
     El importe lo definimos en el método crearTrienios()*/
    public Empresa(int nEmple) {
        empleado = new Empleados[nEmple];
        crearEmpleados();
        crearTrienios();
    }

    public void crearEmpleados() {
        for (int nEmple = 0; nEmple < empleado.length; nEmple++) {
            empleado[nEmple] = new Empleados();
        }
    }

    public void crearTrienios() {
        /*Los primeros corchetes([]) son para definir un conjuntos y
         en las llaves ({}) definimos los valores.
         Es muy parecido al arrays.asList del JUnit*/
 /*Hemos puesto una posición de más para que coincida con la
         posición cero*/
        miTrienio = new int[]{0, 100, 250, 500, 600, 1200, 1500};
    }

    public void pedirDatos() {
        LasFechas fechaActual = new LasFechas();//Al dejar los parentesis vacios nos va a coger el contructor de la fecha actual de la clase LasFechas
        //System.out.println(fechaActual.visualizar()); //Esto me visualiza solo la fecha actual
        /*Creamos un objeto de tipo LasFechas que esta en dicha clase*/
        int d = 0, m = 0, a = 0;
        int resultado = 1;//Lo inciciamos a 1 para que entre en el while la primera vez
        Numeros numero = new Numeros();
        Caracteres caracter = new Caracteres();
        for (int nEmple = 0; nEmple < empleado.length; nEmple++) {
            /*Al dejar los parentesis de fechaAlta vacios nos va a coger el contructor de la
            fecha actual de la clase LasFechas, da igual porque luego le guardaremos la fecha introducida por el usuario*/
            LasFechas fechaAlta = new LasFechas();//Lo ponemos dentro del for para que no ponga la misma fecha para todos los empleados
            /*LasFechas fechaAlta = new LasFechas(10,5,2014);
            System.out.println(fechaAlta.visualizar()); Nos va mostrar lo que tengamos en los parentesis
            porque va a coger el constructor con las variables definidades entre los parentesis*/
            empleado[nEmple].setNombre(caracter.pedirString("Introdcir nombre: "));
            while (resultado == 1) {
                d = numero.pedirNumeroEntero("DÍA DE ALTA: ", 1, 31);
                m = numero.pedirNumeroEntero("MES DE ALTA: ", 1, 12);
                a = numero.pedirNumeroEntero("AÑO DE ALTA: ", 1900, 2100);
                /*Nos devuelve 1 si la fecha introducida no existe o si la fecha es mayor a la fecha actual.
                 por ejemplo, una fecha que no existe es 30-2-2017*/
                if (!(fechaAlta.comprobarFecha(a, m, d))) {//SI FECHAALTA ES FALSO...
                    /*fechaTra contiene la fecha que la comprueba para saber
                     si es correcta.
                     A este if solo entra si la fecha metida no existe, como por ejemplo,
                     32-5-2016*/
                    System.out.println("Esa fecha no existe");
                    resultado = 1;
                } else {
                    /*Llamamos al metodo de la clase LasFechas que te devuelve un
                     resultado 1 o -1. Con lo que se quedará en el while o saldrá de él*/
                    resultado = fechaAlta.compararFechas(fechaActual);
                }
            }
            empleado[nEmple].setF(fechaAlta);
            /*ponemos fechaAlta por es la que recoge la fecha del empleado*/
            resultado = 1;//Volvemos a poner 1 para que siga pidiendo empleados mientas no se cumpla el bucle for
        }
    }

    public void informe() {
        System.out.println("NOMBRE" + "\t" + "\t" + "FECHA DE ALTA" + "\t" + "\t" + "Nº TRIENIOS" + "\t" + "\t" + "IMPORTE");
        System.out.println("---------------------------------------------------------------------");
        int pos;
        for (int nEmple = 0; nEmple < empleado.length; nEmple++) {
            pos = empleado[nEmple].getF().calcularTrienios();/*ME DEVUELVE LA CANTIDAD DE TRIENIOS que coincide también
            // con la posición de los trienios, por eso no creamos la clase trienios*/
            if (pos > miTrienio.length) {
                /*Dentro de este if ponemos "pos>miTrienio.length" porque el array miTrienio va desde el 0 al 6,
                que aunque sean 7 posiciones en total, en el teclado solo van a ser del número 0 al 6 incluido.*/
                int trienio = miTrienio[miTrienio.length - 1];/*Restamos "-1" porque le decimos que:
                "miTrienio[7-1], es decir, el array miTrienio tiene 7 posiciones que van desde
                el 0 al 6, no existe el numero 7 porque sino tendríamos 8 posiciones.*/
                System.out.println(empleado[nEmple].getNombre() + "\t" + "\t" + empleado[nEmple].getF().visualizar() + "\t" + "\t" + pos + "\t" + "\t" + "\t" + trienio);
            } else {
                System.out.println(empleado[nEmple].getNombre() + "\t" + "\t" + empleado[nEmple].getF().visualizar() + "\t" + "\t" + pos + "\t" + "\t" + "\t" + miTrienio[pos]);
            }
        }
    }
}
