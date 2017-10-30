/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sarmiento
 */
public class DaoCliente extends Conexion{
    PreparedStatement pre;
    ResultSet res;
    String sql;
    public List<Cliente> mostrarCliente() throws Exception
    {
        List<Cliente> listaCliente = new ArrayList<>();
        
        try {
            this.conectar();
            sql = "Select * from cliente";
            pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            
            while (res.next()) { 
                Cliente c = new Cliente();
               c.setCodigoCliente(res.getInt("codigoCliente"));
               c.setNombre(res.getString("nombre"));
               c.setGenero(res.getString("genero"));
               listaCliente.add(c);
                
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
        
        return listaCliente;
    }
    
        public void registrarCliente(Cliente c) throws Exception {
        try {
            this.conectar();
            String sql = "insert into cliente (nombre,genero) values(?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getNombre());
            pre.setString(2, c.getGenero());
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Clase Dao");
            System.out.println(e.toString());
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    public void modificarCliente(Cliente c) throws Exception{
        try {
            this.conectar();
            String sql="update cliente set nombre=?, genero=? where codigoCliente=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, c.getNombre());
            pre.setString(2, c.getGenero());
            pre.setInt(3, c.getCodigoCliente());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
    }
    
    public void eliminarCliente(Cliente c) throws Exception{
        try {
            this.conectar();
            String sql="delete from cliente where codigoCliente=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, c.getCodigoCliente());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
    }
}
