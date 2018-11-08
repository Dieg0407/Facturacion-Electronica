package com.amd.caronte.modelo.dao.beans;

import java.io.Serializable;

public class BeanDocumento implements Serializable {

    private String serie;
    private int numero;
    private String tipoDocumento;

    private String fechaEmision;
    private String fechaVencimiento;

    private String tipoCliente;
    private String numeroCliente;
    private String nombreCliente;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    private String email;

    private double ventaAfecta;
    private double ventaInafecta;
    private double ventaExonerada;

    private double isc;
    private String codIsc;
    private double igv;
    private String codIgv;
    private double otrosTributos;
    private double total;

    private int estado;
    private int resumen;

    public BeanDocumento(){}

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getVentaAfecta() {
        return ventaAfecta;
    }

    public void setVentaAfecta(double ventaAfecta) {
        this.ventaAfecta = ventaAfecta;
    }

    public double getVentaInafecta() {
        return ventaInafecta;
    }

    public void setVentaInafecta(double ventaInafecta) {
        this.ventaInafecta = ventaInafecta;
    }

    public double getVentaExonerada() {
        return ventaExonerada;
    }

    public void setVentaExonerada(double ventaExonerada) {
        this.ventaExonerada = ventaExonerada;
    }

    public double getIsc() {
        return isc;
    }

    public void setIsc(double isc) {
        this.isc = isc;
    }

    public String getCodIsc() {
        return codIsc;
    }

    public void setCodIsc(String codIsc) {
        this.codIsc = codIsc;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public String getCodIgv() {
        return codIgv;
    }

    public void setCodIgv(String codIgv) {
        this.codIgv = codIgv;
    }

    public double getOtrosTributos() {
        return otrosTributos;
    }

    public void setOtrosTributos(double otrosTributos) {
        this.otrosTributos = otrosTributos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getResumen() {
        return resumen;
    }

    public void setResumen(int resumen) {
        this.resumen = resumen;
    }
}
