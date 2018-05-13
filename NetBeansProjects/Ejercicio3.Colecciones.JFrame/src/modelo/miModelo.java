/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 203pc19
 */
public class miModelo extends DefaultTableModel {//hereda del modelo DefaultTableModel
    public boolean isCellEditable(int row, int column){
        /*Así no dejamos modificar la informacion de la tabla*/
        return false;
    }
}
