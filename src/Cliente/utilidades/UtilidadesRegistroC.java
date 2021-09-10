/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Utilidades para registrar un cliente
 * 
 * @author YENNYFER
 */
public class UtilidadesRegistroC {
    
    /**
     * Obtiene una referencia del objeto remoto registrado en el ns con el 
     * puerto y la dirección ip dados
     * @param dirIP direccion ip
     * @param puerto puerto
     * @param nameObjReg nombre del objeto remoto
     * @return Referencia al objeto remoto
     */
     public static Remote obtenerObjRemoto(String dirIP,int puerto, String nameObjReg)
    {
        String URLRegistro;
        URLRegistro  = "rmi://" + dirIP + ":" + puerto + "/"+nameObjReg;
        try
        {
            return Naming.lookup(URLRegistro);
        }
        catch (NotBoundException | MalformedURLException | RemoteException e)
        {
            System.out.println("Excepcion en obtencion del objeto remoto"+ e);
            return null;
        }
    }
}
