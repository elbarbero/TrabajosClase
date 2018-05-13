/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio24.compañia.telefonica3;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {
        Empresa miEmpresa;
        miEmpresa = new Empresa();
        miEmpresa.Entrada();
        miEmpresa.Salida();//Se llama al método salida de la clase Empresa
    }
}
