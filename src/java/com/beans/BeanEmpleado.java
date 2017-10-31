/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.DaoEmpleado;
import com.modelo.Departamento;
import com.modelo.Empleado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gerardo
 */
@Named(value = "beanEmpleado")
@Dependent
public class BeanEmpleado implements Serializable{
    private DaoEmpleado de= new DaoEmpleado();
    private Empleado em= new Empleado();
    private Empleado selEm= new Empleado();
    private List<Empleado> lista= new ArrayList<>();
    private List<Departamento> listad = new ArrayList<>();

    public List<Departamento> getListad() {
        return listad;
    }

    public void setListad(List<Departamento> listad) {
        this.listad = listad;
    }
    

    public DaoEmpleado getDe() {
        return de;
    }

    public void setDe(DaoEmpleado de) {
        this.de = de;
    }

    public Empleado getEm() {
        return em;
    }

    public void setEm(Empleado em) {
        this.em = em;
    }

    public Empleado getSelEm() {
        return selEm;
    }

    public void setSelEm(Empleado selEm) {
        this.selEm = selEm;
    }

    public List<Empleado> getLista() {
        return lista;
    }

    public void setLista(List<Empleado> lista) {
        this.lista = lista;
    }
    
    public BeanEmpleado() throws Exception{
        lista=de.listarEmpleados();
        listad = de.listarDepartamentos();
    }
    public void select(){
        em=selEm;
    }
    public void limpiar(){
        selEm= new Empleado();
        em= new Empleado();
    }
    public void insertar() throws Exception{
        try {
            de.registrarEmpleado(em);
            FacesContext context= FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion","Empleado insertado Correctamente"));
            lista=de.listarEmpleados();
            limpiar();
        } catch (Exception e) {
            FacesContext context= FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.toString()));
            throw e;
        }
    }
    public void modificar() throws Exception{
        try {
            de.modificarEmpleado(em);
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion","Empleado Modificado Correctamente"));
            lista=de.listarEmpleados();
            limpiar();
        } catch (Exception e) {
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.toString()));
            throw e;
        }
    }
    public void eliminar() throws Exception{
        try {
            de.eliminarEmpleado(em);
            FacesContext context= FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion","Empleado Eliminado Correctamente"));
            lista=de.listarEmpleados();
            limpiar();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.toString()));
            throw e;
        }
    }
    
}
