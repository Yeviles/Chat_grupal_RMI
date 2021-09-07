/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.sop_rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import Servidor.utilidades.UtilidadesArchivosTxt;
import java.util.ArrayList;
/**
 *
 * @author YENNYFER
 */
public class GestionEstadisticaImpl extends UnicastRemoteObject implements GestionEstadisticaInt{
    private static ServidorCallbackImpl objServidorCallbackImpl;
    private int totalMensajes; 
    private String usuario;
    private Date fechaUltimoMjs;
    private ArrayList<String> mensajes;
    

    public GestionEstadisticaImpl() throws RemoteException {
        super();
    }

    public GestionEstadisticaImpl(ServidorCallbackImpl prmObjRemoto) throws RemoteException {
        super();
        objServidorCallbackImpl = prmObjRemoto;
        this.usuario = "";
        mensajes = new ArrayList<>();

    }
    
    @Override
    public void almacenarMensajes(String mensaje) throws RemoteException {
        System.out.println("\n\n Invocando a almacenar mensajes");

        UtilidadesArchivosTxt.escribirArchivo("historialMensajes.txt", mensaje);
    }
     @Override
    public String consultarMensajes() throws RemoteException {
        System.out.println("\n\n Invocando a consultar mensajes");
        String formatos = UtilidadesArchivosTxt.leerArchivo("historialMensajes.txt");
        return formatos;
    }
    @Override
    public void mjsTotalUltimoMin() throws RemoteException {
        System.out.println("Invocando método msgTotalUltimoMin()...");
      
        actualizarMjsUsuarios();
        totalMensajes =0;
        for (int i = 0; i < objServidorCallbackImpl.getListaUsuarios().size(); i++) {
            totalMensajes += objServidorCallbackImpl.getListaUsuarios().get(i).getCantidadMensajes();
        }
        restablecerCantidadMensajes();        
        almacenarMensajes(mensajeCantidadMjs());      
       
    }
   
    public String mensajeCantidadMjs(){
        
        String mensaje;
        
        if (totalMensajes == 0) {
            mensaje = String.valueOf(fechaUltimoMjs) + "\n No hay mensajes registrados en el último minuto *\n";
        } else {
            mensaje = String.valueOf(fechaUltimoMjs) + "\n Cantidad mensajes en el último minuto:  " + totalMensajes + "*\n\n";
        }
        return mensaje;
    }
    
    public void restablecerCantidadMensajes() {
        for (int i = 0; i < objServidorCallbackImpl.getListaUsuarios().size(); i++) {
            objServidorCallbackImpl.getListaUsuarios().get(i).setCantidadMensajes(0);
        }
    }

    public void actualizarMjsUsuarios() {
        Date fechaActual = new Date();
        int cantMensajesU = 0;
          fechaUltimoMjs = fechaActual;
        for (int i = 0; i <objServidorCallbackImpl.getListaUsuarios().size(); i++) {
            cantMensajesU = objServidorCallbackImpl.getListaUsuarios().get(i).getFechaMensajesCliente().size();
          
            for (int j = 0; j < cantMensajesU; j++) {
                Date fechaMensaje = objServidorCallbackImpl.getListaUsuarios().get(i).getFechaMensajesCliente().get(j);
                long difMin = fechaActual.getTime() - fechaMensaje.getTime();

                float minutos = TimeUnit.MILLISECONDS.toMinutes(difMin);
                if (minutos <= 1) {
                    fechaUltimoMjs = fechaMensaje;
                    int cantidad = objServidorCallbackImpl.getListaUsuarios().get(i).getCantidadMensajes();
                    objServidorCallbackImpl.getListaUsuarios().get(i).setCantidadMensajes(cantidad + 1);
                }
            }
        }
    }
     
}

