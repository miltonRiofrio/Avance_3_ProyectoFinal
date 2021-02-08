/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Dao.EnvioDao;
import Controlador.Dao.HistorialEntregaDao;
import Controlador.ListaDoble.ListaDoble;
import Controlador.Sesion;
import Vistas.Tablas.ModeloTablaEnvios;
import Vistas.Tablas.ModeloTablaHistorialEntrega;

/**
 *
 * @author Sebastian
 */
public class RegistroEnvios extends javax.swing.JFrame {

    /**
     * Creates new form RegistroEnvios
     */
    private ModeloTablaEnvios modeloEnvios = new ModeloTablaEnvios();
    private ModeloTablaHistorialEntrega modeloHE = new ModeloTablaHistorialEntrega();
    private EnvioDao ed = new EnvioDao();
    private HistorialEntregaDao hed = new HistorialEntregaDao();
    
    public RegistroEnvios() {
        initComponents();
        autorizacion();
        cargarTablaEnvios();
        cargarTablaHE();
    }
    
    private void cargarTablaEnvios() {        
        modeloEnvios.setEnvios(ed.ordenar(ed.listar(), ListaDoble.ORDENAR_DESCENDENTE));        
        tblenvios.setModel(modeloEnvios);
        tblenvios.updateUI();
    }
    
    private void cargarTablaHE() {        
        modeloHE.setEntrega(hed.ordenar(hed.listar(), ListaDoble.ORDENAR_DESCENDENTE));        
        tblhistorialEntrega.setModel(modeloHE);
        tblhistorialEntrega.updateUI();
    }
    
    private void autorizacion() {
        if(Sesion.getRol().getRol().equals("Secretario")) {
            btnagregarHist.setEnabled(false);
            tblhistorialEntrega.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblenvios = new javax.swing.JTable();
        btnAgregarEnvio = new javax.swing.JButton();
        btnestadoEntregado = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btnseleccionar = new javax.swing.JButton();
        btneliminarEnvio = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btnagregarHist = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhistorialEntrega = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("ADMINISTRACION DE ENVIOS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(530, 40, 170, 14);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("VISUALIZACION DE ENVIOS"));

        tblenvios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdEnvio", "Id Paquete", "Remitente", "CI Cliente", "Fecha de envio", "Fecha de entrega", "Prioridad", "Estado de Envio", "Origen", "Destino", "Es Fragil"
            }
        ));
        jScrollPane1.setViewportView(tblenvios);

        btnAgregarEnvio.setText("AGREGAR ENVIO");
        btnAgregarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEnvioActionPerformed(evt);
            }
        });

        btnestadoEntregado.setText("ENTREGADO");
        btnestadoEntregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnestadoEntregadoActionPerformed(evt);
            }
        });

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtrar por Codigo Envio:");

        btnbuscar.setText("BUSCAR");

        btnseleccionar.setText("SELECCIONAR");
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });

        btneliminarEnvio.setText("ELIMINAR ENVIO");

        btnmodificar.setText("MODIFICAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1138, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnseleccionar)
                        .addGap(193, 193, 193)
                        .addComponent(btnAgregarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btneliminarEnvio)
                        .addGap(48, 48, 48)
                        .addComponent(btnmodificar)
                        .addGap(0, 373, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnestadoEntregado, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnbuscar)
                    .addComponent(btnestadoEntregado))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarEnvio)
                    .addComponent(btnseleccionar)
                    .addComponent(btneliminarEnvio)
                    .addComponent(btnmodificar))
                .addGap(17, 17, 17))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 80, 1160, 360);

        btnagregarHist.setText("AGREGAR AL HISTORIAL ");
        btnagregarHist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarHistActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregarHist);
        btnagregarHist.setBounds(980, 520, 170, 23);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("HISTORIA DE ENTREGA"));

        tblhistorialEntrega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdHEntrega", "Ciudad Origen", "Ciudad Destino", "Cedula Camionero", "Placa Camion", "Fecha de Entrega"
            }
        ));
        jScrollPane2.setViewportView(tblhistorialEntrega);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 460, 950, 180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1197, 692));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnestadoEntregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnestadoEntregadoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnestadoEntregadoActionPerformed

    private void btnagregarHistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarHistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagregarHistActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void btnAgregarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEnvioActionPerformed
        // TODO add your handling code here:
        new FrmCargarArticulo(new javax.swing.JDialog(), true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarEnvioActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroEnvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEnvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEnvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEnvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEnvios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEnvio;
    private javax.swing.JButton btnagregarHist;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminarEnvio;
    private javax.swing.JButton btnestadoEntregado;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnseleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblenvios;
    private javax.swing.JTable tblhistorialEntrega;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
