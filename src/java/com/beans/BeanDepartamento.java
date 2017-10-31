/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.DaoDepartamento;
import com.modelo.Departamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author David Sarmiento
 */
@Named(value = "beanDepartamento")
@ViewScoped
public class BeanDepartamento implements Serializable{
    private Departamento d = new Departamento();
    private Departamento selDepto = new Departamento();
    private DaoDepartamento ddp = new DaoDepartamento();
    private List<Departamento> lista = new ArrayList<>();

    public Departamento getD() {
        return d;
    }

    public void setD(Departamento d) {
        this.d = d;
    }

    public Departamento getSelDepto() {
        return selDepto;
    }

    public void setSelDepto(Departamento selDepto) {
        this.selDepto = selDepto;
    }

    public DaoDepartamento getDdp() {
        return ddp;
    }

    public void setDdp(DaoDepartamento ddp) {
        this.ddp = ddp;
    }

    public List<Departamento> getLista() {
        return lista;
    }

    public void setLista(List<Departamento> lista) {
        this.lista = lista;
    }
    

    /**
     * Creates a new instance of BeanDepartamento
     */
    public BeanDepartamento() throws Exception {
        lista = ddp.listarDepartamentos();
    }
    
    public void select()
    {
        d = selDepto;
    }
}
