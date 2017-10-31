/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.DaoDepartamento;
import com.modelo.Departamento;
import java.io.Serializable;
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
    private DaoDepartamento ddp = new DaoDepartamento();

    /**
     * Creates a new instance of BeanDepartamento
     */
    public BeanDepartamento() {
    }
    
}
