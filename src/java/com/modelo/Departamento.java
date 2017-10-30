/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author David Sarmiento
 */
public class Departamento {

    private int codigoDepartamento;
    private String nombre;
    private int cantidadEmpleados;

    public Departamento() {
    }

    public Departamento(int codigoDepartamento, String nombre, int cantidadEmpleados) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombre = nombre;
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }
    
    
}
