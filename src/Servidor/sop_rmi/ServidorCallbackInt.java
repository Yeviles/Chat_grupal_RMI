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
 * Define los métodos correspondientes al servidor de chat y el callback
 *
 * @author YENNYFER, YEFERSON
 */
public interface ServidorCallbackInt extends Remote {

    /**
     * Registra un nuevo cliente encapsulado junto con su referencia
     * correspondiente y lo almacena en una lista de clientes
     *
     * @param objRefencia referencia del cliente
     * @param nickName nombre
     * @return Verdadero si se registró el cliente con éxito. Falso de lo
     * contrario
     * @throws RemoteException
     */
    public boolean registrarCliente(UsuarioCallbckInt objRefencia, String nickName) throws RemoteException;

    /**
     * Envía el mensaje dado a todos los clientes conectados
     *
     * @param mensaje
     * @param nickName
     * @throws RemoteException
     */
    void enviarMensaje(String mensaje, String nickName) throws RemoteException;

    /**
     * Actualiza la lista de contactos activos y notificar al cliente.
     *
     * @param objReferencia
     * @param nickName
     * @return Verdadero si se eliminó el cliente con éxito. Falso de lo
     * contrario.
     * @throws RemoteException
     */
    public boolean desconectarCliente(UsuarioCallbckInt objReferencia, String nickName) throws RemoteException;

    /**
     * Informa la cantidad de usuarios conectados en el momento en que sea
     * invocado.
     *
     * @return cantidad de usuarios conectados.
     * @throws RemoteException
     */
    public int numUsuariosConectado() throws RemoteException;
}
