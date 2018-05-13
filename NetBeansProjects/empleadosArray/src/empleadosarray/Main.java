package empleadosarray;

/**
 *
 * @author 203pc19
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*El 2 de los parentesis es el número de valores que va a 
        guardar el array*/
        Empresa empresaBurgos = new Empresa(3);
        empresaBurgos.pedirDatosEmpleadosConNombreCategoria();
        empresaBurgos.informe();
    }

}
