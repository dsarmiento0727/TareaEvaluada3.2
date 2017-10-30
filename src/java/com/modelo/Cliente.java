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
public class Cliente {

    private int codigoCliente;
    private String nombre;
    private String genero;

    public Cliente() {
    }

    public Cliente(int codigoCliente, String nombre, String genero) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.genero = genero;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
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

    
}
