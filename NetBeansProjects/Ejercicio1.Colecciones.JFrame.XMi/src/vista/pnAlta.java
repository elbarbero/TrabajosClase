/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Empresa;
import modelo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class pnAlta extends javax.swing.JPanel {

    Empresa miEmpresa;                                                          //DECLARAMOS LA EMPRESA

    /**
     * Creates new form pnAlta
     */
    public pnAlta(Empresa miEmpresa) {                                          //LE PASAMOS AL CONSTRUCTOR LA EMPRESA
        initComponents();
        this.miEmpresa = miEmpresa;                                              //LE PASAMOS LA EMPRESA LA EMPRESA
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
        jLabel4 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        pwdContra = new javax.swing.JPasswordField();
        btnGrabar = new javax.swing.JButton();
        brnCancelar = new javax.swing.JButton();

        jLabel1.setText("ALTA EMPLEADOS:");

        jLabel2.setText("E-MAIL:");

        jLabel3.setText("LOGIN:");

        jLabel4.setText("PASSWORD:");

        btnGrabar.setText("GRABAR");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        brnCancelar.setText("CANCELAR");
        brnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(brnCancelar)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(42, 42, 42))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMail)
                                    .addComponent(txtLogin)
                                    .addComponent(pwdContra, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pwdContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(brnCancelar))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        String login, email, password;
        login = txtLogin.getText().trim();                                        //COGE LO QUE HAY EN EL CUADRO DE TEXTO ESCRITO Y TRIM QUITA LOS ESPACIOS DEL PRINCIPIO Y DEL FINAL
        if (login.length() == 0) {
            JOptionPane.showMessageDialog(this, "LOGIN. CAMPO OBLIGATORIO");    //SI EL CAMPO ESTA VACIO, MENSAJE
        } else {
            if (miEmpresa.buscarUsuario(login)) {                                 //SINO BUSCA SI EXISTE EL USUARIO
                JOptionPane.showMessageDialog(this, "LOGIN. EXISTENTE");        //SI EXISTE MENSAJE
                txtLogin.setText("");                                           //BORRA LOS CAMPOS DE LOGIN
                txtLogin.requestFocus();                                        //RECUPERA EL FOCO
            } else {                                                              //SI EL USUARIO NO EXISTE...
                email = txtMail.getText().trim();
                if (email.length() == 0) {
                    JOptionPane.showMessageDialog(this, "EMAIL. CAMPO OBLIGATORIO");    //SI EL CAMPO ESTA VACIO, MENSAJE
                    txtMail.setText("");                                           //BORRA LOS CAMPOS DE LOGIN
                    txtMail.requestFocus();                                        //RECUPERA EL FOCO
                } else {
                    if (miEmpresa.buscarEmail(email)) {
                        JOptionPane.showMessageDialog(this, "EMAIL. EXISTENTE");        //SI EXISTE MENSAJE
                        txtLogin.setText("");                                           //BORRA LOS CAMPOS DE LOGIN
                        txtLogin.requestFocus();                                        //RECUPERA EL FOCO
                    } else {
                        password = new String(pwdContra.getPassword());                        
                        password = password.trim();
                        if (password.length() == 0) {
                            JOptionPane.showMessageDialog(this, "CONTRASEÑA OBLIGATORIA");
                            pwdContra.setText("");
                            pwdContra.requestFocus();
                        } else {
                            /*Escribimos las variables seegún el orden en que esten definidas
                            en el constructor de la clase "Usuario" pero con el nombre
                            que le hayamos puesto en este mismo método*/
                            Usuario nuevo = new Usuario(email, login, password);
                            miEmpresa.getUsuarios().add(nuevo);
                            JOptionPane.showMessageDialog(this, "Usuario Nuevo Creado");
                            limpiar();
                        }
                    }
                }
            }            
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void brnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_brnCancelarActionPerformed
    private void limpiar() {
        txtLogin.setText("");
        txtMail.setText("");
        pwdContra.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnCancelar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pwdContra;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtMail;
    // End of variables declaration//GEN-END:variables
}
