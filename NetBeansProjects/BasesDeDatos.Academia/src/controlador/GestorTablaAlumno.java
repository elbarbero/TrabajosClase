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
import modelo.Alumno;

/**
 *
 * @author 203pc19
 */
public class GestorTablaAlumno {

    Conexion bd;

    public GestorTablaAlumno(Conexion bd) {
        this.bd = bd;
    }

    public ArrayList<Alumno> consultaTodosAlumnos() {//devuelve una coleccion de datos(arrayList) de tipo "Alumno"
        Statement sentencia = null;
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String slq = "select * from programacion.alumnos";
        try {
            sentencia = bd.getConexion().createStatement();
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(slq);//asi ejecutamos la sentencia
            while (registros.next()) {//mientras tenga registros...
                Alumno a = new Alumno(registros.getInt("cod_Alumno"),
                        registros.getString("nombre"), registros.getString("dni"),
                        registros.getString("cod_Curso"), registros.getString("direccion"),
                        registros.getString("poblacion"), registros.getInt("telefono"),
                        registros.getDouble("importe_gastos"));
                alumnos.add(a);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return alumnos;
    }

    public boolean existeAlumno(int codAlumno) {
        boolean existe = false;
        try {
            String slq = "select * from programacion.alumnos where cod_alumno= '" + codAlumno + "' ";
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

    public Alumno existeUnAlumno(String codAlumno) {
        Alumno miAlumno = null;
        try {
            String slq = "select * from programacion.alumnos where cod_alumno= '" + codAlumno + "' ";
            Statement st = bd.getConexion().createStatement();
            ResultSet registros = st.executeQuery(slq);
            if (registros.first()) {
                /*en este if le decimos; colocate en el primer registro
                porque la sentencia solo devolvera un registro porque hemos
                puesto una condicion (un where).
                si en ese primer y único registro eexiste un valor igual que
                el que hemos puesto dentro del where, entonces, ya existe u no lo agregues*/
                miAlumno = new Alumno(registros.getInt("cod_Alumno"),
                        registros.getString("nombre"), registros.getString("dni"),
                        registros.getString("cod_Curso"), registros.getString("direccion"),
                        registros.getString("poblacion"), registros.getInt("telefono"),
                        registros.getDouble("importe_gastos"));
                registros.close();
                st.close();
            }
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return miAlumno;
    }

    public int grabarAlumno(int codAlumno, String nombre, String dni, String codCurso, String direccion, String poblacion, int telefono, double importeGastos) {
        int valor = 0;
        String sql = "insert into alumnos(cod_Alumno, nombre, dni, cod_Curso, direccion, poblacion, telefono, importe_gastos) values('"
                + codAlumno + "','" + nombre + "','" + dni + "','" + codCurso + "','" + direccion + "','" + poblacion + "','" + telefono + "','" + importeGastos + "')";
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

    public int borrarAlumno(int cod_alumno) {
        int valor = 0;
        String sql = "delete from programacion.alumnos where cod_alumno= '" + cod_alumno + "'";
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

    public int actualizarRegistros(Alumno a) {
        int registros = 0;
        try {
            String sql = "update alumnos set cod_Curso='" + a.getCodCurso()
                    + "' where cod_Alumno='" + a.getCodAlumno() + "'";
            Statement st = bd.getConexion().createStatement();
            registros = st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    /* public int actualizarRegistros(Alumno a) {
        int registros = 0;
        try {
            String sql = "update alumnos set nombre='" + a.getNombre()
                    + "',dni='" + a.getDni() + "',cod_Curso='" + a.getCodCurso()
                    + "',direccion='" + a.getDireccion() + "',poblacion='" + a.getPoblacion()
                    + "',telefono='" + a.getTelefono() + "',importe_gastos='" + a.getImporteGastos()
                    + "' where cod_Alumno='" + a.getCodAlumno() + "'";
            Statement st = bd.getConexion().createStatement();
            registros = st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }*/
 /*public Statement consultarMaxId(int codAlumno) {
        String sql = "select max(cod_alumno) from alumno";
        Statement st;
        ResultSet registros=null;
        try {
            st = bd.getConexion().createStatement();
            registros =st.executeQuery(sql);
            /*executeUpdate te devuelve la cantidad de registros grabados*/
 /*} catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }*/
}
