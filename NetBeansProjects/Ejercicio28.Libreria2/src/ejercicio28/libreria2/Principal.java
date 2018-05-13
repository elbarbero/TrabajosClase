package ejercicio28.libreria2;

/**
 *
 * @author 203pc19
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa empresa1;
        //Empresa empresa2;
        /*Habrá tantos constructores como situaciones se te puedan plantear*/
        empresa1 = new Empresa();
        //empresa2 = new Empresa("Fisica", "Matematicas");
        empresa1.pedirDatos();
        empresa1.informe();
        /*Este siguiente System te devuelve la dirección de la memoria donde se guarda
         porque Libro1 es el conjunto de todas las propiedades del libro.*/
        //System.out.println(empresa1.getLibro1());
        /*El System siguiente ya te devuelve el nombre del Libro1.*/
        //System.out.println(empresa1.getLibro1().getNombre()+"\t"+empresa1.getLibro1().getContado());
    }

}
