/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JOptionPane;
import modelo.Agenda;
import modelo.Empresa;
import modelo.Usuario;

/**
 *
 * @author Mario
 */
public class VentanaEmpleado extends javax.swing.JFrame {

    Empresa miEmpresa;
    Usuario validado;
    pnModificarDatosPers pModificarDatos;
    pnInsertarEventUser pnInsertarEventos;
    pnAnularEventUser pnAnularEventos;
    pnConsultarEventUser pnConsultarEventos;

    /**
     * Creates new form VentanaEmpleado
     */
    public VentanaEmpleado() {
        initComponents();
    }

    public VentanaEmpleado(Empresa miEmpresa, Usuario validado) {
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
        miModificarDatos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miIntroducir = new javax.swing.JMenuItem();
        miConsultar = new javax.swing.JMenuItem();
        miAnular = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miCerrarSesion = new javax.swing.JMenuItem();
        miSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.FlowLayout());

        jMenu1.setText("Datos Personales");

        miModificarDatos.setText("Modificar");
        miModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miModificarDatosActionPerformed(evt);
            }
        });
        jMenu1.add(miModificarDatos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Agenda");

        miIntroducir.setText("Introducir Evento");
        miIntroducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miIntroducirActionPerformed(evt);
            }
        });
        jMenu2.add(miIntroducir);

        miConsultar.setText("Consultar Evento");
        miConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultarActionPerformed(evt);
            }
        });
        jMenu2.add(miConsultar);

        miAnular.setText("Anular Evento");
        miAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAnularActionPerformed(evt);
            }
        });
        jMenu2.add(miAnular);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Salir");

        miCerrarSesion.setText("Cerrar Sesión");
        miCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarSesionActionPerformed(evt);
            }
        });
        jMenu3.add(miCerrarSesion);

        miSalir.setText("Salir de la Aplicación");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        jMenu3.add(miSalir);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void quitarPaneles() {
        try {
            this.remove(pModificarDatos);
        } catch (Exception e) {
        }
        try {
            this.remove(pnInsertarEventos);
        } catch (Exception e) {
        }
        try {
            this.remove(pnAnularEventos);
        } catch (Exception e) {
        }
        try {
            this.remove(pnConsultarEventos);
        } catch (Exception e) {
        }
    }
    private void miCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarSesionActionPerformed
        //new Login(miEmpresa).setVisible(true);
        this.dispose();
        //vPrincipal.setVisible(true);
        new VentanaPrincipal(miEmpresa).setVisible(true);//Así abrimos la ventana de nuevo
        pack();
    }//GEN-LAST:event_miCerrarSesionActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        int x = JOptionPane.showConfirmDialog(this, //DEVUELVE UN VALOR ENTERO 
                "¿DESEA SALIR DEL SISTEMA?", // MENSAJE DE CABECERA ENCIMA DE LOS BOTONES
                "SALIR DEL SISTEMA", // BARRA DE TITULO DE LA VENTANA
                JOptionPane.YES_NO_OPTION);     // LOS BOTONES 0 PARA EL CIERRE Y 1 PARA EL NO
        if (x == JOptionPane.YES_OPTION) {    //TAMBIEN ES VALIDO ESTA LINEA PARA EL IF EN VEZ DE EL 0
            //if (x == 0) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_miSalirActionPerformed

    private void miModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miModificarDatosActionPerformed
        quitarPaneles();
        pModificarDatos = new pnModificarDatosPers(validado);
        getContentPane().add(pModificarDatos);
        pack();
    }//GEN-LAST:event_miModificarDatosActionPerformed

    private void miConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultarActionPerformed
        quitarPaneles();
        pnConsultarEventos = new pnConsultarEventUser(validado, miEmpresa);
        getContentPane().add(pnConsultarEventos);
        pack();
    }//GEN-LAST:event_miConsultarActionPerformed

    private void miIntroducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miIntroducirActionPerformed
        quitarPaneles();
        pnInsertarEventos = new pnInsertarEventUser(validado);
        getContentPane().add(pnInsertarEventos);
        pack();
    }//GEN-LAST:event_miIntroducirActionPerformed

    private void miAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAnularActionPerformed
        quitarPaneles();
        pnAnularEventos = new pnAnularEventUser(miEmpresa, validado);
        getContentPane().add(pnAnularEventos);
        pack();
    }//GEN-LAST:event_miAnularActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miAnular;
    private javax.swing.JMenuItem miCerrarSesion;
    private javax.swing.JMenuItem miConsultar;
    private javax.swing.JMenuItem miIntroducir;
    private javax.swing.JMenuItem miModificarDatos;
    private javax.swing.JMenuItem miSalir;
    // End of variables declaration//GEN-END:variables
}
