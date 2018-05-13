/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author 203pc19
 */
public class VentanaMedico extends javax.swing.JFrame {

    PnAltaMedicacion pAltaMedicacion;
    PnConsultarMedicacionMedico pConsultarMedicacion;

    /**
     * Creates new form VentanaMedico
     */
    public VentanaMedico() {
        initComponents();
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
        miAltaMedicacion = new javax.swing.JMenuItem();
        miConsultamed = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miSalirAplicacion = new javax.swing.JMenuItem();
        miCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MEDICO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.FlowLayout());

        jMenu1.setText("Control");

        miAltaMedicacion.setText("Alta medicación");
        miAltaMedicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltaMedicacionActionPerformed(evt);
            }
        });
        jMenu1.add(miAltaMedicacion);

        miConsultamed.setText("Consulta medicación");
        miConsultamed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultamedActionPerformed(evt);
            }
        });
        jMenu1.add(miConsultamed);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");

        miSalirAplicacion.setText("Salir de la aplicación");
        miSalirAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirAplicacionActionPerformed(evt);
            }
        });
        jMenu2.add(miSalirAplicacion);

        miCerrarSesion.setText("Cerrar sesion");
        miCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarSesionActionPerformed(evt);
            }
        });
        jMenu2.add(miCerrarSesion);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSalirAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirAplicacionActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "¿DESEA SALIR DEL SISTEMA?", "SALIR DEL SISTEMA",
                JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_miSalirAplicacionActionPerformed

    private void miCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarSesionActionPerformed
        this.dispose();
        new Login().setVisible(true);//Así abrimos la ventana de nuevo
        pack();
    }//GEN-LAST:event_miCerrarSesionActionPerformed

    private void miAltaMedicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltaMedicacionActionPerformed
        quitarPaneles();
        pAltaMedicacion = new PnAltaMedicacion();
        getContentPane().add(pAltaMedicacion);
        pack();
    }//GEN-LAST:event_miAltaMedicacionActionPerformed

    private void miConsultamedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultamedActionPerformed
        quitarPaneles();
        pConsultarMedicacion = new PnConsultarMedicacionMedico();
        getContentPane().add(pConsultarMedicacion);
        pack();
    }//GEN-LAST:event_miConsultamedActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int x = JOptionPane.showConfirmDialog(this, "¿DESEA SALIR DEL SISTEMA?", "SALIR DEL SISTEMA",
                JOptionPane.YES_NO_OPTION);     // LOS BOTONES 0 PARA EL CIERRE Y 1 PARA EL NO
        if (x == JOptionPane.YES_OPTION) {    //TAMBIEN ES VALIDO ESTA LINEA PARA EL IF EN VEZ DE EL 0
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing
    private void quitarPaneles() {
        try {
            this.remove(pAltaMedicacion);
        } catch (Exception e) {
        }
        try {
            this.remove(pConsultarMedicacion);
        } catch (Exception e) {
        }
    }

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
            java.util.logging.Logger.getLogger(VentanaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miAltaMedicacion;
    private javax.swing.JMenuItem miCerrarSesion;
    private javax.swing.JMenuItem miConsultamed;
    private javax.swing.JMenuItem miSalirAplicacion;
    // End of variables declaration//GEN-END:variables
}
