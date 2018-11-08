package com.amd.caronte.modelo.dao.beans;

import java.io.Serializable;

public class BeanEstado implements Serializable{

    private int id;
    private String descripcion;

    public BeanEstado(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
