/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sarmiento
 */
public class DaoEmpleado extends Conexion{
     public void registrarEmpleado(Empleado em) throws Exception{
        try {
            this.conectar();
            String sql="insert into empleado(nombre, genero, intereses,edad,direccion, cargo, codigoDeparatento) values(?,?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, em.getNombre());
            pre.setString(2, em.getGenero());
            pre.setString(3, em.convertirIntereses(em.getIntereses()));
            pre.setInt(4, em.getEdad());
            pre.setString(5, em.getDireccion());
            pre.setString(6, em.getCargo());
            pre.setInt(7, em.getCodigoDepartamento());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
     }  
     
     public void modificarEmpleado(Empleado em) throws Exception{
     try {
            this.conectar();
            String sql="update empleado set nombre=?,genero=?,intereses=?,edad=?,direccion=?,cargo=?,codigoDeparatento=? where codigoEmpleado=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, em.getNombre());
            pre.setString(2, em.getGenero());
            pre.setString(3, em.convertirIntereses(em.getIntereses()));
            pre.setInt(4, em.getEdad());
            pre.setString(5, em.getDireccion());
            pre.setString(6, em.getCargo());
            pre.setInt(7, em.getCodigoDepartamento());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
     }
     public void eliminarEmpleado(Empleado em) throws Exception{
     try {
            this.conectar();
            String sql="delete from empleado where codigoEmpleado=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, em.getCodigoDepartamento());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
     }  
     
      public List<Empleado> listarEmpleados() throws Exception{
        ResultSet res;
        List<Empleado> lista; 
        try {
            this.conectar();
            String sql="select * from empleado";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            lista = new ArrayList();
            while (res.next()) {                
                Empleado em= new Empleado();
                em.setCodigoEmpleado(res.getInt("codigoEmpleado"));
                em.setNombre(res.getString("nombre"));
                em.setGenero(res.getString("genero"));
                em.setIntereses(em.obtenerIntereses(res.getString("intereses")));
                em.setEdad(res.getInt("edad"));
                em.setDireccion(res.getString("direccion"));
                em.setCargo(res.getString("cargo"));
                em.setCodigoDepartamento(res.getInt("codigoDepartamento"));
                lista.add(em);
            }
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
        return lista;
    }
      public Empleado leerId(Empleado em) throws Exception{
        Empleado emp= null;
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from empleado where codigoEmpleado=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, emp.getCodigoEmpleado());
            res=pre.executeQuery();
            while (res.next()) {                
                emp= new Empleado();
                em.setNombre(res.getString("nombre"));
                em.setGenero(res.getString("genero"));
                em.setIntereses(em.obtenerIntereses(res.getString("intereses")));
                em.setEdad(res.getInt("edad"));
                em.setDireccion(res.getString("direccion"));
                em.setCargo(res.getString("cargo"));
                em.setCodigoDepartamento(res.getInt("codigoDepartamento"));
            }
        } catch (Exception e) {
            throw e;
        }finally {
        this.desconectar();
        }
        return emp;
    }
}
