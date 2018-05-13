package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 203pc19
 */
public class Conexion {

    private Connection conexion;

    public Connection getConexion() {
        /*Ponemos un get porque necesitamos acceder a la conexion
         para poder modficar o leer algo de la base de datos de sql*/
        return conexion;
    }

    /**
     * Método para registrar el driver JDBC de mySQL
     *
     * @return Si es "0" dirver registrado y si es "-1" driver no registrado
     */
    public int registrarDriver() {
        int resultado;
        try {
            Class.forName("com.mysql.jdbc.Driver");//esto nos permite trabajar con bases de datos de mySQL
            resultado = 0;
        } catch (ClassNotFoundException ex) {
            resultado = -1;//si no lo encuentra que me devuelva "-1"
        }
        return resultado;
    }

    /**
     * Método para conectarse con la base da datos de mySQL
     *
     * @param url es protocolo(dirccion) de la base da datos
     * @return Si es "0" la conexión se ha establecido, si es "-1" la direccion
     * de la base de datos o el usuario no existe y si es "-2" es un error
     * generico
     */
    public int conectar(String url) {
        /*para establecer la conexion y sirve para cualquier base de datos de mySQL
         y le pasamos la direccion de la base de datos*/
        int resultado;
        try {
            /*lo de los parantesis es la direccion de la base de datos, el usuario y la contraseña con la que accedemos a mySQL*/
            conexion = DriverManager.getConnection(url, "root", "root");
            /*conexion = DriverManager.getConnection(url, "root", "");*/
            resultado = 0;
        } catch (SQLException e) {
            /*para cuando intentamos acceder a una base da datos que no existe
             o el usuario no existe*/
            resultado = -1;
        } catch (Exception e) {
            resultado = -2;
        }
        return resultado;
    }

    /**
     * Método para conectarse en el orden correcto con la base da datos de mySQL
     *
     * @param url es protocolo(dirccion) de la base da datos
     * @return devuelve el resultado. Si es"0" la conexion es correcta
     */
    public int establecer(String url) {
        int resultado;
        resultado = registrarDriver();
        if (resultado == 0) {
            resultado = conectar(url);
        }
        return resultado;
    }

    public void cerrar() {
        try {
            conexion.close();
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);//te dice xk se a producido el error
        }
    }
}
