/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fernando
 */
public class Usuario implements Funcionable {

    
        int idU;
        String nomusuario;
        String contraseña;

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
        
        
    @Override
    public String returnRegistros() {
        return "select * from usuario";
    }

    @Override
    public void setID(String d) {
      nomusuario=d;
    }

    @Override
    public String returnRegistroUnitario() {
        return "select * from usuario where nomusuario=" + "'"+nomusuario+"'";
    }

    @Override
    public String UpdateRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
