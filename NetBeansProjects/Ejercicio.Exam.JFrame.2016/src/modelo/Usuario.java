/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 203pc19
 */
public class Usuario {

    String login;
    String pass;
    int tipo;

    public Usuario(String login, String pass, int tipo) {
        this.login = login;
        this.pass = pass;
        this.tipo = tipo;
    }

    public Usuario(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public int getTipo() {
        return tipo;
    }

}
