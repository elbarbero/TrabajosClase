/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JOptionPane;
import modelo.Empresa;
import modelo.Usuario;

/**
 *
 * @author 203pc19
 */
public class Login extends javax.swing.JFrame {

    Empresa miEmpresa;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        miEmpresa = new Empresa();
        Usuario u1 = new Usuario("admin", "xxx", 1);
        Usuario u2 = new Usuario("profe", "xxx", 0);
        miEmpresa.getUsuarios().add(u1);
        miEmpresa.getUsuarios().add(u2);
    }

    public Login(Empresa miEmpresa) {
        initComponents();
        this.miEmpresa = miEmpresa;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLogin = new javax.swing.JTextField();
        pwdContra = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión Académica");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        jLabel1.setText("USUARIO:");

        jLabel2.setText("PASSWORD:");

        jLabel3.setText("- VENTANA DE LOGIN - ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwdContra)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwdContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String login = txtLogin.getText();
        String password = new String(pwdContra.getPassword());                   // USAR EL get.Password Y CONVERTIRLO A STRING
        int pos = miEmpresa.buscarUsuario(login, password);                     // BUSCA LA EXITENCIA DEL USUARIO Y SU PASSWORD
        if (pos == -1) {                                                            // SI LA POS ES -1 MENSAJE: USUARIO INCORRECTO
            JOptionPane.showMessageDialog(this, "Usuarios Incorrecto");
        } else {                                                                  // SI ES OTRO NUMERO LA POSICION
            if (miEmpresa.getUnUsuario(pos).getTipo() == 1) {
                new VentanaAdmin(miEmpresa, miEmpresa.getUnUsuario(pos)).setVisible(true);                                      // ABRE UNA NUEVA VENTANA VADMIN
            } else {
                //con "miEmpresa.Get...(pos)" recibimos toda la informacion del usuario de esa posicion
                new VentanaProfe(miEmpresa, miEmpresa.getUnUsuario(pos)).setVisible(true);
                //miEmpresa.getUnUsuarios(pos), esto es el usuario que se ha validado
            }
            dispose();           
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int x = JOptionPane.showConfirmDialog(this, //DEVUELVE UN VALOR ENTERO 
                "¿DESEA SALIR DEL SISTEMA?", // MENSAJE DE CABECERA ENCIMA DE LOS BOTONES
                "SALIR DEL SISTEMA", // BARRA DE TITULO DE LA VENTANA
                JOptionPane.YES_NO_OPTION);     // LOS BOTONES 0 PARA EL CIERRE Y 1 PARA EL NO
        if (x == JOptionPane.YES_OPTION) {    //TAMBIEN ES VALIDO ESTA LINEA PARA EL IF EN VEZ DE EL 0
            //if (x == 0) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int x = JOptionPane.showConfirmDialog(this, //DEVUELVE UN VALOR ENTERO 
                "¿DESEA SALIR DEL SISTEMA?", // MENSAJE DE CABECERA ENCIMA DE LOS BOTONES
                "SALIR DEL SISTEMA", // BARRA DE TITULO DE LA VENTANA
                JOptionPane.YES_NO_OPTION);     // LOS BOTONES 0 PARA EL CIERRE Y 1 PARA EL NO
        if (x == JOptionPane.YES_OPTION) {    //TAMBIEN ES VALIDO ESTA LINEA PARA EL IF EN VEZ DE EL 0
            //if (x == 0) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pwdContra;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
