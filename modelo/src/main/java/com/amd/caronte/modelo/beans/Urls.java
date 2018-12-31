package com.amd.caronte.modelo.beans;

import com.azoth.eve.anotaciones.CampoTabla;
import com.azoth.eve.anotaciones.LlavePrimaria;
import com.azoth.eve.anotaciones.LlavePrimariaCompuesta;
import com.azoth.eve.anotaciones.NombreTabla;

import java.io.Serializable;
import java.sql.Types;

@NombreTabla(nombre = "usuarios")
@LlavePrimariaCompuesta
public class Urls implements Serializable {

    @LlavePrimaria
    @CampoTabla(campo = "produccion", tipoDato = Types.VARCHAR)
    private String produccion;
    @LlavePrimaria
    @CampoTabla(campo = "guias_remision", tipoDato = Types.VARCHAR)
    private String guiaRemision;
    @LlavePrimaria
    @CampoTabla(campo = "retenciones", tipoDato = Types.VARCHAR)
    private String retenciones;
    @LlavePrimaria
    @CampoTabla(campo = "validacion_comprobante", tipoDato = Types.VARCHAR)
    private String validacionCE;
    @LlavePrimaria
    @CampoTabla(campo = "validacion_constancia", tipoDato = Types.VARCHAR)
    private String validacionConstancia;
    @LlavePrimaria
    @CampoTabla(campo = "verificar_boletas", tipoDato = Types.BOOLEAN)
    private boolean verificarBoletas;

    public Urls(){}

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

    public boolean getVerificarBoletas() {
        return verificarBoletas;
    }

    public void setVerificarBoletas(boolean verificarBoletas) {
        this.verificarBoletas = verificarBoletas;
    }
}
