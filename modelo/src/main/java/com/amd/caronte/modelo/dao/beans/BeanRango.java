package com.amd.caronte.modelo.dao.beans;

import java.io.Serializable;

public class BeanRango implements Serializable {

    private int id;
    private String descripcion;

    public BeanRango(){}

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
