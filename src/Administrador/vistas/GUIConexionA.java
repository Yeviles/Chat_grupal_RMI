/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador.vistas;

import Servidor.sop_rmi.GestionEstadisticaInt;
import Cliente.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author YENNYFER
 */
public class GUIConexionA extends javax.swing.JFrame {

     private static GestionEstadisticaInt objRemoto;
     
    public GUIConexionA() throws RemoteException{
        setTitle("Registrar NS");
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

        pnlConexion = new javax.swing.JPanel();
        lblDirIp = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        lblNumPuerto = new javax.swing.JLabel();
        txtNumPuerto = new javax.swing.JTextField();
        pnlBoton = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlConexion.setBackground(new java.awt.Color(0, 153, 153));
        pnlConexion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conexion Servidor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlConexion.setLayout(new java.awt.GridLayout(5, 1));

        lblDirIp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDirIp.setForeground(new java.awt.Color(255, 255, 255));
        lblDirIp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDirIp.setText("Cual es el la dirección ip donde se encuentra  el n_s");
        pnlConexion.add(lblDirIp);

        txtIp.setText("localhost");
        pnlConexion.add(txtIp);

        lblNumPuerto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumPuerto.setForeground(new java.awt.Color(255, 255, 255));
        lblNumPuerto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumPuerto.setText("Cual es el número de puerto por el cual escucha el n_s");
        pnlConexion.add(lblNumPuerto);

        txtNumPuerto.setText("5000");
        pnlConexion.add(txtNumPuerto);

        pnlBoton.setLayout(new java.awt.GridBagLayout());

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlBoton.add(btnRegistrar, new java.awt.GridBagConstraints());

        pnlConexion.add(pnlBoton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        String varIp = "";
        int varPuerto = 0;
        String varNickName = "";
        varIp = txtIp.getText();
        varPuerto = Integer.parseInt(txtNumPuerto.getText());
        objRemoto = (GestionEstadisticaInt) UtilidadesRegistroC.obtenerObjRemoto(varIp, varPuerto, "ServidorEstadisticas");
        if (objRemoto != null) {
            GUIAdministrador objAdmin = new GUIAdministrador(objRemoto);
            objAdmin.setVisible(true);
            this.dispose();
        } else {
            System.out.println("No se logra obtener el objeto remoto");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
 
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblDirIp;
    private javax.swing.JLabel lblNumPuerto;
    private javax.swing.JPanel pnlBoton;
    private javax.swing.JPanel pnlConexion;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtNumPuerto;
    // End of variables declaration//GEN-END:variables

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
            java.util.logging.Logger.getLogger(GUIConexionA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIConexionA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIConexionA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIConexionA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUIConexionA().setVisible(true);
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(GUIConexionA.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        });
    }


}
