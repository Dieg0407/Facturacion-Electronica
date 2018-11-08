package com.amd.caronte.modelo.dao.beans;

import java.io.Serializable;

public class BeanResumen implements Serializable {

    private int id;
    private String fechaGeneracion;

    private String tipoDocumento;
    private int correlativo;

    private String fechaReferencia;
    private String ticket;

    private byte[] archivo;
    private byte[] respuesta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getFechaReferencia() {
        return fechaReferencia;
    }

    public void setFechaReferencia(String fechaReferencia) {
        this.fechaReferencia = fechaReferencia;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public byte[] getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(byte[] respuesta) {
        this.respuesta = respuesta;
    }
}
