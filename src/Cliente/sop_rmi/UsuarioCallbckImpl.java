/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.sop_rmi;
import Cliente.clsFechaHora;
import Cliente.vistas.GUICliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author YENNYFER
 */
public class UsuarioCallbckImpl extends UnicastRemoteObject implements  UsuarioCallbckInt{
    //Declarar un atributo de Tipo GUICliente el cual permite almacenar la referencia remota a la ventana del cliente. 
    GUICliente GUIC;

    public UsuarioCallbckImpl() throws RemoteException{
    super();
    }

    public UsuarioCallbckImpl(GUICliente objGUICliente) throws  RemoteException{
        super();
        this.GUIC = objGUICliente;
    }
    @Override
        public void recibirMensaje(String nicknameEmisor, String mensaje, clsFechaHora objfFechaHora)throws RemoteException{
            //invoca al método fijarTexto() del atributo GUIC
            GUIC.fijarTexto(nicknameEmisor, mensaje,objfFechaHora);
        }
    @Override
    public void actualizarNuevoContacto(String contacto) throws  RemoteException{
        //Invoca al metodo fijarcontactos() del atributo GUIC
        GUIC.fijarContactos(contacto);
    }
    @Override
    public void eliminarContacto(String contacto) throws RemoteException{
        //Invoca al metodo fijarcontacto() del atributo GUIC
        GUIC.fijarContacto(contacto);
    }


    
    

}
