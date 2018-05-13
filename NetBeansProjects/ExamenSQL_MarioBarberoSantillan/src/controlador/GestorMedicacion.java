/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Medicaciones;

/**
 *
 * @author 203pc19
 */
public class GestorMedicacion {
    Conexion bd;

    public GestorMedicacion(Conexion bd) {
        this.bd = bd;
    }
     public ArrayList<Medicaciones> consultaTodasMedicaciones() {//devuelve una coleccion de datos(arrayList) de tipo "Cursos"
        Statement sentencia = null;
        ArrayList<Medicaciones> miMedicacion = new ArrayList<>();
        String slq = "select * from examen8615.tblmedicaciones";
        try {
            sentencia = bd.getConexion().createStatement();
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(slq);//asi ejecutamos la sentencia
            while (registros.next()) {//mientras tenga registros...
                Medicaciones m = new Medicaciones(registros.getString("codigoMedicacion"),
                        registros.getString("denominacion"), registros.getString("indicaciones"));
                miMedicacion.add(m);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return miMedicacion;
    }

    public boolean existeMedicacion(String codigoMedicacion) {
        boolean existe = false;
        try {
            String slq = "select * from examen8615.tblmedicaciones where codigoMedicacion= '" + codigoMedicacion + "' ";
            Statement st = bd.getConexion().createStatement();
            ResultSet registros = st.executeQuery(slq);
            if (registros.first()) {
                /*en este if le decimos; colocate en el primer registro
                porque la sentencia solo devolvera un registro porque hemos
                puesto una condicion (un where).
                si en ese primer y único registro eexiste un valor igual que
                el que hemos puesto dentro del where, entonces, ya existe u no lo agregues*/
                existe = true;
                registros.close();
                st.close();
            }
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return existe;
    }

   /* public Curso existeUnaMedicacion(String codigoMedicacion) {
        Curso miCurso = null;
        try {
            String slq = "select * from examen8615.tblmedicaciones where cod_curso= '" + cod_curso + "' ";
            Statement st = bd.getConexion().createStatement();
            ResultSet registros = st.executeQuery(slq);
            if (registros.first()) {
                /*en este if le decimos; colocate en el primer registro
                porque la sentencia solo devolvera un registro porque hemos
                puesto una condicion (un where).
                si en ese primer y único registro eexiste un valor igual que
                el que hemos puesto dentro del where, entonces, ya existe u no lo agregues*/
                /*miCurso = new Curso(registros.getString("cod_curso"),
                        registros.getString("denominacion"), registros.getInt("nPlazasDisp"));
                registros.close();
                st.close();
            }
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return miCurso;
    }*/
}
