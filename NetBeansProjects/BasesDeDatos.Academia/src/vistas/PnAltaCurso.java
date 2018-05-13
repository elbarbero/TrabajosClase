/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Conexion;
import controlador.GestorTablaCurso;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class PnAltaCurso extends javax.swing.JPanel {

    Conexion bd;

    /**
     * Creates new form PnAltaCurso
     */
    public PnAltaCurso() {
        initComponents();
        bd = new Conexion();
        int resultado = bd.establecer("jdbc:mysql://localhost:3306/programacion");// lo último es el nombre de la base de datos
        if (resultado != 0) {
            JOptionPane.showMessageDialog(this, "CONEXIÓN INCORRECTA");
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDenominacion = new javax.swing.JTextField();
        txtNPlazas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jLabel2.setText("DENOMINACIÓN");

        jLabel3.setText("Nº PLAZAS");

        jLabel4.setText("CÓDIGO");

        jLabel1.setText("ALTA DE ACADEMIAS");

        btnGrabar.setText("GRABAR");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDenominacion, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(txtNPlazas)
                                    .addComponent(txtCodigo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGrabar)
                                .addGap(63, 63, 63)
                                .addComponent(btnCancelar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnCancelar))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        String cod_curso, denominacion;
        int nPlazasDisp = 0;
        GestorTablaCurso tabla = new GestorTablaCurso(bd);
        cod_curso = txtCodigo.getText();
        if (tabla.existeCurso(cod_curso)) {
            JOptionPane.showMessageDialog(this, "EL CURSO YA EXISTE");
            txtCodigo.setText("");
            txtCodigo.requestFocus();
        } else {
            denominacion = txtDenominacion.getText();
            /*Si "txtNPlazas.getText()" está vacio nos devuelve "", por eso hacemos el compare to*/
            if (denominacion.length() == 0 || txtNPlazas.getText().compareToIgnoreCase("") == 0) {
                JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR");
                limpiar();
            } else {
                try {
                    nPlazasDisp = Integer.parseInt(txtNPlazas.getText());
                    if (tabla.grabarCurso(cod_curso, denominacion, nPlazasDisp) == 1) {
                        /*le decimos si es igual a 1 porque solo añadimos un registro cada vez por lo
                que siempre nos devolvera 1 si la grabación es correcta*/
                        JOptionPane.showMessageDialog(this, "REGISTRO AÑADIDO");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(this, "SE HA PRODUCIDO ALGÚN ERROR");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "NO ES UN NÚMERO");
                    txtNPlazas.setText("");
                }
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    public void limpiar() {
        txtCodigo.setText("");
        txtDenominacion.setText("");
        txtNPlazas.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDenominacion;
    private javax.swing.JTextField txtNPlazas;
    // End of variables declaration//GEN-END:variables
}
