/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.MiModeloTabla;
import modelo.Correo;
import modelo.Empresa;
import modelo.Usuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 203pc19
 */
public class pnLeer extends javax.swing.JPanel {
    
    DefaultTableModel modeloTabla;
    Usuario validado;
    Empresa miEmpresa;

    /**
     * Creates new form pnLeer
     */
    public pnLeer(Empresa miEmpresa, Usuario validado) {
        /*sino ponemos esto no podemos trabajar con ello y siempre será nulo
         Hay que hacerlo antes de trabajar con ello en el constructor.
         No es necesario ponerlo después del initComponent()*/
        this.validado = validado;
        this.miEmpresa = miEmpresa;
        initComponents();
        modeloTabla = new MiModeloTabla();//"MiModeloTabla" es el nombre de la clase que hereda todo de JTable
        /*Esto ,modeloTabla = new MiModeloTabla();, es igual que esto: modeloTabla = new DefaultTableModel();*/
        String[] titulos = {"Fecha", "Emisor", "Asunto"};// Son los titulos que va a tener cada columna. Total 2 columnas
        modeloTabla.setColumnIdentifiers(titulos);
        tblCorreos.setModel(modeloTabla);
        cargarCorreos();
    }
    
    private void cargarCorreos() {
        ArrayList<Correo> correos = validado.getbEntrada();
        for (int i = 0; i < correos.size(); i++) {
            Correo c = correos.get(i);/* esto no me devuelve la posición del correo,
             esto ya me devuelve el correo en concreto*/
            
            String[] datos = new String[3];
            datos[0] = c.getFecha();
            datos[1] = c.getRemitente().getEmail();
            datos[2] = c.getAsunto();
            modeloTabla.addRow(datos);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCorreos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        taTexto = new javax.swing.JTextArea();
        btnBorrar = new javax.swing.JButton();

        tblCorreos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblCorreos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCorreosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCorreos);

        taTexto.setColumns(20);
        taTexto.setRows(5);
        jScrollPane2.setViewportView(taTexto);

        btnBorrar.setText("BORRAR CORREO");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrar)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrar)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblCorreosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCorreosMouseClicked
        int fila = tblCorreos.rowAtPoint(evt.getPoint());//Así leemos el correo seleccionado
        Correo c = validado.getbEntrada().get(fila);
        taTexto.setText(c.getTexto());
    }//GEN-LAST:event_tblCorreosMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

 
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taTexto;
    private javax.swing.JTable tblCorreos;
    // End of variables declaration//GEN-END:variables
}
