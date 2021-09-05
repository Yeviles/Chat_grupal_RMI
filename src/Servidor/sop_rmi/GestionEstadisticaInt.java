/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.sop_rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author YENNYFER
 */
public interface GestionEstadisticaInt extends Remote{
    
    public void almacenarMensajes(String mensaje) throws RemoteException;
     public String consultarMensajes() throws RemoteException;
    public void mjsTotalUltimoMin() throws RemoteException;
}
