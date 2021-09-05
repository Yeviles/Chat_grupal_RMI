/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.vistas;

import Cliente.utilidades.UtilidadesRegistroC;
import Servidor.sop_rmi.ServidorCallbackInt;
import ds.desktop.notify.DesktopNotify;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YENNYFER
 */
public class GUIConexion extends javax.swing.JFrame {
    
    private static ServidorCallbackInt objRemoto;
    
    public GUIConexion() {
        initComponents();
        setTitle("Registrar NS");
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
        lblNumMesa = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        pnlBoton = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlConexion.setBackground(new java.awt.Color(0, 153, 153));
        pnlConexion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conexion Servidor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlConexion.setLayout(new java.awt.GridLayout(7, 1));

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

        lblNumMesa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumMesa.setForeground(new java.awt.Color(255, 255, 255));
        lblNumMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumMesa.setText("Digite su Nickname");
        pnlConexion.add(lblNumMesa);
        pnlConexion.add(txtNickName);

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
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        varNickName = txtNickName.getText();
        if (!varNickName.equals("")) {
            objRemoto = (ServidorCallbackInt) UtilidadesRegistroC.obtenerObjRemoto(varIp, varPuerto, "ServidorChat");
            if (objRemoto != null) {
                try {
                    GUICliente objCliente = new GUICliente(objRemoto, varNickName);
                    objCliente.setVisible(true);
                    this.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(GUIConexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                DesktopNotify.showDesktopMessage("Advertencia", "No se ha registrado el objeto remoto", DesktopNotify.TIP, 5000L);
            }

        } else {
            DesktopNotify.showDesktopMessage("Advertencia", "Debe ingresar un nickname", DesktopNotify.TIP, 5000L);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblDirIp;
    private javax.swing.JLabel lblNumMesa;
    private javax.swing.JLabel lblNumPuerto;
    private javax.swing.JPanel pnlBoton;
    private javax.swing.JPanel pnlConexion;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JTextField txtNumPuerto;
    // End of variables declaration//GEN-END:variables
}