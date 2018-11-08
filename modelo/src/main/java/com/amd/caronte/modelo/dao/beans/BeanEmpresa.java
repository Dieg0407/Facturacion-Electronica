package com.amd.caronte.modelo.dao.beans;

import java.io.Serializable;

public class BeanEmpresa implements Serializable {

    private String ruc;
    private String nombre;
    private String nombreComercial;
    private String ubigeo;
    private String direccion;
    private String urbanizacion;
    private String distrito;
    private String provincia;
    private byte[] certificado;
    private String nombreCertificado;
    private String pin;
    private String alias;

    private String usuarioSecundario;
    private String password;

    private String[] telefonos;
    private String email;
    private String web;

    public BeanEmpresa(){}

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public byte[] getCertificado() {
        return certificado;
    }

    public void setCertificado(byte[] certificado) {
        this.certificado = certificado;
    }

    public String getNombreCertificado() {
        return nombreCertificado;
    }

    public void setNombreCertificado(String nombreCertificado) {
        this.nombreCertificado = nombreCertificado;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUsuarioSecundario() {
        return usuarioSecundario;
    }

    public void setUsuarioSecundario(String usuarioSecundario) {
        this.usuarioSecundario = usuarioSecundario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String[] telefonos) {
        this.telefonos = telefonos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
