/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Conexion;
import controlador.GestorTablaAlumno;
import controlador.GestorTablaCurso;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Alumno;

/**
 *
 * @author Mario
 */
public class PnBajaAlumno extends javax.swing.JPanel {

    private Conexion bd;
    DefaultComboBoxModel modeloAlumnos;
    Alumno miAlumno;
    int longitudActual;//LOS ALUMNOS QUE HAY ANTES DE BORRAR ALGUNO
    int longitudVieja;//LOS ALUMNOS QUE HAY DESPUÉS DE BORRAR ALGUNO

    /**
     * Creates new form PnBajaAlumno
     */
    public PnBajaAlumno() {
        initComponents();
        bd = new Conexion();
        modeloAlumnos = new DefaultComboBoxModel();
        cmbAlumnos.setModel(modeloAlumnos);
        int resultado = bd.establecer("jdbc:mysql://localhost:3306/programacion");// lo último es el nombre de la base de datos
        if (resultado != 0) {
            JOptionPane.showMessageDialog(this, "CONEXIÓN INCORRECTA");
            System.exit(0);
        }
        cargarAlumnos();
    }

    private void cargarAlumnos() {
        GestorTablaAlumno a = new GestorTablaAlumno(bd);
        ArrayList<Alumno> alumnos;
        //lo hago así por un comboBox no es compatible con la clase GestorTablaAcademia
        alumnos = a.consultaTodosAlumnos();
        for (int i = 0; i < alumnos.size(); i++) {
            modeloAlumnos.addElement(alumnos.get(i));
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
        cmbAlumnos = new javax.swing.JComboBox<>();
        cmbBorrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdAlumno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtPoblacion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtGastos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setText("MODIFICAR ALUMNOS");

        jLabel2.setText("ALUMNOS");

        cmbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlumnosActionPerformed(evt);
            }
        });

        cmbBorrar.setText("BORRAR");
        cmbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBorrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");

        jLabel9.setText("ID ALUMNO");

        txtIdAlumno.setEditable(false);

        jLabel3.setText("DNI");

        jLabel4.setText("NOMBRE");

        txtDni.setEditable(false);

        txtNombre.setEditable(false);

        jLabel5.setText("CURSO");

        txtCurso.setEditable(false);

        txtDireccion.setEditable(false);

        txtPoblacion.setEditable(false);

        txtTelefono.setEditable(false);

        txtGastos.setEditable(false);

        jLabel6.setText("DIRECCIÓN");

        jLabel7.setText("POBLACIÓN");

        jLabel8.setText("TELÉFONO");

        jLabel10.setText("IMPORTE/GASTOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(cmbBorrar)
                        .addGap(76, 76, 76)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(cmbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdAlumno, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre)
                                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDireccion)
                                .addComponent(txtGastos)
                                .addComponent(txtTelefono)
                                .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBorrar)
                    .addComponent(btnCancelar))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlumnosActionPerformed
        if (longitudActual < longitudVieja) {
            longitudVieja = 0;
            longitudActual = 0;
            cargarAlumnos();
        }
        miAlumno = (Alumno) modeloAlumnos.getSelectedItem();
        txtIdAlumno.setText(Integer.toString(miAlumno.getCodAlumno()));
        txtDni.setText(miAlumno.getDni());
        txtNombre.setText(miAlumno.getNombre());
        txtCurso.setText(miAlumno.getCodCurso());
        txtDireccion.setText(miAlumno.getDireccion());
        txtPoblacion.setText(miAlumno.getPoblacion());
        txtTelefono.setText(Integer.toString(miAlumno.getTelefono()));
        txtGastos.setText(Double.toString(miAlumno.getImporteGastos()));
    }//GEN-LAST:event_cmbAlumnosActionPerformed

    private void cmbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBorrarActionPerformed
        int pos = cmbAlumnos.getSelectedIndex();
        int idAlumno, nPlazasOcu, nPlazasLibres, nPlazasCursoTotales;
        GestorTablaAlumno migestor = new GestorTablaAlumno(bd);
        GestorTablaCurso c = new GestorTablaCurso(bd);
        ArrayList<Alumno> alumnos1;
        alumnos1 = migestor.consultaTodosAlumnos();
        longitudVieja = alumnos1.size();//ME DA LA TODOS LOS ALUMNOS QUE HAY ANTES DE BORRAR ALGUNO

        miAlumno = (Alumno) modeloAlumnos.getSelectedItem();
        idAlumno = Integer.valueOf(miAlumno.getCodAlumno());
        /*String codigoGuardado = miCurso.getCodCurso();
        int NPlazasGuardado = Integer.valueOf(miCurso.getnPlazasDisp());
        String denominacionGuardado = miCurso.getDenominacion();*/

        migestor.borrarAlumno(idAlumno);
        JOptionPane.showMessageDialog(this, "BORRADO CORRECTO");
        nPlazasCursoTotales = c.plazasCurso(txtCurso.getText());// ME DEVUELVE LAS PLAZAS TOTALES QUE TIENE EL CURSO
        nPlazasOcu = c.AlumnosPorCurso(txtCurso.getText());
        nPlazasLibres = nPlazasCursoTotales - nPlazasOcu;// ME DEVUELVE LAS PLAZAS LIBRES QUE TIENE EL CURSO

        alumnos1 = migestor.consultaTodosAlumnos();
        longitudActual = alumnos1.size();//ME DA LA TODOS LOS ALUMNOS QUE HAY DESPUÉS DE BORRAR ALGUNO

        modeloAlumnos.removeAllElements();
    }//GEN-LAST:event_cmbBorrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbAlumnos;
    private javax.swing.JButton cmbBorrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtGastos;
    private javax.swing.JTextField txtIdAlumno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPoblacion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
