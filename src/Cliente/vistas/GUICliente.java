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
 * Interfaz de chat para cada cliente.
 *
 * @author YENNYFER, YEFERSON
 */
public class GUICliente extends javax.swing.JFrame implements MouseListener, KeyListener {

    private final ServidorCallbackInt objServidorCallbackInt;
    private final UsuarioCallbckImpl objUsuarioCallbckImpl;
    GUIConexion objGUIConexion;
    private String nickName;
    private boolean tieneMensaje;

    public GUICliente(ServidorCallbackInt objServidorCallbackInt, String nickname) throws RemoteException {
        initComponents();
        this.objUsuarioCallbckImpl = new UsuarioCallbckImpl(this);
        this.objServidorCallbackInt = objServidorCallbackInt;
        this.tieneMensaje = false;
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        registrarNickName(nickname);
        setImages();
        addListeners();
    }

    /**
     * Muestra el texto dado en el panel definido como pantalla de chat.
     *
     * @param nombre nombre del usuario
     * @param msg mensaje enviado por el usuario
     * @param objFechaHoraMensaje fecha y hora del mensaje
     */
    public void fijarTexto(String nombre, String msg, clsFechaHora objFechaHoraMensaje) {

        System.out.println("Mensaje nuevo en el chat");
        String doc = "", auxDoc = "";

        doc = "<html><body><table>";
        boolean b = false;
        try {
            for (int i = 0; i < 10; i++) {
                if (msg.equals(i + ".png")) {
                    b = true;
                    break;
                }
            }

            if (!b) {
                auxDoc = "<tr><td>"
                        + objFechaHoraMensaje.getFecha() + ", " + objFechaHoraMensaje.getHora()
                        + "</td><td><font color='rgb(55,178,204)'><b>"
                        + nombre + ": "
                        + "</b></font></td><td>"
                        + msg
                        + "</td>";

            } else {
                auxDoc = "<tr><td>"
                        + objFechaHoraMensaje.getFecha() + ", " + objFechaHoraMensaje.getHora() + "<br>"
                        + "</td><td><font color='rgb(55,178,204)'><b>"
                        + nombre + ": "
                        + "</b></font></td><td><img src= '"
                        + this.getClass().getResource("/Recursos/" + msg)
                        + "' width=40 height=40 /> </td>";
            }
            if (!tieneMensaje) {
                doc += auxDoc;
                tieneMensaje = true;
            } else {
                String v = chatListTextArea.getText().trim();
                v = v.substring(0, v.length() - 36);
                doc = v + auxDoc;
            }
        } catch (Exception ex) {
            ex.getMessage();
        }

        doc += "</tr></table></body></html>";

        chatListTextArea.setText(doc);
    }

    /**
     * Muestra una notificaci??n cuando se conecte un nuevo usuario.
     *
     * @param nombre nuevo usuario conectado
     */
    public void nuevoContacto(String nombre) {
        System.out.println("Un nuevo usuario ha ingresado al chat");
        try {
            DesktopNotify.showDesktopMessage("Notificacion", "Nuevo usuario conectado: " + " " + nombre, DesktopNotify.TIP, 5000L);
        } catch (Exception ex) {
        }
    }

    /**
     * Muestra el nuevo usuario conectado en el listado correspondiente.
     *
     * @param nombre nuevo usuario conectado
     * @throws RemoteException
     */
    public void fijarContactos(String nombre) throws RemoteException {
        System.out.println("Actualizar el listado de contactos");

        txtUsuarios.setText(nombre);
        lbCantidadUsuarios.setText(String.valueOf(objServidorCallbackInt.numUsuariosConectado()));

    }

    /**
     * Registra el usuario en el servidor, enviando la referencia
     * correspondiente
     *
     * @param prmNickName nuevo usuario
     * @throws RemoteException
     */
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
        jScrollPane3 = new javax.swing.JScrollPane();
        chatListTextArea = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlPrincipal.setBackground(new java.awt.Color(191, 206, 220));

        lbNickName.setBackground(new java.awt.Color(0, 102, 102));
        lbNickName.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbNickName.setForeground(new java.awt.Color(255, 255, 255));
        lbNickName.setText("jLabel1");

        txtUsuarios.setColumns(20);
        txtUsuarios.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUsuarios.setRows(5);
        txtUsuarios.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtUsuarios.setEnabled(false);
        jScrollPane2.setViewportView(txtUsuarios);

        txtMensaje.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel13.setText("Agregar Emoji");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 20));

        btnSalir.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/blue_exit_delete_delete_12417.png"))); // NOI18N
        btnSalir.setText("Cerrar Sesion");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lbCantidadUsuarios.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbCantidadUsuarios.setText("-");

        btnEnviar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_send_128_28719.png"))); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        chatListTextArea.setEditable(false);
        chatListTextArea.setContentType("text/html"); // NOI18N
        chatListTextArea.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        chatListTextArea.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p style=\"margin-top: 0\">\n      <h1 color='blue'>Bienvenid@s</h1>\n    </p>\n  </body>\n</html>\n");
        jScrollPane3.setViewportView(chatListTextArea);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Usuarios");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(lbCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lbNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCantidadUsuarios)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 204, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(719, 90));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/free-30-instagram-stories-icons64_122611.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nuestra recompensa se encuentra en el esfuerzo y no en el resultado. ");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Un esfuerzo total es una victoria  completa. Mahatma Ghandi, L??der espiritual");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(kGradientPanel1, java.awt.BorderLayout.PAGE_START);

        kGradientPanel2.setkEndColor(new java.awt.Color(51, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 255));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(719, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder-social-media-applications-1facebook-4102573_113807.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Instagram_icon-icons.com_66804.png"))); // NOI18N
        jLabel3.setText("jLabel1");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/twitter_icon-icons.com_65411.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Realizado por: Yennyfer Aviles - Yeferson Benavidez");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18))
        );

        getContentPane().add(kGradientPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrarSesion();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Realiza el cierre de sesi??n de forma segura, desconectando el cliente del
     * servidor
     */
    private void cerrarSesion() {
        try {
            objServidorCallbackInt.desconectarCliente(objUsuarioCallbckImpl, nickName);
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

    /**
     * Ubica las imagenes correspondientes a los emojis en la vista
     */
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

    /**
     * Agrega el evento de mouse a cada emoji
     */
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

    @Override
    public void mouseClicked(MouseEvent e) {
        clsNicknameUsuario message = new clsNicknameUsuario();
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
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel angLabel;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextPane chatListTextArea;
    private javax.swing.JLabel glsLabel;
    private javax.swing.JLabel hpyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextArea txtUsuarios;
    private javax.swing.JLabel ywnLabel;
    // End of variables declaration//GEN-END:variables

}
