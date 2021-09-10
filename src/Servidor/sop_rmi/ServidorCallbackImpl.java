/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.sop_rmi;
import Cliente.clsFechaHora;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Servidor.dto.clsNicknameUsuario;
import Cliente.sop_rmi.UsuarioCallbckInt;
import Servidor.utilidades.UtilidadesArchivosTxt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author YENNYFER
 */
public class ServidorCallbackImpl extends UnicastRemoteObject implements ServidorCallbackInt{
    
    private ArrayList<clsNicknameUsuario> listaUsuarios;
    private String usuarioEnLinea;
    private int totalMensajes;
    private Date fechaUltimoMjs;
    
    public ServidorCallbackImpl() throws RemoteException {
        super();
        listaUsuarios = new ArrayList<>();
        this.totalMensajes =0;
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                almacenarMensajes(mensajeCantidadMjs());  
                totalMensajes =0;
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 60000);
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
        
         UsuarioCallbckInt objUsuarioCallbckInt;
     
        String nickNameEmisor = obtenerNickname(nickName);
        
        if (nickName != null) {
            totalMensajes ++;
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
    
     @Override
    public int numUsuariosConectado() throws RemoteException {
        System.out.println("Invocando metodo usuarios conectados");
        return listaUsuarios.size();
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
    
    /**
     * LLama al método actualizarNuevoContacto que se encuentra definido en la interface UsuariosCllbckInt del Cliente.
     * @throws RemoteException 
     */
    public void fijarUsuariosChat() throws RemoteException {
        
        for (clsNicknameUsuario listaUsuario : listaUsuarios) {
            listaUsuario.getUsuario().actualizarNuevoContacto(usuarioEnLinea);
        }
    }
      
    public ArrayList<clsNicknameUsuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public void mjsTotalUltimoMin()  {
        System.out.println("Invocando método msgTotalUltimoMin()...");
      
       // actualizarMjsUsuarios();
//        totalMensajes =0;
//        for (int i = 0; i < this.getListaUsuarios().size(); i++) {
//            totalMensajes += this.getListaUsuarios().get(i).getCantidadMensajes();
//        }
       // restablecerCantidadMensajes();        
        almacenarMensajes(mensajeCantidadMjs());      
       
    }
     
    public String mensajeCantidadMjs(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fechaActual = dateFormat.format(date);
        
        String mensaje;
        
        if (totalMensajes == 0) {
            mensaje = fechaActual + "\n No hay mensajes registrados en el último minuto *\n";
        } else {
            mensaje = fechaActual + "\n Cantidad mensajes en el último minuto:  " + totalMensajes + "*\n\n";
        }
        return mensaje;
    }
    
    public void restablecerCantidadMensajes() {
        for (int i = 0; i < this.getListaUsuarios().size(); i++) {
            this.getListaUsuarios().get(i).setCantidadMensajes(0);
        }
    }
    
    public void almacenarMensajes(String mensaje) {
        System.out.println("\n\n Invocando a almacenar mensajes");

        UtilidadesArchivosTxt.escribirArchivo("historialMensajes.txt", mensaje);
    }
    
    public void actualizarMjsUsuarios() {
        Date fechaActual = new Date();
        int cantMensajesU = 0;
          fechaUltimoMjs = fechaActual;
        for (int i = 0; i <this.getListaUsuarios().size(); i++) {
            cantMensajesU = this.getListaUsuarios().get(i).getFechaMensajesCliente().size();
          
            for (int j = 0; j < cantMensajesU; j++) {
                Date fechaMensaje = this.getListaUsuarios().get(i).getFechaMensajesCliente().get(j);
                long difMin = fechaActual.getTime() - fechaMensaje.getTime();

                float minutos = TimeUnit.MILLISECONDS.toMinutes(difMin);
                if (minutos <= 1) {
                    fechaUltimoMjs = fechaMensaje;
                    int cantidad = this.getListaUsuarios().get(i).getCantidadMensajes();
                    this.getListaUsuarios().get(i).setCantidadMensajes(cantidad + 1);
                }
            }
        }
    }
    
    
}
