/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.ControladorLogin;
import Modelo.Funcionable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class ClaseDAO {
    
    public static Connection con=null;
    private static Funcionable obj=null;
    
    public static Connection Conexion() {
        String Host = "ec2-54-227-246-152.compute-1.amazonaws.com";
        String Database = "d3lo1vgacnqljj";
        String User = "dnbjlteazkssau";
        String Port = "5432";
        String Password = "0e27eed92b09a0297f13357573033a41dfab4955ea6cf6c1102b33c52053e9d5";
        String URL = "jdbc:postgresql://" + Host + ":" + Port + "/" + Database + "?sslmode=require";

        try {

            con = DriverManager.getConnection(URL, User, Password);

        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }
    
    
    public static String[] ConsultarRegistroUnitario(String id, String object) {
        String[] resultado = null;
       
      if (con == null) {
            con = Conexion();
        }
        try {
            Statement stmt = con.createStatement();
            obj.setID(id);
            ResultSet rel = stmt.executeQuery(obj.returnRegistroUnitario());
            int nRows = rel.getMetaData().getColumnCount();

            if (nRows > 0) {
                resultado = new String[nRows];

                while (rel.next()) {
                    for (int i = 0; i < nRows; i++) {
                        resultado[i] = String.valueOf(rel.getObject(i + 1));
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
    
    
}
