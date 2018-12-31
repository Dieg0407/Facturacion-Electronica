package com.amd.caronte.modelo.beans;

import com.azoth.eve.anotaciones.CampoTabla;
import com.azoth.eve.anotaciones.LlavePrimaria;
import com.azoth.eve.anotaciones.LlavePrimariaSimple;
import com.azoth.eve.anotaciones.NombreTabla;

import java.io.Serializable;
import java.sql.Types;

@NombreTabla(nombre = "tipos_documentos")
@LlavePrimariaSimple
public class TipoDocumento implements Serializable {

    @LlavePrimaria
    @CampoTabla(campo = "tipo_doc",tipoDato = Types.VARCHAR)
    private String tipoDocumento;
    @CampoTabla(campo = "descripcion",tipoDato = Types.VARCHAR)
    private String descripcion;

    public TipoDocumento(){}

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
