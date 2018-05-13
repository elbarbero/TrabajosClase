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
import modelo.Curso;

/**
 *
 * @author 203pc19
 */
public class GestorTablaCurso {

    Conexion bd;

    public GestorTablaCurso(Conexion bd) {
        this.bd = bd;
    }

    public ArrayList<Curso> consultaTodosCursos() {//devuelve una coleccion de datos(arrayList) de tipo "Cursos"
        Statement sentencia = null;
        ArrayList<Curso> cursos = new ArrayList<>();
        String slq = "select * from programacion.curso";
        try {
            sentencia = bd.getConexion().createStatement();
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(slq);//asi ejecutamos la sentencia
            while (registros.next()) {//mientras tenga registros...
                Curso c = new Curso(registros.getString("cod_curso"),
                        registros.getString("denominacion"), registros.getInt("nPlazasDisp"));
                cursos.add(c);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return cursos;
    }

    public boolean existeCurso(String cod_curso) {
        boolean existe = false;
        try {
            String slq = "select * from programacion.curso where cod_curso= '" + cod_curso + "' ";
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

    public Curso existeUnCurso(String cod_curso) {
        Curso miCurso = null;
        try {
            String slq = "select * from programacion.curso where cod_curso= '" + cod_curso + "' ";
            Statement st = bd.getConexion().createStatement();
            ResultSet registros = st.executeQuery(slq);
            if (registros.first()) {
                /*en este if le decimos; colocate en el primer registro
                porque la sentencia solo devolvera un registro porque hemos
                puesto una condicion (un where).
                si en ese primer y único registro eexiste un valor igual que
                el que hemos puesto dentro del where, entonces, ya existe u no lo agregues*/
                miCurso = new Curso(registros.getString("cod_curso"),
                        registros.getString("denominacion"), registros.getInt("nPlazasDisp"));
                registros.close();
                st.close();
            }
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return miCurso;
    }

    public int grabarCurso(String cod_curso, String denominacion, int nPlazasDisp) {
        int valor = 0;
        String sql = "insert into curso(cod_curso, denominacion, nPlazasDisp)values('"
                + cod_curso + "','" + denominacion + "','" + nPlazasDisp + "')";
        Statement st;
        try {
            st = bd.getConexion().createStatement();
            valor = st.executeUpdate(sql);
            /*executeUpdate te devuelve la cantidad de registros grabados*/
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public int borrarCurso(String cod_curso) {
        int valor = 0;
        String sql = "delete from programacion.curso where cod_curso= '" + cod_curso + "'";
        Statement st;
        try {
            st = bd.getConexion().createStatement();
            valor = st.executeUpdate(sql);
            /*executeUpdate te devuelve la cantidad de registros grabados*/
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public void cerrar() {
        bd.cerrar();
    }

    public int actualizarRegistros(Curso c) {
        int registros = 0;
        try {
            String sql = "update curso set denominacion='" + c.getDenominacion()
                    + "',nPlazasDisp='" + c.getnPlazasDisp() + "' where cod_curso='" + c.getCodCurso() + "'";
            Statement st = bd.getConexion().createStatement();
            registros = st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public boolean tieneSocios(String codCurso) {
        boolean existe = false;
        try {
            //SELECT count(*) FROM programacion.alumnos where cod_curso=2222;
            String sql = "SELECT * FROM programacion.alumnos where cod_curso='" + codCurso + "'";
            Statement st = bd.getConexion().createStatement();
            ResultSet registros = st.executeQuery(sql);
            if (registros.first()) {
                existe = true;
                registros.close();
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }

    public int AlumnosPorCurso(String codCurso) {
        Statement sentencia = null;
        int nPlazasocupadas = 0;
        String sql = "select count(*) from programacion.alumnos where cod_curso='" + codCurso + "'";
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            /*sentencia = bd.getConexion().createStatement();*/
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(sql);//asi ejecutamos la sentencia
            if (registros.next()) {
                nPlazasocupadas = registros.getInt(1);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nPlazasocupadas;
    }
    
     public int plazasCurso(String codCurso) {
        Statement sentencia = null;
        int nPlazasoTotales = 0;
        String sql = "select nPlazasDisp from programacion.curso where cod_curso='" + codCurso + "'";
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            /*sentencia = bd.getConexion().createStatement();*/
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(sql);//asi ejecutamos la sentencia
            if (registros.next()) {
                nPlazasoTotales = registros.getInt(1);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nPlazasoTotales;
    }
}
