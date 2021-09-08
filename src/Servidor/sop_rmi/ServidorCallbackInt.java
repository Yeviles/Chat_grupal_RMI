/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.sop_rmi;

import Cliente.sop_rmi.UsuarioCallbckInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author YENNYFER
 */
public interface ServidorCallbackInt extends  Remote{
    
    public boolean registrarCliente(UsuarioCallbckInt objRefencia, String nickName) throws  RemoteException;
    
    void enviarMensaje(String mensaje, String nickName)throws  RemoteException;
   
    public boolean desconectarCliente(UsuarioCallbckInt objReferencia,String nickName)throws RemoteException;
    
    public int numUsuariosConectado() throws RemoteException;
}
