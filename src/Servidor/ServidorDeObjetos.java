/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import Servidor.sop_rmi.GestionEstadisticaImpl;
import Servidor.sop_rmi.ServidorCallbackImpl;
import Servidor.utilidades.UtilidadesRegistroS;
import Servidor.utilidades.UtilidadesConsola;
import  java.rmi.RemoteException;
/**
 *
 * @author YENNYFER
 */
public class ServidorDeObjetos {
    
     public static void main(String args[]) throws RemoteException {
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        
        System.out.println("Cual es el la dirección ip donde se encuentra  el RMI-registry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        
        System.out.println("Cual es el número de puerto por el cual escucha el RMI-registry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero();  
        
        try {
            ServidorCallbackImpl objServidorCallbackImpl = new ServidorCallbackImpl();
            GestionEstadisticaImpl objGestionEstadisticaImpl = new GestionEstadisticaImpl();
            
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objServidorCallbackImpl, direccionIpRMIRegistry, numPuertoRMIRegistry, "ServidorChat");
            UtilidadesRegistroS.RegistrarObjetoRemoto(objGestionEstadisticaImpl, direccionIpRMIRegistry, numPuertoRMIRegistry, "ServidorEstadisticas");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}
