package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Coche;

/**
 *
 * @author 203pc19
 */
public class GestorTblCoches {

    Conexion bd;

    public GestorTblCoches(Conexion bd) {
        this.bd = bd;
    }

    public ArrayList<Coche> consultaTodosCoches() {//devuelve una coleccion de datos(arrayList) de tipo "Coche"
        Statement sentencia = null;
        ArrayList<Coche> coches = new ArrayList<>();
        String slq = "select * from programacion.tblCoches";
        /*String slq = "select * from programacion.tblCoches where matricula='4444JDK'";*/
        try {
            sentencia = bd.getConexion().createStatement();
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(slq);//asi ejecutamos la sentencia
            while (registros.next()) {//mientras tenga registros...
                Coche c = new Coche(registros.getString("matricula"),
                        registros.getString("marca"), registros.getString("modelo"),
                        registros.getString("color"), registros.getFloat("precio"));
                coches.add(c);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return coches;
    }

    public boolean existeCoche(String matricula) {
        boolean existe = false;
        try {
            String slq = "select * from programacion.tblCoches where matricula= '" + matricula + "' ";
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

    public Coche existeUnCoche(String matricula) {
        Coche miCoche = null;
        try {
            String slq = "select * from programacion.tblCoches where matricula= '" + matricula + "' ";
            Statement st = bd.getConexion().createStatement();
            ResultSet registros = st.executeQuery(slq);
            if (registros.first()) {
                /*en este if le decimos; colocate en el primer registro
                porque la sentencia solo devolvera un registro porque hemos
                puesto una condicion (un where).
                si en ese primer y único registro eexiste un valor igual que
                el que hemos puesto dentro del where, entonces, ya existe u no lo agregues*/
                miCoche = new Coche(registros.getString("matricula"),
                        registros.getString("marca"), registros.getString("modelo"),
                        registros.getString("color"), registros.getFloat("precio"));
                registros.close();
                st.close();
            }
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return miCoche;
    }

    public int grabarCoche(String matricula, String modelo, String marca, String color, float precio) {
        int valor = 0;
        String sql = "insert into tblCoches(matricula,marca,modelo,color,precio)values('"
                + matricula + "','" + marca + "','" + modelo + "','" + color + "'," + precio + ")";
        Statement st;
        try {
            st = bd.getConexion().createStatement();
            valor = st.executeUpdate(sql);
            /*executeUpdate te devuelve la cantiadad de registros grabados*/
        } catch (SQLException ex) {
            Logger.getLogger(GestorTblCoches.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public int eliminarUnCoche(String matricula) {
        int registros = 0;
        try {
            String sql = "delete from tblcoches where matricula ='" + matricula + "'";
            Statement st = bd.getConexion().createStatement();
            registros = st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTblCoches.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public void cerrar() {
        bd.cerrar();
    }

    public int actualizarRegistros(Coche c) {
        int registros = 0;
        try {
            String sql = "update tblcoches set color='" + c.getColor()
                    + "', marca='" + c.getMarca() + "', modelo='" + c.getModelo()
                    + "',precio=" + String.valueOf(c.getPrecio())
                    + " where matricula='" + c.getMatricula() + "'";
            Statement st = bd.getConexion().createStatement();
            registros = st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTblCoches.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
}
