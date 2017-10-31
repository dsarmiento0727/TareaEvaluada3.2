/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sarmiento
 */
public class DaoDepartamento extends Conexion{
    public void registrarDepartamento(Departamento d) throws Exception{
        try {
            this.conectar();
            String sql="insert into departamento(nombre, cantidadEmpleado) values(?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, d.getNombre());
            pre.setInt(2, d.getCantidadEmpleados());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
    }
    
    public void modificarDepartamento(Departamento d) throws Exception{
        try {
            this.conectar();
            String sql="update departamento set nombre=?, cantidadEmpleado=? where codigoDepartamento=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, d.getNombre());
            pre.setInt(2, d.getCantidadEmpleados());
            pre.setInt(3, d.getCodigoDepartamento());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
    }
   
     public void eliminarDepartamento(Departamento d) throws Exception{
        try {
            this.conectar();
            String sql="delete from departamento where codigoDepartamento=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, d.getCodigoDepartamento());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
    }
     
     public List<Departamento> listarDepartamentos() throws Exception{
        ResultSet res;
        List<Departamento> lista; 
        try {
            this.conectar();
            String sql="select * from departamento";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            lista = new ArrayList();
            while (res.next()) {                
                Departamento d= new Departamento();
                d.setCodigoDepartamento(res.getInt("codigoDepartamento"));
                d.setNombre(res.getString("nombre"));
                d.setCantidadEmpleados(res.getInt("cantidadEmpleado"));
                lista.add(d);
            }
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
        return lista;
    }
    
    public Departamento leerId(Departamento d) throws Exception{
        Departamento dp= null;
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from departamento where codigoDepartamento=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, dp.getCodigoDepartamento());
            res=pre.executeQuery();
            while (res.next()) {                
                dp= new Departamento();
                dp.setCodigoDepartamento(res.getInt("codigoDepartamento"));
                dp.setNombre(res.getString("nombre"));
                dp.setCantidadEmpleados(res.getInt("cantidadEmpleado"));
            }
        } catch (Exception e) {
            throw e;
        }finally {
        this.desconectar();
        }
        return dp;
    }
}
