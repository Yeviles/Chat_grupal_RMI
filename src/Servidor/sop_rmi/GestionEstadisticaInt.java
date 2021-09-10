/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Define los metodos relacionados a las estadisticas del chat.
 *
 * @author YENNYFER, YEFERSON
 */
public interface GestionEstadisticaInt extends Remote {

    /**
     * Consulta los reportes almacenados en el medio de persistencia
     * @return Reportes leidos
     * @throws RemoteException 
     */
    public String consultarMensajes() throws RemoteException;

}
