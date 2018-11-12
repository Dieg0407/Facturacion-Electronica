package com.amd.caronte.modelo.dao;

/**
 * Representación de un parámetro general para un Query en java
 */
public class Parametro {

    private Object valor;
    private String field;
    private int tipo;

    public Parametro(){}

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
