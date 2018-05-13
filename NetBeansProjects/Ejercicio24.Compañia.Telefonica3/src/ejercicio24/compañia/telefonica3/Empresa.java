package ejercicio24.compañia.telefonica3;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Empresa {

    Compañia compañia1;
    Compañia compañia2;
    Compañia compañia3;

    /*Toda clase tiene que tener al menos un constructor.
     Si no se pone nada, java pone uno por defecto*/
    public Empresa() {
        compañia1 = new Compañia("Movistar");
        compañia2 = new Compañia("Vodafone");
        compañia3 = new Compañia("Otros");
    }

    public Empresa(String n1, String n2, String n3) {
        /*Si no me dicen como quieren empezar, que me muestre estos nombres.*/
        compañia1 = new Compañia("n1");
        compañia1 = new Compañia("n2");
        compañia1 = new Compañia("n3");
    }

    public Compañia getCompañia1() {
        return compañia1;
    }

    /*La primera letra de la palabra que se pone a continuación
     del set y el get se pone en mayuscula por norma general.*/
    public void Entrada() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre, contrato;
        nombre = pedirOperador();
        while (nombre.compareTo("*") != 0) {
            contrato = pedirContrato();
            /*if (nombre.compareToIgnoreCase(compañia1.getNombre()) == 0) {
                if (contrato.equalsIgnoreCase("contrato")) {
                    compañia1.actualizarContrato();;
                } else {
                    compañia1.actualizarTarjeta();
                }
            } else if (nombre.compareToIgnoreCase(compañia2.getNombre()) == 0) {
                if (contrato.equalsIgnoreCase("contrato")) {
                    compañia2.actualizarContrato();;
                } else {
                    compañia2.actualizarTarjeta();
                }else if (nombre.compareToIgnoreCase(compañia3.getNombre()) == 0) {
                if (contrato.equalsIgnoreCase("contrato")) {
                    compañia3.actualizarContrato();;
                } else {
                    compañia3.actualizarTarjeta();
                }
                        }
            Esta es otra forma de hacerlo*/

                if (contrato.compareToIgnoreCase("c") == 0 && nombre.compareToIgnoreCase("m") == 0) {
                    compañia1.actualizarContrato();
                    /*Entre los parentesis se pone las variables que tenga el método al que se llama dentro de sus parentesis*/
                    compañia1.totalTelefonos();
                } else if (contrato.compareToIgnoreCase("t") == 0 && nombre.compareToIgnoreCase("m") == 0) {
                    compañia1.actualizarTarjeta();
                    compañia1.totalTelefonos();
                }
                if (contrato.compareToIgnoreCase("c") == 0 && nombre.compareToIgnoreCase("v") == 0) {
                    compañia2.actualizarContrato();
                    compañia2.totalTelefonos();
                } else if (contrato.compareToIgnoreCase("t") == 0 && nombre.compareToIgnoreCase("v") == 0) {
                    compañia2.actualizarTarjeta();
                    compañia2.totalTelefonos();
                }
                if (contrato.compareToIgnoreCase("c") == 0 && nombre.compareToIgnoreCase("o") == 0) {
                    compañia3.actualizarContrato();
                    compañia3.totalTelefonos();
                } else if (contrato.compareToIgnoreCase("t") == 0 && nombre.compareToIgnoreCase("o") == 0) {
                    compañia3.actualizarTarjeta();
                    compañia3.totalTelefonos();
                }

                nombre = pedirOperador();
            }

        }
        /*Si no se pone public delante del método quiere decir que es de nivel amistoso,
         solo es publico para las clase que pertenecen al mismo paquete.
         Si se llama desde otra clase de otro paquete, se comporta como privado.*/

        String pedirOperador() throws IOException {
            InputStreamReader flujo = new InputStreamReader(System.in);
            BufferedReader teclado = new BufferedReader(flujo);
            String operador = "";
            boolean correcto = false;
            try {
                System.out.println("MOVISTAR(m), VODAFONE(v), OTRAS(o)");
                System.out.print("Introduce operador: ");
                operador = teclado.readLine();
                while (operador.compareToIgnoreCase("m") != 0 && operador.compareToIgnoreCase("v") != 0
                        && operador.compareToIgnoreCase("o") != 0 && operador.compareTo("*") != 0) {
                                    System.out.println("MOVISTAR(m), VODAFONE(v), OTRAS(o)");
                System.out.print("Introduce operador de nuevo: ");
                operador = teclado.readLine();
                } 
            } catch (IOException ex) {
            }
            return operador;
        }

    

    

    public String pedirContrato() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String contrato = "";
        try {
            System.out.print("Contrato o tarjeta (T o C): ");
            contrato = teclado.readLine();
            while (contrato.compareToIgnoreCase("T") != 0 && contrato.compareToIgnoreCase("C") != 0) {
                System.out.print("Vuelve a introducir tipo de contrato: ");
                contrato = teclado.readLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR I/O");

        }
        return contrato;
    }

    public void Salida() {/*entre parentesis se pone lo que necesitemos de la
         clase principal. Si no nos hace falta nada, se deja vacio.
         Compañia1, compañia2, compañia3 son objetos creados en esta misma clase.
         Si los datos osn numericos te los sumaria.*/

        System.out.println("\t" + "CONTRATOS" + "\t" + "TARJETAS" + "\t" + "TOTAL TLF");

        System.out.println(compañia1.getNombre() + "\t" + compañia1.getContrato()
                + "\t" + "\t" + compañia1.getTarjeta() + "\t" + "\t" + compañia1.totalTelefonos());

        System.out.println(compañia2.getNombre() + "\t" + compañia2.getContrato()
                + "\t" + "\t" + compañia2.getTarjeta() + "\t" + "\t" + compañia2.totalTelefonos());

        System.out.println(compañia3.getNombre() + "\t" + "\t" + compañia3.getContrato()
                + "\t" + "\t" + compañia3.getTarjeta() + "\t" + "\t" + compañia3.totalTelefonos());

        System.out.println("TOTAL" + "\t" + "\t" + (compañia1.getContrato() + compañia2.getContrato() + compañia3.getContrato()) + "\t" + "\t"
                + (compañia1.getTarjeta() + compañia2.getTarjeta() + compañia3.getTarjeta())
                + "\t" + "\t" + (compañia1.totalTelefonos() + compañia2.totalTelefonos() + compañia3.totalTelefonos()));

        /*System.out.print(compañia1.Visualizar());
         Este system resume el system anterior de compañia1 creando previamente
         un public en la clase compañia.*/
    }

    public void setCompañia1(Compañia compañia1) {
        this.compañia1 = compañia1;
    }

    public Compañia getCompañia2() {
        return compañia2;
    }

    public void setCompañia2(Compañia compañia2) {
        this.compañia2 = compañia2;
    }

    public Compañia getCompañia3() {
        return compañia3;
    }

    public void setCompañia3(Compañia compañia3) {
        this.compañia3 = compañia3;
    }

}
