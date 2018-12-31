package com.amd.caronte.modelo.beans;

import com.azoth.eve.anotaciones.CampoTabla;
import com.azoth.eve.anotaciones.LlavePrimaria;
import com.azoth.eve.anotaciones.LlavePrimariaSimple;
import com.azoth.eve.anotaciones.NombreTabla;

import java.io.Serializable;
import java.sql.Types;

@NombreTabla(nombre = "usuarios")
@LlavePrimariaSimple
public class Usuario implements Serializable {

    @LlavePrimaria
    @CampoTabla(campo = "id", tipoDato = Types.VARCHAR)
    private String idUsuario;
    @CampoTabla(campo = "pass", tipoDato = Types.VARCHAR)
    private String password;
    @CampoTabla(campo = "nombres", tipoDato = Types.VARCHAR)
    private String nombre;
    @CampoTabla(campo = "dni", tipoDato = Types.VARCHAR)
    private String dni;
    @CampoTabla(campo = "rango", tipoDato = Types.INTEGER)
    private int rango;

    public Usuario(){}

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
}
