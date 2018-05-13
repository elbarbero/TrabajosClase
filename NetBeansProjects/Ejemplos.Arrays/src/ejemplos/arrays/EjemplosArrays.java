/*Ejemplos con Arrays */
package ejemplos.arrays;

/**
 *
 * @author Mario
 */
public class EjemplosArrays {

    public static void main(String[] args) {
        int sumaMatriz;
        /*Donde el "int" es el tipo de dato de la matriz.
        Donde "mi_matriz" es el nombre de la matriz (Se puede poner cualquier otro).
        Donde "[5]" es el número de valores que almacenará la matriz.*/
 /*Solo puede haber una matriz con el mismo nombre*/
        System.out.println("PRIMER ARRAY");
        int[] mi_matriz = new int[5];

        /*A continuación, vamos a almacenar en su interior los distintos
        valores de tipo entero. Empieza siempre en la pisición 0 y en este caso hasta la 4.
        un total de 5 posición*/
        mi_matriz[0] = 5;
        mi_matriz[1] = 10;
        mi_matriz[2] = 15;
        mi_matriz[3] = 20;
        mi_matriz[4] = 25;

        /*En cada system mandamos que muestre en pantalla el valor de cada posicion*/
        System.out.println(mi_matriz[0]);
        System.out.println(mi_matriz[1]);
        System.out.println(mi_matriz[2]);
        System.out.println(mi_matriz[3]);
        System.out.println(mi_matriz[4]);

        /*Lo siguiente es un bucle for. Sirve para que el programa repita algo
        hasta el limite que le pongamos.
        Primero tenemos que poner el tipo de datos que queremos que repita (int,float,double,...).
        Le decimos que empieze desde la posición 0 (se puede poner cualquier letra o nombre, en este caso he utilizado la i).
        A continuación, le tenemos que poner la condición del bucle,
        hasta donde queremos que vaya la "i".
        Como tenemos desde la posición 0 hasta la posición 4, ambas iclusive,
        tendremos que poner que i<5.
        Por último ponemos que la "i" incremente en 1 la posición hasta que sea
        la posición 4 (i=4).*/
        for (int i = 0; i < 5; i++) {
            System.out.println("Valor del índice " + i + " = " + mi_matriz[i]);
        }

        /*int mi_matriz123[]=new int[5];
        Esta es otra forma de declarar un array*/
        System.out.println("------------------------------------------------");
        System.out.println("SEGUNDA ARRAY");
        /*Otra forma de decalarar una matriz. En esta forma los valores
         se declaran en la misma línea. Ocupando la posición 0 hasta la posición que sea,
         leyendose de izquierda a derecha.*/
        int[] mi_matriz2 = {5, 23, 41, -61, 8, 345, 11};

        for (int i = 0; i < 7; i++) {
            System.out.println("Valor del índice " + i + " = " + mi_matriz2[i]);
        }

        System.out.println("------------------------------------------------");
        System.out.println("TERCERA ARRAY");
        int[] mi_matriz3 = {5, 23, 41, 1, 46, 90 - 61, 8, 11, -9, 23};
        /*De esta forma, utilizando la propiedad length del objeto array (mi_matriz3),
            Esta propiedada nos devuelve la longitud de la matriz, la última posición.
            Esto es muy util cuando tienes muchos elementos dentro la matriz*/
        for (int i = 0; i < mi_matriz3.length; i++) {
            System.out.println("Valor del índice " + i + " = " + mi_matriz3[i]);
        }
        /*De esta forma se suman valores de una matriz (array).
        Se pone el nombre de la matriz y la posición que ocupa el valor en la matriz.*/
        sumaMatriz=mi_matriz[2]+mi_matriz2[1];
        System.out.println(sumaMatriz);
    }

}
