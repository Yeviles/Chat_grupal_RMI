/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.dto;

import Cliente.sop_rmi.UsuarioCallbckInt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author YENNYFER
 */
public class clsNicknameUsuario implements Serializable{
    
    private UsuarioCallbckInt usuario;
    private String nickName;
    private int numMensajes;
    private String smiley;
    
    private ArrayList<Date> fechaMensajesCliente;

    public clsNicknameUsuario() {
    }
    
    public clsNicknameUsuario(UsuarioCallbckInt usuario, String nickName) {
        this.usuario = usuario;
        this.nickName = nickName;
        fechaMensajesCliente = new ArrayList<>();
    }

    public String getSmiley() {
        return smiley;
    }

    public void setSmiley(String smiley) {
        this.smiley = smiley;
    }

    public UsuarioCallbckInt getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioCallbckInt usuario) {
        this.usuario = usuario;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public ArrayList<Date> getFechaMensajesCliente() {
        return fechaMensajesCliente;
    }

    public void setFechaMensajesCliente(Date fechaMensajesCliente) {
        this.fechaMensajesCliente.add(fechaMensajesCliente);
    }
    public void setCantidadMensajes(int numMesajes){
        this.numMensajes = numMesajes;
    }
    public int getCantidadMensajes(){
        return numMensajes;
    }
}
