package com.amd.caronte.modelo.dao.beans;

import java.io.Serializable;

public class BeanEnvios implements Serializable {

    private int id;
    private String serie;
    private String numero;

    private String serieElectronica;
    private String numeroElectronico;

    private String fechaEnvio;

    private byte[] archivo;
    private byte[] respuesta;

    private boolean activo;

    public BeanEnvios(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSerieElectronica() {
        return serieElectronica;
    }

    public void setSerieElectronica(String serieElectronica) {
        this.serieElectronica = serieElectronica;
    }

    public String getNumeroElectronico() {
        return numeroElectronico;
    }

    public void setNumeroElectronico(String numeroElectronico) {
        this.numeroElectronico = numeroElectronico;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
