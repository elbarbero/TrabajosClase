package empleadosarray;

import Utilidades.Numeros;
import Utilidades.Caracteres;

/**
 *
 * @author 203pc19
 */
public class Empresa {

    /*Objeto de tipo Empleado (el nombre de la clase)*/
    Empleado[] empleados;
    /*Objeto de tipo Categoria (el nombre de la clase)
     Se hace otra clase por por categoría hay más de un dato: la tarifa y nombre de la categoria*/
    Categoria[] categorias;

    public Empresa() {
        empleados = new Empleado[10];
        inicializar();
        crearCategorias();
    }

    public Empresa(int numeroEmpleados) {
        empleados = new Empleado[numeroEmpleados];
        categorias = new Categoria[4];
        inicializar();
        crearCategorias();
    }

    private void crearCategorias() {
        /*Este método solo se va a utilizar en esta clase*/
        categorias = new Categoria[4];
        /*Entre los parentesis ponemos en nombre de la categoría y la tarifa, en el mismo orden
         en el que se han declarado en el constructor de la clase Categoria.
         No se pone el bucle for por cada categoría tiene valores diferentes*/
        categorias[0] = new Categoria("10", 6);
        categorias[1] = new Categoria("20", 8);
        categorias[2] = new Categoria("30", 10);
        categorias[3] = new Categoria("40", 14);
    }

    private void inicializar() {
        for (int numEmple = 0; numEmple < empleados.length; numEmple++) {
            /*La siguiente línea me crea a los empleados*/
            empleados[numEmple] = new Empleado();
        }
    }

    public void pedirDatosEmpleados() {
        String nombre;
        int horas;
        int categoria;
        Caracteres caracteres = new Caracteres();
        Numeros numeros = new Numeros();
        /*La variable numEmple solo existe mientras se ejecute el bucle for*/
        for (int numEmple = 0; numEmple < empleados.length; numEmple++) {
            nombre = caracteres.pedirString("Nombre: ");
            /*el número 0 es el número más pequeño que aceptamos*/
            /*Aqui llamamos a un método de una clase llamada numeros de otro programa*/
            horas = numeros.pedirNumeroEntero("Horas :", 0);
            /*Los números 10 y 40 son la gategoría minima y la máxima que aceptamos*/
            informacion();
            categoria = numeros.pedirNumeroEntero("Categoría: ", 0, categorias.length - 1);
            empleados[numEmple].setNombre(nombre);
            empleados[numEmple].setHoras(horas);
            empleados[numEmple].setCodCategoria(categoria);
        }
    }

    private void informacion() {
        System.out.println("NUM CATEGORÍA" + "\t" + "TARFIFA");
        System.out.println("-------------------");
        for (int numCat = 0; numCat < categorias.length; numCat++) {
            /*Este bucle for me devuelve lo siguiente de esta forma:
             "Categoría 1= nombre 10 y tarifa 6"
             System.out.println("Categoría " + numCat + " = " + "nombre Categoría " +
             categorias[numCat].getNomCategoria() + "y tarifa " + categorias[numCat].getTarifa());*/
            System.out.println(numCat + " \t "
                    + categorias[numCat].getNomCategoria() + "\t" + categorias[numCat].getTarifa());
        }
    }

    private int busquedaCategoria(String categoriaBuscar) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < categorias.length) {
            if (categorias[pos].getNomCategoria().equalsIgnoreCase(categoriaBuscar)) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        if (!encontrado) {//SI NO LE ENCUENTRA DEVUELVE -1 DE LO CONTRARIO DEVOLVERIA LA ULTIMA POSICION DEL ARRAY
            System.out.println("NO SE ENCUENTRA LA CATEGORIA");
            pos = -1;
        }
        return pos;

    }

    public void pedirDatosEmpleadosConNombreCategoria() {
        String nombre;
        String nombreCategoria;
        int horas;
        int categoria;
        Caracteres caracteres = new Caracteres();
        Numeros numeros = new Numeros();

        for (int nemple = 0; nemple < empleados.length; nemple++) {
            nombre = caracteres.pedirString("NOMBRE: ");
            horas = numeros.pedirNumeroEntero("HORAS: ", 0);
            informacion();
            nombreCategoria = caracteres.pedirString("Nombre Categoria");
            categoria = busquedaCategoria(nombreCategoria);
            while (categoria == -1) {
                System.out.println("CATEGORIA INEXISTENTE");
                nombreCategoria = caracteres.pedirString("Nombre Categoria");
                categoria = busquedaCategoria(nombreCategoria);
            }
            //categoria = numeros.pedirNumeroEntero("CATEGORIA: ", 0, categorias.length - 1);
            empleados[nemple].setNombre(nombre);
            empleados[nemple].setCodCategoria(categoria);
            empleados[nemple].setHoras(horas);
        }
    }

    public void pedirDatosEmpleados2() {
        String nombre;
        int horas;
        int categoria;
        Caracteres caracteres = new Caracteres();
        /*Creamos el objeto numeros(en minuscula) en la clase Numeros, que es la que hemos importado a traves
         del archivo .jar*/
        Numeros numeros = new Numeros();
        /*La variable numEmple solo existe mientras se ejecute el bucle for*/
        for (int numEmple = 0; numEmple < empleados.length; numEmple++) {
            nombre = caracteres.pedirString("Nombre: ");
            /*el número 0 es el número más pequeño que aceptamos*/
            /*Aqui llamamos a un método de una clase llamada numeros de otro programa llamado UtilidadesNumeros*/
            horas = numeros.pedirNumeroEntero("Horas :", 0);
            /*Los números 10 y 40 son la gategoría minima y la máxima que aceptamos*/
            categoria = numeros.pedirNumeroEntero("Categoría: ", 10, 40);
            /*La siguiente línea me crea el empleado, Me cambia null por el empleado en cuestión*/
            empleados[numEmple] = new Empleado(nombre, horas, categoria); //INICIALIZA YA POR DEFECTO (SE OMITE EL INICIALIZAR())
        }
    }

    private float CalcularSueldoMedio() {
        /*Esta variable no se incializa por defecto porque
         no perntenece a la clase, sino que pertenece al
         método*/
        float suma = 0, salarioBruto;
        float sueldoMedio;
        for (int numEmple = 0; numEmple < empleados.length; numEmple++) {
            //salarioBruto = empleados[numEmple].CalculoSueldoBruto(precioHora);
            //Esto es igual que la línea de abajo
            salarioBruto = empleados[numEmple].CalculoSueldoBruto(categorias[empleados[numEmple].getCodCategoria()].getTarifa());
            suma = suma + salarioBruto;
        }
        /*empleados.length guarda el número total de empleados*/
        sueldoMedio = suma / empleados.length;//divide la suma entre los empleados totales
        return sueldoMedio;
    }

    public void informe() {
        float salarioBruto;
        float salarioNeto;
        int posicionCategoria;
        float tarifa;
        float descuento;
        float sueldoMedio;
        sueldoMedio = CalcularSueldoMedio();
        System.out.println("El sueldo medio es " + sueldoMedio + "€");
        System.out.println("NOMBRE" + "\t" + "\t" + "CATEGORÍA" + "\t" + "\t" + "SALARIO BRUTO" + "\t" + "\t" + "DESCUENTO" + "\t" + "\t" + "SALARIO NETO");
        for (int numEmple = 0; numEmple < empleados.length; numEmple++) {
            /*Si dentro del system solo ponemos "empleados[numEmple]" me muestra
             la dirección donde se a guardado cada empleado.
             toUpperCase() te muestra el nombre en mayusculas.*/
            //System.out.print(empleados[numEmple].getNombre().toUpperCase());
            //salarioBruto = empleados[numEmple].CalculoSueldoBruto(categorias[empleados[numEmple].getCodCategoria()].getTarifa());
            posicionCategoria = empleados[numEmple].getCodCategoria();
            tarifa = categorias[posicionCategoria].getTarifa();
            salarioBruto = empleados[numEmple].CalculoSueldoBruto(tarifa);
            if (sueldoMedio < salarioBruto) {
                descuento = empleados[numEmple].CalculoDescuento(salarioBruto);
                salarioNeto = empleados[numEmple].CalculoSueldoNeto(salarioBruto, descuento);
                System.out.print(empleados[numEmple].getNombre());
                System.out.print("\t" + "\t" + categorias[posicionCategoria].getNomCategoria());
                System.out.print("\t" + "\t" + "\t" + salarioBruto);
                System.out.print("\t" + "\t" + "\t" + descuento);
                System.out.println("\t" + "\t" + "\t" + salarioNeto);
            }
        }
    }
}
