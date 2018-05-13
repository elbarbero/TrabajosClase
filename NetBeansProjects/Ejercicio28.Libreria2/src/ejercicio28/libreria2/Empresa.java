package ejercicio28.libreria2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class Empresa {
    /*Se pone en nombre de la clase donde se han declarado sus propiedades
     y el nombre que le ponemos el objeto.*/
    /*Libro1 y libro2 es de tipo tipoLibro, el nombre de la clase.*/

    private TipoLibro libro1;
    private TipoLibro libro2;
    private TipoLibro total;

    public Empresa() {
        libro1 = new TipoLibro("Informatica");
        libro2 = new TipoLibro("Economia");
    }

    public Empresa(String infor, String econ) {
        libro1 = new TipoLibro(infor);
        libro2 = new TipoLibro(econ);
    }

    public TipoLibro getLibro1() {
        return libro1;
    }

    public TipoLibro getLibro2() {
        return libro2;
    }
    /*Se pone private delante del método porque solo va a ser utilizado
     en esta clase, pero se puede poner public igualmente.*/

    private String pedirLibro() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String libro = "";
        try {
            System.out.print("Introduce libro: ");
            libro = teclado.readLine();
            while (libro.compareToIgnoreCase(libro1.getNombre()) != 0 && libro.compareToIgnoreCase(libro2.getNombre()) != 0
                    && libro.compareToIgnoreCase("fin") != 0) {
                System.out.println("ERROR");
                System.out.print("Vuelve a introducir libro: ");
                libro = teclado.readLine();
            }
        } catch (IOException e) {

        }
        return libro;
    }

    private String pedirPago() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String pago = "";
        try {
            System.out.print("Introduce forma de pago: ");
            pago = teclado.readLine();
            while (pago.compareToIgnoreCase("contado") != 0 && pago.compareToIgnoreCase("credito") != 0) {
                System.out.println("ERROR");
                System.out.print("Vuelve a forma de pago: ");
                pago = teclado.readLine();
            }
        } catch (IOException e) {

        }
        return pago;
    }
    /*En public Informe se pone lo queremos que muestre. Lo llamamos desde la clase Principal.*/

    public void informe() {
        int totalEco, totalInf, total = 0;
        float porcInf = 0, porcEco = 0;
        totalInf = libro1.totalLibros();
        totalEco = libro2.totalLibros();
        total = totalEco + totalInf;
        porcInf = (float) totalInf / total * 100;
        porcEco = (float) totalEco / total * 100;
        if (total > 0) {
            System.out.println("NOMBRE" + "\t" + "\t" + "CONTADO" + "\t" + "\t" + "CREDITO" + "\t" + "\t" + "TOTAL");
            System.out.println("------------------------------------------------------------------------");
            System.out.println(libro1.getNombre() + "\t" + "\t" + libro1.getContado() + "\t" + "\t"
                    + libro1.getCredito() + "\t" + "\t" + libro1.totalLibros());
            System.out.println(libro2.getNombre() + "\t" + "\t" + libro2.getContado() + "\t" + "\t"
                    + libro2.getCredito() + "\t" + "\t" + libro2.totalLibros());
            System.out.println("TOTAL" + "\t" + "\t" + (libro1.getContado() + libro2.getContado()) + "\t" + "\t"
                    + (libro1.getCredito() + libro2.getCredito()) + "\t" + "\t" + (libro1.totalLibros() + libro2.totalLibros()));
            System.out.println("Porcentaje de libros de Informatica: " + porcInf + "%");
            System.out.println("Porcentaje de libros de Economia: " + porcEco + "%");
            if (totalInf > totalEco) {
                System.out.println("El libro menos vendido es "+libro2.getNombre());
            } else if (totalInf < totalEco) {
                System.out.println("El libro menos vendido es "+libro1.getNombre());
            } else {
                System.out.println("Ambos libros se han vendido por igual");
            }
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
    }
    /*Si no se necesita nada de otro lado del programa ajeno a este método,
     se pone public void*/

    public void pedirDatos() {
        String formaPago, libro;
        libro = pedirLibro();
        while (libro.compareToIgnoreCase("fin") != 0) {
            formaPago = pedirPago();
            if (libro.compareToIgnoreCase(libro1.getNombre()) == 0) {
                if (formaPago.compareToIgnoreCase("contado") == 0) {
                    libro1.acumularContado();
                } else {
                    //Métodos de la clase TipoLibro
                    libro1.acumularCredito();
                }
            } else {
                if (formaPago.compareToIgnoreCase("contado") == 0) {
                    libro2.acumularContado();
                    //Para sumar +1 a los contadores correspondientes
                } else {
                    libro2.acumularCredito();
                }
            }
            libro = pedirLibro();
        }
    }
}
