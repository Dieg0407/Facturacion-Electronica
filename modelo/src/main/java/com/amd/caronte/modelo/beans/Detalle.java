package com.amd.caronte.modelo.beans;

import com.azoth.eve.anotaciones.CampoTabla;
import com.azoth.eve.anotaciones.LlavePrimaria;
import com.azoth.eve.anotaciones.LlavePrimariaCompuesta;
import com.azoth.eve.anotaciones.NombreTabla;

import java.io.Serializable;
import java.sql.Types;

@NombreTabla(nombre = "detalles")
@LlavePrimariaCompuesta
public class Detalle implements Serializable {

    @LlavePrimaria
    @CampoTabla(campo = "sec",tipoDato = Types.INTEGER)
    private int sec;
    @LlavePrimaria
    @CampoTabla(campo = "serie",tipoDato = Types.VARCHAR)
    private String serie;
    @LlavePrimaria
    @CampoTabla(campo = "numero",tipoDato = Types.INTEGER)
    private int numero;


    @CampoTabla(campo = "codigo",tipoDato = Types.VARCHAR)
    private String codigo;
    @CampoTabla(campo = "descripcion",tipoDato = Types.VARCHAR)
    private String descripcion;
    @CampoTabla(campo = "unidad",tipoDato = Types.VARCHAR)
    private String unidad;
    @CampoTabla(campo = "valor_unitario",tipoDato = Types.NUMERIC)
    private double valorUnitario;
    @CampoTabla(campo = "cantidad",tipoDato = Types.NUMERIC)
    private double cantidad;

    @CampoTabla(campo = "isc",tipoDato = Types.NUMERIC)
    private double isc;
    @CampoTabla(campo = "cod_isc",tipoDato = Types.VARCHAR)
    private String codIsc;
    @CampoTabla(campo = "igv",tipoDato = Types.NUMERIC)
    private double igv;
    @CampoTabla(campo = "cod_igv",tipoDato = Types.VARCHAR)
    private String codIgv;
    @CampoTabla(campo = "otros_tributos",tipoDato = Types.NUMERIC)
    private double otrosTributos;
    @CampoTabla(campo = "total",tipoDato = Types.NUMERIC)
    private double total;

    public Detalle(){}

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
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
