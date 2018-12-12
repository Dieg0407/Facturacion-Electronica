package com.amd.caronte.modelo.beans;

import java.io.Serializable;

public class BeanCorrelacion implements Serializable {

    private String tipoDocumento;
    private String identificador;
    private int correlativo;

    public BeanCorrelacion(){}

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }
}
