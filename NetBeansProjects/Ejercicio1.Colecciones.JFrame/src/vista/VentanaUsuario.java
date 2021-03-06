/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Empresa;
import modelo.Usuario;

/**
 *
 * @author 203pc19
 */
public class VentanaUsuario extends javax.swing.JFrame {

    Empresa miEmpresa;
    Usuario validado;
    pnEnviar pEnviar;//objeto de tipo panel de enviar
    pnLeer pLeer;

    /**
     * Creates new form VentanaUsuario
     */
    public VentanaUsuario(Empresa miEmpresa, Usuario validado) {
        initComponents();
        this.miEmpresa = miEmpresa;
        this.validado = validado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuModificar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuLeer = new javax.swing.JMenuItem();
        mnuEnviar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuSesion = new javax.swing.JMenuItem();
        mnuCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jMenu1.setText("Datos Personales");

        mnuModificar.setText("Modificar");
        jMenu1.add(mnuModificar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Correos");

        mnuLeer.setText("Leer");
        mnuLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLeerActionPerformed(evt);
            }
        });
        jMenu2.add(mnuLeer);

        mnuEnviar.setText("Enviar");
        mnuEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEnviarActionPerformed(evt);
            }
        });
        jMenu2.add(mnuEnviar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Salir");

        mnuSesion.setText("Cerrar Sesión");
        mnuSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSesionActionPerformed(evt);
            }
        });
        jMenu3.add(mnuSesion);

        mnuCerrar.setText("Salir de la Aplicación");
        jMenu3.add(mnuCerrar);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLeerActionPerformed
        quitarPaneles();
        pLeer = new pnLeer(miEmpresa, validado);
        this.getContentPane().add(pLeer);
        pack();
    }//GEN-LAST:event_mnuLeerActionPerformed

    private void mnuEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEnviarActionPerformed
        quitarPaneles();//para quitar el el panel de enviar nada mas dar en el menuItem enviar
        pEnviar = new pnEnviar(miEmpresa, validado);
        this.getContentPane().add(pEnviar);
        pack();
    }//GEN-LAST:event_mnuEnviarActionPerformed

    private void mnuSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSesionActionPerformed
        new Login(miEmpresa).setVisible(true);
        dispose();
        pack();
    }//GEN-LAST:event_mnuSesionActionPerformed
    private void quitarPaneles() {
        try {
            this.remove(pEnviar);
        } catch (Exception e) {
        }
        try {
            this.remove(pLeer);
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuCerrar;
    private javax.swing.JMenuItem mnuEnviar;
    private javax.swing.JMenuItem mnuLeer;
    private javax.swing.JMenuItem mnuModificar;
    private javax.swing.JMenuItem mnuSesion;
    // End of variables declaration//GEN-END:variables
}
