package com.amd.caronte.modelo.beans;

import com.azoth.eve.anotaciones.CampoTabla;
import com.azoth.eve.anotaciones.LlavePrimaria;
import com.azoth.eve.anotaciones.LlavePrimariaCompuesta;
import com.azoth.eve.anotaciones.NombreTabla;

import java.io.Serializable;
import java.sql.Types;

@NombreTabla(nombre = "documentos")
@LlavePrimariaCompuesta
public class Documento implements Serializable {

    @LlavePrimaria
    @CampoTabla(campo = "serie",tipoDato = Types.VARCHAR)
    private String serie;
    @LlavePrimaria
    @CampoTabla(campo = "numero",tipoDato = Types.INTEGER)
    private int numero;
    @LlavePrimaria
    @CampoTabla(campo = "tipo_doc",tipoDato = Types.VARCHAR)
    private String tipoDocumento;

    @CampoTabla(campo = "fecha_emision",tipoDato = Types.VARCHAR)
    private String fechaEmision;
    @CampoTabla(campo = "fecha_vencimiento",tipoDato = Types.VARCHAR)
    private String fechaVencimiento;


    @CampoTabla(campo = "tipo_cliente",tipoDato = Types.VARCHAR)
    private String tipoCliente;
    @CampoTabla(campo = "num_cliente",tipoDato = Types.VARCHAR)
    private String numeroCliente;
    @CampoTabla(campo = "nom_cliente",tipoDato = Types.VARCHAR)
    private String nombreCliente;
    @CampoTabla(campo = "direccion",tipoDato = Types.VARCHAR)
    private String direccion;
    @CampoTabla(campo = "distrito",tipoDato = Types.VARCHAR)
    private String distrito;
    @CampoTabla(campo = "provincia",tipoDato = Types.VARCHAR)
    private String provincia;
    @CampoTabla(campo = "departamento",tipoDato = Types.VARCHAR)
    private String departamento;
    @CampoTabla(campo = "email",tipoDato = Types.VARCHAR)
    private String email;

    @CampoTabla(campo = "venta_afecta",tipoDato = Types.NUMERIC)
    private double ventaAfecta;
    @CampoTabla(campo = "venta_inafecta",tipoDato = Types.NUMERIC)
    private double ventaInafecta;
    @CampoTabla(campo = "venta_exonerada",tipoDato = Types.NUMERIC)
    private double ventaExonerada;

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


    @CampoTabla(campo = "id_estado",tipoDato = Types.INTEGER)
    private int estado;
    @CampoTabla(campo = "id_resumen",tipoDato = Types.INTEGER)
    private int resumen;

    public Documento(){}

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
