/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author David Sarmiento
 */
public class Conexion {
    Connection con;

    public Connection getCon() {
        return con;
    }
    
    public void conectar() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjsf?user=root&password=root");
        } catch (Exception e) {
            System.out.println("Error en Clase Conexion");
            throw e;
        }
    }
    
    public void desconectar() throws Exception
    {
        try {
            if(con !=null)
            {
                if(con.isClosed() == false)
                    con.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
