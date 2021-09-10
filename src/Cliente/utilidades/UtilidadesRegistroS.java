/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Utilidades para el registro de un servidor
 * @author YENNYFER, YEFERSON
 */
public class UtilidadesRegistroS {
    
    /**
     * Pone en marcha el servidor de nombres asignandole el puerto dado y 
     * creando un nuevo registro, si es necesario.
     * @param numPuertoRMI puerto
     * @throws RemoteException 
     */
    public static void arrancarNS(int numPuertoRMI) throws RemoteException {
        try {

            Registry registro = LocateRegistry.getRegistry(numPuertoRMI);
            String[] vector = registro.list();
            for (String idNS : vector) {
                System.out.println("ns : " + idNS);
            }
            System.out.println("El rmiRegistry se ha obtenido y se encuentra escuchando en el puerto: " + numPuertoRMI);

        } catch (RemoteException e) {
            System.out.println("El rmiRegistry no se localizó en el puerto: " + numPuertoRMI);

            LocateRegistry.createRegistry(numPuertoRMI);
            System.out.println("El registro se ha creado en el puerto: " + numPuertoRMI);
        }

    }
    
    /**
     * Registra el objeto remoto dado en el NS.
     * 
     * @param objetoRemoto objeto remoto a registrar
     * @param dirIPNS direccion ip
     * @param numPuertoNS puerto
     * @param identificadorObjetoRemoto nombre o identificador del objeto remoto
     */
    public static void RegistrarObjetoRemoto(Remote objetoRemoto, String dirIPNS, int numPuertoNS, String identificadorObjetoRemoto) {
        String UrlRegistro = "rmi://" + dirIPNS + ":" + numPuertoNS + "/" + identificadorObjetoRemoto;
        try {
            Naming.rebind(UrlRegistro, objetoRemoto);
            System.out.println("Se realizó el registro del objeto remoto en el ns ubicado en la dirección: " + dirIPNS + " y " + "puerto" + numPuertoNS);
        } catch (RemoteException e) {
            System.out.println("Error en el registro del objeto remoto");
        } catch (MalformedURLException e) {
            System.out.println("Error url inválida");
        }

    }
}
