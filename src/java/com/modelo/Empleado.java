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
public class Empleado {
    private int codigoEmpleado;
    private String nombre;
    private String genero;
    private String[] intereses;
    private int edad;
    private String direccion;
    private String cargo;
    private int codigoDepartamento;

    public Empleado() {
    }

    public Empleado(int codigoEmpleado, String nombre, String genero, String[] intereses, int edad, String direccion, String cargo, int codigoDepartamento) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.genero = genero;
        this.intereses = intereses;
        this.edad = edad;
        this.direccion = direccion;
        this.cargo = cargo;
        this.codigoDepartamento = codigoDepartamento;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String[] getIntereses() {
        return intereses;
    }

    public void setIntereses(String[] intereses) {
        this.intereses = intereses;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }
    
     public String convertirIntereses(String[] intereses) {
        String interesesC = null;
        for (int i = 0; i < intereses.length; i++) {
            if (interesesC != null) {
                interesesC = interesesC +","+ intereses[i];
            } else {
                interesesC = intereses[i];
            }
        }
        return interesesC;
    }

    public String[] obtenerIntereses(String intereses) {
        String[] interesesBase = null;

        if (intereses.equals("leer")) {
            interesesBase[1] = "leer";
        }
        if (intereses.equals("leer,dormir")) {
            interesesBase[1] = "leer";
            interesesBase[2] = "dormir";
        }
        if (intereses.equals("leer,dormir,cantar")) {
            interesesBase[1] = "leer";
            interesesBase[2] = "dormir";
            interesesBase[3] = "cantar";
        }

        if (interesesBase.equals("leer,dormir,cantar,jugar")) {
            interesesBase[1] = "leer";
            interesesBase[2] = "dormir";
            interesesBase[3] = "cantar";
            interesesBase[4] = "jugar";
        }
        

        return interesesBase;
    }
}
