package com.amd.caronte.modelo.dao.beans;

import java.io.Serializable;

public class BeanDetalle implements Serializable {

    private String sec;
    private String serie;
    private int numero;

    private String codigo;
    private String descripcion;
    private String unidad;
    private double valorUnitario;
    private double cantidad;

    private double isc;
    private String codIsc;
    private double igv;
    private String codIgv;
    private double otrosTributos;
    private double total;

    public BeanDetalle(){}

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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
}
