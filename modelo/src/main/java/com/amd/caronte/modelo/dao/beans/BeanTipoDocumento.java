package com.amd.caronte.modelo.dao.beans;

import java.io.Serializable;

public class BeanTipoDocumento implements Serializable {

    private String tipoDocumento;
    private String descripcion;

    public BeanTipoDocumento(){}

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
