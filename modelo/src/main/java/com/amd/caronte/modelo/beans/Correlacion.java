package com.amd.caronte.modelo.beans;

import com.azoth.eve.anotaciones.CampoTabla;
import com.azoth.eve.anotaciones.LlavePrimaria;
import com.azoth.eve.anotaciones.LlavePrimariaCompuesta;
import com.azoth.eve.anotaciones.NombreTabla;

import java.io.Serializable;
import java.sql.Types;

@NombreTabla(nombre = "correlacion")
@LlavePrimariaCompuesta
public class Correlacion implements Serializable {

    @LlavePrimaria
    @CampoTabla(campo = "tipo_doc",tipoDato = Types.VARCHAR)
    private String tipoDocumento;
    @LlavePrimaria
    @CampoTabla(campo = "identificador",tipoDato = Types.VARCHAR)
    private String identificador;
    @LlavePrimaria
    @CampoTabla(campo = "correlativo",tipoDato = Types.VARCHAR)
    private int correlativo;

    public Correlacion(){}

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
