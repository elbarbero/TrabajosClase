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
import modelo.EnfermoMedicacion;

/**
 *
 * @author 203pc19
 */
public class GestorMedicacionEnfermo {

    Conexion bd;

    public GestorMedicacionEnfermo(Conexion bd) {
        this.bd = bd;
    }

    public ArrayList<EnfermoMedicacion> consultaTodasEnfermosMedicaciones() {
        Statement sentencia = null;
        ArrayList<EnfermoMedicacion> miEnfermoMed = new ArrayList<>();
        String slq = "select * from examen8615.tblenfermomedicacion";
        try {
            sentencia = bd.getConexion().createStatement();
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(slq);//asi ejecutamos la sentencia
            while (registros.next()) {//mientras tenga registros...
                EnfermoMedicacion em = new EnfermoMedicacion(registros.getString("numeroSeguridadSocial"),
                        registros.getString("codigoMedicacion"));
                miEnfermoMed.add(em);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return miEnfermoMed;
    }
    
    
    public ArrayList<EnfermoMedicacion> consultaTodasEnfermosMedicaciones2() {
        Statement sentencia = null;
        ArrayList<EnfermoMedicacion> miEnfermoMed = new ArrayList<>();
        String slq = "select * from examen8615.tblenfermomedicacion";
        try {
            sentencia = bd.getConexion().createStatement();
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(slq);//asi ejecutamos la sentencia
            while (registros.next()) {//mientras tenga registros...
                EnfermoMedicacion em = new EnfermoMedicacion(registros.getString("numeroSeguridadSocial"),
                        registros.getString("codigoMedicacion"));
                miEnfermoMed.add(em);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return miEnfermoMed;
    }

    public boolean existeEnfermoMedicacion(String numeroSeguridadSocial, String codigoMedicacion) {
        boolean existe = false;
        try {
            String slq = "select * from examen8615.tblenfermomedicacion where numeroSeguridadSocial= '" + numeroSeguridadSocial + "' and codigoMedicacion= '" + codigoMedicacion + "' ";
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

    public int grabarMedicacionEnfermo(String numeroSeguridadSocial, String codigoMedicacion) {
        int valor = 0;
        String sql = "insert into examen8615.tblenfermomedicacion(numeroSeguridadSocial, codigoMedicacion) values('"
                 + numeroSeguridadSocial + "','"+ codigoMedicacion + "')";
        Statement st;
        try {
            st = bd.getConexion().createStatement();
            valor = st.executeUpdate(sql);
            /*executeUpdate te devuelve la cantidad de registros grabados*/
        } catch (SQLException ex) {
            Logger.getLogger(GestorMedicacionEnfermo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

  /*  SELECT tm.codigoMedicacion, tm.denominacion,tm.indicaciones
from tblmedicaciones tm,tblenfermos te, tblenfermomedicacion tem 
where tem.numeroSeguridadSocial=te.numeroSeguridadSocial;*/
    
    
    
    
}
