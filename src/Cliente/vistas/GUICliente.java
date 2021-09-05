/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.vistas;

import Cliente.clsFechaHora;
import Cliente.sop_rmi.UsuarioCallbckImpl;
import Servidor.dto.clsNicknameUsuario;

import Servidor.sop_rmi.ServidorCallbackInt;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


/**
 *
 * @author YENNYFER
 */
public class GUICliente extends javax.swing.JFrame implements MouseListener, KeyListener{

    private  ServidorCallbackInt objServidorCallbackInt;
    private  UsuarioCallbckImpl objUsuarioCallbckImpl;
    GUIConexion objGUIConexion;
    private String nickName;

    public GUICliente() throws RemoteException {
        this.objGUIConexion = new GUIConexion();
        this.objGUIConexion.setVisible(true);
        initComponents();
      
    }
    
      public GUICliente(ServidorCallbackInt objServidorCallbackInt, String nickname) throws RemoteException {
        initComponents();
        this.objUsuarioCallbckImpl = new UsuarioCallbckImpl(this);
        this.objServidorCallbackInt = objServidorCallbackInt;
        registrarNickName(nickname);
        setImages();
        addListeners();
        
    }
     public void fijarTexto(String nombre, String msg, clsFechaHora objFechaHoraMensaje) {
         
        System.out.println("Mensaje nuevo en el chat");               
        try {
            txtChat.append(nombre + " :" + msg + "\n" + 
                    objFechaHoraMensaje.getFecha() + ", " + objFechaHoraMensaje.getHora() +"\n");

        } catch (Exception ex) {
            ex.getMessage();
        }
        
    }
    
    public void fijarContacto(String nombre) {
        System.out.println("Un nuevo usuario ha ingresado al chat");
        try {
            DesktopNotify.showDesktopMessage("Notificacion", "Nuevo cliente conectado", DesktopNotify.TIP, 5000L);
        } catch (Exception ex) {
        }
        
    }

    public void fijarContactos(String nombre) {
        System.out.println("Actualizar el listado de contactos");
        try {
            txtUsuarios.setText(nombre);
            lbCantidadUsuarios.setText(String.valueOf(objServidorCallbackInt.numUsuariosConectado()));
                    } catch (Exception ex) {
        }
        
    }
     public void registrarNickName(String prmNickName) throws RemoteException {
         nickName = prmNickName;
         lbNickName.setText(nickName);
        
         if (objServidorCallbackInt.registrarCliente(objUsuarioCallbckImpl, nickName)) {
             this.setVisible(true);
         } else {
             DesktopNotify.showDesktopMessage("Nueva Notificacion", "Usuario No Registrado", DesktopNotify.TIP, 5000L);
             System.exit(-1);
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

        pnlPrincipal = new javax.swing.JPanel();
        lbNickName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtUsuarios = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        hpyLabel = new javax.swing.JLabel();
        sadLabel = new javax.swing.JLabel();
        supLabel = new javax.swing.JLabel();
        angLabel = new javax.swing.JLabel();
        tngLabel = new javax.swing.JLabel();
        glsLabel = new javax.swing.JLabel();
        ywnLabel = new javax.swing.JLabel();
        kisLabel = new javax.swing.JLabel();
        luvLabel = new javax.swing.JLabel();
        lghLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lbCantidadUsuarios = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(0, 102, 102));

        lbNickName.setBackground(new java.awt.Color(0, 102, 102));
        lbNickName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNickName.setForeground(new java.awt.Color(255, 255, 255));
        lbNickName.setText("jLabel1");

        txtChat.setColumns(20);
        txtChat.setRows(5);
        txtChat.setEnabled(false);
        jScrollPane1.setViewportView(txtChat);

        txtUsuarios.setColumns(20);
        txtUsuarios.setRows(5);
        txtUsuarios.setEnabled(false);
        jScrollPane2.setViewportView(txtUsuarios);

        jPanel5.setBackground(new java.awt.Color(194, 181, 252));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 87, 169)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hpyLabel.setText("0");
        jPanel5.add(hpyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 50));

        sadLabel.setText("2");
        jPanel5.add(sadLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 50));

        supLabel.setText("3");
        jPanel5.add(supLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 50, 50));

        angLabel.setText("4");
        jPanel5.add(angLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 50, 50));

        tngLabel.setText("5");
        jPanel5.add(tngLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 50, 50));

        glsLabel.setText("6");
        jPanel5.add(glsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 50, 50));

        ywnLabel.setText("7");
        jPanel5.add(ywnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 50, 50));

        kisLabel.setText("8");
        jPanel5.add(kisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 50, 50));

        luvLabel.setText("9");
        jPanel5.add(luvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 50, 50));

        lghLabel.setText("1");
        jPanel5.add(lghLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 50, 50));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(55, 178, 204));
        jLabel13.setText("add a smiley");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 20));

        btnSalir.setText("Cerrar Sesión");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lbCantidadUsuarios.setText("jLabel15");

        btnEnviar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEnviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(txtMensaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(117, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lbCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantidadUsuarios))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(kGradientPanel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(kGradientPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try {
            objServidorCallbackInt.desconectarCliente(objUsuarioCallbckImpl,nickName);
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        String mensajeC = txtMensaje.getText();
        if (!mensajeC.equalsIgnoreCase("")) {
            try {
                objServidorCallbackInt.enviarMensaje(mensajeC, nickName);
            } catch (RemoteException ex) {
                Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtMensaje.setText("");
        } else {
            DesktopNotify.showDesktopMessage("Nueva Notificacion", "Debe ingresar un mensaje", DesktopNotify.TIP, 5000L);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

     private void setImages() {
        ImageIcon icons[] = new ImageIcon[10];
        for (int i = 0; i < 10; i++) {
            icons[i] = new ImageIcon(getClass().getResource("/Recursos/" + i + ".png"));
        }
        hpyLabel.setIcon(icons[0]);
        lghLabel.setIcon(icons[1]);
        sadLabel.setIcon(icons[2]);
        supLabel.setIcon(icons[3]);
        tngLabel.setIcon(icons[4]);
        angLabel.setIcon(icons[5]);
        glsLabel.setIcon(icons[6]);
        ywnLabel.setIcon(icons[7]);
        kisLabel.setIcon(icons[8]);
        luvLabel.setIcon(icons[9]);
    }
       private void addListeners() {
         hpyLabel.addMouseListener(this);
         lghLabel.addMouseListener(this);
         sadLabel.addMouseListener(this);
         supLabel.addMouseListener(this);
         tngLabel.addMouseListener(this);
         angLabel.addMouseListener(this);
         glsLabel.addMouseListener(this);
         ywnLabel.addMouseListener(this);
         kisLabel.addMouseListener(this);
         luvLabel.addMouseListener(this);
         txtMensaje.addKeyListener(this);
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
            java.util.logging.Logger.getLogger(GUICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUICliente().setVisible(false);
                    

                } catch (RemoteException ex) {
                    Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel angLabel;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel glsLabel;
    private javax.swing.JLabel hpyLabel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel kisLabel;
    private javax.swing.JLabel lbCantidadUsuarios;
    private javax.swing.JLabel lbNickName;
    private javax.swing.JLabel lghLabel;
    private javax.swing.JLabel luvLabel;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JLabel sadLabel;
    private javax.swing.JLabel supLabel;
    private javax.swing.JLabel tngLabel;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextArea txtUsuarios;
    private javax.swing.JLabel ywnLabel;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void mouseClicked(MouseEvent e) {
        clsNicknameUsuario message = new clsNicknameUsuario();
       // message.setUsername(username);
//        message.setType("client");
//        message.setDate(new Date());
        if (e.getSource() == hpyLabel) {
            message.setSmiley("0.png");
        } else if (e.getSource() == lghLabel) {
            message.setSmiley("1.png");
        } else if (e.getSource() == sadLabel) {
            message.setSmiley("2.png");
        } else if (e.getSource() == supLabel) {
            message.setSmiley("3.png");
        } else if (e.getSource() == tngLabel) {
            message.setSmiley("4.png");
        } else if (e.getSource() == angLabel) {
            message.setSmiley("5.png");
        } else if (e.getSource() == glsLabel) {
            message.setSmiley("6.png");
        } else if (e.getSource() == ywnLabel) {
            message.setSmiley("7.png");
        } else if (e.getSource() == kisLabel) {
            message.setSmiley("8.png");
        } else if (e.getSource() == luvLabel) {
            message.setSmiley("9.png");
        }
        try {
            objServidorCallbackInt.enviarMensaje(message.getSmiley(), nickName);
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//            sendNewMessage();
//        }
    }
//  private void sendNewMessage() {
//        String inputMessage = chatInputText.getText();
//        chatInputText.setText("");
//        Messages message = new Messages();
//        message.setUsername(username);
//        message.setMsg(inputMessage);
//        message.setType("client");
//        message.setDate(new Date());
//        try {
//            chat.sendMessage(message);
//        } catch (RemoteException ex) {
//            Logger.getLogger(ChatView.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}