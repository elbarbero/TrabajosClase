package ejemplos.pkgtry.pkgcatch;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EjemplosTryCatch {
    /*Los métodos siempre se ponen dentro de la clase y fuera del public static void main*/

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String dato1 = "";
        String dato5 = "";
        int dato2, dato3, sumaEdad = 0, sumaNota = 0, conTotal = 0;
        float dato4, sumaEstatura = 0;;
        float media;
        /*En las dos siguientes lineas y en la siguiente declaramos el objeto
         Se tiene que llamar como la clase.*/
        EjemplosTryCatch objeto;
        objeto = new EjemplosTryCatch();
        /*ponemos objeto porque es el nombre que le hemos puesto.
         Se le puede cualquier otro nombre.
         Se pone "objeto.pedirNombre" porque es el nombre del objeto y el nombre del método.
         De esa forma llamamos al método.
         Lo que pongo entre comillas en dato 1,2 y 3 es lo que quiero que aparezca
         en el system del método.
         */
        dato1 = objeto.pedirNombre("Introduce nombre: ");// Con dato1 pido el nombre
        while (dato1.compareTo("*") != 0) {
            /*con dato2 pido la edad. El cero indica el valor minimo que se acepta.
             para indicar un valor máximo se pone a lado el numero que queremos
             separado por una coma.
             Lo que he escrito entre los parentesis de cada dato( dato1 y el 2)
             es el mensaje que quiero que aparezca en los system de los métodos.
             Si los parentesis estan vacios, como en dato3, es que en el metodo
             que le corresponda voy ha hacer los system como siempre.*/
            dato5 = objeto.pedirSexo();//se pide el sexo del alumno
            dato2 = objeto.pedirEdad("Introduce edad: ", 0);
            dato4 = objeto.pedirEstatura("Introduce estatura: ", 0, 2.80f);//aqui pedimos la estatura
            //asignamos el valor minimo permitido y el máximo
            dato3 = objeto.pedirNota();//con dato3 pido la nota
            conTotal++;
            sumaEdad = sumaEdad + dato2;
            sumaNota = sumaNota + dato3;
            sumaEstatura = sumaEstatura + dato4;
            dato1 = objeto.pedirNombre("Introduce nombre: ");
        }
        if (conTotal > 0) {
            media = (float) sumaEdad / conTotal;
            System.out.println("La edad media de todos los alumnos es " + media + " años");
            media = (float) sumaNota / conTotal;
            System.out.println("La nota media de todos los alumnos es " + media);
            media = (float) sumaEstatura / conTotal;
            System.out.println("La estatura media de todos los alumnos es " + media + " metros");
        } else {
            System.out.println("NO HAY DATOS");
        }
    }//FIN DEL PUBLIC STATIC VOID

    public String pedirNombre(String mensaje) throws IOException {
        //esto es método.
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre;
        /*en este método no declaramos ningun boolean ni usamos el try porque no
         estamos controlando nada.En String entran todos los caracteres.
         Con nombres no se suele poner boolean.*/
        System.out.print(mensaje);
        nombre = teclado.readLine();
        while (nombre.compareTo("") == 0) {
            System.out.println("ERROR");
            System.out.print(mensaje);
            nombre = teclado.readLine();
        }
        return nombre;//con esto le decimo que vuelva a la variable nombre
    }

    public String pedirSexo() throws IOException {
        /*En cada método hay que poner los InputStreamReader, el BufferedReader,
         y el IOException. Son como miniprogramas, Así si falla uno es más fácil
         corregirlo.*/
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String sexo = "";
        /*en try ponemos lo queremos que vuelva a mostrar
         en caso que ocurra alguna excepcion o el dato este mal introducido.*/
        try {
            System.out.print("Introduce sexo (V o M): ");
            sexo = teclado.readLine();
            /*Aqui he puesto un while en vez de if porque sino entraria una vez
             y se iria sin tener en en cuenta si el dato introducido de nuevo es correcto o falso.*/
            while (sexo.compareToIgnoreCase("v") != 0 && sexo.compareToIgnoreCase("M") != 0) {
                System.out.print("Vuelve a meter sexo del alumno: ");
                sexo = teclado.readLine();
            }
        } catch (IOException e) {
        }
        return sexo;
    }

    public int pedirEdad(String mensaje, int limiteInferior) throws IOException {
        /*En este método declaramos las variables de la clase principal.
         El mensaje que queriamos que apareciese y el limite inferior que admitiamos
         en esta variable.
         String mensaje es un nombre aleatorio.
         Se puede poner otro cualquiera pero se tiene que llamar que loque
         pongamos entre los parentesis de los system de los métodos, por ejemplo, String casa
         pero entre los system tambien tendriamos que poner casa*/
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int edad = 0;
        boolean correcto = false;//variable boolean
        //la inizializamos como false al principio
        while (!correcto) {
            try {
                System.out.print(mensaje);
                edad = Integer.parseInt(teclado.readLine());
                if (edad < limiteInferior) {//limiteInferior es el cero de la clase principal.
                    //lo hemos puesto nombre(declarado)entre los parentesis de este metodo.
                    System.out.println("ERROR");
                } else {
                    /*aqui decimos que si el dato es correcto, cambie la
                     variable correcto de false a true para que no siga*/
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                /*aqui decimos que si la edad es no es numero.
                 El correcto=false no seria necesario ponerlo porque lo
                 hemos declarado como false al inicio y no ha cambiado todavia.
                 Lo pongo para que lo veas. Dentro de la excepcion la variable
                 correcto debe seguir siendo false*/
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
                correcto = false;
                /*con esto controlamos un error de entrada/salida.
                 No ponemos ningún mensaje dentro porque es casi imposible hacerle saltar.*/
            } catch (IOException e) {//en cada catch se ponen las excepciones
            }
        }
        return edad;
    }

    public float pedirEstatura(String mensaje, double limiteInferior, double limiteSuperior) throws IOException {
        /*aqui hemos definido los valores inferior y superior, por eso los
         pongo entre los parentesis.
         En public double hay que decir de que tipo es el dato del método,
         por eso he puesto duble. Si es Integer, se pone int.*/
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float estatura = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                estatura = Float.parseFloat(teclado.readLine());
                if (estatura < limiteInferior || estatura > limiteSuperior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return estatura;
    }

    public int pedirNota() throws IOException {
        /*En este método no hemos puesto nada entre los parentesis
         porque me ha dado la gana controlarlo todo dentro del método.
         Como ves tampoco he puesto String mensaje porque si te has fijado
         la variable dato3(es la que llama a este método)no tenia nada escrito
         entre los parentesis*/
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int nota = 0;
        boolean correcto = false;
        while (!correcto) {
            correcto = false;
            try {
                System.out.print("Introduce Nota: ");
                nota = Integer.parseInt(teclado.readLine());
                /*Aqui he querido controlar el valor minimo y maximo.
                 Si hubiera querido controlarlo en la principal como he hecho
                 con dato2(que es para la edad), pondría el minimo y el maximo alli.
                 Y aqui hubiera puesto mensaje entre los parentesis del system*/
                if (nota < 0 || nota > 10) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
                correcto = false;
            } catch (IOException e) {
            }
        }
        return nota;
    }
}//FIN DEL PUBLIC CLASS
