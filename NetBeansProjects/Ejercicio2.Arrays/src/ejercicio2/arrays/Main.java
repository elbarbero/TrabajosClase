package ejercicio2.arrays;

/**
 *
 * @author Mario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa miEmpresa=new Empresa(2);
        miEmpresa.pedirDatos();
        miEmpresa.informe();
        //Fechas fechaHoy = new Fechas();
        /* Fechas f1 = new Fechas(12, 5, 2004);
         Fechas f2 = new Fechas();
         Fechas f3 = new Fechas();*/
        /*Te cambia el valor de la posición 1 por la que hayamos puesto en el método "cambio".
         Da igual quien llame al método.
         Solo te cambia el valor de la posición en suestión si es estatico(static int[]diasMes={};)*/
        //f2.cambio();
        /*En la siguiente línea tiene en cuenta el año de "f1" pero te cambia los diás de febrero
         a 29 también en fechaHoy, f1 y f2*/
        /*f1.bisiesto();
         fechaHoy.bisiesto();*/
      }
}