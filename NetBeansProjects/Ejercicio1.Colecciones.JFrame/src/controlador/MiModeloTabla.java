/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 203pc19
 */
public class MiModeloTabla extends DefaultTableModel{
    /*En esta clase heredamos todo lo que corresponda o contenga
    DefaultTableModel que es todo lo de JTable*/
    @Override// esto quiere decir que sobreescribimos su propiedad, lo modificamos
    public boolean isCellEditable(int row, int column){
        /*el "return false" quiere decir que haga lo que haga,
        ninguna celda sea editable*/
        return false;
    }
}
