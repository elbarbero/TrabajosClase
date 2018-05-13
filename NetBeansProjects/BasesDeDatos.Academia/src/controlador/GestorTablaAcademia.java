package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Academia;

/**
 *
 * @author 203pc19
 */
public class GestorTablaAcademia {

    Conexion bd;

    public GestorTablaAcademia(Conexion bd) {
        this.bd = bd;
    }

    public ArrayList<Academia> consultaTodasAcademias() {//devuelve una coleccion de datos(arrayList) de tipo "Academia"
        Statement sentencia = null;
        ArrayList<Academia> academias = new ArrayList<>();
        String slq = "select * from programacion.academia";
        try {
            sentencia = bd.getConexion().createStatement();
            ResultSet registros;//para guardar los valores que nos devuelva la sentencia
            registros = sentencia.executeQuery(slq);//asi ejecutamos la sentencia
            while (registros.next()) {//mientras tenga registros...
                Academia a = new Academia(registros.getString("nombre"),
                        registros.getString("cif"), registros.getString("direccion"),
                        registros.getString("poblacion"), registros.getString("telefono"), registros.getString("email"));
                academias.add(a);
            }
            registros.close();
            sentencia.close();
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return academias;
    }

    public boolean existeAcademia(String cif) {
        boolean existe = false;
        try {
            String slq = "select * from programacion.academia where cif= '" + cif + "' ";
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

    public Academia existeUnaAcademia(String cif) {
        Academia miAcademia = null;
        try {
            String slq = "select * from programacion.academia where cif= '" + cif + "' ";
            Statement st = bd.getConexion().createStatement();
            ResultSet registros = st.executeQuery(slq);
            if (registros.first()) {
                /*en este if le decimos; colocate en el primer registro
                porque la sentencia solo devolvera un registro porque hemos
                puesto una condicion (un where).
                si en ese primer y único registro eexiste un valor igual que
                el que hemos puesto dentro del where, entonces, ya existe u no lo agregues*/
                miAcademia = new Academia(registros.getString("nombre"),
                        registros.getString("cif"), registros.getString("direccion"),
                        registros.getString("poblacion"), registros.getString("telefono"), registros.getString("email"));
                registros.close();
                st.close();
            }
        } catch (SQLException e) {
//Una excepción que proporciona información sobre un error de acceso a la base de datos
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
        return miAcademia;
    }

    public int grabarAcademia(String nombre, String cif, String direccion, String poblacion, String telefono, String email) {
        int valor = 0;
        String sql = "insert into academia(nombre,cif,direccion,poblacion,telefono, email)values('"
                + nombre + "','" + cif + "','" + direccion + "','" + poblacion + "','" + telefono + "','" + email + "')";
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

    public int actualizarRegistros(Academia a) {
        int registros = 0;
        try {
            String sql = "update academia set telefono='" + a.getTelefono()
                    + "',email='" + a.getEmail() + "' where cif='" + a.getCif() + "'";
            Statement st = bd.getConexion().createStatement();
            registros = st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    
    /*public int actualizarRegistros(Academia a) {
        int registros = 0;
        try {
            String sql = "update academia set nombre='" + a.getNombre()
                    + "', cif='" + a.getCif() + "', direccion='" + a.getDireccion()
                    + "',poblacion=" + a.getPoblacion() + "',telefono=" + String.valueOf(a.getTelefono())
                    + "',email=" + a.getEmail() + " where cif='" + a.getCif() + "'";
            Statement st = bd.getConexion().createStatement();
            registros = st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTablaAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }*/
}
