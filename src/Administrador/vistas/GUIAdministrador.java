/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador.vistas;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Servidor.sop_rmi.GestionEstadisticaInt;
import Cliente.utilidades.UtilidadesConsola;
import Cliente.utilidades.UtilidadesRegistroC;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author YENNYFER
 */
public class GUIAdministrador extends javax.swing.JFrame {

    private static GestionEstadisticaInt objGestionEstadisticaInt;
    private String mensajes;

    public GUIAdministrador(GestionEstadisticaInt prmObjeto) {
        objGestionEstadisticaInt = prmObjeto;
        this.mensajes = "";
        initComponents();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                consultarMensajes();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 60000);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMensajes = new javax.swing.JTextArea();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));

        pnlContenedor.setBackground(new java.awt.Color(191, 206, 220));

        jTextAreaMensajes.setColumns(20);
        jTextAreaMensajes.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMensajes);

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(pnlContenedor, java.awt.BorderLayout.CENTER);
        pnlContenedor.getAccessibleContext().setAccessibleName("");

        kGradientPanel2.setkEndColor(new java.awt.Color(51, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 255));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(424, 100));

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(kGradientPanel2, java.awt.BorderLayout.PAGE_START);

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 204));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(424, 49));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Instagram_icon-icons.com_66804.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder-social-media-applications-1facebook-4102573_113807.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(762, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        getContentPane().add(kGradientPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void consultarMensajes(){
        jTextAreaMensajes.setText("");
          try {
            objGestionEstadisticaInt.mjsTotalUltimoMin();
            mensajes = objGestionEstadisticaInt.consultarMensajes();            
           jTextAreaMensajes.setText(mensajes);
        } catch (RemoteException ex) {
            Logger.getLogger(GUIAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMensajes;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JPanel pnlContenedor;
    // End of variables declaration//GEN-END:variables
}