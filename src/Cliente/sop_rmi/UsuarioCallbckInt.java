/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.sop_rmi;
import java.rmi.RemoteException;
import java.rmi.Remote;
import Cliente.clsFechaHora;
/**
 *
 * @author YENNYFER
 */
public interface UsuarioCallbckInt extends  Remote{
    
        //public void recicbirMensaje(String nicknameEmisor, String mensaje,FechaHora objFechaHora )throws RemoteException;
    //FaLTA LO DE FECHA OJO 
    public void recibirMensaje(String nicknameEmisor, String mensaje, clsFechaHora objFechaHora )throws RemoteException;
    public void actualizarNuevoContacto(String contacto) throws  RemoteException;
    public void eliminarContacto(String contacto) throws RemoteException;

}