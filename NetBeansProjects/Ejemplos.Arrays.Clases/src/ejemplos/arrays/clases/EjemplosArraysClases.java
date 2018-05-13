package ejemplos.arrays.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class EjemplosArraysClases {


    /*DECLARANDO ARRAY*/
    public static void main(String[] args) throws IOException {
        int[] dias;
        /*Es del tipo de la clase Alumno, por eso ponemos "Alumno"
         en vez de int, float, etc.*/
        /*En la siguiente línea creamos un objeto llamado "alumnos"
         para utilizar en arrays, por eso ponemos entre medias [] en vez
         de dejar un espacio*/
        Alumno[] alumnos;

        /*CREAR ARRAY*/
        dias = new int[12];
        dias[0] = 30;
        dias[1] = 10;
        dias[2] = 5;
        dias[3] = 13;
        try {
            System.out.println("Los días de la posición 0 es " + dias[0]);
            System.out.println("Los días de la posición 13 es " + dias[2]);
            System.out.println("Los días de la posición 13 es " + dias[13]);
        } catch (ArrayIndexOutOfBoundsException e) {
            /*Controla el error producido si se supera el número de posiciones*/
            System.out.println("No existe esa posición");
        }

        System.out.println("------------------------------------");
        int numAlumnos;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        System.out.print("Introduce número de elemenos de la array: ");
        numAlumnos = Integer.parseInt(teclado.readLine());
        /*En la línea anterior metemos pòr teclado el número de valores
         que va a tener el array.*/
        alumnos = new Alumno[numAlumnos];
        //alumnos=new Alumno[30];
        alumnos[0] = new Alumno("Mario", "7126897");
        /*En la línea anterior le damos un nombre y un DNi al alumno que está en la
         posición 0 del array.
         Lo que va entre los parentesis tiene que ir en el mismo orden en el que ha sido declarado
         en el contructor de la clase Alumno*/
        System.out.println(alumnos[0].getNombre() + " y su DNI es " + alumnos[0].getDni());

        System.out.println("------------------------------------");

        /*int posicion = 0;
         while (posicion < alumnos.length) {
         //En la siguiente línea  llamamos al constructor que no recibe nada
         //de la clase Alumno
         alumnos[posicion] = new Alumno();
         posicion++;
         }*/
        for (int posicion = 0; posicion < alumnos.length; posicion++) {
            alumnos[posicion] = new Alumno();
            /*Este System me muestra el valor de cada posicion del array*/
            System.out.println("Dato de la posición " + posicion + "= " + alumnos[posicion]);
        }

        System.out.println("------------------------------------");

        int[] dias_mes2 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        /*Estas dos formas hacen lo mismo*/
        int[] dias_mes = new int[12];
        /*Hacen referencia a los meses del año*/
        dias_mes[0] = 31;
        dias_mes[1] = 28;
        dias_mes[2] = 31;
        dias_mes[3] = 30;
        dias_mes[4] = 31;
        dias_mes[5] = 30;
        dias_mes[6] = 31;
        dias_mes[7] = 31;
        dias_mes[8] = 30;
        dias_mes[9] = 31;
        dias_mes[10] = 30;
        dias_mes[11] = 31;

        
        String[]parking;
        parking=new String[100];
        for(int nPlazas=0;nPlazas<parking.length;nPlazas++){
            parking[nPlazas]="Libre";
            System.out.println("PLAZA "+nPlazas+"= "+parking[nPlazas]);
        }
    }

}
