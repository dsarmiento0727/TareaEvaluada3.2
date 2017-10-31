/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.DaoCliente;
import com.modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author David Sarmiento
 */
@Named(value = "beanCliente")
@ViewScoped
public class BeanCliente implements Serializable {

    private DaoCliente dc = new DaoCliente();
    private Cliente cli = new Cliente();
    private Cliente selCli = new Cliente();
    private List<Cliente> lista = new ArrayList<>();

    public DaoCliente getDc() {
        return dc;
    }

    public void setDc(DaoCliente dc) {
        this.dc = dc;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Cliente getSelCli() {
        return selCli;
    }

    public void setSelCli(Cliente selCli) {
        this.selCli = selCli;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    /**
     * Creates a new instance of BeanCliente
     */
    public BeanCliente() throws Exception {

        lista = dc.mostrarCliente();
    }

    public void select() {
        cli = selCli;
    }

    public void insertar() throws Exception {
        try {
            dc.registrarCliente(cli);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestionar", "Cliente Ingresado Correctamente"));
            lista = dc.mostrarCliente();
            limpiar();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.toString()));
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dc.modificarCliente(selCli);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestion", "Cliente Modificado Correctamente"));
            lista = dc.mostrarCliente();
            limpiar();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.toString()));
            throw e;
        }
    }

    public void eliminar() throws Exception {
        try {
            dc.eliminarCliente(selCli);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestion", "Cliente Eliminado Correctamente"));
            lista = dc.mostrarCliente();
            limpiar();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.toString()));
            throw e;
        }
    }

    public void limpiar() {
        selCli = new Cliente();
        cli = new Cliente();
    }
}
