package com.amd.caronte.modelo.beans;

import com.azoth.eve.anotaciones.CampoTabla;
import com.azoth.eve.anotaciones.LlavePrimaria;
import com.azoth.eve.anotaciones.LlavePrimariaSimple;
import com.azoth.eve.anotaciones.NombreTabla;

import java.io.Serializable;
import java.sql.Types;

@NombreTabla(nombre = "rangos")
@LlavePrimariaSimple
public class Rango implements Serializable {

    @LlavePrimaria
    @CampoTabla(campo = "id",tipoDato = Types.INTEGER)
    private int id;
    @CampoTabla(campo = "descripcion",tipoDato = Types.VARCHAR)
    private String descripcion;

    public Rango(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
