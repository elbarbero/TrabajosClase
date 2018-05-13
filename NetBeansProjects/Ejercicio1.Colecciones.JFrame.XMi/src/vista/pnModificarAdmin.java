/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Correo;
import modelo.Empresa;
import modelo.Fecha;
import modelo.Usuario;

/**
 *
 * @author Mario-Portatil
 */
public class pnModificarAdmin extends javax.swing.JPanel {

    DefaultComboBoxModel modelo;
    Empresa miEmpresa;
    Usuario validado;
    pnModificarAdmin pnModAdmin;
    Fecha f;

    /**
     * Creates new form pnModificarAdmin
     */
    public pnModificarAdmin(Empresa miEmpresa, Usuario validado) {
        this.miEmpresa = miEmpresa;
        this.validado = validado;
        initComponents();
        modelo = new DefaultComboBoxModel();
        cmbEmpleados.setModel(modelo);
        cargarEmpleados();
        f = new Fecha();
    }

    private void cargarEmpleados() {
        /*Lista de arrays que son de tipo Usuario(<Usuario>) y lo llamamos "usuarios"*/
        ArrayList<Usuario> usuarios = miEmpresa.getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            modelo.addElement(usuarios.get(i));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbEmpleados = new javax.swing.JComboBox<String>();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPassVieja = new javax.swing.JTextField();
        btnVer = new javax.swing.JButton();
        txtPassNuevo1 = new javax.swing.JPasswordField();
        txtPassNuevo2 = new javax.swing.JPasswordField();

        jLabel1.setText("EMPLEADOS");

        jLabel2.setText("CONTRASEÑA NUEVA");

        jLabel3.setText("CONTRASEÑA NUEVA");

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("CONTRASEÑA VIEJA");

        txtPassVieja.setEditable(false);

        btnVer.setText("VER");
        btnVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVerMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPassNuevo2)
                                    .addComponent(txtPassNuevo1)
                                    .addComponent(btnCancelar)
                                    .addComponent(txtPassVieja, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(btnVer)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassVieja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVer))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassNuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void envio() {
        Usuario user;
        String fecha;
        String asunto = "Cambio de contraseña por el administrador";
        user = (Usuario) cmbEmpleados.getSelectedItem();//...y después cojo el valor selecionado, que lo hemos puesto en la posicion 0
        fecha = f.visualizar();
        String texto = "Su nueva contraseña es: " + user.getPassword();// me da la contraseña nueva
        //  cmbEmpleados.setSelectedIndex(0);//primero pongo cojo el valor de la posicion 0...
        
        Correo c = new Correo(fecha, asunto, texto, validado);
        user.getbEntrada().add(c); //y se le añade a su bandeja de entrada
        limpiar();
    }
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String passNuevo;
        Usuario user;
        String texto = "";
        String valor = new String(txtPassNuevo1.getPassword());
        //Pasamos ambos txtPassNuevo a un String para poder comprarlos despues
        String valor2 = new String(txtPassNuevo2.getPassword());
        if (valor.compareToIgnoreCase(valor2) != 0) {
            JOptionPane.showMessageDialog(this, "La contraseña nueva no coincide");
            txtPassNuevo1.setText("");
            txtPassNuevo2.setText("");
        } else {
            passNuevo = txtPassNuevo2.getText();
            user = (Usuario) cmbEmpleados.getSelectedItem();
            user.setPassword(passNuevo);
            envio();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerMousePressed
        String passViejo;
        Usuario user;
        user = (Usuario) modelo.getSelectedItem();
        passViejo = user.getPassword();
        txtPassVieja.setText(passViejo);
    }//GEN-LAST:event_btnVerMousePressed

    private void btnVerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerMouseReleased
        txtPassVieja.setText("");
    }//GEN-LAST:event_btnVerMouseReleased
    private void limpiar() {
        txtPassNuevo1.setText("");
        cmbEmpleados.getSelectedItem();
        txtPassNuevo2.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox<String> cmbEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtPassNuevo1;
    private javax.swing.JPasswordField txtPassNuevo2;
    private javax.swing.JTextField txtPassVieja;
    // End of variables declaration//GEN-END:variables
}
