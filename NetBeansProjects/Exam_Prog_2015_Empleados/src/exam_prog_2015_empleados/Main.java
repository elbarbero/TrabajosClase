/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam_prog_2015_empleados;

/**
 *
 * @author Mario Barbero
 */
public class Main {

    public static void main(String[] args) {
        /*Si no ponemos ningún valor entre los parentesis, el número de empleados
        será el que le hayamos puesto en el constructor de la clase Empresa.
        El valor que pongamos entre los parentesis en esta clase, corresponede
        a la variable nEmpleados de la clase Empresa*/
        Empresa empresasMario=new Empresa();
        empresasMario.pedirDatos();
        empresasMario.informe();
    }
    
}
