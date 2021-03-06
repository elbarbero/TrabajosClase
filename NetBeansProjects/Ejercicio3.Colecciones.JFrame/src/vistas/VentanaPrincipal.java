/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import modelo.Empresa;
import modelo.Sala;

/**
 *
 * @author Mario-Portatil
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    pnAltaClientes pAltaClientes;
    pnAlquiler pAlquiler;
    pnConsulta pConsulta;
    Empresa miEmpresa;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        initComponents();
        this.setSize(400, 400);//para darle tamaño a la ventana
        miEmpresa = new Empresa();
        cargarDatos();
    }

    private void cargarDatos() {
        Sala s = new Sala(1, "Sala 1", 1000);
        miEmpresa.anadirUnaSala(s);
        s = new Sala(2, "Sala 2", 1500);
        miEmpresa.anadirUnaSala(s);
        s = new Sala(3, "Sala 3", 2100);
        miEmpresa.anadirUnaSala(s);
        s = new Sala(4, "Sala 4", 3000);
        miEmpresa.anadirUnaSala(s);
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
        miAlta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miAlquilerSalas = new javax.swing.JMenuItem();
        miConsulta = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GESTIÓN DE ALQUILERES");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrar(evt);
            }
        });
        getContentPane().setLayout(new java.awt.FlowLayout());

        jMenu1.setText("Clientes");

        miAlta.setText("Alta");
        miAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltaActionPerformed(evt);
            }
        });
        jMenu1.add(miAlta);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salas");

        miAlquilerSalas.setText("Alquiler");
        miAlquilerSalas.setToolTipText("asd");
        miAlquilerSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlquilerSalasActionPerformed(evt);
            }
        });
        jMenu2.add(miAlquilerSalas);

        miConsulta.setText("Consulta");
        miConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaActionPerformed(evt);
            }
        });
        jMenu2.add(miConsulta);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Salir");

        miCerrar.setText("Cerrar");
        jMenu3.add(miCerrar);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void quitarPaneles() {
        /* try {
         remove(miVentana);
         } catch (Exception ex) {
         }*/
        try {
            remove(pAltaClientes);
        } catch (Exception ex) {
        }
        try {
            remove(pAlquiler);
        } catch (Exception ex) {
        }
        try {
            remove(pConsulta);
        } catch (Exception ex) {
        }

        //pack(); no es necesario ponerlo aqui
    }
    private void miAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltaActionPerformed
        quitarPaneles();
        pAltaClientes = new pnAltaClientes(miEmpresa);
        this.getContentPane().add(pAltaClientes, BorderLayout.CENTER);
        pack();
    }//GEN-LAST:event_miAltaActionPerformed

    private void miAlquilerSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlquilerSalasActionPerformed
        quitarPaneles();
        pAlquiler = new pnAlquiler(miEmpresa);
        getContentPane().add(pAlquiler, BorderLayout.CENTER);
        pack();
    }//GEN-LAST:event_miAlquilerSalasActionPerformed

    private void miConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaActionPerformed
        quitarPaneles();
        pConsulta = new pnConsulta(miEmpresa);
        getContentPane().add(pConsulta, BorderLayout.CENTER);
        pack();
    }//GEN-LAST:event_miConsultaActionPerformed

    private void cerrar(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_cerrar
        int x = JOptionPane.showConfirmDialog(this, //DEVUELVE UN VALOR ENTERO 
                "¿DESEA SALIR DEL SISTEMA?", // MENSAJE DE CABECERA ENCIMA DE LOS BOTONES
                "SALIR DEL SISTEMA", // BARRA DE TITULO DE LA VENTANA
                JOptionPane.YES_NO_OPTION);// LOS BOTONES 0 PARA EL CIERRE Y 1 PARA EL NO
        //int x2 = JOptionPane.showConfirmDialog(this, "¿DESEA SALIR DEL SISTEMA?");
        if (x == JOptionPane.NO_OPTION) { //TAMBIEN ES VALIDO ESTA LINEA PARA EL IF EN VEZ DE EL 0

        } else { //if (x2 == 0) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_cerrar

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miAlquilerSalas;
    private javax.swing.JMenuItem miAlta;
    private javax.swing.JMenuItem miCerrar;
    private javax.swing.JMenuItem miConsulta;
    // End of variables declaration//GEN-END:variables
}
