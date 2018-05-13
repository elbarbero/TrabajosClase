/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado.JUnit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class Principal {

        public static void main(String[] args)throws IOException {
        Empleado miEmpleado;
        miEmpleado=new Empleado();
        miEmpleado.pedirDatos();
    }
}
