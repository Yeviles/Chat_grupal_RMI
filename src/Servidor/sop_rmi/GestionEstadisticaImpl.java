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
        this.totalMensajes = 0;

    }
    
    @Override
    public void almacenarMensajes(String mensaje) throws RemoteException {
        System.out.println("\n\n Invocando a almacenar mensajes");

        UtilidadesArchivosTxt.escribirArchivo("historialMensajes.txt", mensaje);
    }
     @Override
    public String consultarMensajes() throws RemoteException {
//        System.out.println("\n\n Invocando a consultar mensajes");
//        String formatos = UtilidadesArchivosTxt.leerArchivo("historialMensajes.txt");
//        return formatos;
        int mensajes = this.objServidorCallbackImpl.getTotalMensajes();
        this.objServidorCallbackImpl.setTotalMensajes(0);
        return mensajes+"";
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
   
   
     
}

