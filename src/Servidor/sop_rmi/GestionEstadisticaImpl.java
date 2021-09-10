/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Servidor.utilidades.UtilidadesArchivosTxt;

/**
 * Implementa los metodos relacionados a las estadisticas del chat.
 *
 * @author YENNYFER, YEFERSON
 */
public class GestionEstadisticaImpl extends UnicastRemoteObject implements GestionEstadisticaInt {

    public GestionEstadisticaImpl() throws RemoteException {
        super();
    }

    @Override
    public String consultarMensajes() throws RemoteException {
        System.out.println("\n\n Invocando a consultar mensajes");
        String formatos = UtilidadesArchivosTxt.leerArchivo("historialMensajes.txt");
        return formatos;
    }

}
