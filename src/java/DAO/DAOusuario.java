/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuario;
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
public class DAOusuario {
    
    private static Connection tol = null;
    private static Usuario obj = null;
    
    public static Connection Conexion() {
        String Host = "ec2-23-23-248-192.compute-1.amazonaws.com";
        String Database = "dea1qb7dn9qd3c";
        String User = "ycngoyjfezozqs";
        String Port = "5432";
        String Password = "c43299c402a39b117ccf063915741c9186f54c0ee869431f33927b27e2d64556";
        String URL = "jdbc:postgresql://" + Host + ":" + Port + "/" + Database + "?sslmode=require";

        try {

            tol = DriverManager.getConnection(URL, User, Password);

        } catch (Exception ex) {
           
        }

        return tol;

    }
    
    public static String ConsultarRegistros(String object) {
        String resultado = "";
        if (tol == null) {
            tol = Conexion();
        }
        try {

            Statement stmt = tol.createStatement();

        } catch (SQLException ex) {
            
        }

        return resultado;
    }
    
    public static String[] ConsultarRegistroUnitario(String id) {
        String[] resultado = null;
        
        if (tol == null) {
            tol = Conexion();
        }
        try {
            Statement stmt = tol.createStatement();
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
            
        }

        return resultado;
    }
    
}
