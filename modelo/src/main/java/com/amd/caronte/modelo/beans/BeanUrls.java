package com.amd.caronte.modelo.beans;

import java.io.Serializable;

public class BeanUrls implements Serializable {

    private String produccion;
    private String guiaRemision;
    private String retenciones;
    private String validacionCE;
    private String validacionConstancia;
    private int verificarBoletas;

    public BeanUrls(){}

    public String getProduccion() {
        return produccion;
    }

    public void setProduccion(String produccion) {
        this.produccion = produccion;
    }

    public String getGuiaRemision() {
        return guiaRemision;
    }

    public void setGuiaRemision(String guiaRemision) {
        this.guiaRemision = guiaRemision;
    }

    public String getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(String retenciones) {
        this.retenciones = retenciones;
    }

    public String getValidacionCE() {
        return validacionCE;
    }

    public void setValidacionCE(String validacionCE) {
        this.validacionCE = validacionCE;
    }

    public String getValidacionConstancia() {
        return validacionConstancia;
    }

    public void setValidacionConstancia(String validacionConstancia) {
        this.validacionConstancia = validacionConstancia;
    }

    public int getVerificarBoletas() {
        return verificarBoletas;
    }

    public void setVerificarBoletas(int verificarBoletas) {
        this.verificarBoletas = verificarBoletas;
    }
}
