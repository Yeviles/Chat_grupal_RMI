/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.sop_rmi;
import Cliente.clsFechaHora;
import Cliente.sop_rmi.UsuarioCallbckImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import Servidor.dto.clsNicknameUsuario;
import Cliente.sop_rmi.UsuarioCallbckInt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author YENNYFER
 */
public class ServidorCallbackImpl extends UnicastRemoteObject implements ServidorCallbackInt{
    
    private ArrayList<clsNicknameUsuario> listaUsuarios;
    private String usuarioEnLinea;
    
    public ServidorCallbackImpl() throws RemoteException {
        super();
        listaUsuarios = new ArrayList<>();
    }
    //Permite registrar un Usuario
    @Override
    public boolean registrarCliente(UsuarioCallbckInt objRefencia, String nickName) throws RemoteException {
        System.out.println("Invocando Registrar Usuario");

        clsNicknameUsuario objNickName;

        boolean aux = true;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getNickName().equals(nickName)) {
                aux = false;
            }
        }
        if (aux) {
            objNickName = new clsNicknameUsuario(objRefencia, nickName);
            listaUsuarios.add(objNickName);
            fijarUsuario(nickName);
            usuariosConectados();
            fijarUsuariosChat();
        }
        return aux;
    }
    //Permite enviar el mensaje a los diferentes usuarios conectados. 
    @Override
    public void enviarMensaje(String mensaje, String nickName) throws RemoteException {
        System.out.println("Invocando enviar mensaje");
        enviarMensajes(mensaje, nickName);
    }
    //Actualiza la lista de contactos activos y notificar al cliente.
    @Override
    public boolean desconectarCliente(UsuarioCallbckInt objRefencia,String nickName) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getUsuario().equals(objRefencia)) {
                listaUsuarios.remove(i);
                usuariosConectados();
                try {
                    fijarUsuariosChat();
                } catch (RemoteException ex) {
                    Logger.getLogger(ServidorCallbackImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
    //Hace uso del metodo buscarNickName para conocer el ninckname del usuario que envia el mensaje.
    
    //Se utiliza en enviarMensaje
    private void enviarMensajes(String mensaje, String nickName) throws RemoteException {
        
        UsuarioCallbckInt objUsuarioCallbckInt;
     
        String nickNameEmisor = obtenerNickname(nickName);
        
        if (nickName != null) {
            for (int i = 0; i < listaUsuarios.size(); i++) {
                
                objUsuarioCallbckInt = listaUsuarios.get(i).getUsuario();

                clsFechaHora objFechaHora = new clsFechaHora();
                
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss a");
                
                objFechaHora.setFecha(dateFormat.format(date));
                objFechaHora.setHora(hourFormat.format(date));
                
                objUsuarioCallbckInt.recibirMensaje(nickNameEmisor, mensaje, objFechaHora);
            }
        }
    }
    
    private String obtenerNickname(String nikname) {
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            
            if (listaUsuarios.get(i).getNickName().equals(nikname)) {
                
                Date fechaMensaje = new Date();
                listaUsuarios.get(i).setFechaMensajesCliente(fechaMensaje);
                return listaUsuarios.get(i).getNickName();
            }
        }
        return null;
    }
    
    //Llama  al método eliminarContacto que se encuentra definido en la interface UsuariosCllbckInt del Cliente.
    public void fijarUsuario(String prmNickName) throws RemoteException {

        for (int i = 0; i < listaUsuarios.size(); i++) {
            
            String nickName = listaUsuarios.get(i).getNickName();
            
            if (!prmNickName.equals(nickName)) {
                listaUsuarios.get(i).getUsuario().eliminarContacto(prmNickName);
            }
        }
    }
    
    //Recorre listaUsuarios y guarda los nickname en la variable usuarioEnLinea
    public void usuariosConectados() {
        usuarioEnLinea = "";
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuarioEnLinea = usuarioEnLinea + listaUsuarios.get(i).getNickName() + " en linea\n";
        }
    }
    
    //LLama al método actualizarNuevoContacto que se encuentra definido en la interface UsuariosCllbckInt del Cliente.
    public void fijarUsuariosChat() throws RemoteException {
        
        for (clsNicknameUsuario listaUsuario : listaUsuarios) {
            listaUsuario.getUsuario().actualizarNuevoContacto(usuarioEnLinea);
        }
    }
     @Override
    public int numUsuariosConectado() throws RemoteException {
        System.out.println("Invocando metodo usuarios conectados");
        return listaUsuarios.size();
    }
    public ArrayList<clsNicknameUsuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
