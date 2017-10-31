/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import com.dao.DaoDepartamento;
import com.modelo.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author Karen
 */
@ViewScoped
@Named(value = "beanDepartamento")
public class BeanDepartamento {
    private DaoDepartamento ddp= new DaoDepartamento();
    private Departamento d= new Departamento();
    private Departamento selDepa = new Departamento();
    private List<Departamento> lista = new ArrayList<>();

    public Departamento getSelDepa() {
        return selDepa;
    }

    public void setSelDepa(Departamento selDepa) {
        this.selDepa = selDepa;
    }
   
    public DaoDepartamento getDdp() {
        return ddp;
    }

    public void setDdp(DaoDepartamento ddp) {
        this.ddp = ddp;
    }

    public Departamento getD() {
        return d;
    }

    public void setD(Departamento d) {
        this.d = d;
    }

    public List<Departamento> getLista() {
        return lista;
    }

    public void setLista(List<Departamento> lista) {
        this.lista = lista;
    }
   
    public BeanDepartamento()throws Exception{
        lista=ddp.listarDepartamentos();
    }
    public void select()
    {
        d = selDepa;
    }
    public void limpiar(){
     selDepa = new Departamento();
     d = new Departamento();
     }
    public void insertar() throws Exception{
        try {
            ddp.registrarDepartamento(d);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestion", "Departamento Ingresado Correctamente"));
            lista=ddp.listarDepartamentos();
            limpiar();
        } catch (Exception e) {
            FacesContext context =FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.toString()));
            throw e;
        }
    }
    public void modificar() throws Exception{
        try {
            ddp.modificarDepartamento(d);
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion","Departamento Modificado Correctamente"));
            lista=ddp.listarDepartamentos();
            limpiar();
        } catch (Exception e) {
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.toString()));
            throw e;
        }
    }
    
    public void eliminar() throws Exception{
        try {
            ddp.eliminarDepartamento(d);
            FacesContext context= FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion","Departamento Eliminado Correctamente"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.toString()));
            throw e;
        }
    }
}
